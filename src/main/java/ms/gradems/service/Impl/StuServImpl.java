package ms.gradems.service.Impl;
import ms.gradems.config.TokenConfig;
import ms.gradems.entity.Stu;
import ms.gradems.mapper.StuMapper;
import ms.gradems.service.StuService;
import ms.gradems.service.ex.*;
import ms.gradems.token.TokenBuilder;
import ms.gradems.token.TokenMsg;
import ms.gradems.util.EncryptUtils;
import ms.gradems.util.TokenUtil;
import ms.gradems.vo.StuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StuServImpl implements StuService {

    @Autowired
    private StuMapper stuMapper;

    private final TokenConfig tokenConfig;

    public StuServImpl(TokenConfig tokenConfig) {
        this.tokenConfig = tokenConfig;
    }

    /**
     * 新增学生/学生注册
     * @param stu
     * @throws NoSuchAlgorithmException
     */
    @Override
    public void reg(Stu stu) throws NoSuchAlgorithmException {
        String stuNum = stu.getStuNum();
        //调用findByStuNum(stuNum)判断用户是否被构造过
        Stu findNum = stuMapper.findByStuNum(stuNum);
        //判断结果集是不否为null，抛出学号被占用的异常
        if (findNum != null) {
            //抛出异常
            throw new UserNumDuplicatedException("用户名被占用");
        }
        String stuPwd = stu.getStuPwd();
        //使用java.security.MessageDigest类对密码进行加密
        MessageDigest md5 =  MessageDigest.getInstance("MD5");
        byte[] byteArr = md5.digest(stuPwd.getBytes(StandardCharsets.UTF_8));
        stu.setStuPwd(String.valueOf(EncryptUtils.byte2hex(byteArr)));
        //执行注册业务功能(rows==1)
        Integer rows = stuMapper.insertStu(stu);
        if (rows != 1) {
            throw new InsertException("在用户注册中产生了未知的异常");
        }
    }

    @Override
    public Map<String,Object> login(String stuNum, String stuPwd) throws NoSuchAlgorithmException {
        //查找用户数据，判断用户是否存在
        Stu result = stuMapper.findByStuNum(stuNum);
        if (result == null) {
            throw new UserNotFoundException("用户数据不存在");
        }
        //判断用户密码是否正确
        String password = result.getStuPwd();
        //使用java.security.MessageDigest类对输入密码进行加密，与数据库密码进行匹配
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] byteArr = md5.digest(stuPwd.getBytes(StandardCharsets.UTF_8));
        stuPwd = EncryptUtils.byte2hex(byteArr);
        if(!password.equals(stuPwd)) {
            throw new PasswordNotMatchException("用户密码错误");
        }

        //Token
        TokenMsg tokenMsg = new TokenMsg();
        tokenMsg.setId(result.getStuId());
        tokenMsg.setRole("stu");
        tokenMsg.setNum(result.getStuNum());
        String token = TokenUtil.buildToken(new TokenBuilder(tokenMsg, tokenConfig.getTokenSecretKey()));
        Map<String, Object> data = new HashMap<>(1);
        data.put("token", token);
        return data;
    }

    @Override
    public StuVO searchStu(String stuNum) {
        Stu result = stuMapper.findByStuNum(stuNum);
        if (result==null){
            throw new SearchException("该id所对应的用户不存在");
        }

        //stu转stuVO
        StuVO resultVO = makeDtoStu(result);
        return resultVO;
    }

    @Override
    public List<StuVO> searchAllAdmin() {
        List<Stu> result = stuMapper.findAllStu();
        if (result==null){
            throw new SearchException("查询出现未知错误");
        }
        List<StuVO> stuVOS = null;
        for (Stu stu : result) {
            //拼接照片请求路径
            stuVOS.add(makeDtoStu(stu));
        }
        return stuVOS;
    }
//
//    @Override
//    public List<BaseUser> findAdminByUserZone(String userZone, TokenMsg tokenMsg) throws FileNotFoundException {
//        List<BaseUser> result = adminMapper.findByAdminZone(userZone);
//        if (result == null) {
//            throw new SearchException("该地区所对应的用户不存在");
//        }
//        for (BaseUser comUser : result) {
//            //拼接照片请求路径
//            makeUserAllPic(comUser);
//        }
//        return result;
//    }
//
//    @Override
//    public void deleteAdminById(Integer userId, TokenMsg tokenMsg) {
//        BaseUser result = adminMapper.findAdminById(userId);
//        if(result == null) {
//            throw  new SearchException("该id不存在");
//        }
//        if(result.getUserPic() != null) {
//            DeletePicUtils.deleteUserPic(result.getUserPic());
//        }
//        //删除会员表中信息
//        VipAndUserVO vip = vipService.searchVipByUserId(userId, tokenMsg);
//        if (vip != null) {
//            vipService.deleteVipById(vip.getVipId(), tokenMsg);
//        }
//        adminMapper.deleteAdmin(userId);
//
//    }
//
//    @Override
//    public BaseUser updateAdmin(BaseUser baseUser, TokenMsg tokenMsg) throws NoSuchAlgorithmException, FileNotFoundException {
//        String password = baseUser.getUserPwd();
//        //使用java.security.MessageDigest类对密码进行加密
//        MessageDigest md5 =  MessageDigest.getInstance("MD5");
//        byte[] byteArr = md5.digest(password.getBytes(StandardCharsets.UTF_8));
//        baseUser.setUserPwd(String.valueOf(EncryptUtils.byte2hex(byteArr)));
//        adminMapper.updateAdmin(baseUser);
//        return searchAdminUser(baseUser.getUserId(), tokenMsg);
//    }
//
//    @Override
//    public void updatePic(MultipartFile file, Integer userId, TokenMsg tokenMsg) {
//        BaseUser result = adminMapper.findAdminById(userId);
//        String picPath = result.getUserPic();
//        UpdatePicUtils.updateUserPic(file, picPath);
//    }

    private StuVO makeDtoStu(Stu stu) {
        StuVO stuVO = new StuVO();
        stuVO.setStuId(stu.getStuId());
        stuVO.setStuNum(stu.getStuNum());

        return stuVO;
    }
}