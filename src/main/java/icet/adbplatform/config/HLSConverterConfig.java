package icet.adbplatform.config;

import org.lahirurashmika.converter.HLSConverterMultipartFile;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HLSConverterConfig {
    @Bean
    public HLSConverterMultipartFile hlsConverterMultipartFile() {
        return new HLSConverterMultipartFile();
    }
}
