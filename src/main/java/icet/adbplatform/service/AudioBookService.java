package icet.adbplatform.service;

import icet.adbplatform.model.AudioBook;
import icet.adbplatform.model.AudioBookChapter;
import icet.adbplatform.repository.AudioBookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AudioBookService {

    private final AudioBookRepository audioBookRepository;

    public List<AudioBook> getAllAudioBooks() {
        return audioBookRepository.findAll();
    }

    public Optional<AudioBook> getAudioBookById(Long id) {
        return audioBookRepository.findById(id);
    }

    public List<AudioBook> getMostRatedAudioBooks() {
        // Implement logic to get most rated audio books
        return audioBookRepository.findAll(); 
    }

    public List<AudioBook> getMostRecentAudioBooks() {
        // Implement logic to get most recent audio books
        return audioBookRepository.findAll(); 
    }

    public List<AudioBook> getMostPopularAudioBooks() {
        // Implement logic to get most popular audio books
        return audioBookRepository.findAll(); 
    }

    public List<AudioBook> getMostPurchasedAudioBooks() {
        // Implement logic to get most purchased audio books
        return audioBookRepository.findAll(); 
    }

    public int getAudioBookPurchaseCount(Long id) {
        Optional<AudioBook> audioBook = audioBookRepository.findById(id);
        return audioBook.map(AudioBook::getNumberOfPurchases).orElse(0);
    }

    public int getAudioBookRating(Long id) {
        Optional<AudioBook> audioBook = audioBookRepository.findById(id);
        return audioBook.map(AudioBook::getRating).orElse(0);
    }

    public List<AudioBookChapter> getAudioBookChapters(Long id) {
        Optional<AudioBook> audioBook = audioBookRepository.findById(id);
        return audioBook.map(AudioBook::getChapters).orElse(List.of());
    }

    public AudioBookChapter getAudioBookChapter(Long id, Long chapterId) {
        Optional<AudioBook> audioBook = audioBookRepository.findById(id);
        if (audioBook.isPresent()) {
            List<AudioBookChapter> chapters = audioBook.get().getChapters();
            if (chapterId >= 0 && chapterId < chapters.size()) {
                return chapters.get(chapterId.intValue());
            }
        }
        return null;
    }

    public AudioBook addAudioBook(AudioBook audioBook) {
        return audioBookRepository.save(audioBook);
    }

    public AudioBook updateAudioBook(Long id, AudioBook audioBook) {
        Optional<AudioBook> existingAudioBookOptional = audioBookRepository.findById(id);
        if (existingAudioBookOptional.isPresent()) {
            AudioBook existingAudioBook = existingAudioBookOptional.get();
            existingAudioBook.setTitle(audioBook.getTitle());
            existingAudioBook.setGenre(audioBook.getGenre());
            existingAudioBook.setImageUrl(audioBook.getImageUrl());
            existingAudioBook.setChapters(audioBook.getChapters());
            existingAudioBook.setDescription(audioBook.getDescription());
            return audioBookRepository.save(existingAudioBook);
        } else {
            throw new RuntimeException("Audiobook not found");
        }
    }

    public void deleteAudioBook(Long id) {
        Optional<AudioBook> audioBookOptional = audioBookRepository.findById(id);
        if (audioBookOptional.isPresent()) {
            AudioBook audioBook = audioBookOptional.get();
            audioBook.setIsDisabled(true);
            audioBookRepository.save(audioBook);
        } else {
            throw new RuntimeException("Audiobook not found with id");
        }
    }

    public List<AudioBook> searchAudioBooks(String query) {
        return audioBookRepository.findByTitleContainingOrAuthorContainingIgnoreCase(query, query);
    }
}
