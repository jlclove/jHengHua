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
var filters = {};
$('.filter-category-item').on('click', 'input[type=checkbox]', function(){
    sinceId = 0;
    var kv = $(this).val().split(',');
    if(filterConfig.multi) {
        $(this).closest('li').siblings().find('input[type=checkbox]').attr('checked', false);
    } else {
        $(this).closest('li').siblings().find('input[type=checkbox]').attr('checked', false);
        $(this).closest('.filter-category-item').siblings().find('input[type=checkbox]').attr('checked', false);
    }
    $('.filter-category-item input[type=checkbox]:checked').each(function(i, e){
        var arr = $(e).val().split(',');
        if(filterConfig.multi) {
            filters[arr[0]] = arr[1];
        } else {
            filters[arr[0]] = $(this).val();
        }
    });
    closeFilter();
    if(isLoading) {
        return;
    }

    var url;
    if(!isEmpty(filters)) {
        url = filterConfig.search_url + '?filter=' + mapToList(filters).join(',');
    } else {
        url = filterConfig.list_url;
    }
    // 重置筛选条件数量
    resetFilterCount(mapToList(filters).length);

    if(url) {
        Loading.open();
        $.get(url, function(data){
            Loading.close();
            reRender(data, true, 'search');
            $('.filter-selected-content').show();
            if(filterConfig.multi) {
                $('.filter-property').empty();
                for(var k in filters){
                    if(filters.hasOwnProperty(k)) {
                        $('.filter-property').append('<span class="filter-key">' + k + '</span> : <span class="filter-value mr20">' + filters[k] + '</span>');
                    }
                }
            } else {
                $('.filter-property').html('<span class="filter-key">' + kv[0] + '</span> : <span class="filter-value mr20">' + kv[1] + '</span>');
            }

        });
    }
});

function mapToList(filterMap){
    var result = [];
    for(var k in filterMap){
        if(filterMap.hasOwnProperty(k)) {
            result.push(filterMap[k]);
        }
    }
    return result;
}
function isEmpty(map){
    if(!map) return true;
    for(var k in map){
        return false;
    }
}
function resetFilterCount(count){
    var $filterTip = $('a.filter-item .tip');
    $filterTip.text(count);
    if(count > 0) {
        $filterTip.show();
    } else {
        $filterTip.hide();
    }
}

$('.filter-clear').on('click', function(){
    closeFilter();
    filters = {};
    resetFilterCount(0);
    if(filterConfig.list_url) {
        Loading.open();
        $.get(filterConfig.list_url, function (data) {
            Loading.close();
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

function reRender(data, clear, from){
    isLoading = false;
    if(!data) {
        return;
    }
    if(data.length == 0) {
        sinceId = 0;
    }
    var url;
    if(from == 'search') {
        url = filterConfig.search_template_url ? filterConfig.search_template_url : filterConfig.template_url;
    } else {
        url = filterConfig.template_url;
    }
    if(url) {
        $.get(url, function(html){
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
$.ajaxSettings.error = function(){
    Loading.close();
};
