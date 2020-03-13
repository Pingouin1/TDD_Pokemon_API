package api.tdd.pokemon.pokemonapi.service;

import api.tdd.pokemon.pokemonapi.entity.*;
import api.tdd.pokemon.pokemonapi.repository.PokemonRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@SpringBootTest
public class PokemonServiceTest {

    @Mock
    private PokemonRepository pokemonRepository;

    @InjectMocks
    PokemonService pokemonService;

    private final TypeEntity typeA = new TypeEntity(1L, "Sol");

    private final TypeEntity typeB = new TypeEntity(2L, "Feu");

    private final MoveCategoryEntity moveCategoryA = new MoveCategoryEntity(3L, "Statut");

    private final MoveCategoryEntity moveCategoryB = new MoveCategoryEntity(2L, "Spéciale");

    private final MoveEntity moveA = new MoveEntity(1L, "Abîme", this.typeA, 30, 5, moveCategoryA);

    private final MoveEntity moveB = new MoveEntity(2L, "Déflagration", this.typeB, 110, 85, 5, moveCategoryB);

    private final PokemonCategoryEntity pokemonCategoryA = new PokemonCategoryEntity(1L, "Graine");

    private final PokemonCategoryEntity pokemonCategoryB = new PokemonCategoryEntity(2L, "Lézard");

    private final AbilityEntity abilityA = new AbilityEntity(1L, "Engrais");

    private final AbilityEntity abilityB = new AbilityEntity(2L, "Brasier");

    private final PokemonEntity pokemonA = new PokemonEntity(1L, "Bulbizarre", typeA, Gender.DEUX, 1.00, 25, pokemonCategoryA, abilityA, Arrays.asList(moveA, moveB));

    private final PokemonEntity pokemonB = new PokemonEntity(2L, "Salamèche", typeB, Gender.DEUX, 1.25, 35, pokemonCategoryB, abilityB, Arrays.asList(moveA, moveB));

    @Test
    public void should_return_single_pokemon_when_id_exists() throws Exception {
        when(pokemonRepository.findById(1L)).thenReturn(Optional.of(pokemonA));

        PokemonEntity pokemonTest = pokemonService.getPokemonById(1L);
        assertTrue("should return single pokemon if id exists", pokemonA.equals(pokemonTest));
    }

    @Test
    public void should_return_null_when_id_does_not_exist() throws Exception {
        PokemonEntity pokemonTest = pokemonService.getPokemonById(100000L);
        assertNull(pokemonTest);
    }

    @Test
    public void should_return_list_of_pokemon() {
        when(pokemonRepository.findAll()).thenReturn(Arrays.asList(pokemonA, pokemonB));

        List<PokemonEntity> moveEntityList = pokemonService.getAllPokemon();
        PokemonEntity firstPokemon = moveEntityList.get(0);
        PokemonEntity secondPokemon = moveEntityList.get(1);

        assertAll("should return list of two moves with right parameters",
                () -> assertEquals("should return list of two moves", 2, moveEntityList.size()),
                () -> assertTrue(pokemonA.equals(firstPokemon)),
                () -> assertTrue(pokemonB.equals(secondPokemon)));

    }
}
