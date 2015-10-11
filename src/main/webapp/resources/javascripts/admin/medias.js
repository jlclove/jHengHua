/**
 * Created by charles on 15/9/18.
 */
var ue;
$(document).ready(function(){
    //初始化
    initView();
    ue = UE.getEditor('editor');
});


//填充表格
function reRender(pageNo){
    $.get('/business/news?type=媒体&pageSize=8&pageNo=' + pageNo, function(res){
        Template.getHtml('admin/medias.html', function(tmpl){
            $('#listContainer').html(_.template(tmpl)(res));
        });
        Template.getHtml('admin/pagination.html', function(tmpl){
            var page = Template.getPage(res.pageNo, res.totalPages);
            $('#pagination').html(_.template(tmpl)(page));
        });
    });
}

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

    $('#addMediasModal').on('show.bs.modal', function(e){
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
                $('#link').val(res.link);
                ue.setContent(res.content);
            });
        }
    }).on('hide.bs.modal', function(){
        $('#form')[0].reset();
        $('#id').val('');
        ue.setContent('');
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

            if(!$('[name=content]').val()){
                //alert('请输入内容');
                ue.focus();
                return;
            }
            var newsId = $('#id').val();
            if(newsId > 0) {
                $.ajax({
                    url: '/business/news/' + newsId,
                    data: $(form).serialize(),
                    type: 'put',
                    success: function(){
                        $(form)[0].reset();
                        $('#addMediasModal').modal('hide');
                        reRender(1);
                    }
                });
            } else {
                $.post('/business/news', $(form).serialize(), function(){
                    $(form)[0].reset();
                    $('#addMediasModal').modal('hide');
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




