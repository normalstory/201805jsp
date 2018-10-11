package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public class UserService implements UserServiceInf{

	//UserDao dao = new UserDao();
	
	@Override
	public List<UserVo> selectUserAll() {
		UserDaoInf dao = new UserDao();
		return dao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String param) {
		UserDaoInf dao = new UserDao();
		return dao.selectUser(param);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		UserDaoInf dao = new UserDao();
		return dao.selectUser(userVo);
	}

	
	/**
	* Method : selectUserPageList
	* 작성자 : pc03
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회 
	*/
	@Override
	public 	Map<String,Object> selectUserPageList(PageVo pageVo) {
		UserDaoInf userdao = new UserDao();
		
		//페이지에 해당하는 유저리스트(1~10건)
		List<UserVo> userList = userdao.selectUserPageList(pageVo);
		
		//전체 리스트 
		int totalUserCnt = userdao.getUsetCnt();
		
		//여러개의 결과를 담은 map객체 
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("userList",userList);
		resultMap.put("pageCnt",(int)Math.ceil((double)totalUserCnt/pageVo.getPageSize()));
		
		//(int)Math.ceil((double)total/pageSize)
		
		return resultMap;
	}

}
