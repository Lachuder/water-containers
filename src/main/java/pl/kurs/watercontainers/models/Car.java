package pl.kurs.watercontainers.models;

import java.io.Serializable;
import java.util.Objects;

public class Car implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;
    private String model;
    private int productionYear;

    public Car(String name, String model, int productionYear) {
        this.name = name;
        this.model = model;
        this.productionYear = productionYear;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }
    public int getProductionYear() {
        return productionYear;
    }
    public void setProductionYear(int productionYear) {
        this.productionYear = productionYear;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return productionYear == car.productionYear && Objects.equals(name, car.name) && Objects.equals(model, car.model);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, model, productionYear);
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                '}';
    }
}
