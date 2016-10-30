package net.fboard.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import net.fboard.db.FBoardBean;
import net.fboard.db.FBoradDAO;

public class BoardWriteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		System.out.println("BoardWriteAction execute()");
		
		request.setCharacterEncoding("utf-8");
		
		String realpath=request.getRealPath("/upload");
		System.out.println(realpath);
		
		int maxSize=5*1024*1024; //5M
		
		MultipartRequest multi= new MultipartRequest(request,realpath,maxSize,"utf-8",new DefaultFileRenamePolicy());

		
		FBoardBean fb = new FBoardBean();
		
		fb.setName(request.getParameter("name"));
		fb.setPass(request.getParameter("pass"));
		fb.setSubject(request.getParameter("subject"));
		fb.setContent(request.getParameter("content"));
		// set메서드호출  ip  request.getRemoteAddr()
		fb.setIp(request.getRemoteAddr());
		fb.setFile(multi.getFilesystemName("file"));
		//디비작업 객체 생성BoardDAO  bdao
		FBoradDAO fdao = new FBoradDAO();
		// 메서드호출  insertBoard(fb)
		fdao.insertBoard(fb);
		
		//이동    ActionForward객체생성  forward
		ActionForward forward=new ActionForward();
		// true/false ?   ./BoardList.bo
		forward.setRedirect(true);
		forward.setPath("./BoardList.fbo");
		return forward;
	}

}
