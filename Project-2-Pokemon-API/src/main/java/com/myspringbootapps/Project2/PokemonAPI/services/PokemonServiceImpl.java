package com.myspringbootapps.Project2.PokemonAPI.services;

import com.myspringbootapps.Project2.PokemonAPI.models.Pokemon;
import com.myspringbootapps.Project2.PokemonAPI.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PokemonServiceImpl implements PokemonService{

    @Autowired
    private PokemonRepository pokemonRepository;

    @Override
    public Pokemon savePokemon(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    @Override
    public List<Pokemon> fetchPokemon() {
        return pokemonRepository.findAll();
    }

    @Override
    public Pokemon fetchPokemonById(Integer pokemonId) {
        return pokemonRepository.findById(pokemonId).get();
    }

    @Override
    public Pokemon updatePokemonById(Integer pokemonId, Pokemon pokemon) {
        Pokemon pk = pokemonRepository.findById(pokemonId).get();
        if(Objects.nonNull(pokemon.getName()) &&
                !"".equalsIgnoreCase(pokemon.getType())) {
            pk.setName(pokemon.getName());
        }

        if(Objects.nonNull(pokemon.getName()) &&
                !"".equalsIgnoreCase(pokemon.getName())) {
            pk.setType(pokemon.getType());
        }


        return pokemonRepository.save(pk);
    }

    @Override
    public void deletePokemonById(Integer pokemonId) {
        pokemonRepository.deleteById(pokemonId);
    }

}
