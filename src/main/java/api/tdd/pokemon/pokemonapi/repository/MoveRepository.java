package api.tdd.pokemon.pokemonapi.repository;

import api.tdd.pokemon.pokemonapi.entity.MoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoveRepository extends JpaRepository<MoveEntity, Long> {

    List<MoveEntity> findAllByNameContaining(String name);
}
