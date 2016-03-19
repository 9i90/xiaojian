<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<%@ include file="taglib.jsp" %>
<%
String path = request.getContextPath();
String basePath = path+"/";
%>
<!DOCTYPE html>
<html lang="zh-CN" class="ui-mobile">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>文章详情</title>
    <link rel="stylesheet" href="<%=basePath %>css/base.css">
</head>
<body class="ui-mobile-viewport ui-overlay">
<div class="ui-page ui-page-active">
    <div class="ui-header ui-bar-inherit"></div>
    <div class="ui-content">
        <div class="main articlescrap-main">
            <h1 class="article-title">${info.title }</h1>

            <p class="article-subtitle"><span class="article-date"><fmt:formatDate value="${info.addtime }" pattern="yyyy-MM-dd"/></span><span
                    class="article-editor">${info.content }</span></p>
        </div>
        asdasdasdas啊实打实大师的撒的阿萨德
        <div class="savebar flex-container">
            <a class="flex-item">
                <i class="icon icon-star"></i>收藏
            </a>
            <a class="flex-item">
                <i class="icon icon-next"></i>下一篇
            </a>
        </div>
        <div class=""></div>
    </div>
    <div class="ui-footer ui-bar-inherit"></div>
</div>
</body>
</html>
