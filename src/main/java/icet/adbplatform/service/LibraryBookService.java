package icet.adbplatform.service;

import icet.adbplatform.model.LibraryBook;
import icet.adbplatform.repository.LibraryBookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LibraryBookService {

    private final LibraryBookRepository libraryBookRepository;

    public List<LibraryBook> getAllLibraryBooks() {
        return libraryBookRepository.findAll();
    }

    public Optional<LibraryBook> getLibraryBookById(Long id) {
        return libraryBookRepository.findById(id);
    }

    public LibraryBook saveLibraryBook(LibraryBook libraryBook) {
        return libraryBookRepository.save(libraryBook);
    }

    public void deleteLibraryBook(Long id) {
        libraryBookRepository.deleteById(id);
    }

    public List<LibraryBook> getLibraryBooksByUserId(Long userId) {
        return libraryBookRepository.findByUserId(userId);
    }
}
