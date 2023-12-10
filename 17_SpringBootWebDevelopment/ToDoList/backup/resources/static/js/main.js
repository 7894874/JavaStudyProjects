$(function(){

    const appendTask = function(data){
        var taskCode = '<a href="#" class="task-link" data-id="' +
            data.id + '"><br>' + data.name + '</a><br>';
       $('#task-list')
            .append('<div>' + taskCode + '</div>');
    };

//    //Loading books on load page
//    $.get('/books/', function(response)
//    {
//        for(i in response) {
//            appendBook(response[i]);
//        }
//    });

    //Show adding book form
    $('#show-add-task-form').click(function(){
        $('#task-form').css('display', 'flex');
    });

    //Closing adding book form
    $('#task-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting task
    $(document).on('click', '.task-link', function(){
        var link = $(this);
        var taskId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/todolist/' + taskId,
            success: function(response)
            {
                var code = '<span>Описание:' + response.description + '</span><br>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Задание не найдено!');
                }
            }
        });
        return false;
    });

    //Adding task
    $('#save-task').click(function()
    {
        var data = $('#task-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/todolist/',
            data: data,
            success: function(response)
            {
                $('#task-form').css('display', 'none');
                var task = {};
                task.id = response;
                var dataArray = $('#task-form form').serializeArray();
                for(i in dataArray) {
                    task[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendTask(task);
            }
        });
        return false;
    });

        $('#delete-task-form').click(function()
        {
            var data = $('#task-form form').serialize();
            $.ajax({
                method: "DELETE",
                url: '/todolist/remove/',
                data: data,
                success: function(response)
                {
                    $('#task-form').css('display', 'none');
                    var task = {};
                    task.id = response;
                    var dataArray = $('#task-form form').serializeArray();
                    for(i in dataArray) {
                        task[dataArray[i]['name']] = dataArray[i]['value'];
                    }
                 //   appendTask(task);
                }
            });
            return false;
        });

});