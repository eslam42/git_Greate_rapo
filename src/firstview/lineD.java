/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstview;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author DELL
 */
public class lineD extends JDialog{
    private JTextField itemName;
    private JTextField itemCount;
    private JTextField itemPrice;
    private JLabel itemNameL;
    private JLabel itemCountL;
    private JLabel itemPriceL;
    private JButton okB;
    private JButton cancelB;
    
    public lineD(frameview frame) {
        itemName = new JTextField(20);
        itemNameL = new JLabel("Item Name");
        
        itemCount = new JTextField(20);
        itemCountL = new JLabel("Item Count");
        
        itemPrice = new JTextField(20);
        itemPriceL = new JLabel("Item Price");
        
        okB = new JButton("OK");
        cancelB = new JButton("Cancel");
        
        okB.setActionCommand("createLineOK");
        cancelB.setActionCommand("createLineCancel");
        
        okB.addActionListener(frame.getControlles());
        cancelB.addActionListener(frame.getControlles());
        setLayout(new GridLayout(4, 2));
        
        add(itemNameL);
        add(itemName);
        add(itemCountL);
        add(itemCount);
        add(itemPriceL);
        add(itemPrice);
        add(okB);
        add(cancelB);
        
        pack();
    }

    public JTextField getItemName() {
        return itemName;
    }

    public JTextField getItemCount() {
        return itemCount;
    }

    public JTextField getItemPrice() {
        return itemPrice;
    }
}
