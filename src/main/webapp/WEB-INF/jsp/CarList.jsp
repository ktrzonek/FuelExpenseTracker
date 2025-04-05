<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>


<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">All of your cars are listed below</h1>
<%--        <a href="<c:url value="/user/add"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">--%>
<%--            <i class="fas fa-download fa-sm text-white-50"></i> Dodaj użytkownika</a>--%>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">List of cars for ${email}</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Make</th>
                        <th>Registration number</th>
                        <th>Action</th>

                    </tr>
                    <c:forEach items="${cars}" var="car">
                        <tr>
                            <td>${car.id}</td>
                            <td>${car.make}</td>
                            <td>${car.registrationNumber}</td>
                            <td>


                                    <%--                                <a href='<c:url value="/user/delete?id=${user.id}"/>'>Usuń</a>--%>
                                    <%--                                <a href='<c:url value="/user/edit?id=${user.id}"/>'>Edit</a>--%>
                                    <%--                                <a href='<c:url value="/user/show?id=${user.id}"/>'>Pokaż</a>--%>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>
</div>


<!-- /.container-fluid -->
<%@ include file="footer.jsp" %>


