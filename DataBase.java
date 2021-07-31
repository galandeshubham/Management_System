import javax.swing.*;
import org.hibernate.*;
import org.hibernate.cfg.*;
import java.util.*;
import java.util.regex.*;

class DataBase{
public static void addStudent(int rno, String name, int S1, int S2, int S3){

	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory sf = cfg.buildSessionFactory();
	Session s = null;
	Transaction t = null;
try{
	String s1 = String.valueOf(rno);
	String regex = "[0-9]+";
	Pattern p = Pattern.compile(regex);
	Matcher m = p.matcher(s1);

	String regex1 = "^[A-Za-z]\\w{2,29}$";
	Pattern p1 = Pattern.compile(regex1);
	Matcher m1 = p1.matcher(name);
	
	if (m.matches() == false){
		JOptionPane.showMessageDialog(new JDialog(), "Invalid Roll_no", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
	else if (m1.matches() == false){
		JOptionPane.showMessageDialog(new JDialog(), "Invalid name", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
	else if(rno < 0){
		JOptionPane.showMessageDialog(new JDialog(), "Roll_no cannot be negative", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
	else if(name.length() < 2)
	{
		JOptionPane.showMessageDialog(new JDialog(), "Name Must contain atleast 2 letters", "Mistake", JOptionPane.ERROR_MESSAGE);	
	}
	else if((S1 > 1 && S1 < 100) && (S2 > 1 && S2 < 100) && (S3 > 1 && S3 < 100))
	{
		s = sf.openSession();
		t = s.beginTransaction();
		Student stu = new Student(rno, name, S1, S2, S3);
		s.save(stu);
		t.commit();
		JOptionPane.showMessageDialog(new JDialog(), "Record Inserted");
	} else{
		JOptionPane.showMessageDialog(new JDialog(), "Marks Must be between 0 to 100", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
}catch(Exception e){
	t.rollback();
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e, "Error", JOptionPane.ERROR_MESSAGE);
}finally{
	s.close();
}
}

public static String viewStudent(){
	
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
	for(Student r : stu){
		msg = msg + "Roll_no : " + r.getRno() + "   Name : " + r.getName() + "   S1 : " + r.getS1() + "   S2 : " + r.getS2() + "   S3 : " + r.getS3() + "\n";
	}
}catch(Exception e){
	JOptionPane.showMessageDialog(new JDialog(), "issue " + e);
}finally{
	s.close();
}
return msg;	
}

public static void updateStudent(int rno, String name, int S1, int S2, int S3){
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory sf = cfg.buildSessionFactory();
	Session s = null;
	Transaction t = null;

try{
	String s1 = String.valueOf(rno);
	String regex = "[0-9]+";
	Pattern p = Pattern.compile(regex);
	Matcher m = p.matcher(s1);
	
	String regex1 = "^[A-Za-z]\\w{2,29}$";
	Pattern p1 = Pattern.compile(regex1);
	Matcher m1 = p1.matcher(name);
	
	if (m.matches() == false){
		JOptionPane.showMessageDialog(new JDialog(), "Invalid Roll_no", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
	else if (m1.matches() == false){
		JOptionPane.showMessageDialog(new JDialog(), "Invalid name", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
	else if(rno < 0){
		JOptionPane.showMessageDialog(new JDialog(), "Roll_no cannot be negative", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
	else if(name.length() < 2)
	{
		JOptionPane.showMessageDialog(new JDialog(), "Name Must contains atleast 2 letters", "Mistake", JOptionPane.ERROR_MESSAGE); 	
	}
	else if((S1 > 1 && S1 < 100) && (S2 > 1 && S2 < 100) && (S3 > 1 && S3 < 100))
	{
		s = sf.openSession();
		t = s.beginTransaction();
		Student stu = (Student)s.get(Student.class, rno);
		if (stu != null){
			stu.setName(name);
			stu.setS1(S1);
			stu.setS2(S2);
			stu.setS3(S3);
			s.save(stu);
			t.commit();
			JOptionPane.showMessageDialog(new JDialog(), rno + "updated");
		}else{
		JOptionPane.showMessageDialog(new JDialog(), rno + " does not exists", "Invalid Rno", JOptionPane.ERROR_MESSAGE);
		}
	}else {
		JOptionPane.showMessageDialog(new JDialog(), "Marks Must be between 0 to 100", "Mistake", JOptionPane.ERROR_MESSAGE);
	}
} catch(Exception e)
{
	t.rollback();
	JOptionPane.showMessageDialog(new JDialog(), "issue" + e , "Error", JOptionPane.ERROR_MESSAGE);
}
finally
{
	s.close();
}
}

public static void deleteStudent(int rno){
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory sf = cfg.buildSessionFactory();
	Session s = null;
	Transaction t = null;

try{
	s = sf.openSession();
	t = s.beginTransaction();
	Student stu = (Student)s.get(Student.class, rno);
	if (stu != null){
		s.delete(stu);
		t.commit();
		JOptionPane.showMessageDialog(new JDialog(), rno + "Deleted");
	}else{
	JOptionPane.showMessageDialog(new JDialog(), rno + " does not exists", "Invalid Rno", JOptionPane.ERROR_MESSAGE);
	}
} catch(Exception e)
{
	t.rollback();
	JOptionPane.showMessageDialog(new JDialog(), "issue" + e , "Error", JOptionPane.ERROR_MESSAGE);
}
finally
{
	s.close();
}
}
}




