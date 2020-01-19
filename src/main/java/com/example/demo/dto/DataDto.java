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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DataDto {

    @JsonProperty("data")
    private List<CharactersDto> data;

//    @JsonProperty("data")
//    private List<PhrasesListDto> phrasesDto;
}
