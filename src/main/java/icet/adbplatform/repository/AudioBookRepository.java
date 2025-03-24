package icet.adbplatform.repository;

import icet.adbplatform.model.AudioBook;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AudioBookRepository extends JpaRepository<AudioBook, Long> {
    List<AudioBook> findByTitleContainingOrAuthorContainingIgnoreCase(String query, String query1);

}
