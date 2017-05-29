$(document).on("click", ".signin-container .signin .forgot a", function() {
	$(".modal-container").addClass("activate");
	$(".modal").addClass("activate");
});

$(document).on("click", ".modal .close", function() {
	$(".modal-container").removeClass("activate");
	$(".modal").removeClass("activate");
});