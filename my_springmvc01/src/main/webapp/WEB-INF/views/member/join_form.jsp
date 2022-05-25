<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					회원 가입 
				</h2>
				
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/member/join_run" method="post"
			enctype="multipart/form-data">
				
				
				<div class="form-group">
					 
					<label for="memberid">
						아이디
					</label>
					<input type="text" class="form-control" id="memberid"  name="memberid"/>
				</div>
				
				
				<div class="form-group">
					 
					<label for="memberpw">
						비밀번호
					</label>
					<input type="password" class="form-control" id="memberpw"  name="memberpw"/>
				</div>
				
					
				<div class="form-group">
					 
					<label for="memberpw2">
						비밀번호 확인
					</label>
					<input type="password" class="form-control" id="memberpw2"/>
				</div>
				
				<div class="form-group">
					 
					<label for="membername">
						이름
					</label>
					<input type="text" class="form-control" id="membername" name="membername"/>
				</div>
				
				<div class="form-group">
					 
					<label for="email">
						이메일
					</label>
					<input type="email" class="form-control" id="email" name="email"/>
				</div>
				
				<div class="form-group">
					 
					<label for="m_pic">
						프로필 사진
					</label>
					<input type="file" class="form-control-file" id="m_pic" name="file" />
					<p class="help-block" style="color:red;">
						프로필 사진을 추가해주세요 최대 40mb
					</p>
				</div>
				<button type="submit" class="btn btn-primary">
					작성 완료
				</button>
			</form>
		</div>
	</div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>