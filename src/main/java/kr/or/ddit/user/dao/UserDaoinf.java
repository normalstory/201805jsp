package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface UserDaoinf {
	public List<UserVo> selectUserAll();
	public UserVo selectUser(String param);
	public UserVo selectUser(UserVo userVo);
}
