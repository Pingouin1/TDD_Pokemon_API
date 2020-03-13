package api.tdd.pokemon.pokemonapi.controller.service;

import api.tdd.pokemon.pokemonapi.entity.MoveEntity;
import api.tdd.pokemon.pokemonapi.repository.MoveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MoveService {

    @Autowired
    MoveRepository moveRepository;

    public List<MoveEntity> getAllMoves() {
        return moveRepository.findAll();
    }

    public List<MoveEntity> getMovesByName(String name) {
        return moveRepository.findAllByNameContaining(name);
    }

    public MoveEntity getMoveById(long id) {
        return moveRepository.findById(id).orElse(null);
    }
}
