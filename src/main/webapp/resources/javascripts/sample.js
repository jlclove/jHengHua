/**
 * Created by charles on 15/9/8.
 */
filterConfig.filterTypeUrl = '/henghua/sample/type';
filterConfig.search_url = '/henghua/sample/search';

var sinceId = 0;
var listView;
$(document).ready(function(){
    listView = new Vue({
        el: '#list',
        data: {
            list: undefined
        }
    })
    $.get(filterConfig.search_url, {
        keys: keyword ? keyword : undefined,
        materialTypes: materialTypes?materialTypes:undefined,
        fabrics:fabrics?fabrics:undefined
    }, function(res){
        listView.list = res;
        sinceId = res[res.length - 1].id;
    })
});
