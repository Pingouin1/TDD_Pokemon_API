package api.tdd.pokemon.pokemonapi.entity;

import javax.persistence.Entity;

@Entity
public class AbilityEntity extends BaseEntity {

    private String description;

    public AbilityEntity(){

    }

    public AbilityEntity(long id, String name) {
        super(id, name);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
