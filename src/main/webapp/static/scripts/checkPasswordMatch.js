function checkPasswordMatch() {

	var password=$('#passwordID').val();
	var confirmPassword=$('#confirmPasswordID').val();

	if (password != confirmPassword)
		$("#checkPasswordMatchID").html("Passwords do not match!");
	else
		$("#checkPasswordMatchID").html("Passwords match.");
}