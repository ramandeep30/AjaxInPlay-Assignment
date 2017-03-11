$(document).ready(function(){

 $('#signin').on("click",function(){

                console.log($('#fullName').val())
                console.log("clicked")
                jsRoutes.controllers.SignInController.signInForm($('#userName').val()).ajax({
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