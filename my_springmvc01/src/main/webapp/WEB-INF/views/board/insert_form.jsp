<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					게시판 목록
				</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/board/list">게시판목록</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/board/insert_run" method="post">
				<div class="form-group">
					 
					<label for="writer">
						작성자
					</label>
					<input type="text" class="form-control" id="writer"  name="writer"/>
				</div>
				<div class="form-group">
					 
					<label for="title">
						제목
					</label>
					<input type="text" class="form-control" id="title"  name="title"/>
				</div>
				<div class="form-group">
					 
					<label for="content">
						내용
					</label>
					<textarea name="content" id="content" class="form-control"></textarea>
				</div>
				
				<button type="submit" class="btn btn-primary">
					작성 완료
				</button>
			</form>
		</div>
	</div>
</div>
   <%@ include file="/WEB-INF/views/include/footer.jsp" %>