<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<div class="container-fluid">

    <div>
        <h1 class="h3 mb-0 text-gray-800">Please make the changes below</h1>
    </div>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Update your car details</h6>
        </div>
        <div class="card-body">

            <form action="/car/update/${carId}" method="post">
                <input type="hidden" name="carId" value="${carId}">
                <input type="hidden" name="userId" value="${userId}">


                <div class="form-group">
                    <label for="make">Make</label>
                    <input name="make" type="text" class="form-control" id="make" value="${make}">
                </div>
                <div class="form-group">
                    <label for="model">Model</label>
                    <input name="model" type="text" class="form-control" id="model" value="${model}">
                </div>
                <div class="form-group">
                    <label for="registrationNumber">Registration number</label>
                    <input name="registrationNumber" type="text" class="form-control" id="registrationNumber" value="${registrationNumber}"
                           pattern=".{5,9}" title="Registration number must be between 5 and 9 characters"
                           oninput="this.value = this.value.toUpperCase()">
                </div>

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
