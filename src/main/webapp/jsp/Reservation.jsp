<%@page import="java.util.ArrayList"%>
<%@page import="yanolja.vo.ReservationInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"
    import="yanolja.controller.ReservationController"
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script type="text/javascript" src="../jquery/jquery-3.1.1.js"></script>
</head>
<body>
	
	<% 
	String category = request.getParameter("category");
	String period = request.getParameter("period");
	%>
	
	<h4>국내여행 예약내역</h4>
    <form id="infoForm">
        <select name="category" id="category">
            <option value="all" selected>전체</option>
            <option value="lodging">숙소</option>
            <option value="traffic">교통</option>
        </select>

        <select name="period" id="period">
            <option value="three">최근 3개월</option>
            <option value="six" selected>최근 6개월</option>
            <option value="one">최근 1년</option>
            <option value="two">최근 2년</option>
        </select>
    </form>
	
    <%
		ReservationController rController = new ReservationController();
		
    	List<ReservationInfo> rlist = new ArrayList<ReservationInfo>();
		rlist = rController.getReservationList(category, period);
		
		if (rlist != null) {
			for (int i = 0; i < rlist.size(); i++) {
				ReservationInfo info = rlist.get(i);
	%>
			<div>
				<div><%= info.getReservation() %></div>
				<div><%= info.getReservationDate() %></div>
				<%-- <div><%= info.getProductInfo() %></div> --%>
				<div><%= info.getPersonInfo() %></div>
			</div>
	<%
			}
		}
	%>
    <div id="result" value="<%= category %>"></div>
    <div id="result2" value="<%= period %>"></div>

</body>
<script src="../jquery/Reservation.js"></script>
</html>