$(document).ready(function() {
    LoadIFrame("http://shelly.kpfu.ru/e-ksu/score_rate_web.score_rate_form");
});

function resizeIframe(obj) {
    obj.style.height = obj.contentWindow.document.body.scrollHeight + 'px';
}

function LoadIFrame(url) {
    // Create & display iframe
    var iframe = '<iframe width="100%" height="100%" id="iframe" frameborder="0" src="' + url + '" onload="load()"></iframe>';
    $('#iframeHolder').append(iframe);

    $(".container").addClass("raiting");
    $("iframe *").css("text-align", "left");

    // Time
    var time = new Date().getTime();
    $('#iframeHolder').attr('data-time', time);
}

function AdjustIframeHeightOnLoad() { document.getElementById("iframe").style.height = document.getElementById("iframe").contentWindow.document.body.scrollHeight + "px"; }
function AdjustIframeHeight(i) { document.getElementById("iframe").style.height = parseInt(i) + "px"; }

function load() {
    AdjustIframeHeightOnLoad();

    var requestTime = $('#iframeHolder').attr('data-time');
    var loadTime = new Date().getTime();
    var difference = loadTime - requestTime;
    if (difference < 1000) {
        var url = $('#iframeHolder iframe').attr('src');
        window.open(url, '_blank');
        $('#iframeHolder').empty();
        $('#iframeHolder').append("<div class='loaderror'><i class='fa fa-exclamation-triangle' aria-hidden='true'></i><a>Ошибка на сервере КФУ</a></div>");
    }
}