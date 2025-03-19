package com.oneyo.spring.myref.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneyo.spring.member.service.MemberService;


public class MypageController {
	@Autowired
	private MemberService mService;

}
