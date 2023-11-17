$('.rate').click(function() {
	var radioVal = $('input[name="rating"]:checked').val();
	console.log(radioVal);
});

$(".btn02").click(function() {
	console.log($('input[name="rating"]:checked').val())
	if (typeof $('input[name="rating"]:checked').val() == "undefined") {
		alert("별점을 입력해주세요")
	} else {
		let url = "/yanolja/jsp/SendReview.jsp?infoNum="
			+ $("#rname").attr("value")
			+ "&star="
			+ $('input[name="rating"]:checked').val()
			+ "&text=" + $(".star_box").val();
		location.href = url
	}
})