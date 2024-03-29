package com.opensams.test.dal;

import com.google.common.collect.Lists;
import com.opensams.dal.StudentDao;
import com.opensams.dal.po.Student;
import com.opensams.test.BasicTest;
import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @author Kevin Leung
 */
public class StudentDaoTest extends BasicTest {

    @Resource
    private StudentDao studentDao;

    @Test
    public void testQueryStudentByLoginName() {
        Student student = studentDao.queryStudentByLoginName("20154124");

        System.out.println(student);
    }

    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setStudentName("aaaa");
        student.setStudentCode("bbbb");
        student.setCollege("cccc");
        student.setLoginName("abc");
        student.setLoginPwd("abc");
        student.setCreatedAt(new Date());

        int affectedRows = studentDao.insertStudent(student);

        assert affectedRows == 1;
    }

    @Test
    public void testInsertStudents() {
        Student student1 = new Student();
        student1.setStudentName("aaaa");
        student1.setStudentCode("bbbb");
        student1.setCollege("cccc");
        student1.setLoginName("abc");
        student1.setLoginPwd("abc");

        Student student2 = new Student();
        student2.setStudentName("aaaa");
        student2.setStudentCode("bbbb");
        student2.setCollege("cccc");
        student2.setLoginName("abc");
        student2.setLoginPwd("abc");

        List<Student> students = Lists.newArrayList(student1, student2);

        int affectedRows = studentDao.insertStudents(students);

        assert affectedRows == 2;
    }

    @Test
    public void testQueryStudentsByCodes() {
        List<String> studentCodes = Lists.newArrayList("20154124");
        List<Student> students = studentDao.queryStudentsByCodes(studentCodes);

        assert CollectionUtils.isNotEmpty(students);
    }

    @Test
    public void testQueryStudentsPage() {
        Student studentParam = new Student();
        studentParam.setStart(0);
        studentParam.setOffset(1);
        List<Student> students = studentDao.queryStudentsPage(studentParam);

        assert CollectionUtils.isNotEmpty(students);
    }

    @Test
    public void testQueryStudentByCode() {
        String code = "20154124";

        Student student = studentDao.queryStudentByCode(code);

        assert student != null;

        System.out.println(student);
    }

    @Test
    public void testDeleteStudentByCode() {
        String code = "test01";

        int affectedRows = studentDao.deleteStudentByCode(code);

        assert affectedRows == 1;
    }

}
