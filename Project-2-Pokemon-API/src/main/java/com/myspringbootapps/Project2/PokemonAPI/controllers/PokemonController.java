package com.myspringbootapps.Project2.PokemonAPI.controllers;

import com.myspringbootapps.Project2.PokemonAPI.models.Pokemon;
import com.myspringbootapps.Project2.PokemonAPI.services.PokemonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    private final Logger LOGGER = LoggerFactory.getLogger(PokemonController.class);

    @GetMapping("/pokemon")
    public List<Pokemon> getPokemon(){
        LOGGER.info("Inside getPokemon from PokemonController");
        return pokemonService.fetchPokemon();
    }

    @GetMapping("/pokemon/{id}")
    public Pokemon getPokemonById(@PathVariable("id") Integer pokemonId){
        LOGGER.info("Inside getPokemonById from PokemonController");
        return pokemonService.fetchPokemonById(pokemonId);
    }

    @PostMapping("/pokemon")
    public Pokemon savePokemon(@RequestBody Pokemon pokemon){
        LOGGER.info("Inside savePokemon from PokemonController");
        return pokemonService.savePokemon(pokemon);
    }

    @PutMapping("/pokemon/{id}")
    public Pokemon updatePokemonById(@PathVariable("id") Integer pokemonId, @RequestBody Pokemon pokemon){
        LOGGER.info("Inside savePokemon from PokemonController");
        return pokemonService.updatePokemonById(pokemonId, pokemon);
    }

    @DeleteMapping("/pokemon/{id}")
    public String deletePokemonById(@PathVariable("id") Integer pokemonId){
        LOGGER.info("Inside savePokemon from PokemonController");
        pokemonService.deletePokemonById(pokemonId);
        return "Deleted!";

    }
}
