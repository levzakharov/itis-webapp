$(document).on('click', 'header .col-5:last-child .fa', function () {
    $(".menu-mobile").fadeToggle();
    $(".container header").toggleClass("mobile");
    $("header .col-5:last-child .fa").toggleClass("fa-bars");
    $("header .col-5:last-child .fa").toggleClass("fa-times");
});
