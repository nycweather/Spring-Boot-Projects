package com.myspringbootapps.Project2.PokemonAPI.services;

import com.myspringbootapps.Project2.PokemonAPI.models.Pokemon;

import java.util.List;

public interface PokemonService {
    Pokemon savePokemon(Pokemon pokemon);
    List<Pokemon> fetchPokemon();
    Pokemon fetchPokemonById(Integer pokemonId);
    Pokemon updatePokemonById(Integer pokemonId, Pokemon pokemon);
    void deletePokemonById(Integer pokemonId);
}
