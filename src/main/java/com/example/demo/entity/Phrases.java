package com.example.demo.entity;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "phrases")
@EqualsAndHashCode
@ToString
@Immutable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Phrases {


    @Id
    @Column(name = "PHTRASES_ID", updatable = false, nullable = false)
    private String id;

    @Column
    private String characters;

    @Column
    private String phrase;

}
