package ms.gradems.mapper;

import ms.gradems.entity.Course;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CourseMapper {

    Integer insertCourse(Course course);

    Course findByCourseId(Integer courseId);

    Course findByCourseName(String courseNum);

    Course findByCourseTeacherId(Integer courseTeacherId);

    List<Course> findAllCourse();

    void updateCourse(Course course);

    void deleteCourseById(Integer courseId);

}