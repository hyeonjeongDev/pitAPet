package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import vo.ActionForward;
import action.Action;
import action.ProdCartAddAction;
import action.ProdCartListAction;
import action.ProdCartQtyDownAction;
import action.ProdCartQtyUpAction;
import action.ProdCartRemoveAction;
import action.ProdDeleteAction;
import action.ProdListAction;
import action.ProdItemListAction;
import action.ProdMainAction;
import action.ProdRegistAction;
import action.ProdViewAction;

@WebServlet("*.prod")

public class ProdFrontController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");	//1.요청파악
		String requestURI = request.getRequestURI();	//요청URL:http://localhost:8088/boardProject/boardWriteFrom.bo
		//requestURI:/boardProject/boardWriteForm.bo반환
		
		String contextPath = request.getContextPath();	// /boardProject 반환
		
		String command = requestURI.substring(contextPath.length());
		Action action = null;
		ActionForward forward = null;
		
		//2.각 요청별로 비즈니스 로직 호출
		if(command.equals("/prodList.prod")) {
			action = new ProdListAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodItemList.prod")) {
			action = new ProdItemListAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodMain.prod")) {
			action = new ProdMainAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodView.prod")) {
			action = new ProdViewAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		}  else if(command.equals("/prodDelete.prod")) {
			action = new ProdDeleteAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodCartAdd.prod")) {
			action = new ProdCartAddAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodCartList.prod")) {
			action = new ProdCartListAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodCartRemove.prod")) {
			action = new ProdCartRemoveAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodCartQtyUp.prod")) {
			action = new ProdCartQtyUpAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodCartQtyDown.prod")) {
			action = new ProdCartQtyDownAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodRegist.prod")) {
			action = new ProdRegistAction();
			//프로젝트명 + 기능 + 형태(?)
			try {
				forward = action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/prodRegistForm.prod")) {
			forward = new ActionForward();
			forward.setPath("./prod_regist.jsp");
		} 
		//3.포워딩
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}