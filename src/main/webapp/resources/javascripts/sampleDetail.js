/**
 * Created by charles on 15/9/10.
 */
if(hasLogin) {
    $.get('/henghua/sample/detail/' + detailId + '/quantity', function (data) {
        $('#stock').text(data.stock);
        $('#unit').text(data.unit);
        $('#price').text(data.price);
    });
}