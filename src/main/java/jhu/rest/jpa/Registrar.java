package jhu.rest.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity 
public class Registrar {
	/**
	 * Registrar contains course number and a list of students that are enrolled in that course
	 */
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private long courseNumber;
	private int studentId;
	
	public Registrar() {}

	public Registrar(long courseNumber, Integer studentId) {
		this.courseNumber = courseNumber;
		this.studentId = studentId;
	}
	public long getCourseNumber() {
		return courseNumber;
	}
	public void setCourseNumber(int courseNumber) {
		this.courseNumber = courseNumber;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String toString() {
		// COURSE: ID1, ID2, ID3
		return courseNumber + ": " + studentId;
	}
}