/**
 * Created by charles on 15/9/7.
 */
$('#filterBtn').click(function(e){
    e.preventDefault();
    toggleFilter();
});

$('.filter-category-item a').click(function(e){
    e.preventDefault();
    $('.filter-category-item a.opened').removeClass('opened');
    $(this).addClass('opened');
});

$(document).click(function(e){
    if($(e.target).closest('.filter-bar').length == 0) {
        closeFilter();
    }
});
function closeFilter(){
    toggleFilter(0)
}
/**
 * 切换筛选框状态
 * @param type 0:关闭, 1:打开
 */
function toggleFilter(type) {
    var $category = $('.filter-category');
    var $filterBtn = $('#filterBtn');
    var distance = $filterBtn.outerHeight();
    var height = $category.outerHeight();

    if(type == 0 || $category.is('.animated')){
        $filterBtn.removeClass('opened');
        $category.css('marginTop', - height + distance);
        $('.filter-category-item a', $category).removeClass('opened');
        setTimeout(function(){
            $category.removeClass('animated');
            $category.hide();
        }, 300);
    } else {
        $filterBtn.addClass('opened');
        $category.css('marginTop', - height + distance);
        $category.show();
        setTimeout(function(){
            $category.addClass('animated');
            $category.css('marginTop', distance);
        }, 10);
    }
}


//筛选功能
var filterConfig = {};
$('.filter-category-item').on('click', 'input[type=checkbox]', function(){
    $(this).closest('li').siblings().find('input[type=checkbox]').attr('checked', false);
    $(this).closest('.filter-category-item').siblings().find('input[type=checkbox]').attr('checked', false);
    closeFilter();
    if(isLoading) {
        return;
    }
    var kv = $(this).val().split(',');
    if(filterConfig.search_url) {
        $.get(filterConfig.search_url + '?filter=' + $(this).val(), function(data){
            reRender(data, true);
            $('.filter-selected-content').show();
            $('.filter-property').html('<span class="filter-key">' + kv[0] + '</span> : <span class="filter-value">' + kv[1] + '</span>');
        });
    }
});

$('.filter-clear').on('click', function(){
    closeFilter();
    if(filterConfig.list_url) {
        $.get(filterConfig.list_url, function (data) {
            if (!data || data.length == 0) {
                sinceId = 0;
                return;
            }
            sinceId = data[data.length - 1].id;
            reRender(data, true);
            $('.filter-category-item input[type=checkbox]').attr('checked', false);
            $('.filter-selected-content').hide();
            $('.filter-property').text('');
        });
    }
});

function reRender(data, clear){
    isLoading = false;
    if(!data) return;
    if(filterConfig.template_url) {
        $.get(filterConfig.template_url, function(html){
            var outerHTML = _.template(html)({list: data});
            if(clear) {
                $('#list').html(outerHTML);
            } else {
                $('#list').append(outerHTML);
            }
        })
    }
}

var isLoading = false;
$(document).on('scroll', function(){
    if(filterConfig.list_url) {
        if (isLoading || sinceId == 0) {
            return;
        }
        var height = getClientHeight();
        var theight = getScrollTop();
        var rheight = getScrollHeight();
        var bheight = rheight - theight - height;
        if (bheight <= 1170) {
            isLoading = true;
            $.get(filterConfig.list_url + '?sinceId=' + sinceId, function (data) {
                if (!data || data.length == 0) {
                    sinceId = 0;
                    return;
                }
                sinceId = data[data.length - 1].id;
                reRender(data);
            });
        }
    }
});
