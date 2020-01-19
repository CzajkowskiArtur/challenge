package com.example.demo.resource;

import com.example.demo.JpaRepositoryIT;
import com.example.demo.entity.Characters;
import com.example.demo.repository.CharactersRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.hamcrest.CoreMatchers.is;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;


public class CharactersRestResourceTest extends JpaRepositoryIT {

    @Autowired
    CharactersRepository charactersRepository;

    @Test
    public void findByCharacter_shouldReturnEmptyIfCharactersNotFound() {

        //given
        final String characterID = "59edee68706374dfa957842fA";

        //when
        Optional<Characters> character = charactersRepository.findById(characterID);

        //then
        assertThat(character, is(Optional.empty()));
    }
}