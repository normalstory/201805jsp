package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserServiceInf {
	List<UserVo> selectUserAll();
	UserVo selectUser(String param);
	UserVo selectUser(UserVo userVo);
}
