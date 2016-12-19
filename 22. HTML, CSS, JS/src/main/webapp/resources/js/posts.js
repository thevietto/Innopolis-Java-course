$( document ).ready(function () {
    $(".show-post-text").on('click', function (e) {
        var $parent = $(this).parent('.post');
        $parent.children('.post-text').slideToggle();
        return false;
    });

    $(".delete-post").click(function () {
        var url = $(this).attr("href");
        var $post = $(this).parent('.post');
        $.ajax(url, {
            method: 'GET',
            success: function () {
                $post.hide();
            }
        });
        return false;
    });

});

