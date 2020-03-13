package api.tdd.pokemon.pokemonapi.service;

import api.tdd.pokemon.pokemonapi.controller.service.MoveService;
import api.tdd.pokemon.pokemonapi.entity.CategoryEntity;
import api.tdd.pokemon.pokemonapi.entity.MoveEntity;
import api.tdd.pokemon.pokemonapi.entity.TypeEntity;
import api.tdd.pokemon.pokemonapi.repository.MoveRepository;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

public class MoveServiceTest {

    @MockBean
    private MoveRepository mockRepository;

    @Before
    public void init() {
        MoveEntity move1 = new MoveEntity();
        move1.setName("Abîme");
        move1.setAccuracy(30);
        move1.setCategory(new CategoryEntity(3L, "Statut"));
        move1.setPp(5);
        move1.setType(new TypeEntity(1L, "Sol"));

        MoveEntity move2 = new MoveEntity();
        move2.setName("Déflagration");
        move2.setPower(110);
        move2.setAccuracy(85);
        move2.setCategory(new CategoryEntity(2L, "Spéciale"));
        move2.setPp(5);
        move2.setType(new TypeEntity(2L, "Feu"));
        when(mockRepository.findById(1L)).thenReturn(Optional.of(move1));
        when(mockRepository.findAll()).thenReturn(Arrays.asList(move1, move2));
    }
    private final static MoveService moveService = new MoveService();

    @Test
    public void should_return_single_move_when_id_exists() {
        MoveEntity moveTest = moveService.getMoveById(1L);
        assertAll("Move non conforme",
                () -> assertEquals(1L, moveTest.getType().getId()),
                () -> assertEquals(3L, moveTest.getCategory().getId()),
                () -> assertEquals(1L, moveTest.getId()),
                () -> assertEquals(30, moveTest.getAccuracy()),
                () -> assertEquals(5, moveTest.getPp()),
                () -> assertEquals("Abîme", moveTest.getName()));
    }

    @Test
    public void should_return_null_when_id_does_not_exist() {
        MoveEntity moveTest = moveService.getMoveById(100000L);
        assertNull(moveTest);
    }

    @Test
    public void should_return_list_of_moves() {
        List<MoveEntity> moveEntityList = moveService.getAllMoves();
        MoveEntity firstMove = moveEntityList.get(0);
        MoveEntity secondMove = moveEntityList.get(1);
        assertAll("",
                () -> assertEquals("should return list of two moves", 2, moveEntityList.size()),
                () -> assertEquals(1L, firstMove.getType().getId()),
                () -> assertEquals(3L, firstMove.getCategory().getId()),
                () -> assertEquals(1L, firstMove.getId()),
                () -> assertEquals(30, firstMove.getAccuracy()),
                () -> assertEquals(5, firstMove.getPp()),
                () -> assertEquals("Abîme", firstMove.getName()),
                () -> assertEquals(2L, secondMove.getType().getId()),
                () -> assertEquals(1L, secondMove.getCategory().getId()),
                () -> assertEquals(2L, secondMove.getId()),
                () -> assertEquals(110, secondMove.getPower()),
                () -> assertEquals(85, secondMove.getAccuracy()),
                () -> assertEquals(5, secondMove.getPp()),
                () -> assertEquals("Déflagration", secondMove.getName())
                );

    }
}
