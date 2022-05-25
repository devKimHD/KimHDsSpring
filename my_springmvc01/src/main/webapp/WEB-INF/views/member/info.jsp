<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<div class="row">
		<div class="col-md-12">
			<table class="table">
				<tbody>
					<tr>
						<th>
							아이디
						</th>
						<td>
							${member2Vo.memberid }
						</td>
					</tr>
					
					<tr>
						<th>
							이름
						</th>
						<td>
							${member2Vo.membername }
						</td>
					</tr>
					
					<tr>
						<th>
							이메일
						</th>
						<td>
							${member2Vo.email }
						</td>
					</tr>
					
					<tr>
						<th>
							포인트
						</th>
						<td>
							${member2Vo.m_point }
						</td>
					</tr>
				</tbody>
				
			</table>
		</div>
	</div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>