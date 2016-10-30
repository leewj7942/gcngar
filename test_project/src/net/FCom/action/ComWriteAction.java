package net.FCom.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.FCom.db.FComBean;
import net.FCom.db.FComDAO;

public class ComWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("ComWriteAction execute()");
		
		request.setCharacterEncoding("utf-8");
		
		FComBean cb = new FComBean();
		
		cb.setName(request.getParameter("name"));
		cb.setPass(request.getParameter("pass"));
		cb.setContent(request.getParameter("content"));
		
		FComDAO fcdao = new FComDAO();
		fcdao.insertCom(cb);
		
		ActionForward forward = new ActionForward();
		
		forward.setRedirect(true);
		forward.setPath("./ComList.fco");
		return forward;
	}

}
