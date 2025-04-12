package icet.adbplatform.repository;

import icet.adbplatform.model.AudioBook;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AudioBookRepository extends JpaRepository<AudioBook, Long> {
    List<AudioBook> findByTitleContainingOrAuthorContainingIgnoreCase(String title, String author);
    List<AudioBook> findTop10ByOrderByRatingDesc();
    List<AudioBook> findTop10ByOrderByIdDesc();
    List<AudioBook> findTop10ByOrderByNumberOfListenersDesc();
    List<AudioBook> findTop10ByOrderByNumberOfPurchasesDesc();
}
