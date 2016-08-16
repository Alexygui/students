package com.aaa.entity;

import java.util.Date;
import java.util.List;

import org.junit.Test;

import com.aaa.service.StudentsDao;
import com.aaa.service.implement.StudentsDaoImplement;

public class TestStudentsDaoImplement {
	@Test
	public void testQueryAllStudents() {
		StudentsDao studentsDao = new StudentsDaoImplement();
		List<Students> studentsList = studentsDao.queryAllStudents();
		for(int i=0; i<studentsList.size(); i++) {
			System.out.println(studentsList.get(i));
		}
	}
	
//	@Test
//	public void testGetNewSid() {
//		StudentsDaoImplement studentsDaoImplement = new StudentsDaoImplement();
//		System.out.println(studentsDaoImplement.getNewSid());
//	}
	
	@Test
	public void testAddStudents() {
		Students student = new Students(null, "张三丰", "男", new Date(), "武当山");
		StudentsDao studentsDao = new StudentsDaoImplement();
		studentsDao.addStudents(student);
	}
}
