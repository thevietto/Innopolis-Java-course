$(document).ready(function () {
    $("#password").on("keyup", function () {
        var val = $(this).val();
        if (/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{6,})$/.test(val)) {
            $(this).css("border-color", "green")
        } else if (/^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])([a-zA-Z0-9]{3,})$/.test(val)) {
            $(this).css("border-color", "yellow")
        } else {
            $(this).css("border-color", "red")

        }
    });

});

