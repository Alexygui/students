package com.aaa.action;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
	
	//删除学生的方法
	public String delete() {
		StudentsDao studentsDao = new StudentsDaoImplement();
		String sid = request.getParameter("sid");
		studentsDao.deleteStudents(sid);//调用StudentsDao对象的deleteStudents方法
		return "delete_success";
	}
	
	//添加学生
	public String add() {
		StudentsDao studentsDao = new StudentsDaoImplement();
		Students student = new Students();
		student.setName(request.getParameter("sname"));
		student.setGender(request.getParameter("gender"));
//		student.setBirthday(new Date());
		//添加页面中写的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			student.setBirthday(sdf.parse(request.getParameter("birthday")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		student.setAddress(request.getParameter("address"));
		studentsDao.addStudents(student);
		return "add_success";
	}
	
	//修改学生资料的动作
	public String modify() {
		//获得传递的学生的编号
		String sid = request.getParameter("sid");
		StudentsDao studentsDao = new StudentsDaoImplement();
		Students student = studentsDao.queryStudentsBySid(sid);
		session.setAttribute("modify_students", student);
		return "modify_success";
		
	}
	
	//保存修改后的学生信息动作
	public String save() {
		Students student = new Students();
		StudentsDao studentsDao = new StudentsDaoImplement();
		student.setSid(request.getParameter("sid"));
		student.setName(request.getParameter("sname"));
		student.setGender(request.getParameter("gender"));
		//添加页面中写的日期
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			student.setBirthday(sdf.parse(request.getParameter("birthday")));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		student.setAddress(request.getParameter("address"));
		studentsDao.updateStudents(student);
		return "save_success";
	}
}
