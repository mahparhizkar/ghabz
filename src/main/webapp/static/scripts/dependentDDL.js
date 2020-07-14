$(document).ready(function () {
	$('cityId').on('change', function() {
		alert( this.value );
	});


	// $("#resendOTP").click(function (event) {
	// 	$.ajax({
	// 		type: "POST",
	// 		url: "registration",
	// 		data: $('form').serialize(),
	// 		success: function (result) {
	// 		},
	// 		error: function (result) {
	// 		}
	// 	});
	// });
});