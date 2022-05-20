<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<style>
tr.tr_list{
cursor: pointer;
}
tr.tr_list:hover {
	background-color: aliceblue;
}
</style>
<script>
$(document).ready(function(){
	var insert_result="${insert_result}";
	console.log("insert_result :"+insert_result);
	var delete_result="${delete_result}";
	var reply_result="${reply_result}";
	if(insert_result =="true"){
		alert("게시글 작성 완료");	
	}
	else if(insert_result=="false"){
		alert("게시글 작성 실패");	
	}
	
	
	console.log("delete_result :"+delete_result);
	if(delete_result =="true"){
		alert("게시글 삭제 완료");	
	}
	else if(delete_result=="false"){
		alert("게시글 삭제 실패");	
	}
	
	if(reply_result =="true"){
		alert("답글 작성 완료");	
	}
	
	$(".tr_list").click(function(){
		var bno=$(this).attr("data-bno");
		var frmPaging=$("#frmPaging");
		frmPaging.find("input[name=bno]").val(bno);
		frmPaging.attr("action","/board/content");
		frmPaging.attr("method","get");
		//location.href="/board/content?bno="+bno;
		frmPaging.submit();
	});
	$("#perPage").change(function(){
		//console.log("click");
		var perPage=$(this).val();
		var frmPaging=$("#frmPaging");
		frmPaging.find("input[name=perPage]").val(perPage);
		frmPaging.attr("action","/board/list");
		frmPaging.attr("method","get");
		frmPaging.find("input[name=page]").val(1);
		frmPaging.submit();
		
	});
	
	$("a.page-link").click(function(e){
		e.preventDefault();
		var page=$(this).attr("href");
		var frmPaging=$("#frmPaging");
		frmPaging.find("input[name=page]").val(page);
		frmPaging.attr("action","/board/list");
		frmPaging.attr("method","get");
		frmPaging.submit();
	});
	$("#btnSearch").click(function(){
		console.log("btn 클릭");
		var searchType=$("#searchType").val();
		var keyword=$("#keyword").val();
		var frmPaging=$("#frmPaging");
		frmPaging.find("input[name=searchType]").val(searchType);
		frmPaging.find("input[name=keyword]").val(keyword);
		frmPaging.find("input[name=page]").val(1);
		frmPaging.attr("action","/board/list");
		frmPaging.attr("method","get");
		frmPaging.submit();
	});
});
</script>
<%@ include file="/WEB-INF/views/include/paging.jsp" %>
${pagingDto }
<div class="container-fluid">
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					게시판 목록
				</h2>
				<p>
					<a class="btn btn-primary btn-large" href="/board/insert_form">게시글 작성</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<select name="perPage" id="perPage">
				<c:forEach var="v" begin="5" end="30" step="5">
				<option value="${v}"
				<c:if test="${v ==pagingDto.perPage}">selected</c:if>
				>${v}줄씩 보기</option>
				</c:forEach>
			</select>
		<select name="searchType" id="searchType">
		<option value="t"
		<c:if test="${'t' ==pagingDto.searchType}">selected</c:if>
		>제목</option>
		<option value="c"
		<c:if test="${'c' ==pagingDto.searchType}">selected</c:if>
		>내용</option>
		<option value="w"
		<c:if test="${'w' ==pagingDto.searchType}">selected</c:if>
		>작성자</option>
		<option value="tc"
		<c:if test="${'tc' ==pagingDto.searchType}">selected</c:if>
		>제목+내용</option>
		<option value="tcw"
		<c:if test="${'tcw' ==pagingDto.searchType}">selected</c:if>
		>모두</option>
		</select>
		<input type="text" name="keyword" id="keyword" value="${pagingDto.keyword}">
		<button type="button" id="btnSearch" class="btn btn-sm btn-primary">검색</button>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<table class="table">
				<thead>
					<tr>
						<th>
							#
						</th>
						<th>
							게시판 제목
						</th>
						<th>
							 작성자
						</th>
						<th>
							작성일
						</th>
						<th>
							조회수
						</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach items="${board2List }" var="board2Vo">
					<tr class="tr_list" data-bno="${board2Vo.bno }">
						<td>${board2Vo.bno }</td>
						<td style="padding-left: ${board2Vo.re_level * 40}px">${board2Vo.title }</td>
						<td>${board2Vo.writer }</td>
						<td>${board2Vo.regdate }</td>
						<td>${board2Vo.viewcnt }</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	<!-- paging -->
		<div class="row">
		<div class="col-md-12">
			<nav>
				<ul class="pagination justify-content-center">
					<c:if test="${pagingDto.startPage != 1 }">
					<li class="page-item">
						<a class="page-link" href="${pagingDto.startPage -1}">이전</a>
					</li>
					</c:if>
					<c:forEach begin="${pagingDto.startPage}" end="${pagingDto.endPage}" var="p">
					<li 
					<c:choose>
					<c:when test="${p== param.page }"> class="page-item active"</c:when>
					<c:otherwise>class="page-item"</c:otherwise>
					</c:choose>
					
					
					>
						<a class="page-link" href="${p}">${p}</a>
					</li>
					</c:forEach>
					<c:if test="${pagingDto.endPage != pagingDto.totalPage}">
					<li class="page-item">
						<a class="page-link" href="${pagingDto.endPage+1}">다음</a>
					</li>
					</c:if>
				</ul>
			</nav>
		</div>
	<!-- //paging -->

	</div>
</div>



<%@ include file="/WEB-INF/views/include/footer.jsp" %>