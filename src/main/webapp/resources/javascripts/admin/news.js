/**
 * Created by charles on 15/9/18.
 */

//表格数据模板
var tmpl =
    '<%_.forEach(list, function(news){%>' +
        '<tr>' +
        '<td><%=news.id%></td>' +
        '<td><%=news.title%></td>' +
        '<td><a href="<%=news.link%>" target="_blank"><%=news.link%></td>' +
        '<td><%=news.createTime%></td>' +
        '<td><%=news.createUserId%></td>' +
        '<td>' +
        '<a href="#" class="mr10 news_view" data-id="<%=news.id%>">查看</a>' +
        '<a href="#" class="mr10 news_edit" data-id="<%=news.id%>">编辑</a>' +
        '<a href="#" class="mr10 news_delete" data-id="<%=news.id%>">删除</a>' +
        '</td>' +
        '</tr>' +
    '<%})%>';

//填充表格
function reRender(pageNo){
    $.get('/business/news?type=新闻&pageSize=10&pageNo=' + pageNo, function(res){
        $('#listContainer').html(_.template(tmpl)(res));
    });
}

//删除新闻
$(document).on('click', '.news_delete', function(){
    $.ajax({
        url: '/business/news/' + $(this).data('id'),
        type: 'delete',
        success: function(){
            reRender(1);
        }
    });
});

//初始化第一页数据
reRender(1);
