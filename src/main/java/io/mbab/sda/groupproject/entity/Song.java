package io.mbab.sda.groupproject.entity;

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
    private String album;

    @Column
    private int lenght;

    @Column (length = 64, nullable = true)
    private String artist;




}
