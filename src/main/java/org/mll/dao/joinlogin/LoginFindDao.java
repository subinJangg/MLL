package org.mll.dao.joinlogin;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.mll.dto.joinlogin.LoginFindDto;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface LoginFindDao {

    //로그인 > 아이디찾기
    public List<LoginFindDto> selectFindId(LoginFindDto param) throws Exception ;

    //로그인 > 비밀번호 찾기
    public List<LoginFindDto> selectSearchId(LoginFindDto param) throws Exception;

    //로그인 > 로그인화면 :: 로그인 인증 도입 예정
    public List<LoginFindDto> selectLoginUs(String findUserId, String findUserPass) throws Exception;

}
