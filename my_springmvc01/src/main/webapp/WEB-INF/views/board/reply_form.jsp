<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>

<script>
$(document).ready(function() {
	var frmPaging=$("#frmPaging");
	
	$("#a_list").click(function(e){
		e.preventDefault();
		var bno="${board2Vo.bno}";
		frmPaging.find("input[name=bno]").val(bno);
		frmPaging.attr("action","/board/content");
		frmPaging.attr("method","get");
		frmPaging.submit();
	});
	
});
</script>
<%@ include file="/WEB-INF/views/include/paging.jsp" %>
${board2Vo}
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					답글쓰기
				</h2>
				<p>
					<a class="btn btn-primary btn-large" href="#" id="a_list">게시글 다시보기</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/board/reply_run" method="post">
			<input type="hidden" >
			<input type="hidden" name="page" value="${pagingDto.page}">
			<input type="hidden" name="perPage" value="${pagingDto.perPage}">
			<input type="hidden" name="searchType" value="${pagingDto.searchType}">
			<input type="hidden" name="keyword" value="${pagingDto.keyword}">
			<input type="hidden" name="bno" value="${board2Vo.bno}">
			<input type="hidden" name="re_level" value="${board2Vo.re_level}">
			<input type="hidden" name="re_seq" value="${board2Vo.re_seq}">
			<input type="hidden" name="re_group" value="${board2Vo.re_group}">
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
					<input type="text" class="form-control" id="title"  name="title"
					value="${board2Vo.title}에 대한 답변글 입니다 :"/>
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