package com.example.rutgerscafe;
/**
 * Creates Donut object.
 * @author Zhenglin Li, Adrian Mosquera
 */
public class Donut {
    private String flavor,type;

    /**
     * main constructor of donut
     * @param flavor donut topping
     * @param type hole, yeast, or wheat donuts
     */
    public Donut(String flavor, String type) {
        this.flavor = flavor;
        this.type = type;
    }

    /**
     * @return flavor of current donut
     */
    public String getFlavor(){
        return this.flavor;
    }

    /**
     * @return type of donut
     */
    public String getType(){
        return this.type;
    }

    /**
     * @return string of donut when you print it.
     */
    @Override
    public String toString(){
        return getFlavor() + " " + getType();
    }
}
