<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@include file="../includes/header.jsp" %>
<!-- /.row -->
<div class="row">
		<div class="col-lg-12">
			<div class="panel panel-default">
				<div class="panel-heading">
                       게시글 내용 페이지
                </div>
                <!-- /.panel-heading -->
				<div class="panel-body">
					<div class="form-group">
						<label>글번호</label>
						<input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>글제목</label>
						<input class="form-control" name="title" value="${board.title}" readonly="readonly">
					</div>
					<div class="form-group">
						<label>글내용</label>
						<textarea class="form-control" name="content" rows="3" readonly="readonly">${board.content}</textarea> 
					</div>
					<div class="form-group">
						<label>작성자</label>
						<input class="form-control" name="writer" value="${board.writer}" readonly="readonly">
					</div>
					<button class="btn btn-default" data-oper="modify">수정하기</button>
					<button class="btn btn-info" data-oper="list">리스트로</button>
					
					<form id="operForm" method="get" action="/board/modify">
						<input id="bno" type="hidden" name="bno" value="${board.bno} ">
						<input type="hidden" name="pageNum" value="${cri.pageNum} ">
						<input type="hidden" name="amount" value="${cri.amount} ">
					</form>
				</div>
                <!-- /.panel-body -->
           </div>
           <!-- /.panel -->
       </div>
       <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	$("button[data-oper='modify']").click(() => {
		$("#operForm").submit();
	});
	
	$("button[data-oper='list']").click(() => {
		//location.href="/board/list"; //가장 쉬운 방법 
		$("#operForm").find("#bno").remove();
		$("#operForm").attr("action", "/board/list").submit();
	});
});

</script>