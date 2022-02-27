package dog;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class DogManager {

    private List<Dog> dogNameCountry = new ArrayList<>();

    public String getCountryByExactDogSpecies(String name, Path path) {
        if(name.length() == 0 || name.isBlank()) {
            throw new IllegalArgumentException("No such dog name found.");
        }
        List<String> file = loadFile(path);
        String result = null;
        for(int i = 1; i < file.size(); i++) {
            String[] fileSplit = file.get(i).split(";");
            String dogName = fileSplit[1].toLowerCase();
            String country = fileSplit[4];
            if(dogName.equals(name.toLowerCase())) {
                result = country;
            }
        }
        return result;
    }
    


    public List<Dog> getDogsInAlphabeticalOrderByName() {
        List<Dog> dogFile = new ArrayList<>(dogNameCountry);
        return dogFile.stream().sorted(Comparator.comparing(Dog::getName)).collect(Collectors.toList());
    }

    public Map<String, Integer> getDogStatistics() {
        Map<String, Integer> result = new HashMap<>();
        return result;
    }

    public List<String> loadFile(Path path) {
        try {
            return Files.readAllLines(path);
        }
        catch (IOException ioe) {
            throw new IllegalArgumentException("Cannot read file!");
        }
    }

    public void initDogList(Path path) {
        List<String> file = loadFile(path);
        for(int i = 1; i < file.size(); i++) {
            String[] fileSplit = file.get(i).split(";");
            String dogName = fileSplit[1];
            String country = fileSplit[4];
            dogNameCountry.add(new Dog(dogName, country, "http"));
        }
    }

    public List<Dog> getDogNameCountry() {
        return new ArrayList<>(dogNameCountry);
    }
}
