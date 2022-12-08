package ms.gradems.mapper;

import ms.gradems.entity.Major;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class MajorMapperTest {
    @Autowired
    private MajorMapper majorMapper;

    @Test
    public void insert() {
        Major major = new Major();
        major.setMajorName("软件工程");
        majorMapper.insertMajor(major);
    }

    @Test
    public void find() {
        System.out.println("findByMajorName" + majorMapper.findByMajorName("软件工程"));
        System.out.println("findByMajorId" + majorMapper.findByMajorId(1));
    }

    @Test
    public void findAll() {
        System.out.println(majorMapper.findAllMajor());
    }

    @Test
    public void update() {
        Major major = new Major();
        major.setMajorId(1);
        major.setMajorName("计算机科学与技术");
        majorMapper.updateMajor(major);
        System.out.println(majorMapper.findByMajorId(1));
    }

    @Test
    public void delete() {
        majorMapper.deleteMajorById(1);
    }
}
