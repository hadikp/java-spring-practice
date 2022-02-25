package trees;

public class CherryTree extends Tree {

    private Fruit fruit = Fruit.CHERRY;

    public CherryTree(int leaves) {
        super(leaves);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        int numberOfLeaves = leaves +  (20 * numberOfSunnyDays);
        setLeaves(numberOfLeaves);
        return numberOfLeaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        int numberOfLeaves = growLeaves(numberOfSunnyDays);
        weightOfFruit = numberOfLeaves / 30;
    }

    @Override
    public Fruit getFruit() {
        return fruit;
    }
}
