package api.tdd.pokemon.pokemonapi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DATA_MOVE_CATEGORY")
public class MoveCategoryEntity extends BaseEntity {

    public MoveCategoryEntity() {

    }

    public MoveCategoryEntity(String name) {
        super(name);
    }

    public MoveCategoryEntity(long id, String name) {
        super(id, name);
    }
}
