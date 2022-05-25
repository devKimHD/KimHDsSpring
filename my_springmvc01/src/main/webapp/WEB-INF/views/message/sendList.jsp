<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/header.jsp"%>
${message2List}
<script>
$(document).ready(function(){
	var tds=$("tr").find(".opendate");
	tds.each(function(index,item){
		var is_exist_date=$(item).attr("data-opendate");
		if(is_exist_date=="false"){
			$(item).parent().attr("class","w3-large");
		}
	});
});
</script>
<div class="row">
		<div class="col-md-12">
			<div class="tabbable" id="tabs-758030">
				<ul class="nav nav-tabs">
					<li class="nav-item">
						<a class="nav-link " href="/message/receive" >받은 쪽지함</a>
					</li>
					<li class="nav-item">
						<a class="nav-link active show" href="/message/send" >보낸 쪽지함</a>
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
							받는 사람
						</th>
						<th>
							읽은 날짜
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${message2List}" var="message2Vo" varStatus="status">
					<tr>
					<td>${status.count}</td>
					<td>${message2Vo.message}</td>
					<td>${message2Vo.sender}</td>
					<td class="opendate" data-opendate=
					<c:if test="${empty message2Vo.opendate}">
					false
					</c:if>
					>
					<c:choose>
					<c:when test="${empty message2Vo.opendate}">
					읽지 않음
					</c:when>
					<c:otherwise>
					${message2Vo.senddate}
					</c:otherwise>
					</c:choose>
					</td>
						
					</tr>
				</c:forEach>	
				</tbody>
			</table>
		</div>
	</div>

<%@ include file="/WEB-INF/views/include/footer.jsp"%>