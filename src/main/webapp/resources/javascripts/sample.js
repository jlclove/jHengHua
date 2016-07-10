/**
 * Created by charles on 15/9/8.
 */
filterConfig.filterTypeUrl = '/henghua/sample/type';
filterConfig.multi = true;
filterConfig.list_url = '/henghua/sample';
filterConfig.search_url = '/henghua/sample/search';
filterConfig.template_url = '/static/template/sample.html';
filterConfig.search_template_url = '/static/template/sampleDetailList.html';

var sinceId = 0;
var listView;
$(document).ready(function(){
    listView = new Vue({
        el: '#list',
        data: {
            sampleList: undefined
        }
    })
    $.get(filterConfig.search_url, {
        keys: keyword ? keyword : undefined,
        materialTypes: materialTypes?materialTypes:undefined,
        fabrics:fabrics?fabrics:undefined
    }, function(res){
        listView.sampleList = res;
        sinceId = res[res.length - 1].id;
    })
});
