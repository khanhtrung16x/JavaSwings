import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Control extends JFrame {
    public static void main(String[] args) {
        Control c = new Control();
        c.setVisible(true);
    }

    public Control(){
        setTitle("Student Management");
        setSize(800,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        //-------------------------------------------
        JLabel label1= new JLabel();
        label1.setText("STUDENT MANAGEMENT");
        label1.setBounds(250,10,300,24);
        label1.setForeground(Color.BLUE);;
        label1.setFont(new Font("Serif", Font.PLAIN, 24));
        add(label1);
        //--------------------------------------------
        JLabel label2 = new JLabel();
        label2.setText("ADD NEW STUDENT");
        label2.setBounds(250,390,300,24);
        label2.setForeground(Color.RED);
        label2.setFont(new Font("Serif", Font.PLAIN, 24));
        add(label2);
        //--------------------------------------------
        MyPanel panel = new MyPanel();
        add(panel);
        
    }
}
