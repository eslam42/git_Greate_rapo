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
public class headTabelModel extends AbstractTableModel{
    private ArrayList<header>headers;
    private String[] colum = {"Num","Date","Customer","Total"};
    public headTabelModel(ArrayList<header> headers) {
        this.headers = headers;
    }
    

    @Override
    public int getRowCount() {
        return headers.size(); 
    }

    @Override
    public int getColumnCount() {
        return colum.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        header head = headers.get(rowIndex);
        switch (columnIndex){
            case 0 :return head.getNumber();
            case 1 :return head.getDate();
            case 2 :return head.getName();
            case 3 :return head.getTotal();
            default :return "";
        }
    }

    @Override
    public String getColumnName(int column) {
        return colum[column];
    }
    
    
}
