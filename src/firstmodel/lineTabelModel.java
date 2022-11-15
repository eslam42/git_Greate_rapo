/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstmodel;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Eng Eslam
 */
public class lineTabelModel extends AbstractTableModel {
    private ArrayList <line> lines ;
    private String[] colum = {"Num","Item Name","Item Price","Count","Item Total"};

    public ArrayList<line> getLines() {
        return lines;
    }
 
    public lineTabelModel(ArrayList<line> lines) {
        this.lines = lines;
    }
    @Override
    public int getRowCount() {
        return lines.size();
    }

    @Override
    public int getColumnCount() {
        return colum.length;
    }

    @Override
    public String getColumnName(int column) {
        return colum[column];
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        line line  = lines.get(rowIndex);
        switch (columnIndex){
        case 0 :return line.getInv() .getNumber();
        case 1 :return line.getName();
        case 2 :return line.getPrice() ;
        case 3 :return line.getCounter() ;
        case 4 :return line.getTotel();
        default :return "";
        }
        
    }
    
    
}
