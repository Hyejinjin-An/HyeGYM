package com.hyegym.user;



import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.hyegym.notice.NoticeDTO;
import com.hyegym.notice.NoticeService;
import com.hyegym.notice.PaginationDTO;
import com.hyegym.notice.PagingDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;


//@RestController는 boot에서 html을 사용하게 해주는 것
//하지만 부트에 jsp를 파싱할때는 @Controller로 바꿔줘야한다.
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {

	private Logger log = LogManager.getLogger();
	
	@Autowired
	private UserService userSvc;
	@Autowired
	private NoticeService noticeSvc;
	
	
	@GetMapping("/main")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/main");
		return mav;
	}
	
	@GetMapping("/notice")
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
			log.info("공지사항 조회 완료! " + list.size() + " 건");
			log.info("페이징 객체 확인 " + pagination.toString());
		}catch (Exception e) {
			log.error("select error! " + e.getMessage());
			e.printStackTrace();
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("contents", list);
		mav.addObject("paging", pagination);
		mav.setViewName("user/notice");
		return mav;
	}
	
	@GetMapping("/noticeinfo")
	@ResponseBody
	public ModelAndView noticeinfo(@RequestParam("no") int idx) {
		ModelAndView mav = new ModelAndView();
		NoticeDTO info = noticeSvc.selectNoticeinfo(idx);
		String date = dateFormat(info.getCreateAt());
		mav.addObject("info", info);
		mav.addObject("date", date);
		mav.setViewName("user/noticeinfo");
		return mav;
	}
	
	@GetMapping("/reservation")
	public ModelAndView reservation(HttpServletRequest request, jakarta.servlet.http.HttpSession session) {
		String res = "success";
		Map<String, Object> info = new HashMap<>();
		try {
			if(session.getAttribute("userinfo") == null) {
				res = "fail";
			}else {
				info.put("userinfo", session.getAttribute("userinfo"));
				request.setCharacterEncoding("utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			log.error("UTF-8 설정 중 error 발생!");
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("result", res);
		mav.addObject("userinfo", info);
		mav.setViewName("user/reservation");
		return mav;
	}
	
	@GetMapping("/reservationinfo")
	public ModelAndView reservationinfo(@RequestParam("t") String teacherNum) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("t", teacherNum);
		mav.setViewName("user/reservationinfo");
		return mav;
	}
	
	@PostMapping("/reserveUser")
	@ResponseBody
	public String reserveUser(@RequestBody ReserveUserDTO user, jakarta.servlet.http.HttpSession session) {
		String res = "";
		int result = 0;
		try {
			result = userSvc.insertReserveUser(user);
			if(result == 1) {
				session.setAttribute("reserveUserInfo", user);
				res = "success";
				log.info("insert Reserve UserInfo Success");
			}else {
				res = "fail";
				log.info("insert Reserve UserInfo Fail");
			}
		}catch (Exception e) {
			res = "error";
			log.error("insert error! " + e.getMessage());
		}
		return res;
	}
	
	@GetMapping("/reserveSuccess")
	public ModelAndView reserveSuccess(jakarta.servlet.http.HttpSession session) {
		ReserveUserDTO user = (ReserveUserDTO) session.getAttribute("userinfo");
		ModelAndView mav = new ModelAndView();
		mav.addObject("reserveUserInfo", user);
		mav.setViewName("user/reservation_success");
		return mav;
	}
	
	@GetMapping("/reserveCheck")
	public ModelAndView reserveCheck(jakarta.servlet.http.HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("userinfo");
		ReserveUserDTO checkUser = new ReserveUserDTO();
		
		try {
			checkUser = userSvc.selectReserveUser(user);
		} catch (Exception e) {
			log.error("select error! " + e.getMessage());
		}
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("reserveUserInfo", checkUser);
		mav.setViewName("user/reservation_check");
		return mav;
	}
	
	@PostMapping("/selectReserveUser")
	@ResponseBody
	public String selectReserveUser(jakarta.servlet.http.HttpSession session) {
		UserDTO user = (UserDTO) session.getAttribute("userinfo");
		ReserveUserDTO checkUser = new ReserveUserDTO();
		String res = "fail";
		try {
			if(user != null) {
				checkUser = userSvc.selectReserveUser(user);
				if(checkUser != null) {
					res = "success";
				}
			}
		} catch (Exception e) {
			log.error("select error! " + e.getMessage());
		}

		return res;
	}
	
	@PostMapping("/deleteReservation")
	@ResponseBody
	public int deleteReservation(@RequestBody ReserveUserDTO user) {
		int res = 0;
		try {
			res = userSvc.deleteReservation(user);
			if(res == 1) {
				log.info("delete User Info Success");
			}
		}catch (Exception e) {
			log.error("delete error! " + e.getMessage());
		}
		return res;
	}
	
	@GetMapping("/join")
	public ModelAndView join() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/join");
		return mav;
	}
	
	@PostMapping("/joinUser")
	@ResponseBody
	public int joinUser(@RequestBody UserDTO user) {
		int res = 0;
		try {
			res = userSvc.insertUser(user);
			if(res == 1) {
				log.info("insert User Info Success");
			}
		}catch (Exception e) {
			log.error("insert error! " + e.getMessage());
		}
		return res;
	}
	
	@GetMapping("/joinSuccess")
	public ModelAndView joinSuccess(String id) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.setViewName("user/join_success");
		return mav;
	}
	
	@RequestMapping(value = "/login", method = {RequestMethod.POST, RequestMethod.GET})
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("user/login");
		return mav;
	}
	
	@PostMapping("/loginUser")
	public ModelAndView loginUser(HttpServletRequest request, jakarta.servlet.http.HttpSession session) {
		ModelAndView mav = new ModelAndView();
		RedirectView redirectView = new RedirectView(); // redirect url 설정
		redirectView.setExposeModelAttributes(false);

		UserDTO user = new UserDTO();
		user.setId(request.getParameter("id"));
		user.setPassword(request.getParameter("password"));
		
		try {
			UserDTO userinfo = userSvc.loginCheck(user, session);
			if(userinfo != null && userinfo.getId() != null) {
				log.info("select User Info " + userinfo.toString());
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
