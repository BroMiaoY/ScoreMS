package ms.gradems.mapper;

import ms.gradems.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {

    Integer insertTeacher(Teacher teacher);

    Teacher findByTeacherId(Integer teacherId);

    Teacher findByTeacherNum(String teacherNum);

    List<Teacher> findAllTeacher();

    void updateTeacher(Teacher teacher);

    void deleteTeacherById(Integer teacherId);

}