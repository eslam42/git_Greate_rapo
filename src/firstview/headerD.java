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
public class headerD extends JDialog {
    private JTextField custNamel;
    private JTextField invDatel;
    private JLabel custNameL;
    private JLabel invDateL;
    private JButton okB;
    private JButton cancelB;

    public headerD(frameview frame) {
        custNameL = new JLabel("Customer Name:");
        custNamel = new JTextField(20);
        invDateL = new JLabel("Invoice Date:");
        invDatel = new JTextField(20);
        okB = new JButton("OK");
        cancelB = new JButton("Cancel");
        
        okB.setActionCommand("createInvoiceOK");
        cancelB.setActionCommand("createInvoiceCancel");
        
        okB.addActionListener(frame.getControlles());
        cancelB.addActionListener(frame.getControlles());
        setLayout(new GridLayout(3, 2));
        
        add(invDateL);
        add(invDatel);
        add(custNameL);
        add(custNamel);
        add(okB);
        add(cancelB);
        
        pack();
        
    }

    public JTextField getCustNamel() {
        return custNamel;
    }

    public JTextField getInvDatel() {
        return invDatel;
    }
    
}
