package com.hyegym.admin;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hyegym.notice.NoticeDTO;
import com.hyegym.notice.NoticeService;
import com.hyegym.notice.PaginationDTO;
import com.hyegym.user.ReserveUserDTO;
import com.hyegym.user.UserDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


//@RestController는 boot에서 html을 사용하게 해주는 것
//하지만 부트에 jsp를 파싱할때는 @Controller로 바꿔줘야한다.
@Slf4j
@Controller
@RequestMapping("/admin")
public class AdminController {

	private Logger log = LogManager.getLogger();
	
	@Autowired 
	private AdminService adminSvc;
	@Autowired
	private NoticeService noticeSvc;
	
	
	@GetMapping("/main")
	public ModelAndView main() throws Exception {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/main");
		return mav;
	}

	@GetMapping("/adminUserList")
	public ModelAndView userList(@RequestParam(required = false, defaultValue = "1") int page, 
								@RequestParam(required = false, defaultValue = "1") int range) throws Exception {
		List<AdminDTO> list = null;
		
		// 전체 게시글 갯수 조회
		int listTotalCnt = adminSvc.selectUserTotalCount();
		
		// 페이지 처리를 위한 객체 생성
		PaginationDTO pagination = new PaginationDTO();
		pagination.pageInfo(page, range, listTotalCnt);
		
		try {
			list = adminSvc.selectLimitUserList(pagination);

			log.info("회원정보 조회 완료! " + list.size() + " 건");
			log.info("페이징 객체 확인 " + pagination.toString());
		}catch (Exception e) {
			log.error("select error! " + e.getMessage());
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList", list);
		mav.addObject("paging", pagination);
		mav.setViewName("admin/adminUserList");
		return mav;
	}
	
	@GetMapping("/adminReserveList")
	public ModelAndView workoutinfo(@RequestParam(required = false, defaultValue = "1") int page, 
									@RequestParam(required = false, defaultValue = "1") int range) throws Exception {
		List<ReserveUserDTO> userinfo = null;
		
		// 전체 예약정보 조회
		int reserve = adminSvc.selectReserveTotalCount();
		
		// 페이지 처리를 위한 객체 생성
		PaginationDTO pagination = new PaginationDTO();
		pagination.pageInfo(page, range, reserve);
		try {
			userinfo = adminSvc.selectLimitReserveUserList(pagination);			
		}catch (Exception e) {
			log.error("select error! " + e.getMessage());
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("userList",userinfo);
		mav.addObject("paging", pagination);
		mav.setViewName("admin/adminReserveList");
		return mav;
	}
	
	@PostMapping("/select")
	public List<AdminDTO> selectUserList() throws Exception {
		List<AdminDTO> userList = null;
		try {
			userList = adminSvc.selectUserList();
			log.info("회원 정보 조회 완료! " + userList.size() + " 건");
		}catch (Exception e) {
			log.error("select error! " + e.getMessage());
			e.printStackTrace();
		}
		
		return userList;
	}
	
	@GetMapping("/adminNotice")
	public ModelAndView notice(@RequestParam(required = false, defaultValue = "1") int page, 
								@RequestParam(required = false, defaultValue = "1") int range) {
		List<NoticeDTO> list = null;
		// 전체 게시글 갯수 조회
		int listTotalCnt = noticeSvc.selectContentsTotalCount();
		
		// 페이지 처리를 위한 객체 생성
		PaginationDTO pagination = new PaginationDTO();
		pagination.pageInfo(page, range, listTotalCnt);
		
		try {
			list = noticeSvc.selectNoticeList(pagination);
			for(int i = 0; i < list.size(); i++) {
				// 날짜 포맷 변경
				NoticeDTO param = list.get(i);
				param.setCreateAtStr(dateFormat(param.getCreateAt()));
				list.set(i, param);
			}
			log.info("공지사항 조회 완료! " + listTotalCnt + " 건");
			log.info("페이징 객체 확인 " + pagination.toString());
		}catch (Exception e) {
			log.error("select error! " + e.getMessage());
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("contents", list);
		mav.addObject("paging", pagination);
		mav.setViewName("admin/adminNotice");
		return mav;
	}
	
	@GetMapping("/adminNoticeinfo")
	@ResponseBody
	public ModelAndView adminNoticeinfo(@RequestParam("no") int num) {
		ModelAndView mav = new ModelAndView();
		NoticeDTO info = noticeSvc.selectNoticeinfo(num);
		String date = dateFormat(info.getCreateAt());
		mav.addObject("info", info);
		mav.addObject("date", date);
		mav.setViewName("admin/adminNoticeinfo");
		return mav;
	}
	
	@GetMapping("/adminNoticeNew")
	public ModelAndView noticeNew() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/adminNoticeNew");
		return mav;
	}
	
	@PostMapping("/insertNotice")
	@ResponseBody
	public String insertNotice(@RequestBody NoticeDTO param) {
		String res = "";
		int newContents = 0;
		
		try {
			newContents = noticeSvc.insertNotice(param);
			if(newContents != 0) {
				log.info("공지사항 등록 완료!");
				res = "1";
			}else {
				log.info("공지사항 등록 실패");
				res = "fail";
			}
		}catch (Exception e) {
			log.error("insert error! " + e.getMessage());
			e.printStackTrace();
		}
		return res;
	}
	
	@GetMapping("/noticeinfo")
	@ResponseBody
	public ModelAndView noticeinfo(@RequestParam("idx") int index) {
		ModelAndView mav = new ModelAndView();
		NoticeDTO info = noticeSvc.selectNoticeinfo(index);
		String date = dateFormat(info.getCreateAt());
		mav.addObject("info", info);
		mav.addObject("date", date);
		mav.setViewName("admin/adminNoticeinfo");
		return mav;
	}
	
	@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/login");
		return mav;
	}
	
	@PostMapping("/loginAdmin")
	public ModelAndView loginAdmin(HttpServletRequest request, jakarta.servlet.http.HttpSession session) {
		ModelAndView mav = new ModelAndView();
		RedirectView redirectView = new RedirectView(); // redirect url 설정
		redirectView.setExposeModelAttributes(false);

		AdminDTO user = new AdminDTO();
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		
		try {
			AdminDTO userinfo = adminSvc.loginCheck(user, session);
			if(userinfo != null && userinfo.getId() != null) {
				log.info("select Admin Info " + userinfo.toString());
				redirectView.setUrl("main");
				mav.setView(redirectView);
			}else {
				session.setAttribute("result", "fail");
				redirectView.setUrl("login");
				mav.setView(redirectView);
			}
		}catch (Exception e) {
			log.error("select error! " + e.getMessage());
			session.setAttribute("result", "error");
			redirectView.setUrl("login");
			mav.setView(redirectView);
		}
		return mav;
	}
	
	@PostMapping("/logout")
	@ResponseBody
	public String logout(HttpServletRequest request) {
		log.info("로그아웃 시도 . . .");
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		log.info("로그아웃 성공 ! ");
		String result = "success";
		
		return result;
	}
	
	protected String dateFormat(Date date) {
		SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");
		String result = transFormat.format(date);
		return result;
	}
	
}
