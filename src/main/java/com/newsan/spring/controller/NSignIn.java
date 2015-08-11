package com.newsan.spring.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newsan.spring.vo.NSignInWrapper;

@Controller
@RequestMapping(value="/login")
public class NSignIn {
	@RequestMapping(value = "requestLogin", method = RequestMethod.POST)	
	public @ResponseBody NSignInWrapper login(@RequestBody NSignInWrapper pLoginParms) {
		pLoginParms.setlStatus(true);
		return pLoginParms;
	}
}