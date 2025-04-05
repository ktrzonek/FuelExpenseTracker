<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="header.jsp" %>

<div class="container-fluid">

    <div>
                <h1 class="h3 mb-0 text-gray-800">Hello, ${firstName}</h1>
    </div>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Add your car</h6>
        </div>
        <div class="card-body">

            <form action="/car/addCarToNewUser" method="post">
                <input type="hidden" name="userId" value="${userId}">
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
                    <input name="registrationNumber" type="text" class="form-control" id="registrationNumber" required>
                </div>
                <div class="form-group">
                    <label for="fuelType">Fuel type</label>
                    <input name="fuelType" type="text" class="form-control" id="fuelType" required>
                </div>

                <button type="submit" class="btn btn-primary">Save</button>
            </form>

        </div>
    </div>

</div>


<%@ include file="footer.jsp" %>
