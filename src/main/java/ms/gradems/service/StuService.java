package ms.gradems.service;

import ms.gradems.entity.Stu;
import ms.gradems.vo.StuVO;

import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public interface StuService {
    void reg(Stu stu) throws NoSuchAlgorithmException;

    Map<String,Object> login(String userName, String userPwd) throws NoSuchAlgorithmException;

    StuVO searchStu(String stuNum);

    List<StuVO> searchAllAdmin();
}
