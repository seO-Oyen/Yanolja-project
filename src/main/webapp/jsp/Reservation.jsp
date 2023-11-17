<%@page import="java.util.ArrayList"%>
<%@page import="yanolja.vo.ReservationInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" import="yanolja.controller.ReservationController"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>예약확인</title>
<link rel="stylesheet" href="../css/Reservation.css">
<script type="text/javascript" src="../jquery/jquery-3.1.1.js"></script>
</head>
<body>

	<%
	String category = request.getParameter("category");
	String period = request.getParameter("period");
	%>
	<h2>예약내역</h2>

	<form name="infoForm" id="infoForm">
		<div class="selectBox">
			<select name="category" id="category">
				<option value="all" selected>전체</option>
				<option value="lodging">숙소</option>
				<option value="traffic">교통</option>
			</select>
		</div>
		<div class="selectBox" id="select2">
			<select name="period" id="period">
				<option value="three">최근 3개월</option>
				<option value="six" selected>최근 6개월</option>
				<option value="one">최근 1년</option>
				<option value="two">최근 2년</option>
			</select>
		</div>
	</form>

	<%
	ReservationController rController = new ReservationController();

	List<ReservationInfo> rlist = new ArrayList<ReservationInfo>();
	rlist = rController.getReservationList(category, period);

	if (rlist != null) {
		for (int i = 0; i < rlist.size(); i++) {
			ReservationInfo info = rlist.get(i);
			int infoNum = info.getProductInfo().getProductInfo();
	%>
	<div id="reservation" name="reservation">
		<div onclick="infoClick(<%=infoNum%>)">
		<h4 class="detail"><%=info.getReservationDate()%></h4>
		<div class="detail"><%=info.getProductInfo().isUsed() ? "이용완료" : "이용전"%></div>
		<div class="detail"><%=info.getProductInfo().getName()%></div>
		<div class="detail"><%=info.getProductInfo().getProduct()%></div>
		<div class="detail"><%=info.getProductInfo().getStartDate()%>
			~
			<%=info.getProductInfo().getEndDate()%>
		</div>
		<div class="detail"><%=info.getProductInfo().isBus() ? "자동차" : "도보"%></div>
		<div class="detail">
			체크인
			<%=info.getProductInfo().getCheckIn()%>:00 | 체크아웃
			<%=info.getProductInfo().getCheckOut()%>:00
		</div>
		</div>
		<!-- disabled style="cursor: default" -->
		<button type="button" id="review" name="review" 
			<% if(info.getProductInfo().isReview()) { %>onclick="checkReview(<%=infoNum%>)" <% }
			else { %> onclick="writeReview(<%=infoNum%>)" style="background-color: #DE2E5F; border: 2px solid #DE2E5F; color: white;" <% } %>>
		<%=info.getProductInfo().isReview() ? "리뷰완료" : "리뷰작성" %></button>

		<%-- <div><%= info.getProductInfo() %></div> --%>
		<%-- <div><%= info.getPersonInfo() %></div> --%>
	</div>
	<%
		}
	}
	%>
	<div id="result" value="<%=category%>"></div>
	<div id="result2" value="<%=period%>"></div>

</body>
<script src="../jquery/Reservation.js"></script>
</html>