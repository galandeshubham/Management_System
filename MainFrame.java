import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MainFrame extends  JFrame
{
	Container c;
	JButton btnAdd, btnView, btnupdate, btndelete, btnchart;

	MainFrame()
	{
		c= getContentPane();
		c.setLayout(null);
		c.setBackground(Color.CYAN);

		ImageIcon img = new ImageIcon("k.png");
		setIconImage(img.getImage()); 
		btnAdd = new JButton("Add");
		btnView = new JButton("View");
		btnupdate = new JButton("Update");
		btndelete = new JButton("Delete");
		btnchart = new JButton("Charts");

		btnAdd.setPreferredSize(new Dimension(100,30));
		btnView.setPreferredSize(new Dimension(100,30));
		btnupdate.setPreferredSize(new Dimension(100,30));
		btndelete.setPreferredSize(new Dimension(100,30));
		btnchart.setPreferredSize(new Dimension(100,30));

		btnAdd.setBounds(70, 150, 100, 30);
		btnView.setBounds(210, 150, 100, 30);
		btnupdate.setBounds(70, 200, 100, 30);
		btndelete.setBounds(210, 200, 100, 30);
		btnchart.setBounds(150, 250, 100, 30);
	
		btnAdd.setFont(new Font("Courier New", Font.BOLD, 12));
		btnView.setFont(new Font("Courier New", Font.BOLD, 12));
		btnupdate.setFont(new Font("Courier New", Font.BOLD, 12));
		btndelete.setFont(new Font("Courier New", Font.BOLD, 12));
		btnchart.setFont(new Font("Courier New", Font.BOLD, 12));

		btnAdd.setBackground(Color.PINK);
		btnView.setBackground(Color.PINK);
		btnupdate.setBackground(Color.PINK);
		btndelete.setBackground(Color.PINK);
		btnchart.setBackground(Color.PINK);

		btnAdd.setForeground(Color.WHITE);
		btnView.setForeground(Color.WHITE);
		btnupdate.setForeground(Color.WHITE);
		btndelete.setForeground(Color.WHITE);
		btnchart.setForeground(Color.WHITE);
	
		btnAdd.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
		btnView.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
		btnupdate.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
		btndelete.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));
		btnchart.setBorder(BorderFactory.createBevelBorder(1, Color.BLACK, Color.BLACK));

		ActionListener a1 = (ae) -> {AddFrame a = new AddFrame(); dispose(); };
		btnAdd.addActionListener(a1);

		ActionListener a2 = (ae) -> {ViewFrame a = new ViewFrame(); dispose();};
		btnView.addActionListener(a2);
	
		ActionListener a3 = (ae) -> {UpdateFrame a = new UpdateFrame(); dispose();};
		btnupdate.addActionListener(a3);

		ActionListener a4 = (ae) -> {DeleteFrame a = new DeleteFrame(); dispose();};
		btndelete.addActionListener(a4);

		ActionListener a5 = (ae) -> {ChartFrame a = new ChartFrame(); dispose();};
		btnchart.addActionListener(a5);


		c.add(btnAdd);
		c.add(btnView);
		c.add(btnupdate);
		c.add(btndelete);
		c.add(btnchart);

		setTitle("S.M.S");
		setSize(400,500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}