import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

class ViewFrame extends JFrame{
Container c;
TextArea ta_data;
JButton btn_back;

ViewFrame(){
c = getContentPane();
c.setBackground(Color.PINK);
c.setLayout(new FlowLayout());

ImageIcon img = new ImageIcon("k.png");
setIconImage(img.getImage());
ta_data = new TextArea(10,50);
btn_back = new JButton("Back");
btn_back.setPreferredSize(new Dimension(150, 30));

ActionListener a1 = (ae) -> {MainFrame m = new MainFrame(); dispose(); };
btn_back.addActionListener(a1);

String data = DataBase.viewStudent();
ta_data.setText(data);

c.add(ta_data);
c.add(btn_back);

setTitle("View.St");
setSize(400,500);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setLocationRelativeTo(null);
setVisible(true);

}
}