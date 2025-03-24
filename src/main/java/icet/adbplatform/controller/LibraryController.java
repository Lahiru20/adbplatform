package icet.adbplatform.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/library")
@AllArgsConstructor
public class LibraryController {

    @GetMapping ("/users/id/{id}/recently-played")
    public String getRecentlyPlayed(Long id) {
        return "Recently played";
    }

    @GetMapping ("/users/id/{id}/progress")
    public String getProgress(Long id) {
        return "Progress";
    }

    @GetMapping("/users/id/{id}/purchased-books")
    public String getPurchasedBooks(Long id) {
        return "Purchased books";
    }

    @GetMapping("/users/id/{id}/wishlist")
    public String getWishlist(Long id) {
        return "Wishlist";
    }

}
