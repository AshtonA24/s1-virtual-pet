package loan;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class loan extends JFrame implements ActionListener{

    //GUI
    private JFrame frame;
    private JPanel panel;
    private JTextField text1;
    private JTextField text2;
    private JTextField text3;
    private JTextField text4;
    private JLabel label1;
    private JButton button1;

    //Loas
    private int loan;
    private double interest;
    private double compound;
    private double time;
    private String finBal;
   

    public loan(){
        panel = new JPanel();
        frame = new JFrame("loan calculator");
        text1 = new JTextField(5);
        text2 = new JTextField(5);
        text3 = new JTextField(5);
        text4 = new JTextField(5);
        label1 = new JLabel("             Final Bal: ");
        button1 = new JButton("ENTER");



    



        panel.setBorder(BorderFactory.createEmptyBorder(5, -35, 10, 10)); 
        panel.setLayout(new GridLayout(0,2));
        panel.add(new JLabel("             Loan Amount:"));
        panel.add(text1);
        panel.add(new JLabel("             Interest Rate (%):"));
        panel.add(text2);
        panel.add(new JLabel("             Compound:"));
        panel.add(text3);
        panel.add(new JLabel("             Years to Pay Back:"));
        panel.add(text4);
        panel.add(new JLabel("______________________________"));
        panel.add(new JLabel("______________________________"));
       

        panel.add(label1);
        panel.add(button1);

        



        
        button1.setPreferredSize(new Dimension(200, 30));
        label1.setPreferredSize(new Dimension(200, 30));



        frame.add(panel, BorderLayout.EAST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true); 
        frame.setResizable(false);
        button1.addActionListener(this);
    }


    public String calculateLoan(Integer p, double r, double n, double t){

        double b = p * Math.pow((1 + r/n), n * t);

        DecimalFormat df = new DecimalFormat("#.##");
        b = Double.parseDouble(df.format(b));

        String num = String.valueOf(b);
        
        for(int i = num.length()-6; i > 0 ; i = i-3){
            num = num.substring(0,i) + "," + num.substring(i);
        }

        return num;
    }



    public String removeCommas(String str){
        String [] arr = str.split(",");
        String append = "";
        for(String s: arr)
            append += s;
        return append;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1){
            loan = Integer.parseInt(removeCommas(text1.getText()));
            interest = Double.parseDouble(text2.getText())/100;
            compound = Double.parseDouble(text3.getText());
            time = Double.parseDouble(text4.getText());
            finBal =   calculateLoan(loan, interest, compound, time);
            
            label1.setText("             Final Bal: " + finBal);
        }
    }

    
    public static void main(String[] args) {
        new loan();

    }


    
}