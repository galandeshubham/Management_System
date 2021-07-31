import javax.swing.*;
import org.jfree.data.category.*;
import org.jfree.chart.*;
import org.jfree.chart.plot.*;
import org.hibernate.cfg.*;
import org.hibernate.*;
import java.util.*;

class ChartFrame extends JFrame{
ChartFrame(){

	ImageIcon img = new ImageIcon("k.png");
	setIconImage(img.getImage());

	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory sf = cfg.buildSessionFactory();
	Session s = null;
	String msg = "";
try{
	s = sf.openSession();
	System.out.println("open");
	List<Student> stu = new ArrayList<>();
	stu = s.createQuery("from Student").list();
	
	DefaultCategoryDataset ds = new DefaultCategoryDataset();
	for(Student d : stu)
	{
	ds.addValue(d.S1, d.name, "S1");
	ds.addValue(d.S2, d.name, "S2");
	ds.addValue(d.S3, d.name, "S3");
	}
	JFreeChart ch = ChartFactory.createBarChart3D("Students Performance", "Subject", "Marks", ds, 
PlotOrientation.VERTICAL, true, true, false);

	ChartPanel cp = new ChartPanel(ch);
	setContentPane(cp);
	
}catch(Exception e){
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}finally{
	s.close();
}

setVisible(true);
setLocationRelativeTo(null);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setTitle("Mark Chart");
setSize(700, 400);
}
}