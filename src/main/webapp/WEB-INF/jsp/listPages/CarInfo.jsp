<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>


<div class="container-fluid">

    <!-- Page Heading -->
    <div>
        <h1 class="h3 mb-0 text-gray-800">On this page you can see all the info about your car</h1>
    </div>
    <br>
    <div>
        <h1 class="h3 mb-0 text-gray-800 font-weight-bold">${make} ${model}, ${registrationNumber}</h1>
        <h1 class="h4 mb-0 text-gray-800">Fuel type: ${fuelType}</h1>
    </div>
    <br>

    <div>
        <form method="get" action="${pageContext.request.contextPath}/car/show/${carId}" class="form-inline mb-3">
            <label for="month" class="mr-2">Filter by month:</label>
            <input type="month" id="month" name="month" class="form-control mr-2" value="${selectedMonth}" />
            <button type="submit" class="btn btn-primary">Filter</button>
        </form>
    </div>
    <br>
    <c:if test="${not empty selectedMonth}">
        <div class="alert alert-info mt-3">
            Now you can see all the trips and expenses for <strong>${selectedMonthFormatted}</strong>.
        </div>
    </c:if>
    <br>

    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex justify-content-between align-items-center">
            <h6 class="m-0 font-weight-bold text-primary">Trips</h6>
            <a href="<c:url value='/trip/add?carId=${carId}'/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                <i class="fas fa-download fa-sm text-white-50"></i>Add a trip</a>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Date</th>
                        <th>Trip name</th>
                        <th>Distance</th>
                        <th>Fuel consumption</th>
                        <th>Action</th>
                        <th></th>

                    </tr>
                    <c:forEach items="${trips}" var="trip">
                        <tr>
                            <td>${trip.id}</td>
                            <td>${trip.date}</td>
                            <td>${trip.tripName}</td>
                            <td>${trip.distance}</td>
                            <td>${trip.fuelConsumption}</td>
                            <td>
                                <a href="<c:url value='/trip/delete/${trip.id}?carId=${carId}'/>">Delete</a>
<%--                                <a href="<c:url value='/trip/show/${trip.id}'/>">Show</a>--%>
                            </td>
                            <td>
                                <button onclick="window.location.href='<c:url value='/trip/show/${trip.id}?carId=${carId}'/>'" class="btn btn-primary btn-sm">
                                    Show trip expenses
                                </button>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
    </div>

    <br>

    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex justify-content-between align-items-center">
            <h6 class="m-0 font-weight-bold text-primary">Fuel expenses</h6>
            <a href="<c:url value='/fuelExpense/add?carId=${carId}'/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                <i class="fas fa-download fa-sm text-white-50"></i>Add fuel expense</a>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Date</th>
                        <th>Fuel amount</th>
                        <th>Expense</th>
                        <th>Price per liter</th>
                        <th>Action</th>

                    </tr>
                    <c:forEach items="${fuelExpenses}" var="fuelExpense">
                        <tr>
                            <td>${fuelExpense.id}</td>
                            <td>${fuelExpense.date}</td>
                            <td>${fuelExpense.fuelAmount}</td>
                            <td>${fuelExpense.fuelCost}</td>
                            <td>${fuelExpense.pricePerLiter}</td>
                            <td>
                                <a href="<c:url value='/fuelExpense/delete/${fuelExpense.id}?carId=${carId}'/>">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div>
                <h1 class="h5 mb-0 font-weight-bold text-primary"> You have spent ${totalFuelExpense} PLN on fuel in total</h1>
                </div>
            </div>
        </div>
    </div>

    <br>

    <div class="card shadow mb-4">
        <div class="card-header py-3 d-flex justify-content-between align-items-center">
            <h6 class="m-0 font-weight-bold text-primary">Car expenses</h6>
            <a href="<c:url value='/carExpense/add?carId=${carId}'/>" class="d-none d-sm-inline-block btn btn-sm btn-primary shadow-sm">
                <i class="fas fa-download fa-sm text-white-50"></i>Add car expense</a>
        </div>

        <div class="card-body">
            <div class="table-responsive">
                <table class="table">
                    <tr>
                        <th>Id</th>
                        <th>Date</th>
                        <th>Name</th>
                        <th>Expense</th>
                        <th>Action</th>

                    </tr>
                    <c:forEach items="${carExpenses}" var="carExpense">
                        <tr>
                            <td>${carExpense.id}</td>
                            <td>${carExpense.date}</td>
                            <td>${carExpense.expenseName}</td>
                            <td>${carExpense.carCost}</td>
                            <td>
                                <a href="<c:url value='/carExpense/delete/${carExpense.id}?carId=${carId}'/>">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </table>
                <div>
                    <h1 class="h5 mb-0 font-weight-bold text-primary"> You have spent ${totalCarExpense} PLN on maintenance of this ${make} in total</h1>
                </div>
            </div>
        </div>
    </div>

    <button type="button" class="btn btn-secondary mt-3" onclick="window.location.href='http://localhost:8080/user/cars/${userId}'">Go to Car List</button>
</div>


<!-- /.container-fluid -->
<%@ include file="../footer.jsp" %>
