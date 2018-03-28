package service;

import com.grw.dao.impl.DaoImpl;

import javabean.Person;

public class addService {

	public void add(Person person) {
		DaoImpl dao = new DaoImpl();
		String sql = "INSERT INTO Entity_1(name,id,id4,id2,lou_number,phone,birthday,ru_zhu_time,jie_zhi_time,picture1,picture2,picture3,zhuang_tai)VALUES ('" + person.getName()+ "','"+ person.getId()+"',null,null,'"  + person.getLou_number()
				+ "','" + person.getPhone() + "','" + person.getBirthday()+ "','" + person.getRu_zhu_time()+ "','" + person.getJie_zhi_time()+ "','" + person.getPicture1()+"','" + person.getPicture2()+"','" + person.getPicture3()+"','ÔÚ¼Ò" +"')";
		dao.update(sql);
	}
}
