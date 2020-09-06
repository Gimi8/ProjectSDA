package io.mbab.sda.groupproject2.entity;

import io.mbab.sda.groupproject2.repository.SongRepository;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Song {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 64, nullable = false)
    private String title;

    @Column(length = 64, nullable = false)
    private String artist;

    @Column(length = 64, nullable = true)
    private double lenght;

    @ManyToOne
    private Album album;


}
