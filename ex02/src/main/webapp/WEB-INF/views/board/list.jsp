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
                            게시판 리스트
                            <button id="regBtn" type="button" class="btn btn-xs pull-right">
                            새 게시물 등록
                            </button>
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                            <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                                <thead>
                                    <tr>
                                        <th>번호</th>
                                        <th>제목</th>
                                        <th>작성자</th>
                                        <th>작성일</th>
                                        <th>수정일</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${list}" var="board">
                                <tr>
                                	<td>${board.bno}</td>
                                	<td><a class="move" href="${board.bno}">${board.title}</a></td>
                                	<td>${board.writer}</td>
                                	<td>
                                		<fmt:formatDate pattern="yyyy-MM-dd" value="${board.regDate}" />
                                	</td>
                                	<td>
                                		<fmt:formatDate pattern="yyyy-MM-dd" value="${board.updateDate}" />
                                	</td>
                                </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            
                            <!-- 서치폼 시작 -->
                            <form id="searchForm" method="get" action="/board/list">
				               <select name="type">
				                  <option value="" ${pageMaker.cri.type == null ? 'selected' :''}>--</option>
								  <option value="T" ${pageMaker.cri.type eq 'T' ? 'selected' :''}>제목</option>
							      <option value="C" ${pageMaker.cri.type eq 'C' ? 'selected' :''}>내용</option>
							      <option value="W" ${pageMaker.cri.type eq 'W' ? 'selected' :''}>작성자</option>
								  <option value="TC" ${pageMaker.cri.type eq 'TC' ? 'selected' :''}>제목 + 내용</option>
								  <option value="TW" ${pageMaker.cri.type eq 'TW' ? 'selected' :''}>제목 + 작성자</option>
							      <option value="CW" ${pageMaker.cri.type eq 'CW' ? 'selected' :''}>내용 + 작성자</option>
								  <option value="TCW" ${pageMaker.cri.type eq 'TCW' ? 'selected' :''}>제목 + 내용 + 작성자</option>
				               </select>
				               <input type="text" name="keyword" />
				               <input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}" /> 
				               <input type="hidden" name="amount" value="${pageMaker.cri.amount}" />
				               <button>검색</button>
				            </form>
                            <!-- 서치폼 끝 -->
				            
                            <!-- 페이지네이션 시작 -->
                            <div class="pull-right">
                            	<ul class="pagination">
                            		<c:if test="${pageMaker.prev}">
                            			<li class="paginate_button previous">
                            				<a href="${pageMaker.startPage-1}">Previous</a>
                           				</li>
                            		</c:if>
                            		
                            		<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
	                            		<li class="paginate_button ${pageMaker.cri.pageNum == num ? "active":""} ">
	                            			<a href="${num}">${num}</a>
	                            		</li>
                            		</c:forEach>
                            		
                            		<c:if test="${pageMaker.next}">
                            			<li class="paginate_button next">
                            				<a href="${pageMaker.endPage + 1}">Next</a>
                            			</li>
                            		</c:if>
                            	</ul>
                            </div>
                            <!-- 페이지네이션 종료 -->
                            
                            <form id="actionForm" method="get" action="/board/list">
                            	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
                            	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
                            	<input type="hidden" name="type" value="<c:out value="${pageMaker.cri.type}"/>">
						        <input type="hidden" name="keyword" value="<c:out value="${pageMaker.cri.keyword}"/>">
                            </form>
                            
                            
							<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-hidden="true" aria-labeldby="myModalLabel">
								<div class="modal-dialog">
									<div class="modal-content">
										<div class="modal-header">
										   <button type="button" class="close" data-dismiss="modal"
										      aria-hidden="true">&times;</button>
										   <h4 class="modal-title" id="myModalLabel">Modal title</h4>
										</div>
										<div class="modal-body">처리가 완료되었습니다.</div>
										<div class="modal-footer">
										   <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
										   <button type="button" class="btn btn-primary">Save Changes</button>
										</div>
									</div>
	                        	</div>
	                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            	</div>
            </div>
            <!-- /.row -->
<%@include file="../includes/footer.jsp" %>

<script type="text/javascript">
$(document).ready(function() {
	var origin= '${origin}';
	/* var result = parseInt('${result}'); */
	var result = '${result}';
	
	checkModal(origin);
	
	//self.history.replaceState({}, null, null);
	
	function checkModal(origin) {
		
		if (origin == '') {
			return;
		}
		
		if (origin == "register") {
			if (result > 0) {
				$(".modal-body").html("게시글 " + result + " 번이 등록되었습니다.");
			}
		} else if (origin == "modify") {
			if (result > 0) {
				$(".modal-body").html("게시글 " + result + " 번이 수정되었습니다.");
			} else {
				$(".modal-body").html("게시글 수정 실패");
			}
		} else if (origin == "remove") {
			if (result > 0) {
				$(".modal-body").html("게시글 " + result + " 번이 삭제되었습니다.");
			} else {
				$(".modal-body").html("게시글 삭제 실패");
			}
			
		} else {
			return;
		}
		$('#myModal').modal("show");
	}
	
	$('#regBtn').click(()=>{
		location.href='/board/register';
	})
	
	var actionForm = $("#actionForm");
	
	$('.paginate_button a').on("click", function(e) {
		e.preventDefault();
		if (actionForm.find("input[name='pageNum']").val() == $(this).attr("hef")){
			return;
		}
		actionForm.find("input[name='pageNum']").val($(this).attr("href"));
		actionForm.submit();
	});
	
	$(".move").on("click", function(e) {
		e.preventDefault();
		actionForm.append("<input type='hidden' name='bno' value='"
				+ $(this).attr("href") + "'>");
		actionForm.attr("action", "/board/get");
		actionForm.submit();
	});
	
	var searchForm = $("#searchForm");
 	
 	$("#searchForm button").on("click", function(e){
 		
 		if(!searchForm.find("option:selected").val()){
 			alert("검색종류를 선택하세요");
 			return false;
 		}
 		
 		if(!searchForm.find("input[name='keyword']").val()){
 			alert("키워드를 입력하세요");
 			return false;
 		}
 		
 		searchForm.find("input[name='pageNum']").val("1");
 		
 		e.preventDefault();
 		searchForm.submit();
 	})
});

</script>
