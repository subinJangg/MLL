package org.mll.dao.test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mll.dto.test.MariaTestDto;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface MariaTestDao {

     public List<MariaTestDto> selectTestMariaDb(MariaTestDto param) throws Exception ;

     public List<MariaTestDto> selectSearchId(MariaTestDto param) throws Exception;


}
