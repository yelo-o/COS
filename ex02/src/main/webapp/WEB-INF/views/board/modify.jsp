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
                       게시글 수정 페이지
                </div>
                <!-- /.panel-heading -->
				<div class="panel-body">
					<form method="post" action="/board/modify">
						<input type="hidden" name="pageNum" value="${cri.pageNum}">
						<input type="hidden" name="amount" value="${cri.amount}">
						<div class="form-group">
							<label>글번호</label>
							<input class="form-control" name="bno" value="${board.bno}" readonly="readonly">
						</div>
						<div class="form-group">
							<label>글제목</label>
							<input class="form-control" name="title" value="${board.title}">
						</div>
						<div class="form-group">
							<label>글내용</label>
							<textarea class="form-control" name="content" rows="3">${board.content}</textarea> 
						</div>
						<div class="form-group">
							<label>작성자</label>
							<input class="form-control" name="writer" value="${board.writer}" readonly="readonly">
						</div>
	               		<input type="hidden" name="pageNum" value="${cri.pageNum}">
	                	<input type="hidden" name="amount" value="${cri.amount}">
	               		<input type="hidden" name="type" value="${cri.type}">
	                	<input type="hidden" name="keyword" value="${cri.keyword}">
						<button data-oper="modify">수정하기</button><button data-oper="remove">삭제하기</button>
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
$(() => {
	var formObj = $("form");
	$("button").on("click", function(e) {
		e.preventDefault(); //기본 이벤트 막기
		var operation = $(this).data("oper");
		
		//alert($(this));
		console.log(operation);
		
		if (operation == 'remove'){
			formObj.attr("action", "/board/remove")
		} else if (operation == 'list') {
			//리스트로 이동
			formObj.attr("action", "/board/list").attr("method", "get");
			var pageNumTag = $("input[name='pageNum']").clone();
			var amountTag = $("input[name='amount']").clone;
			
			formObj.empty();
			formObj.append(pageNumTag);
			formObj.append(amountTag);
		}
		formObj.submit();
	});
});
</script>
