$(function () {
	let dval = $("#result").attr("value")
	let dval2 = $("#result2").attr("value")
	console.log(dval)
	console.log(dval2)
	if (dval != 'null'){
		$('#category').val(dval).attr("selected",true);
	}
	if (dval2 != 'null') {
		$("#period").val(dval2).attr("selected", true);
	}
	
	let review = $("[name=review]").text()
	
	for (var i = 0; i < review.length; i++) {
		console.log(review[i])
	}
})

// 카테고리 선택
$("#category").change(function() {
    let value = this.value
	let pvalue = $("#period").val()
    let url = "/yanolja/jsp/Reservation.jsp?category=" + value + "&period=" + pvalue
    location.replace(url)
    // $("#infoForm").attr("action", url).submit();
})

// 기간 선택
$("#period").change(function() {
    let value = this.value
    let cvalue = $("#category").val()
    let today = new Date();
    let url = "/yanolja/jsp/Reservation.jsp?category=" + cvalue + "&period=" + value
    location.replace(url)
    //$("#infoForm").attr("action", "?").submit()
})

function infoClick(infoNum) {
	let url = "/yanolja/jsp/ReservationDetail.jsp?infoNum=" + infoNum
	location.href = url
}

