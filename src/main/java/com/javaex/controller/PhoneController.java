package com.javaex.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.dao.PhoneDao;
import com.javaex.vo.PersonVo;

@Controller
@RequestMapping(value="/phone")
public class PhoneController {

	//필드
	
	//생성자
	
	//메소드 g/s
	
	//메소드 일반
	// /phone/writeForm
	@RequestMapping(value="/writeForm", method= {RequestMethod.GET, RequestMethod.POST})//주소 미리 준비
	public String writeForm() {
		System.out.println("PhoneController>writeForm()");
		
		
		return "/WEB-INF/views/writeForm.jsp";
	}

	
	//ds에서 파라미터 값을 꺼내 정보를 담은 주소와 같은 이름을 써주면됨
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo) {
		System.out.println("PhoneController>write()");
		
		//PersonVo personVo = new PersonVo(name, hp, company);
		//personVo.setName()
		//System.out.println(personVo);
		
		//저장 
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo);
		
		return "redirect:/phone/list";
	}
	
	/*섞어쓰기 가능
	@RequestMapping(value="/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@ModelAttribute PersonVo personVo,
				        @RequestParam("company") String company) {
		
		System.out.println("PhoneController>write()");
		
		System.out.println(personVo);
		System.out.println(company);
		
		//저장
		return "";
	}*/
	
	/*
	@RequestMapping(value="/phone/write", method= {RequestMethod.GET, RequestMethod.POST})
	public String write(@RequestParam("name") String name,
						@RequestParam("hp") String hp, 
						@RequestParam("company") String company) {
		System.out.println("PhoneController>write()");
		
		System.out.println(name);
		System.out.println(hp);
		System.out.println(company);
		
		PersonVo personVo = new PersonVo(name, hp, company);
		//회원가입 한다고하면 정보가 3개뿐일리 없음 20개정도 되면 일일히 노가다 해야할판임
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personInsert(personVo); 
		
		//드라이버 로딩 실패 -> jdbc jar 안넣어서 그런건데 그거 다운받게끔해야함 pom.xml에 jdbc관련 코드를 넣어야함
		
		
		return "";
	}*/
	
	
	/////요청하면 list   주소창에 list 치면

	@RequestMapping(value="/list", method= {RequestMethod.GET, RequestMethod.POST})
	public String list(Model model) {
		System.out.println("PhoneController>list()");
		
		//다오에서 리스트를 가져온다
		PhoneDao phoneDao = new PhoneDao();
		List<PersonVo> personList = phoneDao.getPersonList();
		System.out.println(personList.toString());

		//컨트롤러가 DS한테 데이터를 보내야 함.(model)
		model.addAttribute("personList", personList);  //"" 안이 별명
		
		//jsp정보를 리턴한다(view)
		return "/WEB-INF/views/list.jsp";
	}
	
	
	//phonebook 수정, 삭제 만들기

	//수정폼
	@RequestMapping(value="/updateForm", method= {RequestMethod.GET, RequestMethod.POST})
	public String updateForm(Model model, @RequestParam("no") int no) { //콤마!
		
		PhoneDao pDao = new PhoneDao();
		PersonVo pvo = pDao.getPerson(no);
		
		model.addAttribute("pVo", pvo);
		
		return "/WEB-INF/views/updateForm.jsp";
	}
	
	//수정
	@RequestMapping(value="/update", method= {RequestMethod.GET, RequestMethod.POST})
	public String update(@ModelAttribute PersonVo personVo) {
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personUpdate(personVo);
		
		return "redirect:/phone/list";
	}
	
	
	
	//삭제
	@RequestMapping(value="/delete", method= {RequestMethod.GET, RequestMethod.POST})
	public String delete(@RequestParam("no") int no) {
		System.out.println(no);
		
		PhoneDao phoneDao = new PhoneDao();
		phoneDao.personDelete(no);
		
		return "redirect:/phone/list";
	}
	
}
