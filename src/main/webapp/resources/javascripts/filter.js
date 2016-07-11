/**
 * Created by charles on 15/9/7.
 */
//筛选功能
var filterConfig = {};
var filters = {};
$(document).ready(function(){
    $.get(filterConfig.filterTypeUrl, function(res){
        new Vue({
            el: '#filter',
            data: {
                filters: res,
                materialTypes: materialTypes,
                fabrics: fabrics
            },
            methods: {
                toggleMenuItem: function(event){
                    $('.filter-category-item a.opened').removeClass('opened');
                    $(event.target).addClass('opened');
                },
                toggleFilter: toggleFilter,
                search: search,
                clearAll: clearAll
            },
            ready: function(){
                $('.filter-category-item').on('click', 'input[type=checkbox]', function(){
                    sinceId = 0;
                    filters = {};
                    var multiSelect = $(this).data('multi')!=undefined;
                    //if(filterConfig.multi) {
                    if(!multiSelect) {
                        $(this).closest('li').siblings().find('input[type=checkbox]').attr('checked', false);
                    }
                    initFilters();
                    if(isLoading) {
                        return;
                    }

                    if(!multiSelect) {
                        search();
                    }
                });
                initFilters();
            }
        });
    });
});

$(document).click(function(e){
    if($(e.target).closest('.filter-bar').length == 0) {
        closeFilter();
    }
});
function initFilters(){
    $('.filter-category-item input[type=checkbox]:checked').each(function(i, e){
        var arr = $(e).val().split(','), currentMultiSelect = ($(e).data('multi')!=undefined);
        //if(filterConfig.multi) {
        if(currentMultiSelect){
            if(!filters[arr[0]]) {
                filters[arr[0]] = {value: [arr[1]]}
            } else if (filters[arr[0]].value.indexOf(arr[1]) < 0){
                filters[arr[0]].value.push(arr[1])
            }
            filters[arr[0]].text = arr[2];
        } else {
            filters[arr[0]] = {
                text: arr[2],
                value: arr[1]
            };
        }
    });
    var c = mapToList(filters).length;
    resetFilterCount(c);
    if(c > 0) {
        $('.filter-selected-content').show();
    }else{
        $('.filter-selected-content').hide();
    }
    $('.filter-property').empty();
    for(var k in filters){
        if(filters.hasOwnProperty(k)) {
            $('.filter-property').append('<span class="filter-key">' + filters[k].text + '</span> : <span class="filter-value mr20">' + filters[k].value + '</span>');
        }
    }
}
function closeFilter(){
    toggleFilter(0)
}
function clearAll() {
    closeFilter();
    filters = {};
    materialTypes = fabrics = undefined;
    resetFilterCount(0);
    if (filterConfig.search_url) {
        Loading.open();
        $.get(filterConfig.search_url, {
            keys: keyword?keyword:undefined,
            materialTypes: materialTypes?materialTypes:undefined,
            fabrics:fabrics?fabrics:undefined
        }, function (data) {
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

function search(){
    var url;
    sinceId = 0;
    url = filterConfig.search_url + '?sinceId=' +  sinceId + '&' + mapToList(filters).join('&');

    if(url) {
        Loading.open();
        closeFilter();

        $.get(url, {keys: keyword?keyword:undefined}, function(data){
            Loading.close();
            reRender(data, true, 'search');
            if (!data || data.length == 0) {
                sinceId = 0;
            } else {
                sinceId = data[data.length - 1].id;
            }
            $(document).scrollTop(0);

            initFilters();
            //$('.filter-property').empty();
            //for(var k in filters){
            //    if(filters.hasOwnProperty(k)) {
            //        $('.filter-property').append('<span class="filter-key">' + filters[k].text + '</span> : <span class="filter-value mr20">' + filters[k].value + '</span>');
            //    }
            //}
        });
    }

}

function mapToList(filterMap){
    var result = [];
    for(var k in filterMap){
        if(filterMap.hasOwnProperty(k)) {
            if(k instanceof Array) {
                result.push(k + '=' + filterMap[k].value.join(','));
            } else {
                result.push(k + '=' + filterMap[k].value);
            }
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



function reRender(data, clear, from){
    isLoading = false;
    if(!data || data.length == 0) {
        sinceId = 0;
    }
    if(clear) {
        listView.list = data;
    } else {
        listView.list = listView.list.concat(data);
    }
}

var isLoading = false;
$(document).on('scroll', function(){
    if(filterConfig.search_url) {
        if (isLoading || sinceId == 0) {
            return;
        }
        var height = getClientHeight();
        var theight = getScrollTop();
        var rheight = getScrollHeight();
        var bheight = rheight - theight - height;
        if (bheight <= 1170) {
            isLoading = true;
            $.get(filterConfig.search_url + '?sinceId=' + sinceId + '&' + mapToList(filters).join('&'),{
                keys: keyword?keyword:undefined,
                materialTypes: materialTypes?materialTypes:undefined,
                fabrics:fabrics?fabrics:undefined
            }, function (data) {
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
