package ms.gradems.service;

import ms.gradems.entity.Stu;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.security.NoSuchAlgorithmException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class StuServiceTest {
    @Autowired
    private StuService stuService;

    @Test
    public void reg() throws NoSuchAlgorithmException {
        Stu stu = new Stu();
        stu.setStuNum("5120200001");
        stu.setStuPwd("123");
        stu.setStuRealName("dym");
        stu.setStuMajorId(1);
        stuService.reg(stu);
    }
}
