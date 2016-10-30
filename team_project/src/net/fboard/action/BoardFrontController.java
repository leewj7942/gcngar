package net.fboard.action;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoardFrontController extends HttpServlet {
	
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String RequestURI = request.getRequestURI();
		System.out.println(RequestURI);
		
		String contextPath = request.getContextPath();
		System.out.println(contextPath);
		System.out.println(contextPath.length());
		
		String command = RequestURI.substring(contextPath.length());
		System.out.println(command);
		
		ActionForward forward=null;
		Action action=null;
		if(command.equals("/BoardWrite.fbo")){
			forward = new ActionForward();
			forward.setRedirect(false);
			forward.setPath("./board/write.jsp");
		}else if(command.equals("/BoardWriteAction.fbo")){
			action=new BoardWriteAction(); //부모=자식 업캐스팅
			try {
				//부모에서 오버라이딩한  메서드호출
				forward=action.execute(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		if(forward!=null){
			if(forward.isRedirect()){ //true  sendRedirect()
				response.sendRedirect(forward.getPath());
			}else{//false  forward()
				RequestDispatcher dispatcher=request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
		
		
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.http.HttpServlet#doPost(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doProcess(request, response);
	}
	
	

}
