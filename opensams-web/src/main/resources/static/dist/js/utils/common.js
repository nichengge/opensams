function sendPostRequest(url, data, successCallback, failCallback) {
    $.ajax({
        url: url,
        method: 'post',
        dataType: 'json',
        data: data,
        success: function(response) {
            if (!response) {
                console.log('response is null.');
                return;
            }
            if (response.code === '200') {
                successCallback(response);
            } else if (response.code === '500') {
                failCallback(response);
            }
        }
    });
}