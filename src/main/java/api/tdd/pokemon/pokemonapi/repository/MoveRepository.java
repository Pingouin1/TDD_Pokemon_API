package api.tdd.pokemon.pokemonapi.repository;

import api.tdd.pokemon.pokemonapi.entity.MoveEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MoveRepository extends JpaRepository<MoveEntity, Long> {

}
