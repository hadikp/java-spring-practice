package dog;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class DogManagerTest {

    @Test
    public void testGetCountryByExactDogSpecies() {
        assertEquals("HUNGARY", new DogManager().getCountryByExactDogSpecies("PULI"));
    }

    @Test
    public void testGetCountryByExactDogSpeciesNotExistingSpecies() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new DogManager().getCountryByExactDogSpecies("xyz"));
        assertEquals("No such dog name found.", ex.getMessage());
    }

    @Test
    public void testGetDogsInAlphabeticalOrderByName() {
        List<Dog> dogs = new DogManager().getDogsInAlphabeticalOrderByName();

        assertEquals(354, dogs.size());
        assertEquals("AFFENPINSCHER", dogs.get(0).getName());
        assertEquals("APPENZELL CATTLE DOG", dogs.get(11).getName());
        assertEquals("YAKUTIAN LAIKA", dogs.get(351).getName());
    }

    @Test
    public void testGetDogStatistics() {
        Map<String, Integer> statistics = new DogManager().getDogStatistics();

        assertEquals(9, statistics.get("HUNGARY"));
        assertEquals(2, statistics.get("DENMARK"));
        assertEquals(10, statistics.get("RUSSIA"));
    }

}