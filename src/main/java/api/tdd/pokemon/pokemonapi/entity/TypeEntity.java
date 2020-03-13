package api.tdd.pokemon.pokemonapi.entity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "DATA_TYPE")
public class TypeEntity extends BaseEntity {

    @OneToMany
    public List<TypeEntity> weaknessList;

    @OneToMany
    public List<TypeEntity> strongAgainstList;

    public TypeEntity() {

    }

    public TypeEntity(String name) {
        super();
    }

    public TypeEntity(long id, String name) {
        super(id, name);
    }

    public List<TypeEntity> getWeaknessList() {
        return weaknessList;
    }

    public void setWeaknessList(List<TypeEntity> weaknessList) {
        this.weaknessList = weaknessList;
    }

    public List<TypeEntity> getStrongAgainstList() {
        return strongAgainstList;
    }

    public void setStrongAgainstList(List<TypeEntity> strongAgainstList) {
        this.strongAgainstList = strongAgainstList;
    }
}
