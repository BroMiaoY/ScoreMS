package ms.gradems.mapper;

import ms.gradems.entity.Stu;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface StuMapper {

    Integer insertStu(Stu stu);

    Stu findByStuId(Integer stuId);

    Stu findByStuNum(String stuNum);

    List<Stu> findByClassId(Integer classId);

    List<Stu> findAllStu();

    void updateStu(Stu stu);

    void deleteStuById(Integer stuId);

}