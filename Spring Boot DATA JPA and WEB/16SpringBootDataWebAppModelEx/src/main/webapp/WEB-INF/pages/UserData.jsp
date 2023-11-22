<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c">
<html>
    <head>
        <title>WELCOME TO APP</title>
    </head>
    <body>
        <h2>WELCOME TO FIRST APPLICATION</h2>
        <p>
            Id : ${obj.userId} <br/>
            Name : ${obj.userName} <br/>
            Role : ${obj.userRole} <br/>
            Full Data : ${obj} 

        </p>
        <table border=1>
            <tr>
                <th>ID</th>
                <th>NAME</th>
                <th>ROLE</th>
            </tr>
            <c:forEach var="ob" items="${listobj}">
            	<tr>
            		<td>${ob.userId} </td>
            		<td>${ob.userName} </td>
            		<td>${ob.userRole} </td>
            	</tr>
            </c:forEach>
        </table>
       
    </body>
</html>