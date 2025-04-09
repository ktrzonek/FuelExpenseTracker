<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<div class="container-fluid">

    <div>
        <h1 class="h3 mb-0 text-gray-800">Here you can add fuel expenses for your ${make} ${model}</h1>
    </div>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Enter the details below</h6>
        </div>
        <div class="card-body">

            <form action="/fuelExpense/add" method="post">
                <input type="hidden" name="carId" value="${carId}">

                <div class="form-group">
                    <label for="fuelCost">Fuel cost</label>
                    <input name="fuelCost" type="number" step="any" class="form-control" id="fuelCost" placeholder="" required>
                </div>
                <div class="form-group">
                    <label for="fuelAmount">Fuel amount</label>
                    <input name="fuelAmount" type="number" step="any" class="form-control" id="fuelAmount" required>
                </div>
                <div class="form-group">
                    <label for="date">Date</label>
                    <input name="date" type="date" class="form-control" id="date" required>
                </div>
                <div class="form-group">
                    <label for="pricePerLiter">Price per liter (not required)</label>
                    <input name="pricePerLiter" type="number" step="any" class="form-control" id="pricePerLiter">
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>

            <button type="button" class="btn btn-secondary mt-3" onclick="window.location.href='http://localhost:8080/car/show/' + ${carId}">Go Back</button>

        </div>
    </div>

</div>


<%@ include file="footer.jsp" %>
