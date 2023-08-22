package org.mll.service.test;

import java.util.List;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mll.dto.test.MariaTestDto;
import org.mll.dao.test.MariaTestDao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class MariaTestService {
     private final MariaTestDao mariaTestDao;

    public List<MariaTestDto> getMariaTestList(MariaTestDto param) {
        log.info("test getSearchUserId()");
        return mariaTestDao.selectTestMariaDb(param);
    }

}
