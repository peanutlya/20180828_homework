<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/bs/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/common.css">
    <script src="${pageContext.request.contextPath}/bs/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/bs/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/bs/js/holder.min.js"></script>
</head>
<script>
    $(function () {
        $('li:eq(3)').addClass("active");
    })
</script>
<body>
<jsp:include page="top.jsp"></jsp:include>
<div class="container">
    <div class="row">
        <div class="col-md-4">
            <jsp:include page="left.jsp"></jsp:include>
        </div>

        <div class="col-md-8">
            <div id="route">
                <ol class="breadcrumb">
                    <li><a href="#">系统菜单</a></li>
                    <li class="active">所有学生信息查看</li>

                </ol>
            </div>
            <div id="content">
                <form action="${pageContext.request.contextPath}/StudentServlet?op=queryStudent" method="post">
                    <div class="row">
                        <div class="col-md-2">
                            <a class="btn btn-success" href="${pageContext.request.contextPath}/admin/student/addStudent.jsp">添加</a>
                        </div>
                        <div class="col-md-6"></div>
                        <div class="col-md-4">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="姓名" name="name" autofocus="">
                                <span class="input-group-btn">
             				        <button class="btn btn-default" type="submit">搜索</button>
             				      </span>
                            </div><!-- /input-group -->
                        </div>

                    </div>
                </form>
                <table class="table table-bordered table-striped table-hover">
                    <tr>
                        <th>姓名</th>
                        <th>学号</th>
                        <th>年龄</th>
                        <th>籍贯</th>
                        <th>操作</th>
                    </tr>

                    <c:forEach items="${allStuList}" var="stu">
                        <tr>
                            <td>${stu.username}</td>
                            <td>${stu.password}</td>
                            <td>${stu.age}</td>
                            <td>${stu.address}</td>
                            <td>
                                <a class="btn btn-info btn-xs" href="${pageContext.request.contextPath}/StudentServlet?op=edit&id=${stu.id}">编辑</a>
                                <a class="btn btn-danger btn-xs" href="${pageContext.request.contextPath}/StudentServlet?op=delete&id=${stu.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>

                </table>
            </div>
        </div>
    </div>


</div>
<jsp:include page="bottom.jsp"></jsp:include>
</body>
</html>

