$(function() {
	let dval = $("#star").attr("value")
	console.log(dval)
	$("input[name=rating][value='" + dval + "']").prop("checked", true)
})

$("button").click(function() {
	let url = "/yanolja/jsp/Reservation.jsp"
	location.href = url
})

$("input[name=rating]").click(function() {
	return false
})