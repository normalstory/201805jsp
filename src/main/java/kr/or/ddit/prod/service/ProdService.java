package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class ProdService implements ProdServiceInf{

	ProdDaoInf prodDao = new ProdDao();
	
	@Override
	public List<ProdVo> prodList() {
		return prodDao.prodList();
	}

	@Override
	public ProdVo prodDetail(String prod_id) {
		return prodDao.prodDetail(prod_id);
	}

	@Override
	public 	Map<String,Object> prodPageList(PageVo pageVo) {
		//페이지에 해당하는 유저리스트(1~10건)
		List<ProdVo> prodList = prodDao.prodPageList(pageVo);
		
		//전체 리스트 
		int totalProdCnt = prodDao.getProdCnt();
		
		//여러개의 결과를 담은 map객체 
		Map<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("prodList",prodList);
		resultMap.put("pageCnt",(int)Math.ceil((double)totalProdCnt/pageVo.getPageSize()));
	
		return resultMap;
	}

	@Override
	public int getProdCnt() {
		return prodDao.getProdCnt();
	}

}
