package dog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DogTest {

    @Test
    public void testCreate() {
        Dog dog = new Dog("PULI", "HUNGARY", "http://www.fci.be/en/nomenclature/PULI-55.html");

        assertEquals("PULI", dog.getName());
        assertEquals("HUNGARY", dog.getCountry());
        assertEquals("http://www.fci.be/en/nomenclature/PULI-55.html", dog.getUrl());
    }

}