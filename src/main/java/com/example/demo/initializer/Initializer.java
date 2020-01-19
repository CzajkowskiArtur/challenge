package com.example.demo.initializer;

import com.example.demo.dto.CharactersDto;
import com.example.demo.dto.DataDto;
import com.example.demo.dto.PhrasesDto;
import com.example.demo.dto.PhrasesListDto;
import com.example.demo.resources.ResourceFromJsonX;
import com.example.demo.service.CharactersService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class Initializer {

    private static final String pathToFieldJsonWithCharacters = "src/test/resources/characters.json";
    private static final String pathToFieldJsonWithPhrases = "src/test/resources/phrases.json";

    private final ResourceFromJsonX resourceFromJsonX;
    private final CharactersService charactersService;

    @PostConstruct
    public void initialzeDate() {

        try {
            List<DataDto> charactersFromFieldJson = resourceFromJsonX.getCharactersFromFieldJson(pathToFieldJsonWithCharacters);
            List<PhrasesListDto> phrasesFromFieldJson = resourceFromJsonX.getPhrasesFromFieldJson(pathToFieldJsonWithPhrases);
            saveAllCharacters(charactersFromFieldJson, phrasesFromFieldJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void saveAllCharacters(List<DataDto> listDto, List<PhrasesListDto> phrasesFromFieldJson) {
        DataDto dataDto = listDto.get(0);
        PhrasesListDto phrasesListDto = phrasesFromFieldJson.get(0);

        List<CharactersDto> data = dataDto.getData();

        List<PhrasesDto> data1 = phrasesListDto.getData();


        data.forEach(
                d -> {
                    List<PhrasesDto> collect = data1.stream().filter(f -> f.getCharacter().equals(d.getId())).collect(Collectors.toList());
                    d.setPhrasesDto(collect);
                    charactersService.saveAllCharacters(d);
                }
        );
    }
}
