package architect;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlanTest {

    @Test
    public void testCreateResidentialBuildingPlan() {
        ResidentialBuildingPlan plan = new ResidentialBuildingPlan("Baracska, Rákóczi u. 77.", House.FAMILY_HOUSE, 2, 80);

        assertEquals("Baracska, Rákóczi u. 77.", plan.getProjectName());
        assertEquals(House.FAMILY_HOUSE, plan.getHouse());
        assertEquals(2, plan.getStock());
        assertEquals(80, plan.getArea());
        assertEquals(160, plan.calculateSquareMeter());
       // assertEquals(PlanType.RESIDENTIAL, plan.getType());
    }

    @Test
    public void testCreatePublicBuildingPlan() {
        PublicBuildingPlan plan = new PublicBuildingPlan("Óvoda, Vál", 1, 350);

        assertEquals("Óvoda, Vál", plan.getProjectName());
        assertEquals(1, plan.getStock());
        assertEquals(350, plan.getArea());
        assertEquals(350, plan.calculateSquareMeter());
        //assertEquals(PlanType.PUBLIC, plan.getType());
    }

    @Test
    public void testCreateIndustrialBuildingPlan() {
        IndustrialBuildingPlan plan = new IndustrialBuildingPlan("Műkőgyártó üzem, Kajászó", 250, 2, 600);

        assertEquals("Műkőgyártó üzem, Kajászó", plan.getProjectName());
        assertEquals(250, plan.getAreaOfOfficeBlock());
        assertEquals(2, plan.getStock());
        assertEquals(600, plan.getAreaOfManufacturingHall());
        assertEquals(1100, plan.calculateSquareMeter());
        //assertEquals(PlanType.INDUSTRIAL, plan.getType());
    }

}