<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>


<div class="container-fluid">

    <br>
    <div class="d-flex justify-content-end">
        <a href="<c:url value='/user/update/${userId}'/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>Update your profile</a>
    </div>
    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h1 mb-0 text-gray-800"><strong>${firstName}</strong>, here you can see all of your cars</h1>
        <a href="<c:url value='/user/logout'/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>Log out</a>
    </div>

    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex justify-content-between align-items-center">
            <h6 class="m-0 font-weight-bold text-primary">Choose an action to perform</h6>
            <a href="<c:url value='/car/add'/>" class="btn btn-sm btn-primary shadow-sm">
                <i class="fas fa-download fa-sm text-white-50"></i> Add a car
            </a>
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
                        <th></th>

                    </tr>
                    <c:forEach items="${cars}" var="car">
                        <tr>
                            <td>${car.id}</td>
                            <td>${car.make}</td>
                            <td>${car.model}</td>
                            <td>${car.registrationNumber}</td>
                            <td>
                                                <a href="<c:url value='/car/delete/${car.id}'/>">Delete</a>
                                                <a href="<c:url value='/car/update/${car.id}'/>">Edit</a>
                            </td>
                            <td>
                                <button onclick="window.location.href='<c:url value='/car/show/${car.id}'/>'" class="btn btn-primary btn-sm">
                                    Show details
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>


<!-- /.container-fluid -->
<%@ include file="../footer.jsp" %>
