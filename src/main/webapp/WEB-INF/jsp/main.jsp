<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="QST" uri="http://itshixun.com/page" %>
<%
	String basePath = request.getContextPath()+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/dashboard.css" rel="stylesheet">
<link href="css/bootstrap-datetimepicker.min.css" rel="stylesheet" media="screen">
<title>后台管理</title>
</head>
<body>
    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="">SSM-FENGJJ</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
          	<li><a href="#"><%=new java.util.Date().toLocaleString()%></a></li>
            <li><a href="">${sessionScope.CUSTOMER_SESSION.username}</a></li>
            <li><a href="">退出</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
          	<li>
          	<form>
            <div class="col-lg-14">
			    <div class="input-group">
			      <input type="text" class="form-control">
			      <span class="input-group-btn">
			        <button class="btn btn-default" type="button">搜索</button>
			      </span>
			    </div>
			 </div>
          	</form>
          	</li>
          	<li>&nbsp;</li>
            <li class="active"><a href="list.action">客户管理<span class="sr-only">(current)</span></a></li>
            <li><a href="">Reports</a></li>
            <li><a href="">Analytics</a></li>
            <li><a href="">Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="#">Nav item again</a></li>
            <li><a href="#">One more nav</a></li>
            <li><a href="#">Another nav item</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h5 class="page-header">主界面 > 用户信息操作</h5>
          <div class="panel panel-default">
          <div class="panel-body" style="font-size: 12px">
			<!-- 搜索条件表单开始 -->
			<form class="form-inline" method="get" action="list.action">
			  <div class="form-group">
			    <label>用户姓名</label>
			    <input type="text" class="form-control" size="10" name="username" value="${username}">
			  </div>
			  <div class="form-group">
			    <label>性别</label>
			    <select class="form-control" name="gender">
			    	<option value="">请选择</option>
			    	<option value="1" <c:if test="${gender==1}">selected="selected"</c:if>>男</option>
			    	<option value="0" <c:if test="${gender==0}">selected="selected"</c:if>>女</option>
			    </select>
			  </div>
			  <div class="form-group">
			  <div class="input-append date form_date" data-date-format="yyyy-mm-dd">
			   <label>起始日期</label>
			    <input type="text" class="form-control" size="10" name="startBirthday" value="<fmt:formatDate value="${startBirthday}" pattern="yyyy-MM-dd"/>">
				<span class="add-on"><i class="icon-th"></i></span>
			  </div>
			  </div>
			 <div class="form-group">
			  <div class="input-append date form_date" data-date-format="yyyy-mm-dd">
			   <label>结束日期</label>
			    <input type="text" class="form-control" size="10" name="endBirthday" value="<fmt:formatDate value="${endBirthday}" pattern="yyyy-MM-dd"/>">
			  	<span class="add-on"><i class="icon-th"></i></span>
			  </div>
			  </div>
			  <button type="submit" class="btn btn-primary">查询</button>
			</form>
		</div>
		</div>
		<!-- 搜索条件表单结束 -->
		<!-- 新增用户信息 -->
		<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" data-whatever="">新建</button>
		<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
		  <div class="modal-dialog" role="document">
		    <div class="modal-content">
		      <div class="modal-header">
		        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
		        <h4 class="modal-title" id="exampleModalLabel">新增客户信息</h4>
		      </div>
		      <form method="post" action="register.action">
		      <div class="modal-body">
		          <div class="form-group">
		            <label for="recipient-name" class="control-label">用户名:</label>
		            <input type="text" name="username" class="form-control" id="username">
		          </div>
		          <div class="form-group">
		            <label for="message-text" class="control-label">性别:</label>
		            <label class="radio-inline">
					   <input name="gender" type="radio" value="1">男
					</label>
					<label class="radio-inline">
					  <input name="gender" type="radio" value="0">女
					</label>
		          </div>
		          <div class="form-group">
		            <label for="recipient-name" class="control-label">出生日期:</label>
		            <input type="text" name="birthday" class="form-control" id="birthday">
		          </div>
		          <div class="form-group">
		            <label for="recipient-name" class="control-label">兴趣爱好:</label>
		            <label class="checkbox-inline">
					  <input type="checkbox" name="hobby" id="hobby">阅读
					</label>
		            <label class="checkbox-inline">
					  <input type="checkbox" name="hobby" id="hobby">旅游
					</label>
					<label class="checkbox-inline">
					  <input type="checkbox" name="hobby" id="hobby">编码阅读
					</label>
		          </div>
		      </div>
		      <div class="modal-footer">
		        <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
		        <button type="submit" class="btn btn-primary">提交</button>
		      </div>
		      </form>
		    </div>
		  </div>
		</div>
		<!-- 新增用户信息结束 -->
          
          <div class="table-responsive">
            <table class="table table-striped table-hover table-bordered">
              <thead>
                <tr>
                  <th><input type="checkbox"></th>
                  <th>用户名</th>
                  <th>出生日期</th>
                  <th>性别</th>
                  <th>兴趣</th>
                  <th>编辑</th>
                </tr>
              </thead>
              <tbody>
              <c:forEach items="${page.rows}" var="c">
                <tr>
                  <td><input type="checkbox"></td>
                  <td>${c.username}</td>
                  <td><fmt:formatDate value="${c.birthday}" pattern="yyyy-MM-dd"/></td>
                  <td>${c.gender}</td>
                  <td>${c.hobby}</td>
                  <td><a href="">修改</a>&nbsp;<a href="">删除</a></td>
                </tr>
                </c:forEach>
              </tbody>
            </table>
          </div>
          
          
         <nav aria-label="Page navigation" style="text-align:right">
		  <ul class="pagination">
		  	<QST:page url="list.action"></QST:page>
		    <!-- <li class="disabled">
		      <a href="#" aria-label="Previous">
		        <span aria-hidden="true">&laquo;</span>
		      </a>
		    </li>
		    <li class="active"><a href="#">1</a></li>
		    <li><a href="#">2</a></li>
		    <li><a href="#">3</a></li>
		    <li><a href="#">4</a></li>
		    <li><a href="#">5</a></li>
		    <li>
		      <a href="#" aria-label="Next">
		        <span aria-hidden="true">&raquo;</span>
		      </a>
		    </li> -->
		  </ul>
		</nav>
          
          
        </div>
      </div>
    </div>
    <!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/holder.min.js"></script>
	<script type="text/javascript" src="js/bootstrap-datetimepicker.js" charset="UTF-8"></script>
	<script type="text/javascript" src="js/locales/bootstrap-datetimepicker.zh-CN.js" charset="UTF-8"></script>
	<script type="text/javascript">
	$('.form_date').datetimepicker({
        language:  'zh-CN',
        weekStart: 1,
        todayBtn:  1,
		autoclose: 1,
		todayHighlight: 1,
		startView: 2,
		minView: 2,
		forceParse: 0
    });

	$('#exampleModal').on('show.bs.modal', function (event) {
		  var button = $(event.relatedTarget) // Button that triggered the modal
		  var recipient = button.data('whatever') // Extract info from data-* attributes
		  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
		  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
		  var modal = $(this)
		 // modal.find('.modal-title').text('New message to ' + recipient)
		 // modal.find('.modal-body input').val(recipient)
		})
	</script>
</body>
</html>