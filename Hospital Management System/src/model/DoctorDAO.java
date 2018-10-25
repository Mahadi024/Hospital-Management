package model;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DoctorDAO {
	
	private Session getSession()
	{
		 Configuration configuration = new Configuration().configure("hibernate.cfg.xml");
	     SessionFactory sessionFactory = configuration.buildSessionFactory();
	     return sessionFactory.openSession();
	}
	public void addDoctor(Doctor doctor)
	{
		Session session = getSession();
		Transaction tran = session.beginTransaction();
		session.persist(doctor);
		tran.commit();
	}
	public void modifyAirTicket(Doctor doctor)
	{
		Session session = getSession();
		Doctor old=session.find(Doctor.class, doctor.getDoctorId());
		if(old!=null){
			Transaction tran = session.beginTransaction();
			//old.setDoctorId(doctor.getDoctorId());
			old.setDoctorName(doctor.getDoctorName());
			old.setDoctorSpeciality(doctor.getDoctorSpeciality());
			old.setDoctorCharge(doctor.getDoctorCharge());
			old.setDoctorVisitingDay(doctor.getDoctorVisitingDay());
			old.setDoctorContact(doctor.getDoctorContact());
			session.persist(old);
			tran.commit();
			System.out.println("Updated...DoctorId"+old.getDoctorId());
		}else
			System.out.println(doctor.getDoctorId()+" not found. So no rows affected");
	}
	public void removeDoctor(int doctorId)
	{
		Session session = getSession();
		Doctor old = session.find(Doctor.class, doctorId);
		if(old!=null)
		{
			Transaction tran = session.beginTransaction();
			session.remove(old);
			tran.commit();
		}
		else
			System.out.println(doctorId+" not found. So cannot remove");
	}
	public void removeByHQL(int doctorId)
	{
		Session session = getSession();
		Query query = session.createQuery("DELETE FROM doctor d WHERE d.doctorId=?1");
		query.setParameter(1, doctorId);
		Transaction tran = session.beginTransaction();
		int no=query.executeUpdate();
		tran.commit();
		if(no>0)
			System.out.println("Removed "+doctorId);
		else
			System.out.println("Not removed");
	}
	public static void main(String[] args) {
		DoctorDAO adao=new DoctorDAO();
		Doctor doctor=new Doctor("Nazmul", "Dental", 1000, "Tuesday", "0171800566");
		//doctorName, , netAmout
	    adao.addDoctor(doctor);
		//adao.modifyAirTicket(aticket);
		//adao.removeAirTicket(1);
		//adao.removeByHQL(1);
		System.out.println("Done");
	}
}
