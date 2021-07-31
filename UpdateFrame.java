import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UpdateFrame extends  JFrame
{
	Container c;
	JLabel lbl_name, lbl_rno, lbl_m1, lbl_m2, lbl_m3;
	JTextField txt_name, txt_rno, txt_m1, txt_m2, txt_m3;
	JButton btn_save, btn_back;

	UpdateFrame()
	{
		c= getContentPane();
		c.setLayout(new FlowLayout());
		c.setBackground(Color.GREEN);

		ImageIcon img = new ImageIcon("k.png");
		setIconImage(img.getImage());
		lbl_rno = new JLabel("Enter Rno :  ");
		txt_rno = new JTextField(20);
		lbl_name = new JLabel("Enter Name :");
		txt_name = new JTextField(20);
		lbl_m1 = new JLabel("Enter Sub Marks 1 :");
		txt_m1 = new JTextField(20);
		lbl_m2 = new JLabel("Enter Sub Marks 2 :");
		txt_m2 = new JTextField(20);
		lbl_m3 = new JLabel("Enter Sub Marks 3 :");
		txt_m3 = new JTextField(20);
		btn_save = new JButton("Save");
		btn_back = new JButton("Back");
		
		btn_save.setPreferredSize(new Dimension(180, 30));
		btn_back.setPreferredSize(new Dimension(180, 30));
	
		lbl_rno.setFont(new Font("Calibri", Font.BOLD, 30));
		lbl_name.setFont(new Font("Calibri", Font.BOLD, 30));
		lbl_m1.setFont(new Font("Calibri", Font.BOLD, 30));
		lbl_m2.setFont(new Font("Calibri", Font.BOLD, 30));
		lbl_m3.setFont(new Font("Calibri", Font.BOLD, 30));
		btn_save.setFont(new Font("Calibri", Font.BOLD, 12));
		btn_back.setFont(new Font("Calibri", Font.BOLD, 12));

		txt_name.setBackground(Color.LIGHT_GRAY);
		txt_rno.setBackground(Color.LIGHT_GRAY);
		txt_m1.setBackground(Color.LIGHT_GRAY);
		txt_m2.setBackground(Color.LIGHT_GRAY);
		txt_m3.setBackground(Color.LIGHT_GRAY);


		ActionListener a1 = (ae) -> {MainFrame a = new MainFrame(); dispose(); };
		btn_back.addActionListener(a1);

		ActionListener a2 = (ae) -> {
		try{
			int rno = Integer.parseInt(txt_rno.getText());
			String name = txt_name.getText();
			int M1 = Integer.parseInt(txt_m1.getText());
			int M2 = Integer.parseInt(txt_m2.getText());
			int M3 = Integer.parseInt(txt_m3.getText());
			DataBase db = new DataBase();
			db.updateStudent(rno, name, M1, M2, M3);
		}catch(NumberFormatException e){
			JOptionPane.showMessageDialog(c, "Invalid input", "Mistake", JOptionPane.ERROR_MESSAGE);
			txt_rno.setText("");
			txt_name.setText("");
			txt_m1.setText("");
			txt_m2.setText("");
			txt_m3.setText("");
			txt_rno.requestFocus();
		}
		};
		btn_save.addActionListener(a2);

		c.add(lbl_rno);
		c.add(txt_rno);
		c.add(lbl_name);
		c.add(txt_name);
		c.add(lbl_m1);
		c.add(txt_m1);
		c.add(lbl_m2);
		c.add(txt_m2);
		c.add(lbl_m3);
		c.add(txt_m3);
		c.add(btn_save);
		c.add(btn_back);

		setTitle("Update St.");
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}