package architect;

public class PublicBuildingPlan implements Plan {

    private PlanType planType;
    private String projectName;
    private int stock;
    private int area;

    public PublicBuildingPlan(String projectName, int stock, int area) {
        this.projectName = projectName;
        this.stock = stock;
        this.area = area;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return stock * area;
    }

    @Override
    public PlanType getType() {
        return planType;
    }

    public int getStock() {
        return stock;
    }

    public int getArea() {
        return area;
    }
}
