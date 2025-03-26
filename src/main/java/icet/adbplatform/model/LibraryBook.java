package icet.adbplatform.model;
import java.util.Map;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "librarybooks")
public class LibraryBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "audiobook_id", nullable = false)
    private AudioBook audioBook;

    @Column(name = "is_purchased", nullable = false)
    private Boolean isPurchased;

    @Column(name = "is_wishlisted", nullable = false)
    private Boolean isWishlisted;

    @ElementCollection
    @CollectionTable(name = "chapter_progress", joinColumns = @JoinColumn(name = "librarybook_id"))
    @MapKeyJoinColumn(name = "audiobook_id")
    @Column(name = "progress")
    private Map<AudioBook, String> chapterProgress;
}
