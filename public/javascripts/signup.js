 $(document).ready(function(){

 $('#signUp').on("click",function(){
            /*alert("clicked")*/
                console.log($('#fullName').val())
                console.log("clicked")
                jsRoutes.controllers.SignUpController.addAccount($('#fullName').val(),$('#userName').val(),
                                $('#password').val(),$('#confirmPassword').val(),$('#dateOfBirth').val(),$('#gender').val()).ajax({
                            success: function(data){
                              $('#body').html(data);

                            },
                            error: function(){
                            $('#body').html("hello");
                            alert("fail")
                          }

                })


            })
$('#logout').on("click",function(){

                console.log("clicked")
                jsRoutes.controllers.HomeController.index().ajax({
                            success: function(data){
                              $('#body').html(data);

                            },
                            error: function(){
                            $('#body').html("hello");
                            alert("fail")
                          }

                })


            })

});
