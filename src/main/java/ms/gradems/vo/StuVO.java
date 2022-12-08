package ms.gradems.vo;

import lombok.Data;

@Data
public class StuVO {
    Integer stuId;
    String stuNum;
    String stuRealName;
    //学生专业
    String stuMajorName;
    //学生班主任
    String classTeacher;
    //学生班级
    String className;
}
