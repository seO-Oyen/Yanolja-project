<%@page import="yanolja.controller.ReservationController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 등록</title>
</head>
<body>
	<%
	ReservationController rController = new ReservationController();
	String infoNum = request.getParameter("infoNum");
	String star = request.getParameter("star");
	String text = request.getParameter("text");
	rController.createReview(infoNum, star, text);
	%>
	<h2>리뷰 등록 완료</h2>
	<button type="button" onclick="clicked()">예약 확인으로 돌아가기</button>
</body>
<script>
	function clicked() {
		let url = "/yanolja/jsp/Reservation.jsp"
		location.href = url
	}
</script>
</html>