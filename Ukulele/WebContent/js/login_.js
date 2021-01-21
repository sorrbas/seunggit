


        $(document).ready(function() {
            $('a.login-window').click(function() {

                // Getting the variable's value from a link 
                var loginBox = $(this).attr('href');
                //Fade in the Popup and add close button
               
                $(loginBox).fadeIn(600);

                //Set the center alignment padding + border
                var popMargTop = ($(loginBox).height() + 100) / 2;
                var popMargLeft = ($(loginBox).width() + 100) / 2;
                
                $(loginBox).css({
                    'margin-top': -popMargTop,
                    'margin-left': -popMargLeft
                });

                // Add the mask to body
                $('body').append('<div id="mask"></div>');
                $('#mask').fadeIn(600);

                return false;
            });

            // When clicking on the button close or the mask layer the popup closed
            $('a.close, #mask').live('click', function() {
                $('#mask , .login-popup').fadeOut(300, function() {
                    $('#mask').remove();
                });
                return false;
            });
        });

 
