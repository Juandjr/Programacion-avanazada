package com.homework.task2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table("GAMES") // H2 prefiere trabajar en mayúsculas por defecto
public class Game {
    @Id
    private Long id;

    @Column("TITLE")
    private String title;

    @Column("PRICE")
    private Double price;

    @Column("STOCK")
    private Integer stock;
}
