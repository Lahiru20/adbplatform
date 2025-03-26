package icet.adbplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audiobookchapter")
public class AudioBookChapter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "duration", nullable = false)
    private String duration;

    @Column(name = "audio_url", nullable = false)
    private String audioUrl;

    @Column(name = "progress", nullable = false)
    private Double progress;

    @Column(name = "chapter_number", nullable = false)
    private Integer chapterNumber;

    @ManyToOne
    @JoinColumn(name = "audiobook_id", nullable = false)
    private AudioBook audioBook;
}
