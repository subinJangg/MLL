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



@CrossOrigin(origins = "*")
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/test")
public class MariaTestController {

    private final MariaTestService mariaTestService;

    @RequestMapping("gTest")
    public List<MariaTestDto> getTest()  {
        return mariaTestService.getMariaTestList();

    }


}
