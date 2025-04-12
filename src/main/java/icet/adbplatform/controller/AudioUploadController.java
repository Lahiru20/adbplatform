package icet.adbplatform.controller;
import icet.adbplatform.service.AudioUploadService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/audio")
@RequiredArgsConstructor
@CrossOrigin
public class AudioUploadController {

    @Autowired
    private final AudioUploadService audioUploadService;

    @PostMapping("/upload")
    public ResponseEntity<String> uploadAudio(@RequestParam("file") MultipartFile file) throws Exception {
        try {
            String audioUrl = audioUploadService.uploadAudio(file);
            return ResponseEntity.ok(audioUrl);
        } catch (IOException e) {
            return ResponseEntity.badRequest().body("Audio upload failed: " + e.getMessage());
        }
    }
}

