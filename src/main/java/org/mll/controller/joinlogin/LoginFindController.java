package org.mll.controller.joinlogin;

import lombok.extern.slf4j.Slf4j;
import org.mll.dto.joinlogin.LoginFindDto;
import org.mll.dto.test.MariaTestDto;
import org.mll.service.joinlogin.LoginFindService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Slf4j
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/joinLogin")
public class LoginFindController {

    @Autowired
    LoginFindService loginFindService;

    @RequestMapping("gFindId")
    public ResponseEntity<List<LoginFindDto>> getFindId(@RequestBody LoginFindDto param) throws Exception  {

        List<LoginFindDto> contDto = null;

        ResponseEntity<List<LoginFindDto>> entity = null;

        try {
            contDto = loginFindService.getFindId(param);
            entity = new ResponseEntity<>(contDto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("ctl ::::::: " + e.getMessage());
            throw e;
        }
        return entity;
    }

    @RequestMapping("gSearchId")
    public ResponseEntity<List<LoginFindDto>> getSearchId(@RequestBody LoginFindDto param) throws Exception  {

        List<LoginFindDto> contDto = null;

        ResponseEntity<List<LoginFindDto>> entity = null;

        try {
            contDto = loginFindService.getSearchId(param);
            entity = new ResponseEntity<>(contDto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("ctl ::::::: " + e.getMessage());
            throw e;
        }
        return entity;
    }

    @RequestMapping("gLoginUs")
    public ResponseEntity<List<LoginFindDto>> getLoginUs(@RequestBody LoginFindDto param) throws Exception  {

        List<LoginFindDto> contDto = null;

        ResponseEntity<List<LoginFindDto>> entity = null;

        try {
            contDto = loginFindService.getLoginUs(param);
            entity = new ResponseEntity<>(contDto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("ctl ::::::: " + e.getMessage());
            throw e;
        }
        return entity;
    }

}
