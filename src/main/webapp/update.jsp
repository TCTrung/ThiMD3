<%--
  Created by IntelliJ IDEA.
  User: Le Trinh
  Date: 12/5/2023
  Time: 8:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Student</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="col-12 col-md-12">
        <div class="card">
            <div class="card-header">
                Update Student
            </div>
            <div>
                <c:out value="${message}"></c:out>
            </div>
            <div class="card-body">
                <form action="${pageContext.request.contextPath}/?action=update&id=<c:out value="${student.getId()}"/>" method="post">
                                        <div class="mb-3">
                                            <label for="exampleInputEmail1" class="form-label">Id</label>
                                            <input type="text" name="id" disabled value="<c:out value="${student.getId()}"/>" class="form-control" id="id" aria-describedby="emailHelp">
                                        </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Name</label>
                        <input type="text" name="name" value="<c:out value="${student.getName()}"/>" class="form-control" id="" aria-describedby="emailHelp">
                    </div>
                    <div class="mb-3">
                        <label for="exampleInputEmail1" class="form-label">Email</label>
                        <input type="email" name="email" class="form-control" value="<c:out value="${student.getEmail()}"/>" id="exampleInputEmail1" aria-describedby="emailHelp">
                    </div>
                        <div class="mb-3">
                            <label for="" class="form-label">DateOfBirth</label>
                            <input type="text" name="localDate" value="<c:out value="${student.getLocalDate()}"/>" class="form-control" id="getLocalDate">
                        </div>
                    <div class="mb-3">
                        <label for="" class="form-label">Address</label>
                        <input type="text" name="address" value="<c:out value="${student.getAddress()}"/>" class="form-control" id="address">
                    </div>
                    <div class="mb-3">
                        <label for="" class="form-label">PhoneNumber</label>
                        <input type="text" name="phone" value="<c:out value="${student.getPhoneNumber()}"/>" class="form-control" id="phone">
                    </div>

                    <div class="mb-3">
                        <label for="" class="form-label">Classroom</label>
                        <input type="text" name="classroom" value="<c:out value="${student.getClassroom()}"/>" class="form-control" id="Classroom">
                    </div>
                    <div>
                        <label> Class</label>

                    </div>
                    <button type="submit" class="btn btn-primary">Submit</button>
                    <a href="/home" class="btn btn-info">Cancel</a>
                </form>
            </div>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>
</body>
</html>