package pl.kurs.watercontainers.models;

import pl.kurs.watercontainers.exceptions.InvalidWaterAmountException;

import java.io.Serializable;
import java.util.Objects;

public class WaterContainer implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private double maxCapacity;
    private double waterLevel;

    public WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }

    public void addWater(double value) {
        if (value <= 0) {
            throw new InvalidWaterAmountException("Value should by more than 0");
        }
        if (waterLevel + value > maxCapacity) {
            throw new InvalidWaterAmountException("Too much water to add");
        }
        waterLevel += value;
    }

    public void subtractWater(double value) {
        if (value <= 0) {
            throw new InvalidWaterAmountException("Value should be more than 0");
        }
        if (waterLevel - value < 0) {
            throw new InvalidWaterAmountException("Too much water to subtract");
        }
        waterLevel -= value;
    }
    public void pourWater(WaterContainer destinationContainer, double value) {
        if (destinationContainer == null) {
            throw new IllegalArgumentException("Destination container can not be null");
        }
        if (value <= 0) {
            throw new InvalidWaterAmountException("Valude should be more than 0");
        }
        this.subtractWater(value);
        destinationContainer.addWater(value);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public double getMaxCapacity() {
        return maxCapacity;
    }
    public void setMaxCapacity(double maxCapacity) {
        this.maxCapacity = maxCapacity;
    }
    public double getWaterLevel() {
        return waterLevel;
    }
    public void setWaterLevel(double waterLevel) {
        this.waterLevel = waterLevel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WaterContainer that = (WaterContainer) o;
        return Double.compare(maxCapacity, that.maxCapacity) == 0 && Double.compare(waterLevel, that.waterLevel) == 0 && Objects.equals(name, that.name);
    }
    @Override
    public int hashCode() {
        return Objects.hash(name, maxCapacity, waterLevel);
    }

    @Override
    public String toString() {
        return "WaterContainer{" +
                "name='" + name + '\'' +
                ", maxCapacity=" + maxCapacity +
                ", waterLevel=" + waterLevel +
                '}';
    }
}
