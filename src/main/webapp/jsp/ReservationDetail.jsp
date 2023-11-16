<%@page import="yanolja.vo.ReservationInfo"%>
<%@page import="yanolja.controller.ReservationController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="../css/ReservationDetail.css">
<script type="text/javascript" src="../jquery/jquery-3.1.1.js"></script>
</head>
<body>
	<%
	int infoNum = Integer.parseInt(request.getParameter("infoNum"));

	ReservationController rController = new ReservationController();

	ReservationInfo reservation = rController.getReservation(infoNum);
	%>
	<div id="headerDiv">
		<div class="header1" id="header2">&#60;</div>
		<div class="header1" id="header3">예약내역 상세</div>
	</div>

	<div style="font-weight: bold;"><%=reservation.getReservationDate()%></div>
	<div>
		주문 번호:
		<%=reservation.getReservation()%></div>
	<div id="coment">상품 및 이용 정보</div>
	<div id="divbox1">
		<div><%=reservation.getProductInfo().isUsed() ? "이용완료" : "이용전"%></div>
		<div><%=reservation.getProductInfo().getName()%></div>
		<div><%=reservation.getProductInfo().getProduct()%></div>
		<div><%=reservation.getProductInfo().getStartDate()%>
			~
			<%=reservation.getProductInfo().getEndDate()%>
		</div>
		<div><%=reservation.getProductInfo().isBus() ? "자동차" : "도보"%></div>
		<div>
			체크인
			<%=reservation.getProductInfo().getCheckIn()%>:00 | 체크아웃
			<%=reservation.getProductInfo().getCheckOut()%>:00
		</div>
		<div id="review">
			<%=reservation.getProductInfo().isReview() ? "리뷰완료" : "리뷰작성"%></div>
	</div>
</body>
<script src="../jquery/ReservationDetail.js"></script>
</html>