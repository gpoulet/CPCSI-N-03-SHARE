<%@page import="java.util.List"%>
<%@page import="fr.imie.CrowdFundingDTO"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %> 
<t:template>
	<div class="tableContainer">
		<c:forEach items="${CrowdFundingList}" var="crowdFundingDTO"
			varStatus="loopStatus">
			<div class="tableRow">
				<div>
					<form method="post">
						<button name="idCrowdFunding" value="${crowdFundingDTO.id}">+</button>
					</form>
				</div>
				<div>
					<span><c:out value="${crowdFundingDTO.name}"></c:out></span>
				</div>
				<div>
					<span style="font-style: italic;"><c:out
							value="${crowdFundingDTO.goal}"></c:out></span>
				</div>
				<div>
					<meter min="0" max="${crowdFundingDTO.goal}"
						value="${crowdFundingDTO.goal-crowdFundingDTO.aim}"></meter>
				</div>
			</div>
		</c:forEach>
	</div>
</t:template>