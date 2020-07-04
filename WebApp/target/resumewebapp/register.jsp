<%--
  Created by IntelliJ IDEA.
  User: virtu
  Date: 6/26/2020
  Time: 11:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="loginregister/fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="loginregister/css/style.css">
    <script>


        function changeVisibility() {
            var btnSearch=document.getElementById("signup");
            if (btnSearch.visible){
            btnSearch.visible=false;
            document.getElementById("signup").style.visibility = "hidden";

            }else {
                btnSearch.visible=true;
                document.getElementById("signup").style.visibility = "visible";
            }
        }

        function resetElement() {

        }
    </script>
</head>
<body>


<div class="main">
    <%

        String username=(String)request.getAttribute("username");
        String password=(String) request.getAttribute("password");
        String mesaj=(String) request.getAttribute("mesaj");
        if (mesaj==null||mesaj.equals("")||mesaj.isEmpty()){
            mesaj="";
        }
        if (username==null||username.equals("")||username.isEmpty()){
            username="username";
        }
        if (password==null||password.equals("")||password.isEmpty()){
            password="password";
        }


        String salam= (String) request.getAttribute("null");
        if (salam==null){
            salam="";
        }

    %>
    <!-- Sign up form -->
    <section class="signup">
        <div class="container">
            <div class="signup-content">
                <div class="signup-form">
                    <h2 class="form-title">Sign up</h2>
                    <form method="POST" class="register-form" id="register-form" action="register">
                        <div class="form-group">
                            <span style=" color: #e72734"><%=salam%></span>
                            <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="username" id="name" placeholder="<%=username%>"/>
                        </div>
                        <div class="form-group">
                            <label for="email"><i class="zmdi zmdi-email"></i></label>
                            <input type="email" name="email" id="email" placeholder="Your Email"/>
                        </div>
                        <div class="form-group">
                            <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="pass" placeholder="<%=password%>"/>
                        </div>
                        <div class="form-group">
                            <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                            <input type="password" name="re_pass" id="re_pass" placeholder="Repeat your password"/>
                        </div>
                        <div class="form-group">
                            <input type="checkbox" onclick="changeVisibility()" visible="true" name="agree-term" id="agree-term" class="agree-term" />
                            <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                        </div>
                        <div class="form-group form-button">
                            <input type="submit" name="signup" id="signup" class="form-submit" value="Register" style="visibility:hidden"/>
                        </div>
                    </form>
                </div>

                <div class="signup-image">
                    <figure><img src="loginregister/images/signup-image.jpg" alt="sing up image"></figure>
                    <a href="index.jsp" class="signup-image-link">Come back</a>
                </div>
            </div>
        </div>
    </section>

    <!-- Sing in  Form -->


</div>

<!-- JS -->
<script src="loginregister/vendor/jquery/jquery.min.js"></script>
<script src="loginregister/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>
