/**
 * Created by charles on 15/9/12.
 */
(function (w, $) {
    var $layer = $('<div class="loading-container" style="display: none;"><i class="fa fa-spinner fa-spin"></i></div>');
    var Loading = {
        open: function () {
            $('.product-wrap').append($layer);
            $layer.show();
        },

        close: function(){
            $layer.hide();
            setTimeout(function(){
                $layer.remove();
            }, 0);
        }
    };

    w['Loading'] = Loading;
})(window, $);
