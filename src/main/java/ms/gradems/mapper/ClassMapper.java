package ms.gradems.mapper;

import ms.gradems.entity.CClass;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    Integer insertClass(CClass cClass);

    CClass findByClassId(Integer classId);

    CClass findByClassName(String classNum);

    List<CClass> findAllClass();

    void updateClass(CClass cClass);

    void deleteClassById(Integer classId);

}