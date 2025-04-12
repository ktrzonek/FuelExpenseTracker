<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>

<div class="container-fluid">

    <div>
        <h1 class="h3 mb-0 text-gray-800">Here you can add any additional expense for your ${make} ${model}</h1>
    </div>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Enter the details below</h6>
        </div>
        <div class="card-body">

            <form action="/carExpense/add" method="post">
                <input type="hidden" name="carId" value="${carId}">
                <input type="hidden" name="_csrf" value="${_csrf.token}">  <!-- token CSRF -->

                <div class="form-group">
                    <label for="expenseName">Expense name</label>
                    <input name="expenseName" type="text" class="form-control" id="expenseName" placeholder="" required>
                </div>
                <div class="form-group">
                    <label for="date">Date</label>
                    <input name="date" type="date" class="form-control" id="date" required>
                </div>
                <div class="form-group">
                    <label for="carCost">Amount</label>
                    <input name="carCost" type="number" step="any" class="form-control" id="carCost" required>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>

            <button type="button" class="btn btn-secondary mt-3" onclick="window.location.href='http://localhost:8080/car/show/' + ${carId}">Go Back to Car Info</button>

        </div>
    </div>

</div>


<%@ include file="../footer.jsp" %>
