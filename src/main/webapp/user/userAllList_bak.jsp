<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

		
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
</head>

<body>

	<!-- header -->
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<!-- left -->
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">

					<div class="col-sm-3 col-md-2 sidebar">
						<ul class="nav nav-sidebar">
							<li class="active"><a href="#">Main <span
									class="sr-only">(current)</span></a></li>
							<li class="active"><a href="#">사용자</a></li>
						</ul>
					</div>
					
					<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
						<div class="row">
							<div class="col-sm-8 blog-main">
								<h2 class="sub-header">사용자</h2>
								
								<div class="table-responsive">
								
									<table class="table table-striped">
										<tr>
											<th>번호</th>
											<th>사용자 아이디</th>
											<th>사용자 이름</th>
											<th>생일</th>
										</tr>
										
										<!-- userList loop 출력 -->
										<%
										List<UserVo> userList= (List<UserVo>)request.getAttribute("userList");
										System.out.println(userList.size());
										
										for(int i=0; i<userList.size(); i++){
											//UserVo userVo = new UserVo();
										%>
										<tr>
											<td><%=i+1%></td>
											<td><%=userList.get(i).getUserId()%></td>
											<td><%=userList.get(i).getName()%></td>
											<td><%=userList.get(i).getBirth()%></td>
										</tr>
										<% } %>
									</table>
								</div>

								<a class="btn btn-default pull-right">사용자 등록</a>

								<div class="text-center">
									<ul class="pagination">
										<li><a href="#">1</a></li>
										<li><a href="#">2</a></li>
										<li><a href="#">3</a></li>
										<li><a href="#">4</a></li>
										<li><a href="#">5</a></li>
									</ul>
								</div>
							</div>
						</div>

					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
