package icet.adbplatform.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.S3Configuration;

import java.net.URI;

@Configuration
public class BlackBlazeConfig {
    @Value("${backblaze.access-key}")
    private String accessKey;

    @Value("${backblaze.secret-key}")
    private String secretKey;

    @Value("${backblaze.endpoint}")
    private String endpoint;

    @Value("${backblaze.region}")
    private String region;

    @Value("${backblaze.bucket}")
    private String bucket;

    @Bean
    public S3Client s3Client() {

        S3Configuration s3Config = S3Configuration.builder()
                .checksumValidationEnabled(false)
                .build();

        return S3Client.builder()
                .region(Region.of(region))
                .endpointOverride(URI.create(endpoint))
                .serviceConfiguration(s3Config)
                .credentialsProvider(StaticCredentialsProvider.create(
                        AwsBasicCredentials.create(accessKey, secretKey)
                ))
                .build();
    }

    @Bean
    public String b2BucketName() {
        return bucket;
    }

    @Bean
    public String b2Region() {
        return region;
    }

}
