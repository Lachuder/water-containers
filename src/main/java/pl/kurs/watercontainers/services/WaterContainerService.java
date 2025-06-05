package pl.kurs.watercontainers.services;

import pl.kurs.watercontainers.models.WaterContainer;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class WaterContainerService {

//    - znalezc zbiornik w ktorym jest najwiecej wody
//- znalezc zbiornik ktory jest najbardziej zapelniony
//- znalezc wszystkie puste zbiorniki.

    public static Optional<WaterContainer> findContainerWithBiggestAmountOfWater(List<WaterContainer> containerList) {
        Optional<WaterContainer> max = Optional.ofNullable(containerList)
                .orElseGet(Collections::emptyList)
                .stream()
                .max(Comparator.comparingDouble(WaterContainer::getWaterLevel));
        return max;
    }

}
