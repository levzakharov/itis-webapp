var selectUser, selectUserEdit;

$(document).ready(function () {

    $(".container .content.users .add .block .usertype select").multipleSelect({
        filter: true,
        multiple: true
    });

    selectUser = $('.container .content.users .add .block .usertype select').attr('name');
    // add a hidden element with the same name as the select
    var hidden = $('<input type="hidden" name="' + selectUser + '">');
    hidden.val($('.container .content.users .add .block .usertype select').val());
    hidden.insertAfter($('.container .content.users .add .block .usertype select'));

    $(".container .content.users .add .block .usertype select option").unwrap().each(function () {
        var btn = $('<div class="button">' + $(this).text() + '</div>');
        if ($(this).is(':checked')) btn.addClass('active');
        $(this).replaceWith(btn);
    });


    selectUserEdit = $('.container .content.users .block .usertypeedit select').attr('name');
    // add a hidden element with the same name as the select
    var hidden = $('<input type="hidden" name="' + selectUserEdit + '">');
    hidden.val($('.container .content.users .block .usertypeedit select').val());
    hidden.insertAfter($('.container .content.users .block .usertypeedit select'));

    $(".container .content.users .block .usertypeedit select option").unwrap().each(function () {
        var btn = $('<div class="button">' + $(this).text() + '</div>');
        if ($(this).is(':checked')) btn.addClass('active');
        $(this).replaceWith(btn);
    });

});

$(document).on('click', '.container .content.users .add .block .usertype .button', function () {
    $('.container .content.users .add .block .usertype .button').removeClass('active');
    $(this).addClass('active');
    $('.container .content.users .add .block .usertype input[name="' + selectUser + '"]').val($(this).text());
});

$(document).on('click', '.container .content.users .block .usertypeedit .button', function () {
    $('.container .content.users .block .usertypeedit .button').removeClass('active');
    $(this).addClass('active');
    $('.container .content.users .block .usertypeedit input[name="' + selectUserEdit + '"]').val($(this).text());
});

$(document).on('click', '.container .content .add > .button', function () {
    $(".container .content .add .block").fadeIn();
    $(this).hide();
    $(".container .content .add .cancel").fadeIn();
});

$(document).on('click', '.container .content .add > .cancel', function () {
    $(".container .content .add .block").fadeOut();
    $(this).hide();
    $(".container .content .add > .button").fadeIn();
});


$(document).on('click', '.container .content.users .blocks .block .buttons .fa-search', function () {
    $(this).parents(".buttons").siblings(".edit").toggle();

});