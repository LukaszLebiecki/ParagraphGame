<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <title>Zarejestruj się - Paragraph Game</title>
    <meta charset="UTF-8">
    <meta name="viweport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/main.css">
    <link rel="stylesheet"href="${pageContext.request.contextPath}/styles/forms.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@300;400&display=swap" rel="stylesheet">
</head>

<body>
<nav class="navbar">
    <a href="${pageContext.request.contextPath}" class="logo">
        <i class="far fa-smile"></i>
        ParagraphGame
    </a>
    <h1 class="titleMain">Samotnie przeciwko płomieniom</h1>
    <a href="${pageContext.request.contextPath}/login" class="login-button">Zaloguj</a>
</nav>

<form action="${pageContext.request.contextPath}/signup" method="post" class="user-form">
    <h2 class="user-form-title">Zarejestruj się na ParagraphGame</h2>
    <input name="username" placeholder="Nazwa użytkownika" required>
    <input name="email" placeholder="email" type="email" required>
    <input name="password" placeholder="Hasło" type="password" required>
    <button class="user-form-button">Zarejestruj się</button>
</form>

<footer>ParagraphGame®, developed by Łukasz Lebiecki</footer>
</body>
</html>