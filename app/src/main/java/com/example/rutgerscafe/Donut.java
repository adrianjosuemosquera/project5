package com.example.rutgerscafe;

public class Donut {
    private String flavor,type;

    public Donut(String flavor, String type) {
        this.flavor = flavor;
        this.type = type;
    }

    public String getFlavor(){
        return this.flavor;
    }

    public String getType(){
        return this.type;
    }

    @Override
    public String toString(){
        return getFlavor() + " " + getType();
    }
}
