
public class Patient {
	int patientId;
	String patientName;
	String p_Gender;
	int patientAge;
	String appointmentDate;
	String p_Problem;
	String p_Medecine;
	
	public Patient(){}

	public Patient(int patientId, String patientName, String p_Gender, int patientAge, String appointmentDate,
			String p_Problem) {
		super();
		this.patientId = patientId;
		this.patientName = patientName;
		this.p_Gender = p_Gender;
		this.patientAge = patientAge;
		this.appointmentDate = appointmentDate;
		this.p_Problem = p_Problem;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getP_Gender() {
		return p_Gender;
	}

	public void setP_Gender(String p_Gender) {
		this.p_Gender = p_Gender;
	}

	public int getPatientAge() {
		return patientAge;
	}

	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}

	public String getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(String appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getP_Problem() {
		return p_Problem;
	}

	public void setP_Problem(String p_Problem) {
		this.p_Problem = p_Problem;
	}

	public String getP_Medecine() {
		return p_Medecine;
	}

	public void setP_Medecine(String p_Medecine) {
		this.p_Medecine = p_Medecine;
	}

	@Override
	public String toString() {
		return "Patient [patientId=" + patientId + ", patientName=" + patientName + ", p_Gender=" + p_Gender
				+ ", patientAge=" + patientAge + ", appointmentDate=" + appointmentDate + ", p_Problem=" + p_Problem
				+ ", p_Medecine=" + p_Medecine + "]";
	}
	
	
}
	
