<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%@ page pageEncoding="UTF-8" %>

<%@ include file="/WEB-INF/views/include/header.jsp" %>
<script>
	$(document).ready(function() {
		var login_result="${login_result}";
		if(login_result == "fail"){
			alert("아이디나 비밀번호가 일치하지 않습니다");
		}
	});
</script>
<div class="row">
		<div class="col-md-12">
			<div class="jumbotron">
				<h2>
					로그인 하시기 바랍니다
				</h2>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
			<form role="form" action="/member/login_run" method="post">
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
				
				<div class="checkbox">
					 
					<label>
						<input type="checkbox" /> 아이디 저장
					</label>
				</div> 
				<button type="submit" class="btn btn-primary">
					로그인
				</button>
				<a  class="btn btn-success" href="/member/join_form">회원가입</a>
			</form>
		</div>
	</div>   <%@ include file="/WEB-INF/views/include/footer.jsp" %>
