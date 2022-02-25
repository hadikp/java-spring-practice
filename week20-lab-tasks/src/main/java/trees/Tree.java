package trees;

public class Tree {

    protected Fruit fruit;
    protected int leaves;
    protected int weightOfFruit;

    public Tree(int leaves) {
        this.leaves = leaves;
    }

    public int growLeaves(int numberOfSunnyDays) {
        int numberOfLeaves = leaves +  (10 * numberOfSunnyDays);
        setLeaves(numberOfLeaves);
        return numberOfLeaves;
    }

    public void ripenFruit(int numberOfSunnyDays) {
        int numberOfLeaves = growLeaves(numberOfSunnyDays);
        this.weightOfFruit = numberOfLeaves / 50;
    }

    public int hostBirdNest() {
        return leaves / 200;

    }

    public Fruit getFruit() {
        return fruit;
    }

    public void setLeaves(int leaves) {
        this.leaves = leaves;
    }
}
