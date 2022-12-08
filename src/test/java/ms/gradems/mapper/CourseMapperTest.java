package ms.gradems.mapper;

import ms.gradems.entity.Course;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class CourseMapperTest {
    @Autowired
    private CourseMapper courseMapper;

    @Test
    public void insert() {
        Course course = new Course();
        course.setCourseTeacherId(2);
        course.setCourseName("信息系统开发");
        courseMapper.insertCourse(course);
    }

    @Test
    public void find() {
        System.out.println("findByCourseName" + courseMapper.findByCourseName("信息系统开发"));
        System.out.println("findByCourseTeacherId" + courseMapper.findByCourseTeacherId(2));
        System.out.println("findByCourseId" + courseMapper.findByCourseId(1));
    }

    @Test
    public void findAll() {
        System.out.println(courseMapper.findAllCourse());
    }

    @Test
    public void update() {
        Course course = new Course();
        course.setCourseId(1);
        course.setCourseName("信息系统开发1");
        courseMapper.updateCourse(course);
        System.out.println(courseMapper.findByCourseId(1));
    }

    @Test
    public void delete() {
        courseMapper.deleteCourseById(1);
    }
}
