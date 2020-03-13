package api.tdd.pokemon.pokemonapi.entity;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "DATA_POKEMON")
public class PokemonEntity extends BaseEntity {

    @ManyToOne(targetEntity = TypeEntity.class)
    private TypeEntity type;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private double height;

    private double weight;

    @ManyToOne(targetEntity = PokemonCategoryEntity.class)
    private PokemonCategoryEntity category;

    @ManyToOne
    private AbilityEntity ability;

    @OneToMany
    @JoinColumn(name = "id")
    private List<MoveEntity> moves;

    public PokemonEntity() {}

    public PokemonEntity(long id, String name, TypeEntity type, Gender gender, double height, double weight, PokemonCategoryEntity category, AbilityEntity ability, List<MoveEntity> moves) {
        super(id, name);
        this.type = type;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.category = category;
        this.ability = ability;
        this.moves = moves;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public PokemonCategoryEntity getCategory() {
        return category;
    }

    public void setCategory(PokemonCategoryEntity category) {
        this.category = category;
    }

    public AbilityEntity getAbility() {
        return ability;
    }

    public void setAbility(AbilityEntity ability) {
        this.ability = ability;
    }

    public List<MoveEntity> getMoves() {
        return moves;
    }

    public void setMoves(List<MoveEntity> moves) {
        this.moves = moves;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PokemonEntity)) return false;
        PokemonEntity that = (PokemonEntity) o;
        return Double.compare(that.height, height) == 0 &&
                Double.compare(that.weight, weight) == 0 &&
                type.equals(that.type) &&
                gender == that.gender &&
                category.equals(that.category) &&
                ability.equals(that.ability) &&
                moves.equals(that.moves);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, gender, height, weight, category, ability, moves);
    }
}

