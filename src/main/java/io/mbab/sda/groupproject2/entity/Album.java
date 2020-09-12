package io.mbab.sda.groupproject2.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    @Column(length = 64, nullable = false)
    private String name;


    @Column(length = 64, nullable = false)
    private String artistName ;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "album")
    private Set<Song> songs;



}

