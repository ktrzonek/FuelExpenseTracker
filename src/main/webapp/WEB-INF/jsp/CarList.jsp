<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>


<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Your email: ${email} and ID number: ${userId}</h1>

        <a href="<c:url value='/car/add?userId=${userId}'/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>Add a car</a>
    </div>


    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">All of your cars ${firstName} are listed below</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Make</th>
                        <th>Model</th>
                        <th>Registration number</th>
                        <th>Action</th>

                    </tr>
                    <c:forEach items="${cars}" var="car">
                        <tr>
                            <td>${car.id}</td>
                            <td>${car.make}</td>
                            <td>${car.model}</td>
                            <td>${car.registrationNumber}</td>
                            <td>
                                                <a href="<c:url value='/car/delete/${car.id}?userId=${userId}'/>">Delete</a>
                                                <a href="<c:url value='/car/update/${car.id}?userId=${userId}'/>">Edit</a>
                                                <a href="<c:url value='/car/show/${car.id}'/>">Show</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
<%--    <button type="button" class="btn btn-secondary mt-3" onclick="history.back()">Go Back</button>--%>
    <button type="button" class="btn btn-secondary mt-3" onclick="window.location.href='http://localhost:8080/user/all'">Go to User List</button>
</div>


<!-- /.container-fluid -->
<%@ include file="footer.jsp" %>
