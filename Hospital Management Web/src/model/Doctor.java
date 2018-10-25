package model;

public class Doctor {
	int doctorId;
	String doctorName;
	String doctorSpeciality;
	int doctorCharge;
	String doctorVisitingDay;
	String doctorContact;
	
	public Doctor(){}

	public Doctor(int doctorId, String doctorName, String doctorSpeciality, int doctorCharge, String doctorVisitingDay,
			String doctorContact) {
		super();
		this.doctorId = doctorId;
		this.doctorName = doctorName;
		this.doctorSpeciality = doctorSpeciality;
		this.doctorCharge = doctorCharge;
		this.doctorVisitingDay = doctorVisitingDay;
		this.doctorContact = doctorContact;
	}

	public Doctor(String doctorName, String doctorSpeciality, int doctorCharge, String doctorVisitingDay,
			String doctorContact) {
		super();
		this.doctorName = doctorName;
		this.doctorSpeciality = doctorSpeciality;
		this.doctorCharge = doctorCharge;
		this.doctorVisitingDay = doctorVisitingDay;
		this.doctorContact = doctorContact;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getDoctorSpeciality() {
		return doctorSpeciality;
	}

	public void setDoctorSpeciality(String doctorSpeciality) {
		this.doctorSpeciality = doctorSpeciality;
	}

	public int getDoctorCharge() {
		return doctorCharge;
	}

	public void setDoctorCharge(int doctorCharge) {
		this.doctorCharge = doctorCharge;
	}

	public String getDoctorVisitingDay() {
		return doctorVisitingDay;
	}

	public void setDoctorVisitingDay(String doctorVisitingDay) {
		this.doctorVisitingDay = doctorVisitingDay;
	}

	public String getDoctorContact() {
		return doctorContact;
	}

	public void setDoctorContact(String doctorContact) {
		this.doctorContact = doctorContact;
	}

	@Override
	public String toString() {
		return getDoctorId()+","+getDoctorName()+","+getDoctorSpeciality()+","+getDoctorCharge()+","+getDoctorVisitingDay()+","+getDoctorContact();
	}
	
}
