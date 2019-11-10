package com.icarus.sapling;

public class Plant {
    private String name;
    private String type;
    private float waterF;
    private float waterQ;
    private int maturation;
    private String soilWetness;
    private float space;
    private String sun;
    private String vulnerabilities;
    private float yield;

    public Plant() {}

    private void setName(String _name) {
        name = _name;
    }
    private void setType(String _type) {
        type = _type;
    }
    private void setWaterF(float _waterF) {
        waterF = _waterF;
    }
    private void setWaterQ(float _waterQ) {
        waterQ = _waterQ;
    }
    private void setMaturation(int _maturation) {
        maturation = _maturation;
    }
    private void setSoilWetness(String _soilWetness) {
        soilWetness = _soilWetness;
    }
    private void setSpace(float _space) {
        space = _space;
    }
    private void setSun(String _sun) {
        sun = _sun;
    }
    private void setVulnerabilities(String _vulnerabilities) {
        vulnerabilities = _vulnerabilities;
    }
    private void setYield(float _yield) {
        yield = _yield;
    }
}
