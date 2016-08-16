package com.aaa.action;

import java.util.List;

import com.aaa.entity.Students;
import com.aaa.service.StudentsDao;
import com.aaa.service.implement.StudentsDaoImplement;

//学生Action类
public class StudentsAction extends SuperAction{

	private static final long serialVersionUID = 1L;
	
	//查询所有学生的方法
	public String query() {
		StudentsDao studentsDao = new StudentsDaoImplement();
		List<Students> studentsList = studentsDao.queryAllStudents();
		if(studentsList != null && studentsList.size() > 0) {
			session.setAttribute("students_list", studentsList);
		}
		return "query_success";
	}
}
