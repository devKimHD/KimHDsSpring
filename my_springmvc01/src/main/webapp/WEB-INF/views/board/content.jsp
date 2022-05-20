<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<script>
$(document).ready(function() {
	getCommentAll();
	var frmPaging=$("#frmPaging");
	var update_result="${update_result}";
	
	if(update_result=="true"){
		alert("게시글 수정 완료");
	}
	$("#btnUpdate").click(function(){
		$("*[readonly]").attr("readonly",false);
		$(this).fadeOut("slow");
		$("#btnUpdateRun").fadeIn("slow");
	});		
	$("#aDelete").click(function(e){
		e.preventDefault();
		var confirm=window.confirm("정말로 삭제하시겠습니까?");
		var bno="${board2Vo.bno}";
		var page="${pagingDto.page}";
		var perPage="${pagingDto.perPage}";
		if(confirm == true){
// 			console.log("삭제");
// 			location.href="/board/delete?bno="+bno;
		$("#frmPaging").find("input[name=bno]").val(bno);
		$("#frmPaging").attr("action","/board/delete");
		$("#frmPaging").attr("method","get");
		frmPaging.submit();
		
		}
	});
	$("#a_list").click(function(e){
		e.preventDefault();
		var bno="${board2Vo.bno}";
		frmPaging.find("input[name=bno]").val(bno);
		frmPaging.attr("action","/board/list");
		frmPaging.attr("method","get");
		frmPaging.submit();
	});
	$("#btnReply").click(function(){
		var bno="${board2Vo.bno}";
		frmPaging.find("input[name=bno]").val(bno);
		frmPaging.attr("action","/board/reply_form");
		frmPaging.attr("method","get");
		frmPaging.submit();
	});
	//댓글 달기
	$("#btnComment").click(function(){
		var bno="${board2Vo.bno}";
		var content=$("#c_content").val();
		var user_id=$("#c_user_id").val();
		var sData={
				"bno" : bno,
				"content": content,
				"user_id": user_id
		};
		console.log(sData);
		var url="/comment/commentInsert";
		$.post(url,sData,function(rData){
			console.log(rData);
			$("#c_content").val("");
			$("#c_user_id").val("");
			
			getCommentAll();
		});
	});
	//댓글 불러오기
	function getCommentAll(){
		var bno="${board2Vo.bno}";
		var url="/comment/commentList/"+bno;
		$("#commentTable tr:gt(0)").remove();
		$.get(url,function(rData){
			console.log(rData);
			$.each(rData, function(){
				var tr=$("#cloneTable tr").clone();
				var tds=tr.find("td");
// 				console.log(tr);
// 				console.log(tds);
				tds.eq(0).text(this.cno);
				tds.eq(1).text(this.content);
				tds.eq(2).text(this.user_id);
				tds.eq(3).text(this.regdate);
				tr.find(".btnCommentModify").attr("data-cno",this.cno);
				tr.find(".btnCommentDelete").attr("data-cno",this.cno);
				$("#commentTable").append(tr);
			});
			
		});
	}
	
	//댓글 수정하기 
	$("#commentTable").on("click",".btnCommentModify",function(){
		console.log("수정 버튼 클릭");
		var tr=$(this).parents("tr");
		var content=tr.find("td").eq(1).text();
		tr.find("td").eq(1).text("");
		tr.find("td").eq(1).append("<input type='text' class='form-control txt_content'>");
		$(".txt_content").val(content);
		$(this).fadeOut("slow");
		$(this).next().fadeIn("slow");
	});
	//댓글 수정 완료
	$("#commentTable").on("click",".btnCommentModifyOk",function(){
		console.log("수정완료 버튼 클릭");
		var tr=$(this).parents("tr");
		var content=$(".txt_content").val();
		var cno=tr.find("td").eq(0).text();
// 		console.log("content btnCommentModifyOk",content);
// 		console.log("cno btnCommentModifyOk",cno);
		 var url="/comment/commentUpdate";
	      var sData={
	            "content":content,
	            "cno":cno
	      };
	      $.post(url,sData,function(rData){
	         console.log("update Result ",rData);
	         if(rData=="true"){
	            getCommentAll();
	         }
	      });

	});
	
	//댓글 삭제
	$("#commentTable").on("click",".btnCommentDelete",function(){
		//console.log("삭제 버튼 클릭");
		var cno=$(this).attr("data-cno");
		//console.log("cno",cno);
		url="/comment/commentDelete/"+cno;
		$.get(url, function(rData){
			console.log(rData);
			if(rData=="true"){
				getCommentAll();
			}
		});
	});
	
	
	
});
</script>
<%@ include file="/WEB-INF/views/include/paging.jsp" %>
<div class="container-fluid">
<!-- modal comment -->
<div class="row">
		<div class="col-md-12">
			 <a id="modal-30742" href="#modal-container-30742" role="button" class="btn" data-toggle="modal" style="display:none;">Launch demo modal</a>
			
			<div class="modal fade" id="modal-container-30742" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog" role="document">
					<div class="modal-content">
						<div class="modal-header">
							<h5 class="modal-title" id="myModalLabel">
								댓글 수정
							</h5> 
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">×</span>
							</button>
						</div>
						<div class="modal-body">
							<input type="text" class="form-control" id="modalContent"> 
						</div>
						<div class="modal-footer">
							 
							<button type="button" class="btn btn-primary" id="btnModifyCommentOK" data-dismiss="modal">
								수정 완료
							</button> 
							<button type="button" class="btn btn-secondary" data-dismiss="modal">
								닫기
							</button>
						</div>
					</div>
					
				</div>
				
			</div>
			
		</div>
	</div>

<!-- /modal comment -->
	<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					게시판 글 보기
				</h2>
				<p>
					<a class="btn btn-primary btn-large" href="#" id="a_list">게시판목록</a>
				</p>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/board/update_run" method="post">
			<input type="hidden" name="bno" value="${board2Vo.bno}">
			<input type="hidden" name="page" value="${pagingDto.page}">
			<input type="hidden" name="perPage" value="${pagingDto.perPage}">
			<input type="hidden" name="searchType" value="${pagingDto.searchType}">
			<input type="hidden" name="keyword" value="${pagingDto.keyword}">
				<div class="form-group">
					 
					<label for="writer">
						작성자
					</label>
					<input type="text" class="form-control" id="writer"  name="writer" value="${board2Vo.writer }" readonly="readonly"/>
				</div>
				<div class="form-group">
					 
					<label for="title">
						제목
					</label>
					<input type="text" class="form-control" id="title"  name="title" value="${board2Vo.title }" readonly="readonly"/>
				</div>
				<div class="form-group">
					 
					<label for="content">
						내용
					</label>
					<textarea name="content" id="content" class="form-control" readonly="readonly">${board2Vo.content}</textarea>
				</div>
				<button type="button" class="btn btn-primary" id="btnUpdate">
					수정 하기
				</button>
				<button type="submit" class="btn btn-secondary" style="display: none;" id="btnUpdateRun">
					수정 완료
				</button>
				<a href="#" class="btn btn-danger" id="aDelete">삭제하기</a>
				<button type="button" id="btnReply" class="btn  btn-warning">답글달기</button>
			</form>
		</div>
	</div>
	<!-- comment area -->
	
	<div class="row" style="margin-top: 40px">
		<div class="col-md-9">
			<input class="form-control" type="text" name="c_content" 
			id="c_content" placeholder="댓글을 작성해주세요">
		</div>
		
		<div class="col-md-2">
			<input class="form-control" type="text" name="c_user_id" id="c_user_id"
			placeholder="아이디를 입력해주세요">
		</div>
		
		<div class="col-md-1">
			<button type="button" class="btn btn-info" id="btnComment">댓글작성</button>
		</div>
	</div>
	
	<div class="row" style="margin-top: 20px">
		<div class="col-md-12">
			<table id="cloneTable" style="display:none;">
				<tr>
				<td></td>
				<td></td>
				<td></td>
				<td></td>
				<td>
				<button type="button" class="btn btn-sm btn-info btnCommentModify">수정</button>
				<button type="button" style="display:none;" class="btn btn-sm btn-dark btnCommentModifyOk">수정완료</button>				
				</td>
				<td>
				<button type="button" class="btn btn-sm btn-danger btnCommentDelete">삭제</button>
				</td>
				</tr>	
			</table>
			
			<table class="table" id="commentTable">
				<tr>
				<td>#</td>
				<td>내용</td>
				<td>작성자</td>
				<td>작성일</td>
				<td>수정</td>
				<td>삭제</td>
				</tr>	
			</table>
		</div>
	</div>
	
	
	<!-- comment area -->
</div>

<%@ include file="/WEB-INF/views/include/footer.jsp" %>