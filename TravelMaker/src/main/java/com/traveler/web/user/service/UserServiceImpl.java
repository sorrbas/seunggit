package com.traveler.web.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.traveler.web.user.mapper.UserMapper;
import com.traveler.web.user.model.UserVO;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserMapper usermapper;
	// 회원가입
	@Override
	public void insertUser(UserVO vo)throws Exception {
		
		usermapper.insertUser(vo);
	}
	// 아이디 중복 검사
	@Override
	public int idCheck(String id)throws Exception {
		return usermapper.idCheck(id);
	}
	// 로그인
	@Override
	public UserVO userLogin(UserVO vo)throws Exception {
		
		return usermapper.userLogin(vo);
	}
	// 회원정보 보기
	@Override
	public UserVO readUser(String id)throws Exception {
		return usermapper.readUser(id);
	}
	// 회원정보 수정
	@Override
	public void updateUser(UserVO vo)throws Exception {
		usermapper.updateUser(vo);
	}
	// 회원정보 삭제
	@Override
	public void deleteUser(UserVO vo)throws Exception {
		usermapper.deleteUser(vo);
	}
	// 아이디 찾기
	@Override
	public UserVO searchid(UserVO vo)throws Exception {
		return usermapper.searchid(vo);
	}
//	public UserVO searchid(String id)throws Exception {
//		return usermapper.searchid(id);
//	}
	// 비밀번호 찾기
	public UserVO searchpw(UserVO vo)throws Exception {
		return usermapper.searchpw(vo);
	}
}
