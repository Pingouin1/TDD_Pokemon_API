package api.tdd.pokemon.pokemonapi.service;

import api.tdd.pokemon.pokemonapi.entity.MoveCategoryEntity;
import api.tdd.pokemon.pokemonapi.entity.MoveEntity;
import api.tdd.pokemon.pokemonapi.entity.TypeEntity;
import api.tdd.pokemon.pokemonapi.repository.MoveRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class MoveServiceTest {

    @Mock
    private MoveRepository moveRepository;

    @InjectMocks
    MoveService moveService;

    private final TypeEntity typeA = new TypeEntity(1L, "Sol");

    private final TypeEntity typeB = new TypeEntity(2L, "Feu");

    private final MoveCategoryEntity categoryA = new MoveCategoryEntity(3L, "Statut");

    private final MoveCategoryEntity categoryB = new MoveCategoryEntity(2L, "Spéciale");

    private final MoveEntity moveA = new MoveEntity(1L, "Abîme", this.typeA, 30, 5, categoryA);

    private final MoveEntity moveB = new MoveEntity(2L, "Déflagration", this.typeB, 110, 85, 5, categoryB);

    @Test
    public void should_return_single_move_when_id_exists() throws Exception {
        when(moveRepository.findById(1L)).thenReturn(Optional.of(moveA));

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
    public void should_return_null_when_id_does_not_exist() throws Exception {
        MoveEntity moveTest = moveService.getMoveById(100000L);
        assertNull(moveTest);
    }

    @Test
    public void should_return_list_of_moves() {
        when(moveRepository.findAll()).thenReturn(Arrays.asList(moveA, moveB));

        List<MoveEntity> moveEntityList = moveService.getAllMoves();
        MoveEntity firstMove = moveEntityList.get(0);
        MoveEntity secondMove = moveEntityList.get(1);

        assertAll("should return list of two moves with right parameters",
                () -> assertEquals("should return list of two moves", 2, moveEntityList.size()),
                () -> assertEquals(1L, firstMove.getType().getId()),
                () -> assertEquals(3L, firstMove.getCategory().getId()),
                () -> assertEquals(1L, firstMove.getId()),
                () -> assertEquals(30, firstMove.getAccuracy()),
                () -> assertEquals(5, firstMove.getPp()),
                () -> assertEquals("Abîme", firstMove.getName()),
                () -> assertEquals(2L, secondMove.getType().getId()),
                () -> assertEquals(2L, secondMove.getCategory().getId()),
                () -> assertEquals(2L, secondMove.getId()),
                () -> assertEquals(110, secondMove.getPower()),
                () -> assertEquals(85, secondMove.getAccuracy()),
                () -> assertEquals(5, secondMove.getPp()),
                () -> assertEquals("Déflagration", secondMove.getName()));

    }
}
