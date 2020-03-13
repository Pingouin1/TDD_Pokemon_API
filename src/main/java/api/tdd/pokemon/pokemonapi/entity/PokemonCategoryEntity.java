package api.tdd.pokemon.pokemonapi.entity;

import javax.persistence.Entity;

@Entity
public class PokemonCategoryEntity extends BaseEntity {

    public PokemonCategoryEntity() {

    }

    public PokemonCategoryEntity(String name) {
        super(name);
    }

    public PokemonCategoryEntity(long id, String name) {
        super(id, name);
    }
}
