package ms.gradems.mapper;

import ms.gradems.entity.Major;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MajorMapper {

    Integer insertMajor(Major major);

    Major findByMajorId(Integer majorId);

    Major findByMajorName(String majorNum);

    List<Major> findAllMajor();

    void updateMajor(Major major);

    void deleteMajorById(Integer majorId);

}