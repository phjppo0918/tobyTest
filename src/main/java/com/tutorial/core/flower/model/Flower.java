package com.tutorial.core.flower.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Flower {
    private Integer id;
    private String name;
    private Integer price;
    private String flowerLanguage;
}
