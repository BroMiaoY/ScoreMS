package ms.gradems.mapper;

import ms.gradems.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    Integer insertAdmin(Admin admin);

    Admin findByAdminId(Integer adminId);

    Admin findByAdminNum(String adminNum);

    List<Admin> findAllAdmin();

    void updateAdmin(Admin admin);

    void deleteAdminById(Integer adminId);

}