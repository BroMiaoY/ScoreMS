package ms.gradems.entity;

import lombok.Data;

import java.io.Serializable;

@Data
public class Stu implements Serializable {
    Integer stuId;
    String stuNum;
    String stuPwd;
    String stuRealName;
    Integer stuMajorId;
    Integer stuClassId;
}
