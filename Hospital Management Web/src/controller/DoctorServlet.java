package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Doctor;
import model.DoctorDAO;

/**
 * Servlet implementation class DoctorServlet
 */
@WebServlet("/DoctorServlet")
public class DoctorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Doctor ad=new Doctor();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		model.DoctorDAO dodao=new DoctorDAO();
		List<Doctor> doctors = dodao.getAllDoctors();
		dodao.addDoctor(null);
		PrintWriter out = response.getWriter();
		out.print("<TABLE BODER=1");
		for(Doctor d : doctors)
		{
			out.print("<TR>");
			out.print("<TD>"+d.getDoctorId()+"</TD>");
			out.print("</TR>");
		}
		if(request.getParameter("addDoctor")!=null)
		{
			String doctorName=request.getParameter("doctorName");
			String doctorSpeciality=request.getParameter("doctorSpeciality");
			String doctorCharge=request.getParameter("doctorCharge");
			int Charge=Integer.parseInt(doctorCharge);
			String doctorVisitingDay=request.getParameter("doctorVisitingDay");
			String doctorContact=request.getParameter("doctorContact");
			
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//int doctorId=request.getParameter("doctorId");
		String doctorName=request.getParameter("doctorName");
		String doctorSpeciality=request.getParameter("doctorSpeciality");
		String doctorCharge=request.getParameter("doctorCharge");
		int Charge=Integer.parseInt(doctorCharge);
		String doctorVisitingDay=request.getParameter("doctorVisitingDay");
		String doctorContact=request.getParameter("doctorContact");
		
		HttpSession session=request.getSession();
		DoctorDAO dodao= new DoctorDAO();
		//dodao.addDoctor(doctorName,doctorSpeciality,doctorCharge,doctorVisitingDay,doctorContact);
		//doGet(request, response);
	}

}
