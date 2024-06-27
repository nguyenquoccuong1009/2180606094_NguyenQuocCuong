package Lab03.QuanLySach.entity;


import Lab03.QuanLySach.validator.annotation.ValidCategoryId;
import Lab03.QuanLySach.validator.annotation.ValidUserId;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false, length = 50)
    @NotEmpty(message = "Title must not be empty")
    @Size(min = 1, max = 50, message = "Title must be between 1 and 50 characters")
    private String title;

    @Column(name = "author", nullable = false)
    @NotEmpty(message = "Author must not be empty")
    private String author;

    @Column(name = "price", nullable = false)
    @NotNull(message = "Price is required")
    private Double price;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    @ValidCategoryId(message = "Invalid Category ID")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @ValidUserId
    private User user; // Đã thêm mappedBy ở đây

    // Constructors
    public Book(String title, String author, Double price, Category category) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.category = category;
    }}


