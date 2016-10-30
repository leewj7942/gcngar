<%@page import="net.FBoard.db.FBoardBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link href="../bootstrap/css/bootstrap.css" rel="stylesheet"
	type="text/css" />
<!-- jQuery (부트스트랩의 자바스크립트 플러그인을 위해 필요한) -->
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
</head>
<body>
	<%
		// request.setAttribute("fb", fb);
		FBoardBean fb = (FBoardBean) request.getAttribute("fb");
		//request.setAttribute("pageNum", pageNum);
		String pageNum = (String) request.getAttribute("pageNum");
		
		
	%>
	<h1>board/content.jsp</h1>
	<table border="1">
		<tr>
			<td>글번호</td>
			<td>
				<%-- <%=fb.getNum() %> --%>2
			</td>
			<td>조회수</td>
			<td>
				<%-- <%=fb.getReadcount() %> --%>0
			</td>
		</tr>
		<tr>
			<td>작성자</td>
			<td>
				<%-- <%=fb.getName() %> --%>관리자
			</td>
			<td>작성일</td>
			<td>
				<%-- <%=fb.getDate() %> --%>2016-10-30
			</td>
		</tr>
		<tr>
			<td>글제목</td>
			<td colspan="3">
				<%-- <%=fb.getSubject() %> --%>테스트
			</td>
		</tr>
		<tr>
			<td>첨부파일</td>
			<td colspan="3">
				<%-- <%
if(fb.getFile()!=null){
	%><a href="../upload/<%=fb.getFile()%>"><%=fb.getFile()%></a>
	 <img src="../upload/<%=fb.getFile()%>" width="20" height="20"><%
}
%> --%>테스프.png
			</td>
		</tr>
		<tr>
			<td>글내용</td>
			<td colspan="3">
				<%-- <%=fb.getContent() %> --%>테스트
			</td>
		</tr>
		<tr>
			<td colspan="4"><input type="button" value="글수정"
				onclick="<%-- location.href='./FBoardUpdate.fbo?num=<%=fb.getNum()%>&pageNum=<%=pageNum%>' --%>">
				<input type="button" value="글삭제"
				onclick="<%-- location.href='./FBoardDelete.fbo?num=<%=fb.getNum()%>&pageNum=<%=pageNum%>' --%>">
				<input type="button" value="글목록"
				onclick="<%-- location.href='./FBoardList.fbo?pageNum=<%=pageNum%>' --%>"></td>
		</tr>
		
	</table>
	<div>
	<%
	
	%>
	</div>
	<form action="content_board.jsp" method="post">
	<table >
		<tr>
			<td colspan="4"><input type="text" id="commentParentName"
				name="commentParentName" data-rule-required="true" placeholder="이름" maxlength="10">
			<input type="password" id="commentParentPassword"
				name="commentParentPassword" data-rule-required="true" placeholder="패스워드" maxlength="10">
			<input type="button" value="확인" >
			</td>
			</tr>
			<tr>
			<td colspan="4">
			<textarea rows="4" id="commentParentText" style="width: 388px;"></textarea>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>




