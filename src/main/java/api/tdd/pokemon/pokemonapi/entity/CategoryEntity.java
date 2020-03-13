package api.tdd.pokemon.pokemonapi.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "DATA_MOVE_CATEGORY")
public class CategoryEntity extends BaseEntity {

    public CategoryEntity() {

    }

    public CategoryEntity(String name) {
        super(name);
    }

    public CategoryEntity(long id, String name) {
        super(id, name);
    }
}
