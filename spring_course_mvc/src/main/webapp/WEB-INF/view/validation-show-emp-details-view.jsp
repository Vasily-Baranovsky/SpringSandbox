<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<body>
<h2>Dear Employee, you are WELCOME!!!</h2>
<br/>
<br/>
<br/>

Your name:    ${validated_employee.name}
<br/>
Your surname: ${validated_employee.surname}
<br/>
Your salary:  ${validated_employee.salary}
<br/>
Your department:  ${validated_employee.department}
<br/>
Your car:  ${validated_employee.carBrand}
<br/>
Language(s):
<ul>
    <c:forEach var="lang" items="${validated_employee.lanquages}">
        <li>${lang}</li>
    </c:forEach>
</ul>
</body>

</html>