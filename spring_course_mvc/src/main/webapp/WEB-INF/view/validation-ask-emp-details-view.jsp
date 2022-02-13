<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Dear Employee, please enter your details</h2>
<br/>
<br/>
<form:form action="showDetails" modelAttribute="validated_employee" method="post">
    Name <form:input path="name"/>
    <form:errors path="name"/>
    <br/><br/>
    Surname <form:input path="surname"/>
    <form:errors path="surname"/>
    <br/><br/>
    Salary <form:input path="salary"/>
    <form:errors path="salary"/>
    <br/><br/>
<%--    Second Variant - dynamic --%>
    Department <form:select path="department">
        <form:options items="${validated_employee.departments}"/>
    </form:select>
    <br/><br/>

    <%--    Second Variant - dynamic --%>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${validated_employee.carBrands}"/>
    <br/><br/>

    <%--    Second Variant - dynamic --%>
    Foreign Language(s)
    <form:checkboxes path="lanquages" items="${validated_employee.languageList}"/>
    <br/><br/>
    Phone number <form:input path="phoneNumber"/>
    <form:errors path="phoneNumber"/>
    <br/><br/>
    Email <form:input path="email"/>
    <form:errors path="email"/>
    <br/><br/>

    <input type="submit" value="OK"/>
</form:form>
</body>

</html>