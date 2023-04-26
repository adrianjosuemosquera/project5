package com.example.rutgerscafe;

public class coffee {

    public static double price = 0;
    private String cupSize;
    private String addIns;

    public coffee(String cupSize, String addIns, double price) {

        this.cupSize = cupSize;
        this.addIns = addIns;
        this.price = price;
    }
    /**
     * returns price of coffee total
     * @return total price
     */
    public double itemPrice() {
        return price;
    }

    /**
     * returns cup size
     * @return cup size
     */
    public String getCupSize() {
        return cupSize;
    }

    /**
     * sets cup size selected in drop down menu to cup size for object
     * @param cupSize to be set for object
     */
    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    /**
     * returns add ins for coffee
     * @return add ins for coffee
     */
    public String getAddIns() {
        return addIns;
    }

    /**
     * changes addIns in coffee object
     * @param addIns addins in coffee object
     */
    public void setAddIns(String addIns) {
        this.addIns = addIns;
    }

    /**
     * sets price of coffee
     * @param price price to change price of coffee to
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return getCupSize() + " " + getAddIns() + " " + " Coffee";
    }

}
