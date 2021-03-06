package api.tdd.pokemon.pokemonapi.service;

import api.tdd.pokemon.pokemonapi.entity.PokemonEntity;
import api.tdd.pokemon.pokemonapi.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PokemonService {
    
    @Autowired
    PokemonRepository pokemonRepository;

    public List<PokemonEntity> getAllPokemon() {
        return pokemonRepository.findAll();
    }

    public List<PokemonEntity> getPokemonByName(String name) {
        return pokemonRepository.findAllByNameContaining(name);
    }

    public PokemonEntity getPokemonById(long id) {
        return pokemonRepository.findById(id).orElse(null);
    }
}
