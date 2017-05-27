/**
 * Created by maratgatin on 28/05/2017.
 */
$(document).on("click", "button.accept.button", function(event){
    var url = "/certificates/" + $(this).val() + "/accept"
    $.ajax({
        url : url,
        method : "POST",
        success : function(){
            window.location.href = "/certificates";
        },
    });
});

$(document).on("click", "button.decline.button", function(event){
    var url = "/certificates/" + $(this).val() + "/decline"
    $.ajax({
        url : url,
        method : "POST",
        success : function(){
            window.location.href = "/certificates";
        }
    });
});
