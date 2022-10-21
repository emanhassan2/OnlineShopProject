package edu.miu.cs.cs425.fairfieldlibraryapp.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
//@NamedQueries(name = "Book.lowFeesBook", query = "select b from Books b where b.overdueFee < ")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;
    @Column(nullable = false)
    @NotNull(message = "Isbn cannot be null")
    @NotEmpty(message = "Isbn cannot be empty or null")
    @NotBlank(message = "Isbn cannot be blank or empty or null")
    private String isbn;
    @Column(nullable = false)
    private String title;
    private LocalDate datePublished;
    private Integer numberOfCopies;
    private Double overdueFee;
//    private Double
    @ManyToOne
    @JoinColumn(name = "publisher_id", nullable = true)
    private Publisher publisher;
    @ManyToMany
//    @JoinTable(name = "book_autors",
//        joinColumns = )
    private List<Author> authors;
}
