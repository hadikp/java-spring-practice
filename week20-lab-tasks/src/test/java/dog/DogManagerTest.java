package dog;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class DogManagerTest {

    Path path;
    DogManager dogManager;

    @BeforeEach
    void init() {
        path = Path.of("src/test/resources/dog.csv");
        dogManager = new DogManager();
        dogManager.initDogList(path);
    }

    @Test
    void p() {
        //dogManager.getDogsInAlphabeticalOrderByName();
        //System.out.println(dogManager.getDogNameCountry());
    }

    @Test
    public void testGetCountryByExactDogSpecies() {
        assertEquals("HUNGARY", new DogManager().getCountryByExactDogSpecies("PULI", path));
    }

    @Test
    public void testGetCountryByExactDogSpeciesNotExistingSpecies() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> new DogManager().getCountryByExactDogSpecies("", path));
        assertEquals("No such dog name found.", ex.getMessage());
    }

    @Test
    public void testGetDogsInAlphabeticalOrderByName() {
        List<Dog> dogs = dogManager.getDogsInAlphabeticalOrderByName();

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