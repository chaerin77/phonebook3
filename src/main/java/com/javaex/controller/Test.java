package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board") //공통된 주소 빼기
public class Test {
	
	//필드
	
	//생성자
	
	//메소드g/s
	
	//메소드 일반
	/*
	@RequestMapping("/test")
	public String Testprint() {
		System.out.println("Testprint");
		
		return "/WEB-INF/views/Test.jsp";  //포워드 할 파일의 위치
	}*/
	
	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})  //주소 get방식 /post 방식 할지 써줘야함
	public String Testprint() {
		System.out.println("Testprint");
		
		return "/WEB-INF/views/Test.jsp";  //포워드 할 파일의 위치
	}
	
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String Testprint2() {
		System.out.println("Testprint2");
		
		return "/WEB-INF/views/Test.jsp";
	}
	
	
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String Testprint3() {
		System.out.println("Testprint3");
		
		return "/WEB-INF/views/Test.jsp";
	}

}
