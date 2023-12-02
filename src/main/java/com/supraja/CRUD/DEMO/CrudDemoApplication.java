package com.supraja.CRUD.DEMO;

import com.supraja.CRUD.DEMO.dao.StudentDAO;
import com.supraja.CRUD.DEMO.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> {
//			createStudent(studentDAO);
//			readStudent(studentDAO);
//			getAllStudents(studentDAO);
			findStudentByLastName(studentDAO);
		};
	}

	private void findStudentByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findStudentByLastName("Srikant");
		for (Student student: students) {
			System.out.println(student);
		}

	}

	private void getAllStudents(StudentDAO studentDAO) {
		System.out.println("In side getAll Students");
		List<Student> students = studentDAO.findAllStudents();
		for (Student student: students) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		Integer studentId = 1;
		Student readStudent  = studentDAO.findById(studentId);
		System.out.println("Student read is " + readStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		//Create student object
		System.out.println("Creating new student object");
		Student tempStudent = new Student("Supraja", "Srikanth", "ssupraja@gmail.com");
		System.out.println("Saving the student object");
		//Save the student
		studentDAO.save(tempStudent);

		//Display student id
		System.out.println("Displaying the student object "+ tempStudent.getId());
	}
}
