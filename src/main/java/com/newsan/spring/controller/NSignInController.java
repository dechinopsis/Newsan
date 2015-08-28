package com.newsan.spring.controller;
import java.io.UnsupportedEncodingException;

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
	public @ResponseBody NSignInWrapper login(@RequestBody NSignInWrapper pLoginParms) throws UnsupportedEncodingException {		
		NUser nuser = userDao.getUserByName(pLoginParms.getcUser());
		if(nuser==null){
			pLoginParms.setlStatus(false);
			pLoginParms.setcMessage("Unregistered user");
		}else{
			String decodedPass = new String(nuser.getKey(), "UTF-8");
			if(decodedPass.compareTo(pLoginParms.getcPassword())!=0){
				pLoginParms.setlStatus(false);
				pLoginParms.setcMessage("Wrong password for user "+pLoginParms.getcUser());
			}else{
				pLoginParms.setlStatus(true);
			}
		}
		System.out.println("Finish Method NSignInWrapper");
		return pLoginParms;
	}
	@RequestMapping("/")
	public String start(Model model) {
		return "NSignIn";

	}
}