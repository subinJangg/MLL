package org.mll.dao.test;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mll.dto.test.MariaTestDto;
import org.springframework.stereotype.Repository;

@Mapper

public interface MariaTestDao {

     List<MariaTestDto> selectTestMariaDb(MariaTestDto param) ;




}
