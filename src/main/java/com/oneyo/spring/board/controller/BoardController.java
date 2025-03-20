package com.oneyo.spring.board.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.oneyo.spring.member.service.MemberService;


public class BoardController {
	@Autowired
	private MemberService mService;

}
