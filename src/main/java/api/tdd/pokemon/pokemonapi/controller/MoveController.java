package api.tdd.pokemon.pokemonapi.controller;

import api.tdd.pokemon.pokemonapi.service.MoveService;
import api.tdd.pokemon.pokemonapi.entity.MoveEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MoveController {

    @Autowired
    private MoveService moveService;

    @GetMapping(value = "/moves")
    public List<MoveEntity> getMoves() {
        return moveService.getAllMoves();
    }

    @GetMapping(value = "/moves/names/{name}")
    public List<MoveEntity> getMoveByName(@PathVariable String name) {
        return moveService.getMovesByName(name);
    }

    @GetMapping(value = "/moves/{id}")
    public MoveEntity getMoveById(@PathVariable long id) {
        try {
            return moveService.getMoveById(id);
        } catch (Exception e) {
            System.out.println("Erreur lors de la récupération du move ayant l'id : " + id);
            return null;
        }
    }

}
