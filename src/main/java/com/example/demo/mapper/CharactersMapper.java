package com.example.demo.mapper;

import com.example.demo.entity.Characters;
import com.example.demo.entity.Phrases;
import com.example.demo.dto.CharactersDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CharactersMapper {

    public Characters mapper(CharactersDto dto) {

        Characters characters = new Characters();
        List<Phrases> listPhrases = new ArrayList<>();
        dto.getPhrasesDto().forEach(f ->
                {
                    Phrases build = Phrases.builder()
                            .id(f.getId())
                            .characters(f.getCharacter())
                            .phrase(f.getPhrase())
                            .build();

                    listPhrases.add(build);
                }
        );

        characters.setId(dto.getId());
        characters.setFirstName(dto.getFirstName());
        characters.setLastName(dto.getLastName());
        characters.setAge(dto.getAge());
        characters.setPicture(dto.getPicture());
        characters.setPhrases(listPhrases);

        return characters;
    }



}
