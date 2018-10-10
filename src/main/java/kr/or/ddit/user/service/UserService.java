package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf{

	//UserDao dao = new UserDao();
	
	@Override
	public List<UserVo> selectUserAll() {
		UserDao dao = new UserDao();
		return dao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String param) {
		UserDao dao = new UserDao();
		return dao.selectUser(param);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		UserDao dao = new UserDao();
		return dao.selectUser(userVo);
	}

}
