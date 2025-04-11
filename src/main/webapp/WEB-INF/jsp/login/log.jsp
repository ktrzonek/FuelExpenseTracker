<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>


<div class="container-fluid">


    <div>
        <h1 class="h3 mb-0 text-gray-800">Log in to your account</h1>
    </div>
    <br>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Enter the details below</h6>
        </div>
        <div class="card-body">

            <form action="/login" method="post">
                <input type="hidden" name="_csrf" value="${_csrf.token}">  <!-- token CSRF -->

                <div class="form-group">
                    <label for="email">Login</label>
                    <input name="email" type="text" class="form-control" id="email" placeholder="" required>
                </div>
                <div class="form-group">
                    <label for="password">Password</label>
                    <input name="password" type="password" class="form-control" id="password" required>
                </div>

                <button type="submit" class="btn btn-primary">Log in</button>
            </form>
            <br>
            <a href="/addUser" class="btn btn-secondary">Add New User</a>
        </div>
    </div>

</div>


<%@ include file="../footer.jsp" %>
