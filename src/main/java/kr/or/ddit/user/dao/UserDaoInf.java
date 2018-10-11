package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface UserDaoInf {
	List<UserVo> selectUserAll();
	UserVo selectUser(String param);
	UserVo selectUser(UserVo userVo);
	List<UserVo> selectUserPageList(PageVo pageVo);
	
	/**
	* Method : getUsetCnt
	* 작성자 : pc03
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수조회
	* 
	* 
	*/
	int getUsetCnt();
}
