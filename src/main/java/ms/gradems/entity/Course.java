package ms.gradems.entity;

import lombok.Data;

@Data
public class Course {
    Integer courseId;
    Integer courseTeacherId;
    String courseName;
}
