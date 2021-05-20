import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPanel extends JPanel {
    public void paint(Graphics graphics) {
        super.paint(graphics);
        setLayout(null);
        int width = 350;
        int height = 30;

        Object[][] data = {};
        String[] column = {"Student ID","Student Name","D.O.B","Contact Info"};
        JTable table = new JTable(data,column);
        JScrollPane jScrollPane = new JScrollPane(table);
        jScrollPane.setBounds(50,50,500,300);
        add(jScrollPane);

        JTextField textField = new JTextField(16);
        textField.setBounds(200,400,width,height);
        JTextField textField1 = new JTextField(16);
        textField1.setBounds(200,430,width,height);
        JTextField textField2 = new JTextField(16);
        textField2.setBounds(200,460,width,height);
        JTextField textField3 = new JTextField(16);
        textField3.setBounds(200,490,width,height);

        JLabel jLabel = new JLabel("Student ID");
        jLabel.setBounds(80,400,width,height);
        jLabel.setFont(new Font("Serif", Font.PLAIN, 16));

        JLabel jLabel1 = new JLabel("Student Name");
        jLabel1.setBounds(80,430,width,height);
        jLabel1.setFont(new Font("Serif", Font.PLAIN, 16));

        JLabel jLabel2 = new JLabel("Date Of birth");
        jLabel2.setBounds(80,460,width,height);
        jLabel2.setFont(new Font("Serif", Font.PLAIN, 16));

        JLabel jLabel3 = new JLabel("Contact");
        jLabel3.setBounds(80,490,width,height);
        jLabel3.setFont(new Font("Serif", Font.PLAIN, 16));



        //Button
        JButton b1 = new JButton("Save");
        b1.setBounds(230,530,100,40);

        JButton b2 = new JButton("Cancel");
        b2.setBounds(420,530,100,40);

        JButton b3 = new JButton("Load");
        b3.setBounds(560,50,100,40);

        JButton b4 = new JButton("Add new");
        b4.setBounds(560,100,100,40);

        JButton b5 = new JButton("Edit");
        b5.setBounds(560,150,100,40);

        JButton b6 = new JButton("Delete");
        b6.setBounds(560,200,100,40);

        JButton b7 = new JButton("Exit");
        b7.setBounds(560,700,100,40);

        JButton b8 = new JButton("|<");
        b8.setBounds(440,350,50,20);

        JButton b9 = new JButton(">|");
        b9.setBounds(500,350,50,20);


        add(b1);
        add(b2);
        add(b3);
        add(b4);
        add(b5);
        add(b6);
        add(b7);
        add(b8);
        add(b9);
        add(jLabel);
        add(jLabel1);
        add(jLabel2);
        add(jLabel3);
        add(textField);
        add(textField1);
        add(textField2);
        add(textField3);





    }
}
