/**
 * Created by charles on 15/9/18.
 */
var countryList = [], currentCountryId;
$(document).ready(function(){
    //初始化
    initView();
});


//填充表格
function reRender(){
    $.get('/store?countryId=' + currentCountryId, function(res){
        console.log(res);
        Template.getHtml('admin/stores.html', function(tmpl){
            $('#listContainer').html(_.template(tmpl)({list: res}));
        });
    });
}

// 初始化界面
function initView(){
    //删除门店
    $(document).on('click', '.stores_delete', function(){
        $.ajax({
            url: '/store/' + $(this).data('id'),
            type: 'delete',
            success: function(){
                reRender(1);
            }
        });
    });

    $('#addStoresModal').on('show.bs.modal', function(e){
        var storeId = $(e.relatedTarget).data('id');
        if(storeId) {
            $.get('/store/' + storeId, function(res){
                $('#id').val(res.id);
                $('#storeName').val(res.storeName);
                $('#address').val(res.address);
                $('#province').val(res.province);
                $('#zipCode').val(res.zipCode);
                $('#phone').val(res.phone);
                $('#picPath').val(res.picPath);
                var workTime1 = res.workTime1 ? res.workTime1.split('-') : ['', ''];
                var workTime2 = res.workTime2 ? res.workTime2.split('-') : ['', ''];
                var workTime3 = res.workTime3 ? res.workTime3.split('-') : ['', ''];
                var workTime4 = res.workTime4 ? res.workTime4.split('-') : ['', ''];
                var workTime5 = res.workTime5 ? res.workTime5.split('-') : ['', ''];
                var workTime6 = res.workTime6 ? res.workTime6.split('-') : ['', ''];
                var workTime7 = res.workTime7 ? res.workTime7.split('-') : ['', ''];
                $('#workTime1From').val(workTime1[0]);
                $('#workTime1To').val(workTime1[1]);
                $('#workTime2From').val(workTime2[0]);
                $('#workTime2To').val(workTime2[1]);
                $('#workTime3From').val(workTime3[0]);
                $('#workTime3To').val(workTime3[1]);
                $('#workTime4From').val(workTime4[0]);
                $('#workTime4To').val(workTime4[1]);
                $('#workTime5From').val(workTime5[0]);
                $('#workTime5To').val(workTime5[1]);
                $('#workTime6From').val(workTime6[0]);
                $('#workTime6To').val(workTime6[1]);
                $('#workTime7From').val(workTime7[0]);
                $('#workTime7To').val(workTime7[1]);
            });
        }
        $('#countryName').text(findCountryName());
        $('#countryId').val(currentCountryId);
    }).on('hide.bs.modal', function(){
        $('#form')[0].reset();
        $('#id').val('');
        $('#picPath').val('');
        $('#filename').text('');
    });


    $('#form').validate({
        rules: {
            storeName: {
                required: true
            },
            address: {
                required: true
            },
            province: {
                required: true
            },
            zipCode: {
                required: true
            },
            phone: {
                required: true
            }
        },
        messages: {
            storeName: {
                required: '请输入门店名'
            },
            address: {
                required: '请输入地址'
            },
            province: {
                required: '请输入省份'
            },
            zipCode: {
                required: '请输入邮编'
            },
            phone: {
                required: '请输入联系电话'
            }
        },
        submitHandler: function(form, e){
            e.preventDefault();

            $('#workTime1').val([$('#workTime1From').val(), $('#workTime1To').val()].join('-'));
            $('#workTime2').val([$('#workTime2From').val(), $('#workTime2To').val()].join('-'));
            $('#workTime3').val([$('#workTime3From').val(), $('#workTime3To').val()].join('-'));
            $('#workTime4').val([$('#workTime4From').val(), $('#workTime4To').val()].join('-'));
            $('#workTime5').val([$('#workTime5From').val(), $('#workTime5To').val()].join('-'));
            $('#workTime6').val([$('#workTime6From').val(), $('#workTime6To').val()].join('-'));
            $('#workTime7').val([$('#workTime7From').val(), $('#workTime7To').val()].join('-'));
            var storeId = $('#id').val();
            if(storeId > 0) {
                $.ajax({
                    url: '/store/' + storeId,
                    data: $(form).serialize(),
                    type: 'put',
                    success: function(){
                        $(form)[0].reset();
                        $('#addStoresModal').modal('hide');
                        reRender();
                    }
                });
            } else {
                $.post('/store', $(form).serialize(), function(){
                    $(form)[0].reset();
                    $('#addStoresModal').modal('hide');
                    reRender();
                });
            }
        }
    });

    // 初始化上传组件
    $('#fileupload').fileupload({
        dataType : 'json',
        done : function(e, data) {
            if (data.result) {
                $('#picPath').val(data.result);
                $('#filename').text(data.files[0].name);
            }
        }
    });

    $.get('/store/country', function(res){
        countryList = res;
        $.each(res, function(i, country){
            $('#country').append('<a href="#" data-value="' + country.id + '" class="list-group-item">' + country.name + '</a>');
        });
        if(countryList && countryList.length > 0) {
            currentCountryId = countryList[0].id;
            $('.list-group-item:first-child').addClass('active');
            reRender();findCountryName()
        }
    });

    $(document).on('click', '.list-group-item', function(e){
        var countryId = $(this).data('value');
        $('.list-group-item').removeClass('active');
        $(this).addClass('active');
        currentCountryId = countryId;
        reRender();
    });
    //reRender(1);

    function findCountryName(){
        var country = _.find(countryList, function(country){
            if(country.id == currentCountryId) {
                return country;
            }
        });
        return country ? country.name : '';
    }
}




