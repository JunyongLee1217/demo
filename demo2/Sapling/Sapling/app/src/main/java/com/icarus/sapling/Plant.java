// Authored by: Alex Gonzales
// 11/10/2019

package com.icarus.sapling;

public class Plant {
    private String name;
    private String type;
    private double waterF;
    private double waterQ;
    private int maturation;
    private String soilWetness;
    private double space;
    private String sun;
    private String vulnerabilities;
    private double yield;
    private String picture;
    private boolean inGarden;

    public Plant() {
    }

    public void setName(String _name) {
        name = _name;
    }
    public void setType(String _type) {
        type = _type;
    }
    public void setWaterF(double _waterF) {
        waterF = _waterF;
    }
    public void setWaterQ(double _waterQ) {
        waterQ = _waterQ;
    }
    public void setMaturation(int _maturation) {
        maturation = _maturation;
    }
    public void setSoilWetness(String _soilWetness) {
        soilWetness = _soilWetness;
    }
    public void setSpace(double _space) {
        space = _space;
    }
    public void setSun(String _sun) {
        sun = _sun;
    }
    public void setVulnerabilities(String _vulnerabilities) {
        vulnerabilities = _vulnerabilities;
    }
    public void putInGarden() { inGarden = true; }
    public void removeFromGarden() { inGarden = false; }

    public void setYield(double _yield) {
        yield = _yield;
    }
    public void setPicture(String _picture) {
        picture = _picture;
    }
    public void setInGarden(boolean _inGarden) {
        inGarden = _inGarden;
    }

    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
    public double getWaterF() {
        return waterF;
    }
    public double getWaterQ() {
        return waterQ;
    }
    public int getMaturation() {
        return maturation;
    }
    public String getSoilWetness() {
        return soilWetness;
    }
    public double getSpace() {
        return space;
    }
    public String getSun() {
        return sun;
    }
    public String getVulnerabilities() {
        return vulnerabilities;
    }
    public double getYield() {
        return yield;
    }
    public String getPicture() {
        return picture;
    }
    public boolean isInGarden() {
        return inGarden;
    }

}


