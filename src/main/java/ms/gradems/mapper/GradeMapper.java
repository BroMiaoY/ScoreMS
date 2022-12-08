package ms.gradems.mapper;

import ms.gradems.entity.Grade;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GradeMapper {

    Integer insertGrade(Grade grade);

    Grade findByScId(Integer scId);

    Grade findByScCourseId(Integer scCourseId);

    Grade findByScStuId(Integer scStuId);

    List<Grade> findAllGrade();

    void updateGrade(Grade Grade);

    void deleteGradeById(Integer scId);

}