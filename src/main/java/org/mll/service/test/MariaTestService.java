package org.mll.service.test;

import java.util.List;

import lombok.extern.slf4j.Slf4j;
import org.mll.dto.test.MariaTestDto;
import org.mll.dao.test.MariaTestDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class MariaTestService {

     @Autowired
     private MariaTestDao mariaTestDao;

    public List<MariaTestDto> getMariaTestList(MariaTestDto param) throws Exception {

        List<MariaTestDto> list = null;

        try {
            log.info(param.getSearchUserId());
            list = mariaTestDao.selectTestMariaDb(param);
        } catch (Exception e) {
            log.error("serv :::::::::: " + e.getMessage());
            throw e;
        }
        return list;
    }

}
