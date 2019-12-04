<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.fedex.util.Mappings" %>
<html>
    <head>
        <title>Todo Items</title>
    </head>
    <body>

        <div align="center" cellpadding="5">
            <c:url var="addUrl" value="${Mappings.ADD_ITEM}" />
            <h2><a href="${addUrl}">New Items</a></h2>



            <table border="1">

                <caption><h2>Todo Items</h2></caption>

                <tr>
                    <th>Title</th>
                    <th>Details</th>
                    <th>Deadline</th>
                    <th>ID Number</th>
                    <th>Delete</th>

                </tr>

                <c:forEach var="item" items="${todoData.items}">

                 <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}" >
                    <c:param name="id" value="${item.id}" />
                  </c:url>

                        <tr>
                            <td><c:out value="${item.title}"/></td>
                            <td><c:out value="${item.details}"/></td>
                            <td><c:out value="${item.deadline}"/></td>
                            <td><c:out value="${item.id}"/></td>
                            <td><a href="${deleteUrl}">Delete</a></td>
                        </tr>

                </c:forEach>
            </table>
        </div>


    </body>
</html>