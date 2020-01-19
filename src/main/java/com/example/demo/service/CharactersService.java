package com.example.demo.service;

import com.example.demo.entity.Characters;
import com.example.demo.dto.CharactersDto;


import java.util.List;

public interface CharactersService {

    void saveAllCharacters(CharactersDto dto);

    void save(CharactersDto dto);

    List<Characters> findAllCharacters();

    Characters findById(String id);

    void deleteCharacterById(String id);




}
