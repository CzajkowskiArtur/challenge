package com.example.demo.repository;

import com.example.demo.entity.Characters;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface  CharactersRepository extends JpaRepository<Characters, String> {

}
