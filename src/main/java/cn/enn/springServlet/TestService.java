package cn.enn.springServlet;

import org.nutz.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TestService {
	
	@Autowired
	private Dao dao;
	
	public int count(){
		int count = dao.count(NE_CUSTOMObj.class);
		return count;
	}
}
