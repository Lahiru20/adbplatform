package icet.adbplatform.controller;

import icet.adbplatform.model.AudioBook;
import icet.adbplatform.model.AudioBookChapter;
import icet.adbplatform.service.AudioBookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/audiobook")
@AllArgsConstructor
public class AudioBookController {

    private final AudioBookService audioBookService;

    @GetMapping("/get-all")
    public List<AudioBook> getAllAudioBooks() {
        return audioBookService.getAllAudioBooks();
    }

    @GetMapping("/get-details/{id}")
    public AudioBook getAudioBookDetails(@PathVariable Long id) {
        return audioBookService.getAudioBookById(id).orElse(null);
    }

    @GetMapping("/get/most-rated")
    public List<AudioBook> getMostRatedAudioBooks() {
        return audioBookService.getMostRatedAudioBooks();
    }

    @GetMapping("/get/most-recent")
    public List<AudioBook> getMostRecentAudioBooks() {
        return audioBookService.getMostRecentAudioBooks();
    }

    @GetMapping("/get/most-popular")
    public List<AudioBook> getMostPopularAudioBooks() {
        return audioBookService.getMostPopularAudioBooks();
    }

    @GetMapping("/get/most-purchased")
    public List<AudioBook> getMostPurchasedAudioBooks() {
        return audioBookService.getMostPurchasedAudioBooks();
    }

    @GetMapping("/get/{id}/purchase-count")
    public int getAudioBookPurchaseCount(@PathVariable Long id) {
        return audioBookService.getAudioBookPurchaseCount(id);
    }

    @GetMapping("/get/{id}/rating")
    public int getAudioBookRating(@PathVariable Long id) {
        return audioBookService.getAudioBookRating(id);
    }

    @GetMapping("/{id}/chapters")
    public List<AudioBookChapter> getAudioBookChapters(@PathVariable Long id) {
        return audioBookService.getAudioBookChapters(id);
    }

    @GetMapping("/{id}/chapter/{chapterId}")
    public AudioBookChapter getAudioBookChapter(@PathVariable Long id, @PathVariable Long chapterId) {
        return audioBookService.getAudioBookChapter(id, chapterId);
    }

    @GetMapping("/search")
    public List<AudioBook> searchAudioBooks(@RequestParam String query) {
        return audioBookService.searchAudioBooks(query);
    }
}

