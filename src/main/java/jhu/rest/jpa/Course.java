package jhu.rest.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Course {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long    id;
    private Long number;
    private String title;

   Course() {
      System.out.println("Call Course default, no-args constructor  ");
   }

   public Course (long id, long number, String title) {
       this.id = id;
       this.number = number;
       this.title = title;
       System.out.println("Call Course constructor with args .....+++++ ");
    }

   public long getId() {
      return id;
   }
   public void setId(Long id) {
      this.id = id;
   }
   public long getNumber() {
      return number;
   } 
   public void setNumber(long number) { 
      this.number = number; 
   }
   public String getTitle() { 
      return title; 
   } 
   public void setTitle(String title) {
      this.title = title; 
   } 
   public String toString() {
	   return String.format("Course id=%d: %s %s ", id, number, title);
   }
   public boolean equals(Course other) {
	   return (other.id == id && other.number == number && other.title == title);
   }
}

