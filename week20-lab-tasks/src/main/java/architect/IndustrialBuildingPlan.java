package architect;

public class IndustrialBuildingPlan implements Plan {

    private PlanType planType;
    private String projectName;
    private int areaOfOfficeBlock;
    private int stock;
    private int areaOfManufacturingHall;

    public IndustrialBuildingPlan(String projectName, int areaOfOfficeBlock, int stock, int areaOfManufacturingHall) {
        this.projectName = projectName;
        this.areaOfOfficeBlock = areaOfOfficeBlock;
        this.stock = stock;
        this.areaOfManufacturingHall = areaOfManufacturingHall;
    }

    @Override
    public String getProjectName() {
        return projectName;
    }

    @Override
    public int calculateSquareMeter() {
        return stock * areaOfOfficeBlock + areaOfManufacturingHall;
    }

    @Override
    public PlanType getType() {
        return planType;
    }

    public int getAreaOfOfficeBlock() {
        return areaOfOfficeBlock;
    }

    public int getStock() {
        return stock;
    }

    public int getAreaOfManufacturingHall() {
        return areaOfManufacturingHall;
    }
}
