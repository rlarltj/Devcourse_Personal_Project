package com.prgrms.movieprj.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@Getter
public class Movie extends BaseEntity {
    @Id
    @Column(name = "movie_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "{exception.movie.name.null}")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "{exception.movie.director.null}")
    @Column(name = "director")
    private String director;

    @NotNull(message = "{exception.movie.price.null}")
    @Positive(message = "{exception.movie.price.positive}")
    @Column(name = "price")
    private int price;

    @NotNull(message = "{exception.movie.running.null}")
    @Positive
    @Column(name = "running")
    private int running;

    @NotNull(message = "{exception.movie.timeTable.null}")
    @Column(name = "timeTable")
    private LocalDateTime timeTable;

    @OneToMany(mappedBy = "movie")
    @Builder.Default
    private List<Review> reviews = new ArrayList<>();
}
