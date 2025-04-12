<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../header.jsp" %>


<div class="container-fluid">

    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Error</h1>

    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Given email already exists in the database.</h6>
            <h6 class="m-0 font-weight-bold text-primary">Use a different one or find your profile using the search box at the top of the page.</h6>
        </div>
    </div>
    <button type="button" class="btn btn-secondary mt-3" onclick="window.location.href='<c:url value='/start'/>'">Go Back to Log In</button>
</div>


<!-- /.container-fluid -->
<%@ include file="../footer.jsp" %>


