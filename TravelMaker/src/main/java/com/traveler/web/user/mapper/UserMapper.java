package com.traveler.web.user.mapper;

import com.traveler.web.user.model.UserVO;

public interface UserMapper {
	
	// 회원가입
	public void insertUser(UserVO vo);
	// 아이디 중복검사
	public int idCheck(String id);
	// 로그인
	public UserVO userLogin(UserVO vo);
	// 회원 정보 보기
	public UserVO readUser(String id);
	// 회원 정보 수정
	public void updateUser(UserVO vo);
	// 회원 탈퇴
	public void deleteUser(UserVO vo);
	// 아이디 찾기
	public UserVO searchid(UserVO vo);
//	public UserVO searchid(String id);
	// 비밀번호 찾기
	public UserVO searchpw(UserVO vo);
}
