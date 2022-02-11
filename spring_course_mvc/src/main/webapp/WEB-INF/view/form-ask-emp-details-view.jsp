<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>

<body>
<h2>Dear Employee, please enter your details</h2>
<br/>
<br/>
<form:form action="showDetails" modelAttribute="employee">
    Name <form:input path="name"/>
    <br/><br/>
    Surname <form:input path="surname"/>
    <br/><br/>
    Salary <form:input path="salary"/>
    <br/><br/>
<%--    First Variant - hardcoded--%>
<%--    Department <form:select path="department">--%>
<%--        <form:option value="Information Technology" label="IT"/>--%>
<%--        <form:option value="Human Resources" label="HR"/>--%>
<%--        <form:option value="Sales" label="Sales"/>--%>
<%--    </form:select>--%>

<%--    Second Variant - dynamic --%>
    Department <form:select path="department">
        <form:options items="${employee.departments}"/>
    </form:select>
    <br/><br/>

<%--    First Variant - hardcoded --%>
<%--    Which car do you want?--%>
<%--    BMW <form:radiobutton path="carBrand" value="BMW"/>--%>
<%--    Audi <form:radiobutton path="carBrand" value="Audi"/>--%>
<%--    MB <form:radiobutton path="carBrand" value="Mercedes-Benz"/>--%>
<%--    <br/><br/>--%>

    <%--    Second Variant - dynamic --%>
    Which car do you want?
    <form:radiobuttons path="carBrand" items="${employee.carBrands}"/>
    <br/><br/>

    <%--    First Variant - hardcoded --%>
<%--    Foreign Language(s)--%>
<%--    EN <form:checkbox path="lanquages" value="English"/>--%>
<%--    DE <form:checkbox path="lanquages" value="Deutsch"/>--%>
<%--    FR <form:checkbox path="lanquages" value="French"/>--%>
<%--    <br/><br/>--%>

    <%--    Second Variant - dynamic --%>
    Foreign Language(s)
    <form:checkboxes path="lanquages" items="${employee.languageList}"/>
    <br/><br/>

    <input type="submit" value="OK"/>
</form:form>
</body>

</html>