<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-CN" class="ui-mobile">
<head>
	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport"
          content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>文章查询</title>
    <link rel="stylesheet" href="css/base.css">
</head>
<body class="ui-mobile-viewport ui-overlay">
<div class="ui-page ui-page-active">
    <div class="ui-header ui-bar-inherit"></div>
    <div class="ui-content">
        <div class="main">
            <ul class="nav-earn-tabs nav nav-tabs clearfix flex-container">
                <li class="active flex-item"><a>热文</a></li>
                <li class="flex-item"><a>推荐</a></li>
                <li class="flex-item"><a>健康</a></li>
                <li class="flex-item"><a>视频</a></li>
                <li class="flex-item"><a>育儿</a></li>
                <li class="tab-dropdown dropdown">
                    <a class="dropdown-toggle"><i class="icon icon-down"></i></a>
                    <ul class="dropdown-menu">
                        <li class="nav-earn-more"><a>育儿</a></li>
                        <li class="nav-earn-more"><a>育儿</a></li>
                    </ul>
                </li>
            </ul>
            <div class="feed-list">
                <div class="feed-item media">
                    <div class="media-left"><img class="feed-img" src="images/feed.png"></div>
                    <div class="media-body"><p class="feed-summary">有这五大标记才叫真美女，你有吗？</p></div>
                </div>
            </div>
        </div>
    </div>
    <div class="ui-footer ui-bar-inherit"></div>
</div>
</body>
</html>
