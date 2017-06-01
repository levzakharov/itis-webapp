var transl = {
    'День': 'monday',
    'Неделя': 'week',
    'Личное': 'private',
    'Общее': 'overall',
    'Пн': 'monday',
    'Вт': 'tuesday',
    'Ср': 'wednesday',
    'Чт': 'thursday',
    'Пт': 'friday',
    'Сб': 'saturday',
    'Вс': 'sunday'
}


$(document).ready(function () {
    $('.schedule-form').submit(function (event) {
        event.preventDefault();
        var dataForm = $(this).serialize();
        console.log(dataForm);
        $.ajax({
            url: '/timetable/search',
            data: dataForm,
            success: function (response) {
                $('.response-container').html(response);
            },
        });
    });
    $('.schedule-form .modes input[type="submit"]').hide();
    $('.schedule-form').submit();
});

$(document).on('click', '.size .button', function () {
    $('.size .button').removeClass('active');
    $(this).addClass('active');
    if (transl[$(this).text()] == 'week') {
        $('.days .button').removeClass('active');
    }
    $('.size input[name="interval"]').val(transl[$(this).text()]);
    $('.schedule-form').submit();
});

$(document).on('click', '.days .button', function () {
    $('.days .button').removeClass('active');
    $('.size .button').removeClass('active');
    $('.size .button:first-child').addClass('active');
    $(this).addClass('active');
    $('.size input[name="interval"]').val(transl[$(this).text()]);
    $('.schedule-form').submit();
});

$(document).on('click', '.type .button', function () {
    $('.type .button').removeClass('active');
    $(this).addClass('active');
    console.log($(this).text());
    $('.type input[name="personality"]').val(transl[$(this).text()]);
    $('.schedule-form').submit();
});

$(document).on('click', '.schedule-form .modes .type .overall', function () {
    $('.schedule-form .modes .size').fadeOut();
    $('.schedule-form .modes .size .week').click();
    $('.schedule-form').submit();
});

$(document).on('click', '.schedule-form .modes .type .private', function () {
    $('.schedule-form .modes .size').fadeIn();
    $('.schedule-form').submit();
});