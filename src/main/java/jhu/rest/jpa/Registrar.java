package jhu.rest.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Registrar {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String courseNumber;
    private String studentid;
    private String token;

    public String getCourseNumber() { return courseNumber; }

    public void setCourseNumber(String courseNumber) {
        this.courseNumber = courseNumber;
    }

    public String getStudentid() {
        return studentid;
    }

    public void setStudentid(String studentid) {
        this.studentid = studentid;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Registrar{" +
                "courseNumber='" + courseNumber + '\'' +
                ", studentid='" + studentid + '\'' +
                '}';
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
