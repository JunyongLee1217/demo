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
    private String picture;

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
    private void setPicture(String _picture) {
        picture = _picture;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public float getWaterF() {
        return waterF;
    }
    public float getWaterQ() {
        return waterQ;
    }
    public int setMaturation() {
        return maturation;
    }
    public String getSoilWetness() {
        return soilWetness;
    }
    public float getSpace() {
        return space;
    }
    public String getSun() {
        return sun;
    }
    public String getVulnerabilities() {
        return vulnerabilities;
    }
    public float getYield() {
        return yield;
    }
    public String getPicture() {
        return picture;
    }
}


