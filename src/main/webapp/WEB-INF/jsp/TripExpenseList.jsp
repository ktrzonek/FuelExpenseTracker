<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>


<div class="container-fluid">

    <!-- Page Heading -->
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">A list of expenses for ${tripName}</h1>
        <a href="<c:url value="/tripExpense/add?tripId=${tripId}"/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
            <i class="fas fa-download fa-sm text-white-50"></i>Add new expense</a>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Choose an action to perform</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Expense name</th>
                        <th>Expense amount</th>
                        <th>Action</th>

                    </tr>
                    <c:forEach items="${tripExpenses}" var="tripExpense">
                        <tr>
                            <td>${tripExpense.id}</td>
                            <td>${tripExpense.expenseName}</td>
                            <td>${tripExpense.tripCost}</td>
                            <td>

                                <a href="<c:url value='/tripExpense/delete/${tripExpense.id}?tripId=${tripId}' />">Delete</a>

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


