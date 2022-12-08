package ms.gradems.mapper;

import ms.gradems.entity.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class TeacherMapperTest {
    @Autowired
    private TeacherMapper teacherMapper;

    @Test
    public void insert() {
        Teacher teacher = new Teacher();
        teacher.setTeacherNum("5120200002");
        teacher.setTeacherPwd("123");
        teacher.setTeacherRealName("dym");
        teacherMapper.insertTeacher(teacher);
    }

    @Test
    public void find() {
        System.out.println("findByTeacherNum" + teacherMapper.findByTeacherNum("5120200001"));
        System.out.println("findByTeacherId" + teacherMapper.findByTeacherId(1));
    }

    @Test
    public void findAll() {
        System.out.println(teacherMapper.findAllTeacher());
    }

    @Test
    public void update() {
        Teacher teacher = new Teacher();
        teacher.setTeacherId(1);
        teacher.setTeacherRealName("ddd");
        teacherMapper.updateTeacher(teacher);
        System.out.println(teacherMapper.findByTeacherId(1));
    }

    @Test
    public void delete() {
        teacherMapper.deleteTeacherById(1);
    }
}
