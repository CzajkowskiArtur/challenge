package com.example.demo.service;

import com.example.demo.entity.Characters;
import com.example.demo.dto.CharactersDto;
import com.example.demo.exceptions.CharacterNotFoundException;
import com.example.demo.mapper.CharactersMapper;
import com.example.demo.repository.CharactersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class CharactersServiceImpl implements CharactersService {

    private final CharactersRepository charactersRepository;
    private final CharactersMapper charactersMapper;

    public void saveAllCharacters(CharactersDto dto) {
        Characters characters = charactersMapper.mapper(dto);
        charactersRepository.save(characters);
    }

    @Override
    public void save(CharactersDto dto) {
        Characters mapper = charactersMapper.mapper(dto);
        charactersRepository.save(mapper);
    }

    public List<Characters> findAllCharacters() {
        return charactersRepository.findAll();
    }

    @Override
    public Characters findById(String id) {
        return charactersRepository.findById(id).orElseThrow(CharacterNotFoundException::new);
    }

    @Override
    public void deleteCharacterById(String id) {
        charactersRepository.deleteById(id);
    }


}
