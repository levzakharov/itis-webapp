var selectSize, selectType, selectDay;

$(document).ready(function() {

    $(".container .content .add .block form select").multipleSelect({
        filter: true,
        multiple: true
    });



});



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


$(document).on('click', '.content.notifications .filter .modes .button:first-child', function() {
    $(".content.notifications .blocks.received").hide();
    $(".content.notifications .blocks.sent").fadeIn();
    $('.content.notifications .filter .modes .button').removeClass('active');
    $(this).addClass('active');
});

$(document).on('click', '.content.notifications .filter .modes .button:last-child', function() {
    $(".content.notifications .blocks.sent").hide();
    $(".content.notifications .blocks.received").fadeIn();
    $('.content.notifications .filter .modes .button').removeClass('active');
    $(this).addClass('active');

});






