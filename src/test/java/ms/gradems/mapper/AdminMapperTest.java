package ms.gradems.mapper;

import ms.gradems.entity.Admin;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class AdminMapperTest {
    @Autowired
    private AdminMapper adminMapper;

    @Test
    public void insert() {
        Admin admin = new Admin();
        admin.setAdminNum("5120200001");
        admin.setAdminPwd("123");
        admin.setAdminRealName("dym");
        adminMapper.insertAdmin(admin);
    }

    @Test
    public void find() {
        System.out.println("findByAdminNum" + adminMapper.findByAdminNum("5120205693"));
        System.out.println("findByAdminId" + adminMapper.findByAdminId(1));
    }

    @Test
    public void findAll() {
        System.out.println(adminMapper.findAllAdmin());
    }

    @Test
    public void update() {
        Admin admin = new Admin();
        admin.setAdminId(1);
        admin.setAdminRealName("ddd");
        adminMapper.updateAdmin(admin);
        System.out.println(adminMapper.findByAdminId(1));
    }

    @Test
    public void delete() {
        adminMapper.deleteAdminById(1);
    }
}
