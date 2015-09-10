/**
 * Created by charles on 15/9/10.
 */

$('.serialno-container').on('click', '.product-property-item', function(){
    $('.serialno-container .product-property-item').removeClass('selected');
    $(this).addClass('selected');
    requestDetail($(this).text());
});

function requestDetail(serialNo){
    var $sizeContainer = $('.size-container');
    $sizeContainer.empty();
    $.get('/henghua/cloth/detail/' + serialNo, function(data){
        var sizes = data.size.split(',');
        for(var i in sizes){
            if(sizes[i]) {
                $sizeContainer.append('<span class="product-property-item animated">' + sizes[i] + '</span>');
            }
        }
    });
}



