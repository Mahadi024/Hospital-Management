import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PatientDAO {
	
	private Connection getConnection() throws SQLException
	{
		String url="jdbc:mysql://localhost:3306/hospital";
		String uid="root";
		String pwd="";
		new com.mysql.jdbc.Driver();
		return DriverManager.getConnection(url,uid,pwd);
		
	}
	int addPatient(Patient patient) throws SQLException
	{
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("INSERT INTO PATIENT VALUES(?,?,?,?,?,?)");
		st.setInt(1,patient.getPatientId());
		st.setString(2, patient.getPatientName());
		st.setString(3, patient.getP_Gender());
		st.setInt(4, patient.getPatientAge());
		st.setString(5,patient.getAppointmentDate());
		st.setString(6, patient.getP_Problem());
		int no=st.executeUpdate();
		con.close();
		return no;
		
	}
	public List<Integer>getAllPatientIds() throws SQLException
	{
		Connection con=getConnection();
		java.sql.Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("SELECT PATIENTID FROM PATIENT");
		List<Integer>ids=new ArrayList<Integer>();
		while(rs.next())
		{
			ids.add(rs.getInt(1));
		}
		return ids;
		
	}
	public Patient getPatientById(int patientId) throws SQLException{
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("SELECT * FROM PATIENT WHERE PATIENTID=?");
		st.setInt(1, patientId);
		Patient pt=null;
		ResultSet rs=st.executeQuery();
		if(rs.next())
		{
			pt=new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
		}
		return pt;
		
	}
	public List<Patient> findPatientByProblem(String P_Problem) throws SQLException{
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("SELECT * FROM PATIENT WHERE P_PROBLEM=?");
		st.setString(1, P_Problem);
		ArrayList<Patient>patients=new ArrayList<>();
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			Patient pt=new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			patients.add(pt);
		}
		return patients;
		
	}
	public List<Patient> findPatientByAge(Integer paietntAge) throws SQLException{
		Connection con=getConnection();
		PreparedStatement st=con.prepareStatement("SELECT * FROM PATIENT WHERE PATIENTAGE=?");
		st.setInt(1, paietntAge);
		ArrayList<Patient>patients=new ArrayList<>();
		ResultSet rs=st.executeQuery();
		while(rs.next()){
			Patient pt=new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getInt(4),rs.getString(5),rs.getString(6));
			patients.add(pt);
		}
		return patients;
		
	}
	
	public static void main(String[] args) throws SQLException {
		PatientDAO adao=new PatientDAO();
		/*
		Patient p=new Patient(120102,"Shamim","Male",24, "22 Dec 2017","BackPain");
		int no=adao.addPatient(p);
		System.out.println(no+" row(s) affected");
		for(Integer i : adao.getAllPatientIds())
		{
			System.out.println(i);
		}
		*/
		for(Patient p1:adao.findPatientByAge(24))
		{
			System.out.println(p1);
		}
		
		System.out.println("done");
	}
}
