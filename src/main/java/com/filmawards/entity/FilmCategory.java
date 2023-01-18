package com.filmawards.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class FilmCategory {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    private String filmCategoryName;


    public FilmCategory(String filmCategoryName) {
        this.filmCategoryName = filmCategoryName;
    }
}
