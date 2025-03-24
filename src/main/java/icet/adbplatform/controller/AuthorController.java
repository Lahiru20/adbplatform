package icet.adbplatform.controller;

import icet.adbplatform.model.AudioBook;
import icet.adbplatform.service.AudioBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/author")
@RequiredArgsConstructor
public class AuthorController {

    private final AudioBookService audiobookService;

    // Audiobook CRUD
    @PostMapping("/add/audiobook")
    public AudioBook addAudioBook(@RequestBody AudioBook audioBook) {
        return audiobookService.addAudioBook(audioBook);
    }

    @GetMapping("/audiobook/{id}")
    public Optional<AudioBook> getAudioBookById(@PathVariable Long id) {
        return audiobookService.getAudioBookById(id);
    }

    @PutMapping("/audiobook/update/{id}")
    public AudioBook updateAudioBook(@PathVariable Long id, @RequestBody AudioBook audioBook) {
        return audiobookService.updateAudioBook(id, audioBook);
    }

    @DeleteMapping("/audiobook/delete/{id}")
    public void deleteAudioBook(@PathVariable Long id) {
        audiobookService.deleteAudioBook(id);
    }

    @GetMapping("/audiobooks/search?query={query}")
    public List<AudioBook> searchAudioBooks(@RequestParam String query) {
        return audiobookService.searchAudioBooks(query);
    }

}
