/**
 * Created by charles on 15/9/5.
 */
$('.modal').on('hide.bs.modal', function(){
    $('video', $(this))[0].pause();
});
$('.modal').on('shown.bs.modal', function(){
    $('video', $(this))[0].play();
});
$('.fit-classic-type li a').mouseenter(function(){
    $(this).closest('.fit-classic-type').find('li a').removeClass('active');
    $(this).addClass('active');
    $(this).closest('.fit-classic').find('.fit-classic-img').attr('src', $(this).data('preview'));
});
