package model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class DoctorDAO {
	
	public DoctorDAO(){}
	public void addDoctor(Doctor doctor)
	{
		Session session = DoctorSessionFactory.getSession();
		Transaction tran = session.beginTransaction();
		session.save(doctor);
		tran.commit();
		session.close();
	}
	
	public Doctor findDoctorById(int id)
	{
		Session session = DoctorSessionFactory.getSession();
		return session.find(Doctor.class, id);
	}
	
	public List<Doctor> getAllDoctors()
	{
		Session session = DoctorSessionFactory.getSession();
		return session.createQuery("FROM Doctor", Doctor.class).list();
	}
	
	public void modifyDoctor(Doctor doctor)
	{
		Session session = DoctorSessionFactory.getSession();
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
		Session session = DoctorSessionFactory.getSession();
		Doctor old = session.find(Doctor.class, doctorId);
		if(old!=null)
		{
			Transaction tran = session.beginTransaction();
			session.remove(old);
			tran.commit();
		}
		else{
			System.out.println(doctorId+" not found. So cannot remove");
	}
	}
	public static void main(String[] args) {
		DoctorDAO dodao=new DoctorDAO();
		System.out.println(dodao.getAllDoctors().size());
		//System.out.println(dodao.addDoctor(doctor).size());
	}
}
