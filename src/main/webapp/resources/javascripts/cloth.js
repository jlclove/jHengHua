/**
 * Created by charles on 15/9/8.
 */
var isLoading = false;
$(document).on('scroll', function(){
    if(isLoading || sinceId == 0) {
        return;
    }
    var height=getClientHeight();
    var theight=getScrollTop();
    var rheight=getScrollHeight();
    var bheight=rheight-theight-height;
    if(bheight <= 1170) {
        isLoading = true;
        $.get('/henghua/cloth?sinceId=' + sinceId, function(data){
            if(!data || data.length == 0) {
                sinceId = 0;
            }
            sinceId = data[data.length - 1].id;
            $.get('/static/template/cloth.html', function(html){
                $('#list').append(_.template(html)({list: data}));
                isLoading = false;
            })
        });
    }
});


