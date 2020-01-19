package com.example.demo.resources;

import com.example.demo.dto.DataDto;
import com.example.demo.dto.PhrasesDto;
import com.example.demo.dto.PhrasesListDto;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.List;


@Component
public class ResourceFromJsonX {

    public  List<DataDto> getCharactersFromFieldJson(String pathname) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        List<DataDto> list = objectMapper.readValue(new File(pathname), new TypeReference<List<DataDto>>() {
        });

        return list;
    }

    public List<PhrasesListDto> getPhrasesFromFieldJson(String pathname) throws IOException {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

        List<PhrasesListDto> list = objectMapper.readValue(new File(pathname), new TypeReference<List<PhrasesListDto>>() {
        });

        return list;
    }
}

