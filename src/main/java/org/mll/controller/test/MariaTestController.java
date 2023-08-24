package org.mll.controller.test;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mll.service.test.MariaTestService;
import org.mll.dto.test.MariaTestDto;

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
@RequestMapping("/api/test")
public class MariaTestController {
    @Autowired
    MariaTestService mariaTestService;

    @RequestMapping("gTest")
    public ResponseEntity<List<MariaTestDto>> getTest(@RequestBody MariaTestDto param) throws Exception  {
        log.info(param.getSearchUserId());

        List<MariaTestDto> contDto = null;

        ResponseEntity<List<MariaTestDto>> entity = null;

        try {
            contDto = mariaTestService.getMariaTestList(param);
            entity = new ResponseEntity<>(contDto, HttpStatus.OK);
        } catch (Exception e) {
          log.error("ctl ::::::: " + e.getMessage());
          throw e;
        }
        return entity;
    }

    @RequestMapping("gSearchId")
    public ResponseEntity<List<MariaTestDto>> getSearchId(@RequestBody MariaTestDto param) throws Exception  {
        log.info(param.getUserId());

        List<MariaTestDto> contDto = null;

        ResponseEntity<List<MariaTestDto>> entity = null;

        try {
            contDto = mariaTestService.getSearchId(param);
            entity = new ResponseEntity<>(contDto, HttpStatus.OK);
        } catch (Exception e) {
            log.error("ctl ::::::: " + e.getMessage());
            throw e;
        }
        return entity;
    }


}
