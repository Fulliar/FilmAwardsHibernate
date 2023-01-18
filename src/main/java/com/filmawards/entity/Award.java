package com.filmawards.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Award {


    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String awardName;

    public Award(String awardName) {
        this.awardName = awardName;
    }


}
