/**
 * Created by charles on 15/9/7.
 */
$('#filterBtn').click(function(e){
    e.preventDefault();
    $(this).toggleClass('opened');
    $('.filter-category').toggleClass('opened');
});

$('.filter-category-item a').click(function(e){
    e.preventDefault();
    $('.filter-category-item a.opened').removeClass('opened');
    $(this).addClass('opened');
});

$('.filter-category-item .checkbox').click(function(e){
    //alert($(this).find('input[type=checkbox]').val());
});

$(document).click(function(e){
    if($(e.target).closest('.filter-bar').length == 0) {
        closeFilter();
    }
});
function closeFilter(){
    $('#filterBtn').removeClass('opened');
    $('.filter-category').removeClass('opened');
    $('.filter-category .filter-category-item a').removeClass('opened');
}
