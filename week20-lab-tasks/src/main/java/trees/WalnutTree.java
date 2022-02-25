package trees;

public class WalnutTree extends Tree {

    private Fruit fruit = Fruit.WALNUT;

    public WalnutTree(int leaves) {
        super(leaves);
    }

    @Override
    public int growLeaves(int numberOfSunnyDays) {
        int numberOfLeaves = leaves +  (30 * numberOfSunnyDays);
        setLeaves(numberOfLeaves);
        return numberOfLeaves;
    }

    @Override
    public void ripenFruit(int numberOfSunnyDays) {
        int numberOfLeaves = growLeaves(numberOfSunnyDays);
        weightOfFruit = numberOfLeaves / 10;
    }

    @Override
    public Fruit getFruit() {
        return fruit;
    }
}
