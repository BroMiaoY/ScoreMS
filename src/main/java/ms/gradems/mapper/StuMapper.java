package ms.gradems.mapper;

import ms.gradems.entity.Stu;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StuMapper {
    Integer insertStu(Stu stu);
    Stu findByStuId(Integer stuId);
    void updateStu(Stu stu);
    void deleteStuById(Integer stuId);
}