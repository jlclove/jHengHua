/**
 * Created by charles on 15/9/8.
 */
filterConfig.filterTypeUrl = '/henghua/cloth/type';
filterConfig.search_url = '/henghua/cloth/search';

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
        keys: keyword ? keyword : undefined
    }, function(res){
        listView.list = res;
        sinceId = res[res.length - 1].id;
    })
});