package api.tdd.pokemon.pokemonapi.entity;

import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MoveEntityTest {

    @Test
    public void should_return_every_parameter_with_4_parameters_on_move_constructor() {
        String name = "Abîme";
        TypeEntity type = new TypeEntity("Sol");
        int accuracy = 30;
        int pp = 5;
        CategoryEntity category = new CategoryEntity("Statut");
        MoveEntity move = new MoveEntity();
        move.setName(name);
        move.setAccuracy(accuracy);
        move.setCategory(category);
        move.setPp(pp);
        move.setType(type);
        assertAll("should contain all parameters except power",
                ()-> assertEquals("should return name 'Abîme'", name, move.getName()),
                ()-> assertEquals("should return type 'Sol'", "Sol", move.getType().getName()),
                ()-> assertEquals("should return accuracy 30", accuracy, move.getAccuracy()),
                ()-> assertEquals("should return category 'Statut'", category, move.getCategory()),
                ()-> assertEquals("should return pp 5", move.getPp(), pp));
    }

}
