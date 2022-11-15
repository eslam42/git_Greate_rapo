/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstmodel;

/**
 *
 * @author Eng Eslam
 */
public class line {
    private int invNumber;
    private String name;
    private int counter;
    private double price;
    private header inv;
    public line(String name, double price, int counter, header inv) {
        this.name = name;
        this.price = price;
        this.counter = counter;
        this.inv = inv;  
    }


    public double getTotel(){        
    return counter * price ;
    }
    
    public line(int invNumber, String name, int counter, double price, header inv) {
        this.invNumber = invNumber;
        this.name = name;
        this.counter = counter;
        this.price = price;
        this.inv = inv;
    }

    public header getInv() {
        return inv;
    }

    public void setInv(header inv) {
        this.inv = inv;
    }

    public line(header inv) {
        this.inv = inv;
    }

    public int getInvNumber() {
        return invNumber;
    }

    public void setInvNumber(int invNumber) {
        this.invNumber = invNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    public String getESlSV() {
            return inv.getNumber() + "," + name + "," + price + "," + counter;
        }
    
    @Override
    public String toString() {
        return "line{" + "invNumber=" + invNumber + ", name=" + name + ", counter=" + counter + ", price=" + price + '}';
    }
   
}
