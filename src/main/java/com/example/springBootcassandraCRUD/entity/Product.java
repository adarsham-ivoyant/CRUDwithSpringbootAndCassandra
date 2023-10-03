package com.example.springBootcassandraCRUD.entity;

import lombok.*;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Product {

    @PrimaryKey
    private int id;
    private String name;
}
