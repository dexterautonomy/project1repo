/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(test);

function test()
{
    /*if username field has value but the username already exists in the database*/
    $('#test_User').focusout(function(event)
    {
        if(event.target===this)
        {
            if($(this).val()!=='')
            {
                $.get('user_Test?sent='+ $(this).val(), function(data)
                {
                    if(data==='exists')
                    {
                        /*$('#ajax_Username').addClass('unmatched');*/
                        $('#user_Info').html('Username already taken');
                    }
                    else
                    {
                        $('#user_Info').html('');
                    }
                });
            }
        }
    });
    
    $('#test_Email').focusout(function(event)
    {
        if(event.target===this)
        {
            if($(this).val()!=='')
            {
                $.get('email_Test?sent='+ $(this).val(), function(data)
                {
                    if(data==='exists')
                    {
                        $('#email_Info').html('E-mail already taken');
                    }
                    else
                    {
                        $('#email_Info').html('');
                    }
                });
            }
        }
    });
    
    $('#test_Pswd').focusout(function(event)
    {
        if(event.target===this)
        {
            if($(this).val()!=='')
            {
                $.get('pswd_Test?sent='+ $(this).val(), function(data)
                {
                    if(data==='less')
                    {
                        $('#pswd_Info').html('Password must be at least 7 characters long');
                    }
                    else
                    {
                        $('#pswd_Info').html('');
                    }
                });
            }
        }
    });
    
    $('#login_User').focusout(function(event)
    {
        if(event.target===this)
        {
            if($(this).val()!=='')
            {
                $.get('user_Test?sent='+ $(this).val(), function(data)
                {
                    if(data==='exists')
                    {
                        $('#login_user_Info').html('');
                    }
                    else
                    {
                        $('#login_user_Info').html('Username is not registered');
                    }
                });
            }
        }
    });
    
    
    
    
    
    
    /*if username field has value but the username already exists in the adminTable database*/
    $('#username_Admin').focusout(function(event)
    {
        if(event.target===this)
        {
            if($(this).val()!=='')
            {
                $.get('adminUsernameCheck?sent='+ $(this).val(), function(data)
                {
                    if(data==='exists')
                    {
                        $(this).addClass('unmatched');
                        $('#admin_Username_Info').text('Username exists');
                    }
                    else
                    {
                        $('#admin_Username_Info').text('Username does not exist');
                    }
                });                
            }
        }
    });
}