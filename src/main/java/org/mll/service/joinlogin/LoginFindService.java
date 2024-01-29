package org.mll.service.joinlogin;

import lombok.extern.slf4j.Slf4j;
import org.mll.dao.joinlogin.LoginFindDao;
import org.mll.dto.joinlogin.LoginFindDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LoginFindService {

    @Autowired
    private LoginFindDao loginFindDao;

    public List<LoginFindDto> getFindId(LoginFindDto param) throws Exception {

        List<LoginFindDto> list = null;

        try {
            log.info(param.getSearchUserId());
            list = loginFindDao.selectFindId(param);
        } catch (Exception e) {
            log.error("serv :::::::::: " + e.getMessage());
            throw e;
        }
        return list;
    }

    public List<LoginFindDto> getSearchId(LoginFindDto param) throws Exception {

        List<LoginFindDto> list = null;

        try {
            log.info(param.getUserId());
            list = loginFindDao.selectSearchId(param);
        } catch (Exception e) {
            log.error("serv :::::::::: " + e.getMessage());
            throw e;
        }
        return list;
    }

    public List<LoginFindDto> getLoginUs(LoginFindDto param) throws Exception {

        List<LoginFindDto> list = null;

        try {
            log.info(param.getUserId());

            String findUserId = param.getUserId();
            String findUserPass= param.getUserPass();

            list = loginFindDao.selectLoginUs(findUserId, findUserPass);

        } catch (Exception e) {
            log.error("serv :::::::::: " + e.getMessage());
            throw e;
        }
        return list;
    }



}
