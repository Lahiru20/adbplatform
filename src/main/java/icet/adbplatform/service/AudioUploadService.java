package icet.adbplatform.service;
import org.lahirurashmika.converter.HLSConverterMultipartFile;
import org.lahirurashmika.converter.OutputType;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ObjectCannedACL;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Service
public class AudioUploadService {

    private final S3Client s3Client;
    private final String bucket;
    private final HLSConverterMultipartFile hlsConverterMultipartFile;
    private final String region;

    public AudioUploadService(S3Client s3Client,
                              @Qualifier("b2BucketName") String bucket,
                              HLSConverterMultipartFile hlsConverterMultipartFile,
                              @Qualifier("b2Region") String region) {
        this.s3Client = s3Client;
        this.bucket = bucket;
        this.hlsConverterMultipartFile = hlsConverterMultipartFile;
        this.region = region;
    }

    public String uploadAudio(MultipartFile file) throws Exception {
        String contentType = file.getContentType();
        if (contentType == null || !contentType.startsWith("audio/")) {
            throw new IllegalArgumentException("The file must be an audio file.");
        }

        MultipartFile[] outputs = hlsConverterMultipartFile.convertToHlsMultipartFile(
                file, "output", OutputType.AUDIO_MP3, 5, 0
        );

        String firstFileUrl = null;

        for (int i = 0; i < outputs.length; i++) {
            MultipartFile segment = outputs[i];
            String filename = "audio/" + segment.getOriginalFilename();

            PutObjectRequest putRequest = PutObjectRequest.builder()
                    .bucket(bucket)
                    .key(filename)
                    .contentType(segment.getContentType())
                    .acl(ObjectCannedACL.PUBLIC_READ)
                    .build();

            s3Client.putObject(putRequest, RequestBody.fromBytes(segment.getBytes()));

            if (i == 0) {
                firstFileUrl = generatePublicUrl(filename);
            }
        }

        return firstFileUrl;
    }

    private String generatePublicUrl(String key) {
        return String.format("https://%s.s3.%s.backblazeb2.com/%s",
                bucket,
                region,
                key
        );
    }


}
