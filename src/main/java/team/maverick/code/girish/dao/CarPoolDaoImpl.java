package team.maverick.code.girish.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import team.maverick.code.girish.entity.UserDetail;

@Transactional
public class CarPoolDaoImpl {

	@Autowired
	private SessionFactory sessionFactory;
	
	public UserDetail getUserDetail(String userId) {
		UserDetail user = new UserDetail();
		user.setUserId(userId);
		return sessionFactory.getCurrentSession().
				get(UserDetail.class, user);
	}
}
