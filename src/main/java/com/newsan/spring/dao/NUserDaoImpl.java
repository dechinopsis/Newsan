package com.newsan.spring.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.newsan.spring.domain.NUser;
  
public class NUserDaoImpl implements NUserDao {	
    private SessionFactory sessionFactory;

    @Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}    
	public NUser getUser(int userId) {		
		NUser resultUser = (NUser) this.sessionFactory.openSession().get(NUser.class, userId);		
		return resultUser;
	}

	public NUser getUserByName(String userName) {		
		System.out.println("Querying for user: "+userName);
		Query query = this.sessionFactory.openSession().
				createQuery("FROM NUser WHERE name = :userName ");
		query.setParameter("userName", userName);
		List<NUser> listUsers = (List<NUser>)query.list();
		NUser returnUser = null;
		if(listUsers.size()==1){
			returnUser = listUsers.get(0);
		}
		return returnUser;
	}  
  
  
} 