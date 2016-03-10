package tcs.assignment2.health_care_system;

/**
 * Created by Araja Jyothi Babu on 11-Mar-16.
 */
public class Doctor {

    private double consultingFee;
    private String doctorName;
    private int regNo;
    private String specialization;

    public Doctor(double consultingFee, String doctorName, int regNo, String specialization) {
        this.consultingFee = consultingFee;
        this.doctorName = doctorName;
        this.regNo = regNo;
        this.specialization = specialization;
    }

    public double getConsultingFee() {
        return consultingFee;
    }

    public void setConsultingFee(double consultingFee) {
        this.consultingFee = consultingFee;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
