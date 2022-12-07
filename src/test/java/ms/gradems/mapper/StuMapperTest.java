package ms.gradems.mapper;

import ms.gradems.entity.Stu;
import org.junit.jupiter.api.Test;

public class StuMapperTest {
    StuMapper stuMapper;

    @Test
    public void insert() {
        Stu stu = new Stu();
        stu.setStuNum("5120205693");
        stu.setStuPwd("123");
        stu.setStuRealName("dym");
        stu.setStuMajorId(1);
        System.out.println(stu);
        stuMapper.insertStu(stu);
    }
}
