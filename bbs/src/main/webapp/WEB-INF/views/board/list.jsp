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
					<table width="100%">
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
                            	<td><a href="/board/get?bno=${board.bno}">${board.title}</a></td>
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
				</div>
                <!-- /.panel-body -->
           </div>
           <!-- /.panel -->
       </div>
       <!-- /.col-lg-12 -->
</div>
<!-- /.row -->
<%@include file="../includes/footer.jsp" %>