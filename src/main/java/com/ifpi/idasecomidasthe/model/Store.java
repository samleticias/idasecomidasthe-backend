package com.ifpi.idasecomidasthe.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "stores")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private String openingHours;
    private Double latitude;
    private Double longitude;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}