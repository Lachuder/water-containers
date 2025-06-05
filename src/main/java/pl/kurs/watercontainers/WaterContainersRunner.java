package pl.kurs.watercontainers;

import pl.kurs.watercontainers.models.WaterContainer;
import pl.kurs.watercontainers.services.WaterContainerService;

import java.util.List;
import java.util.Optional;

public class WaterContainersRunner {

    public static void main(String[] args) {


        WaterContainer waterContainer1 = new WaterContainer("Beczka", 100, 0);
        WaterContainer waterContainer2 = new WaterContainer("Zbiornik", 1000, 50);
        WaterContainer waterContainer3 = new WaterContainer("Mauser", 10_000, 1000);

        List<WaterContainer> waterContainerList = List.of(waterContainer1, waterContainer2, waterContainer3);

        Optional<WaterContainer> containerWithBiggestAmountOfWater = WaterContainerService.findContainerWithBiggestAmountOfWater(waterContainerList);

        System.out.println("containerWithBiggestAmountOfWater = " + containerWithBiggestAmountOfWater);

        waterContainer1.addWater(90);
        waterContainer2.subtractWater(45);



    }

}
