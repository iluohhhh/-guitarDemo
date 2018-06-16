package com.github.cumtfc.guitar.po.guitar;


import java.util.Objects;

public class GuitarSpec {

    private String builder;

    private String model;

    private String type;

    private String backWood;

    private String topWood;

    private int serialNumber;


    public GuitarSpec() {
    }


    public GuitarSpec(String builder, String model, String type, String backWood, String topWood, int serialNumber) {
        super();
        this.builder = builder;
        this.model = model;
        this.type = type;
        this.backWood = backWood;
        this.topWood = topWood;
        this.serialNumber = serialNumber;
    }


    public boolean matches(GuitarSpec otherSpec) {
        if (otherSpec.builder != null && !Objects.equals(builder, otherSpec.builder)) {
            return false;
        }
        if (otherSpec.getModel() != null && otherSpec.getModel().trim().length() > 0 && !otherSpec.getModel()
            .toLowerCase().equals(model != null ? model.toLowerCase() : null)) {
            return false;
        }
        if (otherSpec.type != null && !Objects.equals(type, otherSpec.type)) {
            return false;
        }
        if (otherSpec.serialNumber > 0 && serialNumber != otherSpec.serialNumber) {
            return false;
        }
        if (otherSpec.backWood != null && !Objects.equals(backWood, otherSpec.backWood)) {
            return false;
        }
        return otherSpec.topWood == null || Objects.equals(topWood, otherSpec.topWood);
    }


    public String getBuilder() {
        return builder;
    }

    public void setBuilder(String builder) {
        this.builder = builder;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBackWood() {
        return backWood;
    }

    public void setBackWood(String backWood) {
        this.backWood = backWood;
    }

    public String getTopWood() {
        return topWood;
    }

    public void setTopWood(String topWood) {
        this.topWood = topWood;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }


    @Override
    public String toString() {
        return "GuitarSpec{" +
            "builder='" + builder + '\'' +
            ", model='" + model + '\'' +
            ", type='" + type + '\'' +
            ", backWood='" + backWood + '\'' +
            ", topWood='" + topWood + '\'' +
            ", serialNumber=" + serialNumber +
            '}';
    }
}
