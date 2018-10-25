package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Doctor;
import model.DoctorDAO;

/**
 * Servlet implementation class DoctorFinderServlet
 */
@WebServlet("/DoctorFinderServlet")
public class DoctorFinderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorFinderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		int id=0;

		if(request.getParameter("doctorId")!=null && request.getParameter("doctorId")!="")
		{
			if(request.getParameter("doctorId").equals("Select...")){				
				return;
			}
			DoctorDAO dodao=new DoctorDAO();
			Doctor doctor = dodao.findDoctorById(Integer.parseInt(request.getParameter("doctorId")));
			if(doctor!=null)
			{
				out.print(doctor.toString());
			}else
				out.println(request.getParameter("doctorId")+" not found");
		}else
		{
			out.print("Id is not supplied to search the doctor");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
