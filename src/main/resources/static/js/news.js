$(document).on('click', '.container .content .add > .button', function() {
    $(".container .content .add .block").fadeIn();
    $(this).hide();
    $(".container .content .add .cancel").fadeIn();
});

$(document).on('click', '.container .content .add > .cancel', function() {
    $(".container .content .add .block").fadeOut();
    $(this).hide();
    $(".container .content .add > .button").fadeIn();
});

$(document).on('click', '.container .content .blocks .block .buttons .button:first-child', function() {
    $(this).parents(".buttons").siblings(".edit").fadeIn();
});

$(document).on('click', '.container .content .block .edit .cancel', function() {
    $(this).parents(".edit").fadeOut();
});