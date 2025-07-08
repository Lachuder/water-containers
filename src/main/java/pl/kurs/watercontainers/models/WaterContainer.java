package pl.kurs.watercontainers.models;

import pl.kurs.watercontainers.exceptions.InvalidWaterAmountException;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class WaterContainer implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private double maxCapacity;
    private double waterLevel;
    private List<OperationLog> logs = new ArrayList<>();

    public WaterContainer(String name, double maxCapacity, double waterLevel) {
        this.name = name;
        this.maxCapacity = maxCapacity;
        this.waterLevel = waterLevel;
    }

    public boolean addWater(double value) {
        boolean success;
        if (value <= 0) {
            System.out.println("Value should by more than 0");
            success = false;
        } else if (!addIsPossible(value)) {
            success = false;
        } else {
            waterLevel += value;
            success = true;
        }
        logs.add(new OperationLog(Timestamp.from(Instant.now()), OperationLog.OperationType.ADD, this, value, success));
        return success;
    }

    public boolean subtractWater(double value) {
        boolean success;
        if (value <= 0) {
            System.out.println("Value should be more than 0");
            success = false;
        } else if (!subtractIsPossible(value)) {
            success = false;
        } else {
            waterLevel -= value;
            success = true;
        }
        logs.add(new OperationLog(Timestamp.from(Instant.now()), OperationLog.OperationType.ADD, this, value, success));
        return success;
    }

    public boolean pourWater(WaterContainer destinationContainer, double value) {
        if (destinationContainer == null) {
            System.out.println("Destination container can not be null");
            return false;
        }
        if (value <= 0) {
            System.out.println("Value should be more than 0");
            return false;
        }
        if (!this.subtractIsPossible(value) || !destinationContainer.addIsPossible(value)) {
            return false;
        }
        boolean operation1 = this.subtractWater(value);
        boolean operation2 = destinationContainer.addWater(value);
        return operation1 && operation2;

    }

    private boolean subtractIsPossible(double value) {
        if (waterLevel - value < 0) {
            System.out.println("Too much water to subtract");
            return false;
        }
        return true;
    }

    private boolean addIsPossible(double value) {
        if (waterLevel + value > maxCapacity) {
            System.out.println("Too much water to add");
            return false;
        }
        return true;
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
