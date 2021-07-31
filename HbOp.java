import org.hibernate.*;
import org.hibernate.cfg.*;

class HbOp{
public static void main(String args[]){
	Configuration cfg = new Configuration();
	cfg.configure("hibernate.cfg.xml");

	SessionFactory sf = cfg.buildSessionFactory();
	Session s = null;

	try{
		s = sf.openSession();
		System.out.println("open");
	} catch(Exception e){
		System.out.println(e);
	} finally{
		s.close();
		System.out.println("close");
	}
}
}