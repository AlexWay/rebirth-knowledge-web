<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/../includeBase.jsp"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>相册编辑</title>
<link href="${path }css/reset.css" rel="stylesheet" />
<link href="${path }css/globel.css" rel="stylesheet" />
<script type="text/javascript" src="${path }js/banner.js"></script>
</head>
<body>
<div class="warp">
<div class="av">
	<div class="top">
    <div class="right">
          <div class="top_tool">
            <ul>
              <li id="tool_1"><a>装扮</a></li>
              <li id="tool_2"><a>设置</a></li>
              <li id="tool_3"><a>消息
                <ul id="xinxi">
                  <li><label><a href="http://www.baidu.com" target="_blank">查看信箱</a></label>(<span>22</span>)</li>
                  <li><a>查看私信</a>(<span>33</span>)</li>
                  <li><a>系统通知</a>(<span>44</span>)</li>
                </ul>
                </a></li>
              <li id="tool_4"><a href="#">登录</a></li>
              <li id="tool_5"><a href="#">退出</a></li>
            </ul>
          </div>
          <div class="clear"></div>
        </div>
    </div>
</div>
    <div class="head">
      <div class="top">
        <div class="left">
          <div class="logo"><a href="http://www.baidu.com"><img src="${path }images/logo.jpg" /></a></div>
        </div>
        <div class="middle">
            <div class="search">
                <input type="text" value="输入关键字" class="focus1" />
                <span><input type="button" value="搜索" /></span><br />
                <div class="clear"></div>
                <ul>
                  <li><a href="#">新闻</a></li>
                  <li><a>奥运</a></li>
                  <li><a>音乐</a></li>
                  <li><a>视频</a></li>
                  <li><a>美图</a></li>
                  <li><a>交友</a></li>
                  <li><a>美图</a></li>
                  <li><a>交友</a></li>
                  <li><a>美图</a></li>
                  <li><a>奥运</a></li>
                  <li><a>音乐</a></li>
                  <li><a>视频</a></li>
                  <li><a>美图</a></li>
                </ul>
              </div>
        </div> 
      </div>
      <div class="clear"></div>
    </div>
    <div class="nav">
        <ul>
           <li><a href="${path } ">首 页</a>|</li>
          <li><a href="${path }libiary">社区阅览室</a>|</li>
          <li><a href="${path }blogMaster">博文达人</a>|</li>
          <li><a href="${path }study" class="active">我的书房</a>|</li>
          <li><a href="${path }circle">圈 子</a>|</li>
          <li><a href="${path }resourceCenter">企业资源中心</a></li>
        </ul>
      </div>
    <div class="bianji">
        <div class="bianji_con">
        	<div class="bianji_tit">
            	<ul class="t0">
                	<li style="margin-left:10px"><a><img src="${path }images/Edit/fb.png" /></a></li>
                    <li><a><img src="${path }images/Edit/qx.png" /></a></li>
                    <li><a><img src="${path }images/Edit/bccg.png" /></a></li>
                </ul>
                <div class="clear"></div>
                <ul class="t1">
                	<li class="t1_tit"><span>标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;题：</span><input type="text" /></li>
                    <li class="t1_quanxian"><span>阅读权限：</span><select><option>公众公开</option><option>社区公开</option><option>企业公开</option><option>好友公开</option><option>密友公开</option><option>私有</option></select><div><input type="checkbox" />原创投稿</div><div class="nav_quanxian"><select><option>编辑分类</option><option>生 活</option><option>学 习</option><option>娱 乐</option><option>其 他</option></select><ul><li><a>书柜分类</a></li></ul></div></li>
                    <li class="t1_biaoq"><span>标&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;签：</span><input type="text" /><div>博文摘要:<a href="#">添加文章摘要</a>(选填)</div></li>
                </ul>
            </div>	
            <div class="clear"></div>
<style>
.xcbj { width:880px; heig1ht:300px;margin:auto; margin:0 10px; position:relative}
.xcbj h2 { height:25px; line-height:25px; border:1px solid #758793; padding-left:10px; background:#CCDEEC}
.xcbj_con {border: 1px solid #758793;margin: 3px 0;width: 878px;}
.xcbj h3 { height:30px; line-height:30px; border:1px solid #758793; padding-left:12px; background:#CCDEEC; border-bottom:none}
.xcbj h3 a { float:left; margin:0 3px; margin-top:5px}
.xcbj_con ul {}
.xcbj_con ul li { width:138px; height:170px;float:left; margin:17px; margin-bottom:10px}
.xcbj_con ul li img {width:138px; height:148px;}
.pho_title { width:136px; height:20px; line-height:20px; text-align:center;border: 1px dashed #CCCCCC;}
.tjxp { width:410px;border:1px solid #F4E4B0; position:absolute; top:60px; background:#fff; display:none;}
.tjxp h2 { width:399px; height:25px; line-height:25px; background:#F9FBFB;border:1px solid #758793; border-bottom:none;position:relative}
.tjxp h2 a { background:url(images/close1.gif) no-repeat; padding:0px 8px; position:absolute; right:4px; top:6px}
.tjxp_con { margin:20px 0 10px 30px;}
#ta3 {}
#ta3 li { height:auto;width:350px; margin:3px 0;}
#ta3 li span { float:left;margin-right:5px; height:20px; line-height:20px}
#ta3 li textarea { float:left; width:260px; height:60px}
#ta3 li input { float:left; width:150px; height:15px; margin-right:10px}
#ta3 li a img{ width:auto; height:auto}
</style>
            <div class="xcbj">
            <h2>相册描述</h2>
             <div class="xcbj_con">
             <h3><a href="#" class="sc1"><img src="${path }images/sc11.png" /></a><a href="#"><img src="${path }images/sc22.png" /></a></h3>
             <ul>
             	<li>
                <img src="images/tx/05.jpg" />
                <p class="pho_title">逗你玩儿</p>
                </li>
                <li><img src="${path }images/tx/06.jpg" /><p class="pho_title">逗你玩儿</p></li>
                <li><img src="${path }images/tx/07.jpg" /><p class="pho_title">逗你玩儿</p></li>
                <li><img src="${path }images/tx/08.jpg" /><p class="pho_title">逗你玩儿</p></li>
                <li><img src="${path }images/tx/09.jpg" /><p class="pho_title">逗你玩儿</p></li>
                <li><img src="${path }images/tx/10.jpg" /><p class="pho_title">逗你玩儿</p></li>
                <li><img src="${path }images/tx/08.jpg" /><p class="pho_title">逗你玩儿</p></li>
             </ul>
             <div class="clear"></div>
             <div class="tjxp">
             <h2>添加相片<a href="#" class="closeMe">&nbsp;</a></h2>
             <div class="tjxp_con">
             	<ul id="ta3">
                	<li><span>相片名称:</span><input type="text" /></li>
                    <li><span>相片描述:</span><textarea></textarea></li>
                    <li><span>本地文件:</span><input type="text" /><a href="#"><img src="images/ll1.png" /></a>
                    <a href="#"><img src="${path }images/sc1.png" /></a></li>
                </ul>
                <div class="clear"></div>
             </div>
             </div>
             <script type="text/javascript">
             $(document).ready(function(e) {
				 $(".sc1").click(function(){
					$(".tjxp").show();
				 });
                $(".closeMe").click(function(){
					$(".tjxp").hide();
				});
            });
             </script>
             </div>
             <div class="clear"></div>
            </div>
           <div class="clear"></div>
        </div>
    </div>
    <div class="clear"></div>
    <div class="foot">
    	<div class="nav_btm">
        	<ul>
            	<li><a href="#">服务条款</a>|</li>
                <li><a href="#">设博文馆为首页</a>|</li>
                <li><a href="#">留言交流</a>|</li>
                <li><a href="#">联系我们</a>|</li>
                <li><a href="#">友情链接</a>|</li>
                <li><a href="#">管理平台</a></li>
            </ul>
        </div>
        <div class="banq">
        	<div class="lin1">主办单位：福建省民政厅 中国电信福建公司</div>
            <div class="lin2">[电信及增值业务经营许可证：闽ICP备11020745号]</div>
            <div class="lin3">Copyright© 2007—2011 中国电信福建分公司 版权所有互联网违法和不良信息举报中心</div>
        </div>
    </div>
</div>
</body>
</html>