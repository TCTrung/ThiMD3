<%--
  Created by IntelliJ IDEA.
  User: Le Trinh
  Date: 12/11/2023
  Time: 9:19 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://code.jquery.com/jquery-3.7.1.min.js" integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo=" crossorigin="anonymous"></script>

    <title>HOME</title>
</head>
<body>
<div class="container">
    <div class="col-12 col-md-12">
        <div class="card">
            <div class="card-header">
                <div class="row">
                    <div class="col-md-12 title-text">
                        <h1 style="text-align: center">Danh Sach Hoc Vien</h1>
                        <a href="?action=create" class="btn btn-success">Add new</a>


                    </div>
                    <%--                    <div class="col-md-4">--%>
                    <%--                        <form action="/list" method="get">--%>
                    <%--                            <input type="text" name="keyword" value="<c:out value="${keyword}"/>">--%>
                    <%--                            <button type="submit">Search</button>--%>
                    <%--                        </form>--%>
                    <%--                    </div>--%>

                </div>


            </div>
            <div class="card-body">
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Name</th>
                        <th scope="col">Email</th>
                        <th scope="col">DateOfBirth</th>

                        <th scope="col">Address</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Classroom</th>
                        <th scope="col">Action</th>
                        <th></th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${listStudents}" var="student">
                        <tr>
                            <td><c:out value="${student.getId()}"/></td>
                            <td><c:out value="${student.getName()}"/></td>
                            <td><c:out value="${student.getEmail()}"/></td>
                            <td><c:out value="${student.getLocalDate()}"/></td>
                            <td><c:out value="${student.getAddress()}"/></td>
                            <td><c:out value="${student.getPhoneNumber()}"/></td>
                            <td><c:out value="${student.getClassroom()}"/></td>

                            <td>
                                <a href="${pageContext.request.contextPath}?action=update&id=<c:out value="${student.getId()}"/>" class="btn btn-primary">Update</a>

                                <a onclick="return confirm('Are you sure?')" href="${pageContext.request.contextPath}?action=delete&id=<c:out value="${student.getId()}"/>" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

</body>
</html>
