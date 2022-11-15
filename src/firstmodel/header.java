/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstmodel;

import java.util.ArrayList;

/**
 *
 * @author Eng Eslam
 */
public class header {
    private int number;
    private String date;
    private String name;
    private ArrayList<line> lines; 

    header() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
 
    public double getTotal(){
         double total = 0.0;
        for (line line : getLines()) {
            total += line.getTotel();
        }
        return total;
    }
    
    
    public header(int number, String date, String name) {
        this.number = number;
        this.date = date;
        this.name = name;
    }

    public ArrayList<line> getLines() {
        if (lines == null){
            lines = new ArrayList<>();
        }
        return lines;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
 
    

    

    @Override
    public String toString() {
        return "header{" + "number=" + number + ", date=" + date + ", name=" + name + '}';
    }

    public String getESlSV() {
    return number +","+ date+","+ name ;
        }
    
    
    
}
