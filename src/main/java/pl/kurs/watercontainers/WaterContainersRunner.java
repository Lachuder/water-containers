package pl.kurs.watercontainers;

import pl.kurs.watercontainers.models.WaterContainer;
import pl.kurs.watercontainers.services.WaterContainerService;

import java.util.List;
import java.util.Optional;

public class WaterContainersRunner {

    public static void main(String[] args) {


        WaterContainer beczka = new WaterContainer("Beczka", 100, 0);
        WaterContainer zbiornik = new WaterContainer("Zbiornik", 1000, 50);
        WaterContainer mauser = new WaterContainer("Mauser", 10_000, 60);

        List<WaterContainer> waterContainerList = List.of(beczka, zbiornik, mauser);

        Optional<WaterContainer> containerWithBiggestAmountOfWater = WaterContainerService.findContainerWithBiggestAmountOfWater(waterContainerList);

        System.out.println("containerWithBiggestAmountOfWater = " + containerWithBiggestAmountOfWater);

        Optional<WaterContainer> containerWithBiggestUsedCapacity = WaterContainerService.findMostFilledContainer(waterContainerList);

        System.out.println("containerWithBiggestUsedCapacity = " + containerWithBiggestUsedCapacity);

        List<WaterContainer> allEmptyContainers = WaterContainerService.findAllEmptyContainers(waterContainerList);

        System.out.println("allEmptyContainers = " + allEmptyContainers);

//        beczka.addWater(90);
//        zbiornik.subtractWater(45);

        beczka.pourWater(zbiornik, 10);

    }

}
