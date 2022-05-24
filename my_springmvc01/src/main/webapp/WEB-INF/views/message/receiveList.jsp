<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
${message2List}

<div class="row">
		<div class="col-md-12">
			<div class="tabbable" id="tabs-758030">
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<a class="nav-link active" href="#" >받은 쪽지함</a>
					</li>
					<li class="nav-item">
						<a class="nav-link show" href="/message/send" >보낸 쪽지함</a>
					</li>
				</ul>
				
			</div>
			<table class="table">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							내용
						</th>
						<th>
							보낸 사람
						</th>
						<th>
							보낸 날짜
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${message2List}" var="message2Vo" varStatus="status">
					<tr>
					<td>${status.count}</td>
					<td>${message2Vo.message}</td>
					<td>${message2Vo.sender}</td>
					<td>${message2Vo.senddate}</td>
						
					</tr>
				</c:forEach>	
				</tbody>
			</table>
		</div>
	</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>