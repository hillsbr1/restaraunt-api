package jhu.rest.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long    id;
    private String firstName;
    private String lastName;
    private String address;

   Student() {/* NO-ARG CONSTRUCTOR */}

   public Student (Long id, String firstName, String lastName, String address) {
       this.id = id;
       this.firstName = firstName;
       this.lastName = lastName;
       this.address = address;
    }

   public long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public String getFirstName() {
      return firstName;
   } 
   public void setFirstName(String firstName) { 
      this.firstName = firstName; 
   }
   public String getLastName() { 
      return lastName; 
   } 
   public void setLastName(String lastName) {
      this.lastName = lastName; 
   } 
   public String getAddress() { 
      return address; 
   }
   public void setAddress(String address) { 
      this.address = address; 
   }
   
   public String toString() {
	   return "id=" + this.id + ": " + this.firstName + " " + this.lastName + " " + this.address;
   }
}

