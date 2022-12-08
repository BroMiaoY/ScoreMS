package ms.gradems.mapper;

import ms.gradems.entity.CClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class ClassMapperTest {
    @Autowired
    private ClassMapper classMapper;

    @Test
    public void insert() {
        CClass cClass = new CClass();
        cClass.setClassName("卓软2001");
        cClass.setClassTeacherId(1);
        classMapper.insertClass(cClass);
    }

    @Test
    public void find() {
        System.out.println("findByClassNum" + classMapper.findByClassName("卓软2001"));
        System.out.println("findByClassId" + classMapper.findByClassId(1));
    }

    @Test
    public void findAll() {
        System.out.println(classMapper.findAllClass());
    }

    @Test
    public void update() {
        CClass cClass = new CClass();
        cClass.setClassId(1);
        cClass.setClassName("软件2001");
        classMapper.updateClass(cClass);
        System.out.println(classMapper.findByClassId(1));
    }

    @Test
    public void delete() {
        classMapper.deleteClassById(1);
    }
}
