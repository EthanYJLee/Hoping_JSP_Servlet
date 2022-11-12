package com.bootcamp.homecontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bootcamp.host.command.AskCommentCommand;
import com.bootcamp.host.command.BCCommand;
import com.bootcamp.host.command.CampingAddCommand;
import com.bootcamp.host.command.CampingAddFaCommand;
import com.bootcamp.host.command.CampingAddKeyCommand;
import com.bootcamp.host.command.HImageCommand;
import com.bootcamp.host.command.HInfoCommand;
import com.bootcamp.host.command.HInfoInsertCommand;
import com.bootcamp.host.command.HmyInfoCommand;
import com.bootcamp.host.command.HmyInfoModifyCommand;
import com.bootcamp.host.command.HostBookListCommand;
import com.bootcamp.host.command.HostBookTotalPagingCommand;
import com.bootcamp.host.command.HostCampNameList_Command;
import com.bootcamp.host.command.HostCampProfileList_Command;
import com.bootcamp.host.command.HostInfoFaInDelCommand;
import com.bootcamp.host.command.HostInfoFaSelectCommand;
import com.bootcamp.host.command.HostInfoImages1UpCommand;
import com.bootcamp.host.command.HostInfoImages2UpCommand;
import com.bootcamp.host.command.HostInfoImages3UpCommand;
import com.bootcamp.host.command.HostInfoImagesSelectCommand;
import com.bootcamp.host.command.HostInfoKeyInDelCommand;
import com.bootcamp.host.command.HostInfoKeySelectCommand;
import com.bootcamp.host.command.HostInfoLMoCommand;
import com.bootcamp.host.command.HostInfoLSelectCommand;
import com.bootcamp.host.command.HostInfoMRMSelectCommand;
import com.bootcamp.host.command.HostInfoMRMUpdateCommand;
import com.bootcamp.host.command.HostInfoNCTMoCommand;
import com.bootcamp.host.command.HostInfoNCTSelectCommand;
import com.bootcamp.host.command.HostInfoRoomDelCommand;
import com.bootcamp.host.command.HostInfoRoomInCommand;
import com.bootcamp.host.command.HostInfoRoomSelectCommand;
import com.bootcamp.host.command.HostMainInquiryStatus_Command;
import com.bootcamp.host.command.HostMainReservationStatus_Command;
import com.bootcamp.host.command.HostMainReviewStatus_Command;
import com.bootcamp.host.command.HostMonthlyProfit_Command;
import com.bootcamp.host.command.HostMonthlyReservation_Command;
import com.bootcamp.host.command.HostReviewContentView_Command;
import com.bootcamp.host.command.HostReviewList_Command;
import com.bootcamp.host.command.HostSendReviewReply_Command;
import com.bootcamp.host.command.HostTermsADCommand;
import com.bootcamp.host.command.MyHostBookDetailCommand;
import com.bootcamp.host.command.RegCampCommand;
import com.bootcamp.host.command.askDetailCommand;
import com.bootcamp.host.command.askListCommand;
import com.bootcamp.host.dao.HostCheckDao;

/**
 * Servlet implementation class homeController
 */
@WebServlet("*.do")
public class BCFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public BCFrontController() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}

	private void actionDo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");

		String viewPage = null;
		BCCommand command = null;

		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());

		switch (com) {

		// --------------------주현: 약관동의 후 호스트 가입(호스트 정보 insert)--------------------

		// 약관보여주기
		case ("/term.do"):
			viewPage = "HostTerms.jsp";
			break;
		// 약관 동의/비동의
		case ("/termsAD.do"):
			command = new HostTermsADCommand();
			Boolean check = command.execute1(request, response);

			if (check == true) {
				viewPage = "TermsAgree.jsp";

			} else {
				// 나중에 클라이언트랑 연결되면 client 메인페이지로 이동
				viewPage = "list.jsp";

			}

			break;
		// 호스트 가입 (client 정보 >> host 테이블에 insert)
		case ("/show.do"):
			command = new HInfoCommand();
			command.execute(request, response);
			viewPage = "hostJoin.jsp";
			break;

		// 호스트에 인서트
		case ("/insert.do"):
			command = new HInfoInsertCommand();
			command.execute(request, response);
			viewPage = "uploadImage.jsp";
			break;
		// 호스트 이미지 넣기
		case ("/fileUp.do"):
			command = new HImageCommand();
			command.execute(request, response);
			viewPage = "fileShow.jsp";
			break;

		// ——————————주현: 마이페이지 정보 수정(호스트 정보 update)——————————

		// 마이페이지 내정보 불러오기
		case ("/myPage.do"):
			command = new HmyInfoCommand();
			command.execute(request, response);
			viewPage = "HostmyPage.jsp";
			break;
		// 마이페이지 내정보 수정
		case ("/modify.do"):
			command = new HmyInfoModifyCommand();
			command.execute(request, response);
			command = new HmyInfoCommand();
			command.execute(request, response);
			viewPage = "HostmyPage.jsp";
			break;

		// ---------------------상준 : 캠핑장 등록 -----------------------------------

		case ("/regcamp.do"):
			System.out.println("Controller regcamp.do");
			command = new RegCampCommand();
			command.execute(request, response);
			// 자리 지정 페이지로 가야되지만 아직 완성물이 없어서 우선 메인페이지로 이동
			viewPage = "HostMain.jsp";
			break;

		// ---------------------영진: 메인페이지 -----------------------------------

		case ("/host_main.do"):
			command = new HostCampProfileList_Command(); // 호스트 소유 모든 캠핑장의 이름, 사진, 주소 (썸네일용)
			command.execute(request, response);
			command = new HostMonthlyProfit_Command(); // 월별 총수익 차트에 표시 (올해분)
			command.execute(request, response);
			command = new HostMonthlyReservation_Command(); // 월별 총예약건수 차트에 표시 (올해분)
			command.execute(request, response);
			command = new HostMainReservationStatus_Command(); // 오늘의 신규 예약건수, 올해 체크인/체크아웃 예정건수
			command.execute(request, response);
			command = new HostMainInquiryStatus_Command();
			command.execute(request, response);
			command = new HostMainReviewStatus_Command();
			command.execute(request, response);
			viewPage = "HostMain.jsp";
			break;

		case ("/host_review_list.do"):
			command = new HostReviewList_Command(); // 호스트 소유 캠핑장에 달린 리뷰의 리스트
			command.execute(request, response);

			command = new HostCampNameList_Command(); // 호스트 소유 캠핑장 이름 리스트 (검색을 위한 콤보박스용)
			command.execute(request, response);

			viewPage = "HostReviewList.jsp";
			break;

		case ("/host_review_content_view.do"):
			command = new HostReviewContentView_Command(); // 리뷰 정보 (작성자, 제목, 내용 등등) 받아오기
			command.execute(request, response);
			viewPage = "HostReviewContentView.jsp";
			break;

		case ("/send_review_reply.do"):
			command = new HostSendReviewReply_Command(); // 호스트가 후기에 작성한 답글 insert하고 댓글 그룹 업데이트
			command.execute(request, response);
			viewPage = "/host_review_list.do";
			break;

		case ("/host_login.do"): // 호스트용 로그인 화면 (임시용임!!!)
			viewPage = "HostLogin.jsp";
			break;

		case ("/host_check.do"):
			String cId = request.getParameter("cId");
			String cPw = request.getParameter("cPw");
			String hId = null;
			HostCheckDao dao = new HostCheckDao();
			int hSeq = dao.checkHostLogin(cId, cPw);
			if (hSeq != 0) {
				hId = cId;
				HttpSession session = request.getSession();
				session.setAttribute("hId", hId);
				session.setAttribute("hSeq", hSeq);
				viewPage = "host_main.do";
			} else {
				viewPage = "HostError.jsp";
			}
			break;

		// --------------------------호스트 마이페이지에 정보 불러오기--------------------------

		// --------------------------주현 : 고객문의 리스트 페이지--------------------------
		case ("/askList.do"):
			command = new askListCommand();
			command.execute(request, response);
			viewPage = "askList.jsp";
			break;
		case ("/askDetail.do"):
			command = new askDetailCommand();
			command.execute(request, response);
			viewPage = "AskDetail.jsp";
			break;
		case ("/aComment.do"):
			command = new AskCommentCommand();
			command.execute(request, response);
			viewPage = "AskDetail.jsp";
			break;

		// ------------예진 : 예약 리스트 페이지 ------------------------------------
		// 예약 리스트 페이지 열기
		case ("/bookList.do"):
			command = new HostBookTotalPagingCommand();
			command.execute(request, response);
			viewPage = "bookList2.do?page=1";
			break;

		// 예약 리스트 페이지 열기
		case ("/bookList2.do"):
			command = new HostBookListCommand();
			command.execute(request, response);
			viewPage = "HostTotalBookManage.jsp";
			break;

		// 예약 리스트 테이블에서 row 클릭시 디테일 페이지
		case ("/YJHostBookDetail.do"):
			command = new MyHostBookDetailCommand();
			command.execute(request, response);
			viewPage = "YJHostBookDetail.jsp";
			break;

		// ------------예진 : 캠핑장 추가 페이지 ------------------------------------

		// 이름, 설명, 카테고리 등록
		case ("/campingAddLo.do"):
			command = new CampingAddCommand();
			command.execute(request, response);
			viewPage = "CapmingAddFa.jsp";
			break;

		// 편의시설 등록
		case ("/campingAddFa.do"):
			command = new CampingAddFaCommand();
			command.execute(request, response);
			viewPage = "CapmingAddKey.jsp";
			break;

		// 키워드 등록
		case ("/campingAddKey.do"):
			command = new CampingAddKeyCommand();
			command.execute(request, response);
			viewPage = "CampingAddKeyFa.jsp";
			break;

		// ------------예진 : 캠핑장 정보수정 페이지 ------------------------------------

		// 정보 수정 메인페이지 열기
		case ("/HostRInfo.do"):
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지 -> 위치, 설명 수정 페이지
		case ("/HostInfoMLoView.do"):
			command = new HostInfoLSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMLo.jsp";
			break;

		// 위치, 설명 수정
		case ("/HostInfoMLo.do"):
			command = new HostInfoLMoCommand();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지 -> 이름, 카테고리, 전화번호 수정 페이지
		case ("/HostInfoMNCTView.do"):
			command = new HostInfoNCTSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMNameCategoryTel.jsp";
			break;

		// 이름, 카테고리, 전화번호 수정
		case ("/HostInfoMNCT.do"):
			command = new HostInfoNCTMoCommand();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지 -> 키워드 수정 페이지
		case ("/HostInfoKeyView.do"):
			command = new HostInfoKeySelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMKeyword.jsp";
			break;

		// 키워드 삭제와 인서트
		case ("/HostInfoKeyInDel.do"):
			command = new HostInfoKeyInDelCommand();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지 -> 편의시설 수정 페이지로
		case ("/HostInfoFaciView.do"):
			command = new HostInfoFaSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMFacility.jsp";
			break;

		// 편의시설 삭제와 인서트
		case ("/HostInfoFaInDel.do"):
			command = new HostInfoFaInDelCommand();
			command.execute(request, response);
			viewPage = "HostInfoMMain.jsp";
			break;

		// 정보 수정 메인페이지 -> 자리 수정 페이지
		case ("/HostInfoRoomView.do"):
			command = new HostInfoRoomSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMRoom.jsp";
			break;

		// 자리 인서트
		case ("/HostInfoRoomIn.do"):
			command = new HostInfoRoomInCommand();
			command.execute(request, response);
			viewPage = "HostInfoRoomView.do";
			break;

		// 자리 delete
		case ("/HostInfoRoomDel.do"):
			command = new HostInfoRoomDelCommand();
			command.execute(request, response);
			viewPage = "HostInfoRoomView.do";
			break;

		// 정보 수정 메인페이지 -> 약도 수정 페이지
		case ("/HostInfoRoughView.do"):
			command = new HostInfoMRMSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMRoughMap.jsp";
			break;

		// 약도 이미지 업데이트
		case ("/roughMapUp.do"):
			command = new HostInfoMRMUpdateCommand();
			command.execute(request, response);
			viewPage = "HostInfoRoughView.do";
			break;

		// 정보 수정 메인페이지 -> 이미지 수정 페이지
		case ("/HostInfoImagesView.do"):
			command = new HostInfoImagesSelectCommand();
			command.execute(request, response);
			viewPage = "HostInfoMImages.jsp";
			break;

		// 캠핑장 이미지1 업데이트
		case ("/image1Up.do"):
			command = new HostInfoImages1UpCommand();
			command.execute(request, response);
			viewPage = "HostInfoImagesView.do";
			break;

		// 캠핑장 이미지2 업데이트
		case ("/image2Up.do"):
			command = new HostInfoImages2UpCommand();
			command.execute(request, response);
			viewPage = "HostInfoImagesView.do";
			break;

		// 캠핑장 이미지3 업데이트
		case ("/image3Up.do"):
			command = new HostInfoImages3UpCommand();
			command.execute(request, response);
			viewPage = "HostInfoImagesView.do";
			break;

		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
	}
}
