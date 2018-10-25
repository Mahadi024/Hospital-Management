<%@ page import="java.util.*"  %>
<%@ page import="model.*"  %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script>
function findDoctor(item)
{
	//alert(item.value);
	 var xhttp = new XMLHttpRequest();
	 var result;
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	    	result=this.responseText;
	      document.getElementById("divDemo").innerHTML = result;
	      if(result!=""){
			  var arr=result.split(",");
			  document.getElementById("DoctorName").value=arr[1];
			  document.getElementById("DoctorSpeciality").value=arr[2];
			  document.getElementById("DoctorCharge").value=arr[3];
			  document.getElementById("DoctorCharge").value=arr[4];
			  document.getElementById("DoctorContact").value=arr[5];
		  }else
			  {
			  document.getElementById("DoctorName").value="";
			  document.getElementById("DoctorSpeciality").value="";
			  document.getElementById("DoctorCharge").value="";
			  document.getElementById("DoctorCharge").value="";
			  document.getElementById("DoctorContact").value="";
			  }
	    }
	  };
	  xhttp.open("GET", "DoctorFinderServlet?doctorId="+item.value, true);
	  xhttp.send();
	 
}
</script>
</head>
<body>
<form>
<TABLE>
<TR>
<TD>Doctor Id</TD>
<TD>
<SELECT ID=doctorId NAME=doctorId onchange="findDoctor(this)">
<OPTION>Select...</OPTION>
<jsp:useBean id="dodao" class="model.DoctorDAO" />
<%
List<Doctor> doctors=dodao.getAllDoctors(); 
session.setAttribute("doctors", doctors);
%>
<c:forEach var="doctor" items="${doctors }" >
<OPTION>${doctor.doctorId }</OPTION>
</c:forEach>
</SELECT>
</TD>
</TR>
<TR>
<TD>Doctor Name</TD><TD><INPUT TYPE=TEXT NAME=doctorName ID=doctorName /></TD>
</TR>
<TR>
<TD>Doctor Speciality</TD><TD><INPUT TYPE=TEXT NAME=doctorSpeciality ID=doctorSpeciality /></TD>
</TR>
<TR>
<TD>Doctor Charge</TD><TD><INPUT TYPE=NUMBER NAME=doctorCharge ID=doctorCharge /></TD>
</TR>
<TR>
<TD>Doctor Visiting Day</TD><TD><INPUT TYPE=TEXT NAME=doctorVisitingDay ID=doctorVisitingDay /></TD>
</TR>
<TR>
<TD>Doctor Contact</TD><TD><INPUT TYPE=TEXT NAME=doctorContact ID=doctorContact /></TD>
</TR>
<TR>
<TD></TD><TD><INPUT TYPE=SUBMIT value=Save/></TD>
<TD></TD><TD><INPUT TYPE=SUBMIT value=Update/></TD>
<TD></TD><TD><INPUT TYPE=SUBMIT value=Delet/></TD>
</TR>
</TABLE>
<div id="divDemo"></div>
</form>
</body>
</html>