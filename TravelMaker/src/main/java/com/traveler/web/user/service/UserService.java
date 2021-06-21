package com.traveler.web.user.service;

import javax.servlet.http.HttpSession;

import com.traveler.web.user.model.UserVO;

public interface UserService {
	
	// 회원가입
	public void insertUser(UserVO vo)throws Exception;
	// 아이디 중복 검사
	public int idCheck(String id)throws Exception;
	// 로그인
	public UserVO userLogin(UserVO vo)throws Exception;
	// 회원정보 보기 
	public UserVO readUser(String id)throws Exception;
	// 회원정보 수정
	public void updateUser(UserVO vo)throws Exception;
	// 회원탈퇴
	public void deleteUser(UserVO vo)throws Exception;
	// 아이디 찾기
	public UserVO searchid(UserVO vo)throws Exception;
//	public UserVO searchid(String id)throws Exception;
	// 비밀번호 찾기
	public UserVO searchpw(UserVO vo)throws Exception;
}
