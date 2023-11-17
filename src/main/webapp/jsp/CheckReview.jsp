<%@page import="yanolja.vo.ReservationInfo"%>
<%@page import="yanolja.vo.Review"%>
<%@page import="yanolja.controller.ReservationController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리뷰 확인</title>
<link rel="stylesheet" href="../css/CheckReview.css">
<script type="text/javascript" src="../jquery/jquery-3.1.1.js"></script>
</head>
<body>
	<%
	ReservationController rController = new ReservationController();
	int infoNum = Integer.parseInt(request.getParameter("infoNum"));
	ReservationInfo reservation = rController.getReservation(infoNum);
	Review review = rController.getReview(infoNum);
	%>
	
	<h3><%= reservation.getProductInfo().getName() %></h3>
	<div id="star" value="<%= review.getStar() %>"></div>
	<div>
	<fieldset class="rate">
		<input type="radio" id="rating5" name="rating" value="5">
		<label for="rating5" title="5점"></label> 
		<input type="radio" id="rating4" name="rating" value="4">
		<label for="rating4" title="4점"></label> 
		<input type="radio" id="rating3" name="rating" value="3">
		<label for="rating3" title="3점"></label>
		<input type="radio" id="rating2" name="rating" value="2">
		<label for="rating2" title="2점"></label> 
		<input type="radio" id="rating1" name="rating" value="1">
		<label for="rating1" title="1점"></label>
	</fieldset>
	</div>
	
	<div class="star_box">
	<%= review.getText() %>
	</div>
	
	<button type="button" class="btn02">예약 확인으로 돌아가기</button>
	
</body>
<script src="../jquery/CheckReview.js"></script>
</html>