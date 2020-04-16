import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class MyPanel extends JPanel {
	private int editIndex;
	private boolean isOK = true;
	private String fileName;
	private int check = 0;
	private boolean flag = true;
	public String content;

	public boolean isEmpty(String name) {
		if (name.isEmpty()) {
			return false;
		}
		return true;
	}

	public void paint(Graphics graphics) {
		super.paint(graphics);
		setLayout(null);
		int wide = 155;
		int height = 55;

		//------------------------------------------------------------------------------

		Object[][] data = {};
		String[] cols = { "Student ID", "Student Name", "D.O.B", "Contact Info" };
		JTable table = new JTable(data, cols);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(30, 50, 575, 300);
		add(scroll);

		//(JButton)----------------------------------------------------------------------
		JButton bt1 = new JButton();
		bt1.setText("Load");
		bt1.setBounds(620, 50, wide, height);
		JButton bt2 = new JButton();
		bt2.setText("Add New");
		bt2.setBounds(620, 120, wide, height);
		JButton bt3 = new JButton();
		bt3.setText("Edit");
		bt3.setBounds(620, 190, wide, height);
		JButton bt4 = new JButton();
		bt4.setText("Delete");
		bt4.setBounds(620, 260, wide, height);
		JButton bt5 = new JButton();
		bt5.setText("|<");
		bt5.setBounds(440, 360, 70, 25);
		JButton bt6 = new JButton();
		bt6.setText(">|");
		bt6.setBounds(525, 360, 70, 25);
		JButton bt7 = new JButton();
		bt7.setText("Save");
		bt7.setBounds(215, 600, wide, height);
		JButton bt8 = new JButton();
		bt8.setText("Cancel");
		bt8.setBounds(430, 600, wide, height);
		JButton bt9 = new JButton();
		bt9.setText("Exit");
		bt9.setBounds(600, 680, wide, height);

		//(JLabel)-----------------------------------------------------------------------
		JLabel label1 = new JLabel();
		label1.setText("Student ID: ");
		label1.setFont(new Font("Serif", Font.PLAIN, 16));
		label1.setBounds(50, 420, wide, height);
		JLabel label2 = new JLabel();
		label2.setText("Student Name: ");
		label2.setFont(new Font("Serif", Font.PLAIN, 16));
		label2.setBounds(50, 460, wide, height);
		JLabel label3 = new JLabel();
		label3.setText("Date Of Birth: ");
		label3.setFont(new Font("Serif", Font.PLAIN, 16));
		label3.setBounds(50, 500, wide, height);
		JLabel label4 = new JLabel();
		label4.setText("Contact Information: ");
		label4.setFont(new Font("Serif", Font.PLAIN, 16));
		label4.setBounds(50, 540, wide, height);
		JLabel label5 = new JLabel();
		label5.setText("Link: ");
		label5.setFont(new Font("Serif", Font.PLAIN, 16));
		label5.setBounds(50, 700, wide, height);
		JLabel label6 = new JLabel();
		label6.setText("D:\\DSSV\\PM02");
		label6.setFont(new Font("Serif", Font.PLAIN, 16));
		label6.setBounds(85, 700, wide, height);
		
		//(JTextField)-----------------------------------------------------------------------
		JTextField StuID = new JTextField();
		StuID.setBounds(200, 430, 400, 30);
		StuID.setFont(new Font("Serif", Font.PLAIN, 20));
		JTextField StuN = new JTextField();
		StuN.setBounds(200, 470, 400, 30);
		StuN.setFont(new Font("Serif", Font.PLAIN, 20));
		JFormattedDateTextField DOB = new JFormattedDateTextField();
		JTextField normalTf = new JTextField();
		DOB.setBounds(200, 510, 400, 30);
		DOB.setFont(new Font("Serif", Font.PLAIN, 20));
		JTextField CoInfo = new JTextField();
		CoInfo.setBounds(200, 550, 400, 30);
		CoInfo.setFont(new Font("Serif", Font.PLAIN, 20));
		
		//(ADD)-------------------------------------------------------------------------
		add(bt1);
		add(bt2);
		add(bt3);
		add(bt4);
		add(bt5);
		add(bt6);
		add(bt7);
		add(bt8);
		add(bt9);
		add(StuID);
		add(StuN);
		add(DOB);
		add(CoInfo);
		add(label1);
		add(label2);
		add(label3);
		add(label4);
		add(label5);
		add(label6);

		// ---------------------------------------------------------------------------
		DefaultTableModel model = new DefaultTableModel();
		model.setDataVector(data, cols);
		table.setModel(model);
		StuID.setEditable(false);
		StuN.setEditable(false);
		DOB.setEditable(false);
		CoInfo.setEditable(false);

		ActionListener listener = new ActionListener() {
			int id = 0;
			long contact = 0;
			String name = "";

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//(ADD NEW)---------------------------------------------------------------------------------------
				if (e.getSource() == bt2) {// Add new
					StuID.setEditable(true);
					StuN.setEditable(true);
					DOB.setEditable(true);
					CoInfo.setEditable(true);
				//(EXIT)---------------------------------------------------------------------------------------
				} else if (e.getSource() == bt9) {// Exit
					ArrayList<String> arr = new ArrayList<>();
					int result = JOptionPane.showConfirmDialog(null, "Do You Want To Exit?", "Notification", JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						for(int i=0; i< model.getRowCount();i++) {
							arr.add((String) model.getValueAt(i, 0));
							arr.add((String) model.getValueAt(i, 1));
							arr.add((String) model.getValueAt(i, 2));
							arr.add((String) model.getValueAt(i, 3));
						}
						if (!flag) {
                            File f = new File(fileName);
                            f.delete();
                            try {
                                File myObj = new File(fileName);
                                myObj.createNewFile();
                                FileWriter myWriter = new FileWriter(myObj);
                                for (int j = 0; j < arr.size(); j++) {
                                    myWriter.write(arr.get(j) + ",");
                                }
                                myWriter.close();
                            } catch (IOException ex) {
                                System.out.println("An error occurred.");
                                ex.printStackTrace();
                            }

                        }
						System.exit(0);
					}
				//(DELETE)---------------------------------------------------------------------------------------
				} else if (e.getSource() == bt4) {// delete
					int removeIndex = table.getSelectedRow();
                    if (removeIndex == -1) {
                        JOptionPane.showMessageDialog(null, "You have not selected anything to delete!",
                                "Notification", JOptionPane.DEFAULT_OPTION);
                    } else {
                        int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete?",
                        		"Notification", JOptionPane.OK_CANCEL_OPTION);
                        if (result == JOptionPane.OK_OPTION) {
                            model.removeRow(removeIndex);
                        }}
				//(EDIT)-----------------------------------------------------------------------------------------
				} else if (e.getSource() == bt3) {// Edit
					editIndex = table.getSelectedRow();
					if (editIndex < 0) {
						JOptionPane.showMessageDialog(null, "Please select one line to edit!", "Notification",
								JOptionPane.DEFAULT_OPTION);
					} else {
						StuID.setEditable(false);
						StuN.setEditable(false);
						DOB.setEditable(false);
						CoInfo.setEditable(false);

						StuID.setText((String) model.getValueAt(editIndex, 0));
						StuN.setText((String) model.getValueAt(editIndex, 1));
						DOB.setText((String) model.getValueAt(editIndex, 2));
						CoInfo.setText((String) model.getValueAt(editIndex, 3));
					}
					check = 1;
				//(LOAD)----------------------------------------------------------------------------------------
				} else if (e.getSource() == bt1) {// Load
					String content = "";
					JFileChooser file = new JFileChooser();
					var result = file.showOpenDialog(null);
					if (result == JFileChooser.APPROVE_OPTION) {
						model.setRowCount(0);
						fileName = file.getSelectedFile().getAbsolutePath();
						try {
							content = new String(Files.readAllBytes(Paths.get(fileName)));
						} catch (IOException er) {
							er.printStackTrace();
						}
					}
					String[] split = content.split(",");
					try {
						for (int i = 0; i < split.length; i += 4) {
							model.addRow(new Object[] { split[i], split[i + 1], split[i + 2], split[i + 3] });
						}
					} catch (Exception ex) {

					}
					flag = false;
					editIndex = -1;
				//(CANCEL)----------------------------------------------------------------------------------------
				} else if (e.getSource() == bt8) {// Cancel
					StuID.setText("");
					StuN.setText("");
					DOB.setText("");
					CoInfo.setText("");
				//(|<)--------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt5) {// |<
					table.setRowSelectionInterval(0, 0);
				//(>|)--------------------------------------------------------------------------------------------
				} else if (e.getSource() == bt6) {// >|
					int endRow = table.getRowCount() - 1;
					table.setRowSelectionInterval(endRow, endRow);
				}

			}
		//(addActionListener)-------------------------------------------------------------------------------------
		};
		bt1.addActionListener(listener);
		bt2.addActionListener(listener);
		bt3.addActionListener(listener);
		bt4.addActionListener(listener);
		bt5.addActionListener(listener);
		bt6.addActionListener(listener);
		bt8.addActionListener(listener);
		bt9.addActionListener(listener);

		// --------------------------------------------------------------------------------------------------

	}
}
