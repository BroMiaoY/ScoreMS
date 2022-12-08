package ms.gradems.mapper;

import ms.gradems.entity.Grade;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class GradeMapperTest {
    @Autowired
    private GradeMapper gradeMapper;

    @Test
    public void insert() {
        Grade grade = new Grade();
        grade.setScCourseId(1);
        grade.setScStuId(3);
        grade.setScGrade(100);
        gradeMapper.insertGrade(grade);
    }

    @Test
    public void find() {
        System.out.println("findByScCourseId" + gradeMapper.findByScCourseId(1));
        System.out.println("findByScId" + gradeMapper.findByScId(1));
        System.out.println("findByScStuId" + gradeMapper.findByScStuId(3));

    }

    @Test
    public void findAll() {
        System.out.println(gradeMapper.findAllGrade());
    }

    @Test
    public void update() {
        Grade grade = new Grade();
        grade.setScId(1);
        grade.setScStuId(4);
        gradeMapper.updateGrade(grade);
        System.out.println(gradeMapper.findByScId(1));
    }

    @Test
    public void delete() {
        gradeMapper.deleteGradeById(1);
    }
}
