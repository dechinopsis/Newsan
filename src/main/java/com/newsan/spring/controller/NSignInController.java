package com.newsan.spring.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsan.spring.dao.NUserDao;
import com.newsan.spring.dao.NUserDaoImpl;
import com.newsan.spring.domain.NUser;
import com.newsan.spring.vo.NSignInWrapper;
@Controller
@RequestMapping(value = "/login")
public class NSignInController {
	private NUserDao userDao;
	@Autowired
	public void setUserDao(NUserDao userDao) {
		this.userDao = userDao;
	}
	@RequestMapping(value = "requestLogin", method = RequestMethod.POST)
	public @ResponseBody NSignInWrapper login(@RequestBody NSignInWrapper pLoginParms) {		
		NUser nuser = userDao.getUser(1);
		pLoginParms.setcMessage(nuser.getName());
		return pLoginParms;
	}
	@RequestMapping("/")
	public String start(Model model) {
		return "NSignIn";

	}
}