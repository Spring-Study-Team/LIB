function callServer(url, param) {
    $.ajax({
        type: "POST",
        url: url,
        contentType: "application/json",
        data: JSON.stringify(param),
        success: function(res, status, xhr) {
            console.log("hi");
        }
    });
}