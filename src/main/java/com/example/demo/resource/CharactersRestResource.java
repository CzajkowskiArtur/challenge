package com.example.demo.resource;

import com.example.demo.entity.Characters;
import com.example.demo.dto.CharactersDto;
import com.example.demo.exceptions.CharactersIdMismatchException;
import com.example.demo.service.CharactersService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@Controller
@RequiredArgsConstructor
public class CharactersRestResource {

    private final CharactersService charactersService;

    @Value("${spring.application.name}")
    private String appName;


    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }


    @GetMapping("/allCharacters")
    public Iterable findAllCharacters() {
        return charactersService.findAllCharacters();
    }

    @GetMapping("/characters/{id}")
    public Characters findByCharacters(@PathVariable String id, Model model) {
        return charactersService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        Characters byId = charactersService.findById(id);
        charactersService.deleteCharacterById(byId.getId());
    }

    @PutMapping("/{id}")
    public void updateCharacter(@RequestBody CharactersDto dto, @PathVariable String id) {
        if (dto.getId() != id) {
            throw new CharactersIdMismatchException();
        }
        charactersService.findById(id);
        charactersService.save(dto);
    }
}
