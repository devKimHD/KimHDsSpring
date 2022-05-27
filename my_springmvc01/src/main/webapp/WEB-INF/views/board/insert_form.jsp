<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="/WEB-INF/views/include/header.jsp" %>
<style>
#divDropPlace{
	width: 70%;
	height: 150px;
	border: 1px dashed green;
	margin: 40px auto;
	background-color:cyan;
}
.cloneDivImgDesc{
	float:left;
	width:150px;
	
}
</style>
<script src="/resources/js/filenamejs.js"></script>
<script>

	$(function() {
		$("#divDropPlace").on("dragenter dragover",function(e){
			e.preventDefault();
		});
		
		$("#divDropPlace").on("drop", function(e){
			e.preventDefault();
			console.log("event",e);
			var file=e.originalEvent.dataTransfer.files[0];
			console.log("file",file);
			var formData=new FormData();
			formData.append("file",file);
			console.log("formData",formData.get("file"));
			var url="/board/uploadFile";
			$.ajax({
				"processData": false,
				"contentType": false,
				"url": url,
				"method": "post",
				"data": formData,
				"success": function(rData){
					//console.log(rData);
					var targetFilename= getFilename(rData);
					console.log(targetFilename);
					var ext= isExtension(targetFilename);
					console.log("ext",ext);
					var cloneDivImgDesc=$(".cloneDivImgDesc").eq(0).clone();
					cloneDivImgDesc.attr("data-filename",rData);
					cloneDivImgDesc.find("span").text(targetFilename);
					if(ext){
						cloneDivImgDesc.find("img").attr("src",
								"/board/getUploadFile?filename="+rData);
					}
					cloneDivImgDesc.appendTo($("#uploadedList")).show();
					//$("#uploadedList").append(cloneDivImgDesc).show();
				}
				
			});
		});
		$("#frmCreate").submit(function(){
			var divs=$("#uploadedList > .cloneDivImgDesc");
			divs.each(function(){
				var filename=$(this).attr("data-filename");
				var inputHTML="<input type='hidden' name='files' value='"+filename+"'>";
				$("#frmCreate").prepend(inputHTML);
			});
		
		});
		
	});
</script>
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
			<form role="form" action="/board/insert_run" method="post" id="frmCreate">
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

				<div>
					<label>첨부파일을 드래그 &#38; 드롭해주세요</label>
					<div id="divDropPlace">
					<!-- 파일폼 들어갈것 -->
					</div>
				</div>

				<div class="cloneDivImgDesc" style="display:none;">
					<img src="/resources/images/default.png" alt="파일이 없습니다" height="100px">
					<span>확장자가 jpg,gif,png가 아닙니다</span>
				</div>
				
				<div id="uploadedList">
					<!-- 클론된 div들이 뒤에 붙을것 이미지 목록-->
				</div>
				<div style="clear:both;">
				<button type="submit" class="btn btn-primary">
					작성 완료
				</button>
				</div>
			</form>
		</div>
	</div>
	
	
	
	
	
</div>
   <%@ include file="/WEB-INF/views/include/footer.jsp" %>