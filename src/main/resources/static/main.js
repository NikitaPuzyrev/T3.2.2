/**
 *
 */

$('document').ready(function () {

    $('.table .btn').on('click',function (event) {

        event.preventDefault();

            var href= $(this).attr('href');

             $.get(href, function(user){
                  $('#IdEdit').val(user.id);
                  $('#ActiveEdit').val(user.active);
                  $('#UserNameEdit').val(user.username);
                  $('#PasswordEdit').val(user.password);
              /*    $('#RoleEdit').val(user.roles);*/
            });

        $('#editModal').modal();

    });

    $('.table #deleteButton').on('click',function(event){
        event.preventDefault();
        var href= $(this).attr('href');

        $.get(href, function(user){
            $('#IdDel').val(user.id);
            $('#ActiveDel').val(user.active);
            $('#UserNameDel').val(user.username);
            $('#PasswordDel').val(null);
            $('#RoleDel').val(user.roles);
        });

        $('#deleteModal').modal();
    });
});