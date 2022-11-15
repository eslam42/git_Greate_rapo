/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstcontrol;

import firstmodel.header;
import firstmodel.line;
import firstmodel.headTabelModel;
import firstmodel.lineTabelModel;
import firstview.frameview;
import firstview.headerD;
import firstview.lineD;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Eng Eslam
 */
public class Controller implements ActionListener,ListSelectionListener{
            private frameview frame;
            private lineD lineD;
            private headerD headerD;
            public Controller (frameview frame){
                    this.frame = frame;
                }
    @Override
    public void actionPerformed(ActionEvent e) {
       
            String actionCommand =e.getActionCommand();
            switch (actionCommand){
                case "Delete invoice":
                    Deleteinvoice();
                    break;
                case "Greate invoice":
                    Greateinvoice();
                    break;
                case "Greate Item":
                    GreateItem();
                    break;
                case "Delete Item":
                    DeleteItem();
                    break;
                case "Save":
                    Save();
                    break;
                case "Load":
                    {
                        try {
                            Load ();
                        } catch (IOException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                    break;
                    
                case "createInvoiceCancel":
                    createICancel();
                    break;
                case "createInvoiceOK":
                {
                    try{
                    createIOK();
                    }catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
                }
                    
                    }
                    break;
                case "createLineOK":
                    createLineOK();
                    break;
                case "createLineCancel":
                    createLineCancel();
                    break;
            }
        
        
        
    }

    private void Save() {
        ArrayList<header> headers = frame.getHeaders();
        String headers1 = "";
        String lines = "";
        for (header header : headers) {
            String invCSV = header.getESlSV();
            headers1 += invCSV;
            headers1 += "\n";

            for (line line : header.getLines()) {
                String lineCSV = line.getESlSV();
                lines += lineCSV;
                lines += "\n";
            }
        }
        try {
            JFileChooser fc = new JFileChooser();
            int result = fc.showSaveDialog(frame);
            if (result == JFileChooser.APPROVE_OPTION) {
                File headerFile = fc.getSelectedFile();
                FileWriter hfw = new FileWriter(headerFile);
                hfw.write(headers1);
                hfw.flush();
                hfw.close();
                result = fc.showSaveDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File lineFile = fc.getSelectedFile();
                    FileWriter lfw = new FileWriter(lineFile);
                    lfw.write(lines);
                    lfw.flush();
                    lfw.close();
                }
            }
        } catch (Exception ex) {

        }
        
    }
        @Override
    public void valueChanged(ListSelectionEvent e) {
        int index = frame.getInvoiceTable().getSelectedRow();
        if(index != -1){
            header cHead = frame.getHeaders().get(index);
            frame.getInvNumLabel().setText(cHead.getNumber()+"");
            frame.getInvDateLabel().setText(cHead.getDate());
            frame.getInvNameLabel().setText(cHead.getName());
            frame.getInvTotalLabel().setText(cHead.getTotal()+"");
            lineTabelModel linee = new lineTabelModel(cHead.getLines());
            frame.getLineTable().setModel(linee);
        }
    }
    private void Load() throws IOException {
            JFileChooser file = new JFileChooser();
        
            int result = file.showOpenDialog(frame);
        
        if (result == JFileChooser.APPROVE_OPTION){
                File headFile = file.getSelectedFile();
                Path headPath = Paths.get(headFile.getAbsolutePath());
                List<String> headLines = Files.readAllLines(headPath);
                
            ArrayList<header> headerArrays = new ArrayList<>();
         
        for (String headLine:headLines){
                 String[]headpart = headLine.split(",");
                 int invNum = Integer.parseInt(headpart[0]);
                 String invDate = headpart[1];
                 String nameCustomer = headpart[2];
                 
                 header head = new header(invNum,invDate,nameCustomer);
                 headerArrays.add(head);
                 
         }
        
            result = file.showOpenDialog(frame);
        
        if (result == JFileChooser.APPROVE_OPTION){
            File lineFile = file.getSelectedFile();
            Path linePath = Paths.get(lineFile.getAbsolutePath());
            List<String> lineLines = Files.readAllLines(linePath);
            for (String lineLine :lineLines ){
                String linePart[] = lineLine.split(",");
                 int invNumber = Integer.parseInt(linePart[0]);
                 String name = linePart[1];
                 double pri = Double.parseDouble(linePart[2]) ;
                 int conter =Integer.parseInt(linePart[3]);
                 header inv = null;
            for(header head : headerArrays){
                if (head.getNumber() == invNumber){
                inv = head ;
                }
            }
               line line = new line (invNumber,name,conter,pri,inv);
               inv.getLines().add(line);
            
                    }
        }
            frame.setHeaders(headerArrays);
            headTabelModel tableModel = new headTabelModel(headerArrays);
            frame.setTabelModel(tableModel);
            frame.getInvoiceTable().setModel(tableModel);
            frame.getTabelModel().fireTableDataChanged();
            
        }
        } 

    private void Deleteinvoice() {
        int SelectR = frame.getInvoiceTable().getSelectedRow();
        if (SelectR != -1){
            frame.getHeaders().remove(SelectR);
            frame.getTabelModel().fireTableDataChanged();
        }
        
    }

    private void Greateinvoice() {
        headerD = new headerD(frame);
        headerD.setVisible(true);    }

    private void GreateItem() {
        lineD = new lineD(frame);
        lineD.setVisible(true); 
    }
    
    private void DeleteItem() {
    int SelectV = frame.getInvoiceTable().getSelectedRow();
    int SelectR = frame.getLineTable().getSelectedRow();
        if (SelectR != -1 && SelectV != -1){
            header head = frame.getHeaders().get(SelectV);
            head.getLines().remove(SelectR);
            lineTabelModel line = new lineTabelModel(head.getLines());
            frame.getLineTable().setModel(line);
            line.fireTableDataChanged();
        }
    }

    private void createLineCancel() {
        lineD.setVisible(false);
        lineD.dispose();
        lineD = null;
    }

    private void createLineOK() {
        String item = lineD.getItemName().getText();
        String countStr = lineD.getItemCount().getText();
        String priceStr = lineD.getItemPrice().getText();
        int count = Integer.parseInt(countStr);
        double price = Double.parseDouble(priceStr);
        int selectedInvoice = frame.getInvoiceTable().getSelectedRow();
        if (selectedInvoice != -1) {
            header header = frame.getHeaders().get(selectedInvoice);
            line line = new line(item, price, count, header);
            header.getLines().add(line);
            lineTabelModel lTabelModel = (lineTabelModel) frame.getLineTable().getModel();
            //linesTableModel.getLines().add(line);
            lTabelModel.fireTableDataChanged();
            frame.getheadTabelModel().fireTableDataChanged();
        }
        lineD.setVisible(false);
        lineD.dispose();
        lineD = null;
    }
    private void createICancel() {
        headerD.setVisible(false);
        headerD.dispose();
        headerD = null;
        }
    private void createIOK() {
        String date = headerD.getInvDatel().getText();
        String customer = headerD.getCustNamel().getText();
        int num = frame.getNextInvoiceNum();
        
            String[] dateParts = date.split("-"); 
            if (dateParts.length < 3) {
                JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                int day = Integer.parseInt(dateParts[0]);
                int month = Integer.parseInt(dateParts[1]);
                int year = Integer.parseInt(dateParts[2]);
                if (day > 31 || month > 12) {
                    JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    header header = new header(num, date, customer);
                    frame.getHeaders().add(header);
                    frame.getTabelModel().fireTableDataChanged();
                    headerD.setVisible(false);
                    headerD.dispose();
                    headerD = null;
                    }
            }
        }
        

        
}
    

    

