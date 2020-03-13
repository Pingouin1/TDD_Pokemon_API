package api.tdd.pokemon.pokemonapi.controller;

import api.tdd.pokemon.pokemonapi.entity.PokemonEntity;
import api.tdd.pokemon.pokemonapi.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokemonController {

    @Autowired
    PokemonService pokemonService;

    @GetMapping(value = "/pokemon")
    public List<PokemonEntity> getPokemon() {
        return pokemonService.getAllPokemon();
    }

    @GetMapping(value = "/pokemon/names/{name}")
    public List<PokemonEntity> getPokemonByName(@PathVariable String name) {
        return pokemonService.getPokemonByName(name);
    }

    @GetMapping(value = "/pokemon/{id}")
    public PokemonEntity getPokemonById(@PathVariable long id) {
        return pokemonService.getPokemonById(id);
    }
}
