package com.test.student;

import com.test.student.dao.StudentDAO;
import com.test.student.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class StudentApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner->{
//			createStudent(studentDAO);
			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {
		System.out.println("Deleting all students...");
		int rows=studentDAO.deleteAll();
		System.out.println(rows+ " rows deleted");
	}

	private void deleteStudent(StudentDAO studentDAO) {
		int studentId=3;
		System.out.println("Deleting student with id: "+studentId);
		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {
		int studentId=1;
		System.out.println("Getting student with id: "+studentId);

		Student myStudent=studentDAO.findById(studentId);

		System.out.println("Updating the student...");
		myStudent.setFirstName("Menoi");
		studentDAO.update(myStudent);

		System.out.println("Updated student with id: "+studentId);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findByLastName("mena");

		for(Student stud: theStudents){
			System.out.println(stud);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents=studentDAO.findAll();

		for(Student stud: theStudents){
			System.out.println(stud);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating new student object...");
		Student tempStudent=new Student("larva","mena","larva@gmail.com");

		System.out.println("Saving the student");
		studentDAO.save(tempStudent);

		int theId=tempStudent.getId();
		System.out.println("student id is: "+theId);

		System.out.println("Retrieving the student with id: "+theId);
		Student myStudent=studentDAO.findById(theId);

		System.out.println(myStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
		System.out.println("creating 3 student objects...");
		Student tempStudent1=new Student("John","Doe","john@gmail.com");
		Student tempStudent2=new Student("Mena","caca","mena@gmail.com");
		Student tempStudent3=new Student("Puta","Lunga","puta@gmail.com");

		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

		System.out.println("all good");
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("creating new student object...");
		Student tempStudent=new Student("Paul","Doe","paul@gmail.com");

		System.out.println("saving the student...");
		studentDAO.save(tempStudent);

		System.out.println("saved student. generated id: "+tempStudent.getId());
	}
}
