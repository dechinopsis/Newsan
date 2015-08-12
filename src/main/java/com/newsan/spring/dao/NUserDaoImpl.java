package com.newsan.spring.dao;

import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newsan.spring.domain.NUser;
  
@Service
public class NUserDaoImpl implements NUserDao {
	@Autowired
    private SessionFactory sessionFactory;

	public NUser getUser(int userId) {			
		NUser resultUser = (NUser) sessionFactory.openSession().get(NUser.class, userId);
		sessionFactory.close();
		return resultUser;
	}  
  
  
} 