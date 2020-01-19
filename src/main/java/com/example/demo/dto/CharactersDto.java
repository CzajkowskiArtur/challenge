package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.util.List;


@Getter
@Setter
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
public class CharactersDto {

    @JsonProperty("_id")
    private String id;
    private String firstName;
    private String lastName;
    private String picture;
    private Integer age;

    private  List<PhrasesDto> phrasesDto;
}
