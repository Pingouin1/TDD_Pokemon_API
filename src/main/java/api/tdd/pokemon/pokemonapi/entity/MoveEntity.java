package api.tdd.pokemon.pokemonapi.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Table(name = "DATA_MOVE")
@SecondaryTable(name="DATA_TYPE",
        pkJoinColumns={
                @PrimaryKeyJoinColumn(name="id")})
@SecondaryTable(name="DATA_MOVE_CATEGORY",
        pkJoinColumns={
                @PrimaryKeyJoinColumn(name="id")})
@SequenceGenerator(name="SEQ_MOVE",
        sequenceName="SEQUENCE_MOVE")
public class MoveEntity extends BaseEntity implements Serializable {

    @NotNull
    @ManyToOne(targetEntity = TypeEntity.class)
    private TypeEntity type;

    private int power;

    private int accuracy;

    @NotNull
    private int pp;

    @NotNull
    @ManyToOne(targetEntity = CategoryEntity.class)
    private CategoryEntity category;

    public MoveEntity() {}

    public MoveEntity(long id, String name, TypeEntity type, int power, int accuracy, int pp, CategoryEntity category) {
        super(id, name);
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.category = category;
    }

    public MoveEntity(long id, String name, TypeEntity type, int accuracy, int pp, CategoryEntity category) {
        super(id, name);
        this.type = type;
        this.accuracy = accuracy;
        this.pp = pp;
        this.category = category;
    }

    public TypeEntity getType() {
        return type;
    }

    public void setType(TypeEntity type) {
        this.type = type;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(int accuracy) {
        this.accuracy = accuracy;
    }

    public int getPp() {
        return pp;
    }

    public void setPp(int pp) {
        this.pp = pp;
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }
}
