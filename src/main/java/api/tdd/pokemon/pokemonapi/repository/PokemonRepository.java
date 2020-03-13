package api.tdd.pokemon.pokemonapi.repository;

import api.tdd.pokemon.pokemonapi.entity.PokemonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PokemonRepository extends JpaRepository<PokemonEntity, Long> {
    List<PokemonEntity> findAllByNameContaining(String name);
}
