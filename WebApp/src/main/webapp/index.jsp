
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
</head>
<body>
<%
    String username=(String)request.getAttribute("username");
    String password=(String) request.getAttribute("password");
String mesaj=(String) request.getParameter("msg");
if (mesaj==null||mesaj.equals("")||mesaj.isEmpty()){
    mesaj="";
}
if (username==null||username.equals("")||username.isEmpty()){
    username="username";
}
    if (password==null||password.equals("")||password.isEmpty()){
        password="password";
    }

%>

<div class="main">

    <!-- Sign up form -->

    <!-- Sing in  Form -->
    <section class="sign-in">
        <div class="container">
            <div class="signin-content">
                <div class="signin-image">
                    <figure><img src="loginregister/images/signin-image.jpg" alt="sing up image"></figure>
                    <a href="register" class="signup-image-link">Create an account</a>
                </div>

                <div class="signin-form">
                    <h2 class="form-title">Sign up</h2>
                    <form method="POST" class="register-form" id="login-form" action="index">
                        <span style="color: red"><%=mesaj%></span>
                        <div class="form-group">

                            <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                            <input type="text" name="username" id="your_name" placeholder="<%=username%>"/>
                        </div>
                        <div class="form-group">
                            <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                            <input type="password" name="password" id="your_pass" placeholder="<%=password%>"/>
                        </div>

                        <div class="form-group form-button">
                            <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                        </div>
                    </form>

                </div>
            </div>
        </div>
    </section>

</div>

<!-- JS -->
<script src="loginregister/vendor/jquery/jquery.min.js"></script>
<script src="loginregister/js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>