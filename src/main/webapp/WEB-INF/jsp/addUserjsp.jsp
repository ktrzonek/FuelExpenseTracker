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

                <button type="submit" class="btn btn-primary">Save</button>
            </form>

        </div>
    </div>

</div>


<%@ include file="footer.jsp" %>
