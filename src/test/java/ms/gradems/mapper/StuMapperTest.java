package ms.gradems.mapper;

import ms.gradems.entity.Stu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class StuMapperTest {
    @Autowired
    private StuMapper stuMapper;

    @Test
    public void insert() {
        Stu stu = new Stu();
        stu.setStuNum("5120200003");
        stu.setStuPwd("123");
        stu.setStuRealName("dym");
        stu.setStuMajorId(1);
        stu.setStuClassId(1);
        stuMapper.insertStu(stu);
    }

    @Test
    public void findByStuId() {
        System.out.println("findByStuNum" + stuMapper.findByStuNum("5120205693"));
        System.out.println("findByStuId" + stuMapper.findByStuId(1));
    }

    @Test
    public void findByClassId() {
        Integer classId = 1;
        System.out.println(stuMapper.findByClassId(classId));
    }

    @Test
    public void findAll() {
        System.out.println(stuMapper.findAllStu());
    }

    @Test
    public void update() {
        Stu stu = new Stu();
        stu.setStuId(4);
        stu.setStuRealName("ddd");
        stu.setStuClassId(2);
        stuMapper.updateStu(stu);
        System.out.println(stuMapper.findByStuId(4));
    }

    @Test
    public void delete() {
        stuMapper.deleteStuById(2);
    }
}
