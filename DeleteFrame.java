import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DeleteFrame extends JFrame{
Container c;

JLabel lbl_rno;
JTextField txt_rno;
JButton btn_back, btn_save;

DeleteFrame(){
c = getContentPane();
c.setBackground(Color.MAGENTA);
c.setLayout(null);

ImageIcon img = new ImageIcon("k.png");
setIconImage(img.getImage());
lbl_rno = new JLabel("Enter Roll_no");
txt_rno = new JTextField(10);
btn_back = new JButton("Back");
btn_save = new JButton("Save");

lbl_rno.setFont(new Font("Calibri", Font.BOLD, 30));
lbl_rno.setBackground(Color.LIGHT_GRAY);
lbl_rno.setBounds(100, 20, 200, 40);
txt_rno.setBounds(50, 70, 300, 30);
btn_save.setBounds(125, 120, 150, 30);
btn_back.setBounds(125, 170, 150, 30);

ActionListener a1 = (ae) -> {MainFrame m = new MainFrame(); dispose(); };
btn_back.addActionListener(a1);

ActionListener a2 = (ae) -> {
	try{
	int rno = Integer.parseInt(txt_rno.getText());
	DataBase.deleteStudent(rno);
	} catch(NumberFormatException e){
		JOptionPane.showMessageDialog(c, "invalid Roll_no", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
};
btn_save.addActionListener(a2);


c.add(lbl_rno);
c.add(txt_rno);
c.add(btn_save);
c.add(btn_back);

setTitle("Delete St.");
setSize(400,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);

}
}