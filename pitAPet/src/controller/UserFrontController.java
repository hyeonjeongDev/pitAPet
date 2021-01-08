package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.UserDeleteAction;
import action.UserJoinAction;
import action.UserListAction;
import action.UserLoginAction;
import action.UserLogoutAction;
import action.UserViewAction;
import vo.ActionForward;

@WebServlet("*.do")
public class UserFrontController extends javax.servlet.http.HttpServlet
{
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProc(request, response);
	}
	
	protected void doProc(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String RequestURI=request.getRequestURI();
		String contextPath=request.getContextPath();
		String command=RequestURI.substring(contextPath.length());
		ActionForward forward=null;
		Action action=null;
		
		if(command.equals("/userLogin.do")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./login.jsp");
		} else if(command.equals("/userJoin.do")) {
			forward=new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./join.jsp");
		} else if(command.equals("/userLoginAction.do")) {
			action = new UserLoginAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/userJoinAction.do")) {
			action = new UserJoinAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/userListAction.do")) {
			action = new UserListAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/userViewAction.do")) {
			action = new UserViewAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/userDeleteAction.do")) {
			action = new UserDeleteAction();
			try {
				forward=action.execute(request, response);
			} catch(Exception e) {
				e.printStackTrace();
			}
		} else if(command.equals("/userLogout.do")){
			action = new UserLogoutAction();
			try {
				forward =  action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(forward != null) {
			if(forward.isRedirect()) {
				response.sendRedirect(forward.getPath());
			} else {
				RequestDispatcher dispatcher=
					request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
}