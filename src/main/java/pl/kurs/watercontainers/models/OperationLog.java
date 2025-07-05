package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.sql.Timestamp;

public class OperationLog implements Serializable {

//    dla każdej operacji pamiętamy:
//    datę i czas jej wykonania, jej nazwę, zbiornik na którym była ona wykonana oraz ilość wody jaka była brana pod uwagę,
//    oraz to czy operacja się powiodła czy nie.

    private static final long serialVersionUID = 1L;

    private final Timestamp timestamp;
    private final OperationType operationType;
    private final WaterContainer waterContainer;
    private final double waterAmount;
    private final boolean success;

    public OperationLog(Timestamp timestamp, OperationType operationType, WaterContainer waterContainer, double waterAmount, boolean success) {
        this.timestamp = timestamp;
        this.operationType = operationType;
        this.waterContainer = waterContainer;
        this.waterAmount = waterAmount;
        this.success = success;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }
    public OperationType getOperationType() {
        return operationType;
    }
    public WaterContainer getWaterContainer() {
        return waterContainer;
    }
    public double getWaterAmount() {
        return waterAmount;
    }
    public boolean isSuccess() {
        return success;
    }

    public enum OperationType {ADD, SUBTRACT}

}
