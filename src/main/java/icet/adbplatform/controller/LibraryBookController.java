package icet.adbplatform.controller;

import icet.adbplatform.model.LibraryBook;
import icet.adbplatform.service.LibraryBookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/librarybooks")
@RequiredArgsConstructor
public class LibraryBookController {

    private final LibraryBookService libraryBookService;

    @GetMapping
    public ResponseEntity<List<LibraryBook>> getAllLibraryBooks() {
        List<LibraryBook> libraryBooks = libraryBookService.getAllLibraryBooks();
        return ResponseEntity.ok(libraryBooks);
    }

    @GetMapping("/{id}")
    public ResponseEntity<LibraryBook> getLibraryBookById(@PathVariable Long id) {
        return libraryBookService.getLibraryBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<LibraryBook> createLibraryBook(@RequestBody LibraryBook libraryBook) {
        LibraryBook savedLibraryBook = libraryBookService.saveLibraryBook(libraryBook);
        return ResponseEntity.ok(savedLibraryBook);
    }

    @PutMapping("/delete/{id}")
    public ResponseEntity<LibraryBook> updateLibraryBook(@PathVariable Long id, @RequestBody LibraryBook libraryBook) {
        return libraryBookService.getLibraryBookById(id)
                .map(existingLibraryBook -> {
                    libraryBook.setId(existingLibraryBook.getId());
                    LibraryBook updatedLibraryBook = libraryBookService.saveLibraryBook(libraryBook);
                    return ResponseEntity.ok(updatedLibraryBook);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLibraryBook(@PathVariable Long id) {
        if (libraryBookService.getLibraryBookById(id).isPresent()) {
            libraryBookService.deleteLibraryBook(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<LibraryBook>> getLibraryBooksByUserId(@PathVariable Long userId) {
        List<LibraryBook> libraryBooks = libraryBookService.getLibraryBooksByUserId(userId);
        return ResponseEntity.ok(libraryBooks);
    }
}
