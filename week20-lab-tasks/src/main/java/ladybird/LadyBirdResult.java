package ladybird;


import java.util.*;

public class LadyBirdResult {

    private LadiBirdrepository ladiBirdrepository;

    public LadyBirdResult(LadiBirdrepository ladiBirdrepository) {
        this.ladiBirdrepository = ladiBirdrepository;
    }

    public List<String> getLadybirdsWithExactNumberOfPoints(int number) {
        List<LadyBird> ladybirds = ladiBirdrepository.loadData();
        List<String> result = new ArrayList<>();
        for(LadyBird lb: ladybirds) {
            if(lb.getNumberOfPoints() == number) {
                result.add(lb.getHungarianName());
            }
        }
        return result;
    }

    public Map<Integer, Integer> getLadybirdsByNumberOfPoints() {
        List<LadyBird> ladybirds = ladiBirdrepository.loadData();
        Map<Integer, Integer> result = new TreeMap<>();
        result.put(0, 0);
        for(LadyBird lb:ladybirds) {
            Integer numberOfPoints = result.get(lb.getNumberOfPoints());
            if(numberOfPoints == null) {
                result.put(lb.getNumberOfPoints(), 1);
            } else {
                numberOfPoints += 1;
                result.put(lb.getNumberOfPoints(), numberOfPoints);
            }
        }
        return result;
    }

    public Set<LadyBird> getLadybirdByPartOfLatinNameAndNumberOfPoints(String partOfName, int numberOfPoints) {
        List<LadyBird> ladybirds = ladiBirdrepository.loadData();
        Set<LadyBird> result = new LinkedHashSet<>();
        for(LadyBird lb: ladybirds) {
            if(lb.getLatinName().contains(partOfName) && lb.getNumberOfPoints() == numberOfPoints) {
                result.add(lb);
            }
        }
        return result;
    }

    public Map<String, Integer> getLadybirdStatistics() {
        List<LadyBird> ladybirds = ladiBirdrepository.loadData();
        Map<String, Integer> result = new TreeMap<>();
        for(LadyBird lb: ladybirds) {
            Integer genus = result.get(lb.getGenus());
            if(genus == null) {
                result.put(lb.getGenus(), 1);
            } else {
                genus += 1;
                result.put(lb.getGenus(), genus);
            }
        }
        return result;
    }
}
