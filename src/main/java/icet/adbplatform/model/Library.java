package icet.adbplatform.model;
import java.util.Map;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "librarybooks")
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "audiobook", nullable = false)
    private AudioBook audioBook;

    @Column(name = "is_purchased", nullable = false)
    private boolean isPurchased;

    @Column(name = "is_wishlisted", nullable = false)
    private Boolean isWishlisted;
    
    @Column(name = "chapter_progress", nullable = false)
    private Map<AudioBook, String> chapterProgress;

}
