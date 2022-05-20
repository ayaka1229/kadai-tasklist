<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- エラーフラッシュ --%>
<c:if test="${errors != null}">
	<div id="flush_error">
		入力エラーがあります！<br/>

		<c:forEach var="error" items="${errors}">
			・<c:out value="${error}"/><br/>
		</c:forEach>
	</div>
</c:if>

<%-- Newのリクエストスコープに入れている --%>
<label for="content">新しい項目</label><br/>
<input type="text" name="content" value="${ task.content }"/>
<br/><br/>

<input type="hidden" name="_token" value="${ _token }"/>
<button type="submit">追加</button>
