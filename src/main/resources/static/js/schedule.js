var selectSize, selectType, selectDay;

$(document).ready(function() {

    selectSize = $('.size select').attr('name');
    // add a hidden element with the same name as the select
    var hidden = $('<input type="hidden" name="'+selectSize+'">');
    hidden.val($('.size select').val());
    hidden.insertAfter($('.size select'));

    $(".size select option").unwrap().each(function() {
        var btn = $('<div class="button">'+$(this).text()+'</div>');
        if($(this).is(':checked')) btn.addClass('active');
        $(this).replaceWith(btn);
    });

    selectType = $('.type select').attr('name');
    // add a hidden element with the same name as the select
    var hidden = $('<input type="hidden" name="'+selectType+'">');
    hidden.val($('.type select').val());
    hidden.insertAfter($('.type select'));

    $(".type select option").unwrap().each(function() {
        var btn = $('<div class="button">'+$(this).text()+'</div>');
        if($(this).is(':checked')) btn.addClass('active');
        $(this).replaceWith(btn);
    });

    selectDay = $('.days select').attr('name');
    // add a hidden element with the same name as the select
    var hidden = $('<input type="hidden" name="'+selectDay+'">');
    hidden.val($('.days select').val());
    hidden.insertAfter($('.days select'));

    $(".days select option").unwrap().each(function() {
        var btn = $('<div class="button">'+$(this).text()+'</div>');
        if($(this).is(':checked')) btn.addClass('active');
        $(this).replaceWith(btn);
    });
});

$(document).on('click', '.size .button', function() {
    $('.size .button').removeClass('active');
    $(this).addClass('active');
    $('.size input[name="'+selectSize+'"]').val($(this).text());
});

$(document).on('click', '.days .button', function() {
    $('.days .button').removeClass('active');
    $(this).addClass('active');
    $('.days input[name="'+selectDay+'"]').val($(this).text());
});

$(document).on('click', '.type .button', function() {
    $('.type .button').removeClass('active');
    $(this).addClass('active');
    $('.type input[name="'+selectType+'"]').val($(this).text());
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

$(document).on('click', '.container .content .blocks .block .buttons .button:first-child', function() {
    $(this).parents(".buttons").siblings(".edit").fadeIn();
});

$(document).on('click', '.container .content .block .edit .cancel', function() {
    $(this).parents(".edit").fadeOut();
});