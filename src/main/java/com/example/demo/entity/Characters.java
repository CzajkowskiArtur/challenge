package com.example.demo.entity;

import jdk.nashorn.internal.ir.annotations.Immutable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


import javax.persistence.*;
import java.util.List;


@Entity(name = "characters")
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
@Immutable
public class Characters {

    @Id
    @Column
    private String id;

    @Column
    private String firstName;

    @Column
    private String lastName;

    @Column
    private String picture;

    @Column
    private Integer age;


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    private List<Phrases> phrases;
}
