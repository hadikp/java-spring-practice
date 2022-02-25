package trees;

public class AppleTree extends Tree {

    private Fruit fruit = Fruit.APPLE;


    public AppleTree(int leaves) {
        super(leaves);
    }

    public Fruit getFruit() {
        return fruit;
    }
}
