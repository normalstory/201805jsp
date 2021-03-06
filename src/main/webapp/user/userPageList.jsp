<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%

List<UserVo> userList= (List<UserVo>)request.getAttribute("pagelist");
System.out.println(userList.size());

%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>userAllList</title>

<!-- basicLib -->
<%@ include file="/common/basicLib.jsp"%>
<style type="text/css">
	.userClick{
		cursor:pointer;
	}
</style>
<script type="text/javascript">
	function userName(a){
		alert(a);
	}

	$(document).ready(function(){
		console.log("document.ready");
		
		//tr에 select (class="userClick")
		//$(".userClick").click(function(){
		//	console.log("userClick");
		//});
		
		var ec="click"
		$(".userClick").on(ec,function(){
			console.log("userClick");
			
			var userId = $(this).children()[1].innerText;
		
			$("#userId").val(userId);
			//폼태그 지정.submit();
			$("#frm").submit();
		
		});
		
	});	
</script>

</head>

<form id="frm" action="/userDetail" method="get">
	<input type="hidden" id="userId" name="userId">
</form>

<body>

	<!-- header -->
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>

						<div class="table-responsive">

							<table class="table table-striped table-hover">
								<tr>
									<th>번호</th>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>생일</th>
								</tr>

								<!-- userList loop 출력 -->
								<%
								for( UserVo user : userList){
									System.out.println(user);
								%>
								<!-- tr onclick="userName('<%--user.getRnum()%>')"  -->
								<!-- tr onclick="javascript:document.location='/userDetail?userId=<%=user.getUserId()--%>'" -->
								<tr class="userClick" >
									<td><%=user.getRnum()%></td>
									<td><%=user.getUserId()%></td>
									<td><%=user.getName()%></td>
									<td><%=user.getBirth()%></td>
								</tr>
								<% } %>
							</table>
							
						</div>

						<a class="btn btn-default pull-right" href="/userForm">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li>
									<a href="/userPageList?page=1&pageSize=10" aria-label="Previous"> <span
											aria-hidden="true">&laquo;</span>
									</a>
								</li>
								<%
									int pageCnt = (Integer) request.getAttribute("pageCnt");
									for (int p = 1; p <= pageCnt; p++) {
								%>
								<li><a href="/userPageList?page=<%=p%>&pageSize=10"><%=p%></a></li>
								<% } %>
								<li>
									<a href="/userPageList?page=<%=pageCnt%>&pageSize=10" aria-label="Next"> <span
											aria-hidden="true">&raquo;</span>
									</a>
								</li>
							</ul>
						</div>
					</div>
				</div>

			</div>
		</div>
	</div>
</body>
</html>
