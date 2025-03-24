package icet.adbplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "audiobooks")
public class AudioBook {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "author", nullable = false)
    private String author;

    @Column(name = "genre", nullable = false)
    private String genre;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "chapters", nullable = false)
    private List<AudioBookChapter> chapters;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "rating")
    private int rating;

    @Column(name = "number_of_ratings")
    private int numberOfRatings;

    @Column(name = "number_of_purchases")
    private int numberOfPurchases;

    @Column(name = "number_of_listeners")
    private int numberOfListeners;

    @Column(name = "is_purchased")
    private boolean isPurchased;

    @Column(name = "is_disabled")
    private boolean isDisabled;
}
