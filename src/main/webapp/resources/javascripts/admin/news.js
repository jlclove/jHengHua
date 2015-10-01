/**
 * Created by charles on 15/9/18.
 */

//初始化
initView();

//填充表格
function reRender(pageNo){
    $.get('/business/news?type=新闻&pageSize=8&pageNo=' + pageNo, function(res){
        Template.getHtml('admin/news.html', function(tmpl){
            $('#listContainer').html(_.template(tmpl)(res));
        });
        Template.getHtml('admin/pagination.html', function(tmpl){
            var page = Template.getPage(res.pageNo, res.totalPages);
            $('#pagination').html(_.template(tmpl)(page));
        });
    });
}

var Template = {
    // 模板缓存
    _tmplCache : {},
    // 获取模板
    getHtml: function(url, callback){
        if(this._tmplCache[url]) {
            callback(this._tmplCache[url]);
        } else {
            $.get('/static/template/' + url, function(res){
                callback(res);
                Template._tmplCache[url] = res;
            })
        }
    },
    // 计算分页
    getPage : function(pageNo, totalPages) {
        var show = 2;
        var left = pageNo - show;
        var right = pageNo + show, totalPages;
        if(left < 1) {
            left = 1;
            right = Math.min(right + show - pageNo + 1, totalPages);
        }
        if (right> totalPages){
            right = totalPages;
            left = Math.max(left + (totalPages - (show + pageNo)), 1);
        }
        return {
            left: left,
            right: right,
            pageNo: pageNo,
            totalPages: totalPages
        };
    }
};

// 初始化界面
function initView(){
    $('#pagination').on('click', 'li:not(.disabled) a', function(e){
        e.preventDefault();
        reRender($(this).data('page'));
    })

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

    $('#addNewsModal').on('show.bs.modal', function(e){
        var newsId = $(e.relatedTarget).data('id');
        if(newsId) {
            $.get('/business/news/' + newsId, function(res){
                var newsPicture = {
                    sort: 1,
                    main: true,
                    picPath: res.mainPicPath
                };

                $('#id').val(res.id);
                $('#pics').val(JSON.stringify([newsPicture]));
                $('#title').val(res.title);
                $('#subtitle').val(res.subtitle);
                $('#content').val(res.content);
                $('#link').val(res.link);
            });
        }
    }).on('hide.bs.modal', function(){
        $('#form')[0].reset();
    });


    $('#form').validate({
        rules: {
            title: {
                required: true
            },
            subtitle: {
                required: true
            },
            link: {
                url: true
            },
            content: {
                required: true
            }
        },
        messages: {
            title: {
                required: '请输入标题'
            },
            subtitle: {
                required: '请输入子标题'
            },
            link: {
                url: '请输入正确的网址'
            },
            content: {
                required: '请输入内容'
            }
        },
        submitHandler: function(form, e){
            e.preventDefault();

            var newsId = $('#id').val();
            if(newsId > 0) {
                $.ajax({
                    url: '/business/news/' + newsId,
                    data: $(form).serialize(),
                    type: 'put',
                    success: function(){
                        $(form)[0].reset();
                        $('#addNewsModal').modal('hide');
                        reRender(1);
                    }
                });
            } else {
                $.post('/business/news', $(form).serialize(), function(){
                    $(form)[0].reset();
                    $('#addNewsModal').modal('hide');
                    reRender(1);
                });
            }
        }
    });
    $('#pics').on('change', function(e){
        console.log(this.files);
        $.ajax({
            url: '/business/file',
            enctype : "multipart/form-data",
            data: 'file=file'
        });
    });

    // 初始化上传组件
    $('#fileupload').fileupload({
        dataType : 'json',
        done : function(e, data) {
            if (data.result) {
                var newsPicture = {
                    sort: 1,
                    main: true,
                    picPath: data.result
                };
                $('#pics').val(JSON.stringify([newsPicture]));
                $('#filename').text(data.files[0].name);
                //$('#preview').attr('src', data.result.url);
            }
        }
    });

    reRender(1);
}




