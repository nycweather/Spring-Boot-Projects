package com.myspringbootapps.Project2.PokemonAPI.repository;

import com.myspringbootapps.Project2.PokemonAPI.models.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {
}
