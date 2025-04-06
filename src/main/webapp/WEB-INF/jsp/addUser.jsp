<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<div class="container-fluid">

    <div>
<%--        <h1 class="h3 mb-0 text-gray-800">FuelExpenseTracker</h1>--%>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Please enter your personal details</h6>
        </div>
        <div class="card-body">

            <form action="/user/add" method="post">
                <div class="form-group">
                    <label for="firstName">First name</label>
                    <input name="firstName" type="text" class="form-control" id="firstName" placeholder="" required>
                </div>
                <div class="form-group">
                    <label for="lastName">Last name</label>
                    <input name="lastName" type="text" class="form-control" id="lastName" required>
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input name="email" type="email" class="form-control" id="email" required>
                </div>
                <div class="form-group">
                    <label for="make">Make</label>
                    <input name="make" type="text" class="form-control" id="make" placeholder="" required>
                </div>
                <div class="form-group">
                    <label for="model">Model</label>
                    <input name="model" type="text" class="form-control" id="model" required>
                </div>
                <div class="form-group">
                    <label for="registrationNumber">Registration number</label>
                    <input name="registrationNumber" type="text" class="form-control" id="registrationNumber" required
                           pattern=".{5,9}" title="Registration number must be between 5 and 9 characters"
                           oninput="this.value = this.value.toUpperCase()">
                </div>
<%--                <div class="form-group">--%>
<%--                    <label for="fuelType">Fuel type</label>--%>
<%--                    <input name="fuelType" type="text" class="form-control" id="fuelType" required>--%>
<%--                </div>--%>

                <div class="form-group">
                    <label for="fuelType">Fuel type</label>
                    <div>
                        <input type="radio" id="petrol" name="fuelType" value="Petrol" required>
                        <label for="petrol">Petrol</label>
                    </div>
                    <div>
                        <input type="radio" id="diesel" name="fuelType" value="Diesel" required>
                        <label for="diesel">Diesel</label>
                    </div>
                    <div>
                        <input type="radio" id="lpg" name="fuelType" value="LPG" required>
                        <label for="lpg">LPG</label>
                    </div>
                </div>


                <button type="submit" class="btn btn-primary">Save</button>
            </form>
            <button type="button" class="btn btn-secondary mt-3" onclick="history.back()">Go Back</button>

        </div>
    </div>

</div>


<%@ include file="footer.jsp" %>
