<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="org.fedex.util.Mappings" %>
<html>
    <head>
        <title>Single Todo Item</title>
    </head>
    <body>

        <div align="center" cellpadding="5">

            <table border="1">

                <caption><h2>Individual Todo Item</h2></caption>

                <tr>
                    <th>Title</th>
                    <th>Details</th>
                    <th>Deadline</th>
                    <th>ID Number</th>
                    <th>Edit</th>
                    <th>Delete</th>

                </tr>



                 <c:url var="editUrl" value="${Mappings.ADD_ITEM}" >
                    <c:param name="id" value="${item.id}" />
                 </c:url>

                 <c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}" >
                  <c:param name="id" value="${item.id}" />
                 </c:url>

                        <tr>
                            <td><c:out value="${item.title}"/></td>
                            <td><c:out value="${item.details}"/></td>
                            <td><c:out value="${item.deadline}"/></td>
                            <td><c:out value="${item.id}"/></td>
                            <td><a href="${editUrl}">Edit</a></td>
                            <td><a href="${deleteUrl}">Delete</a></td>
                        </tr>


            </table>

             <c:url var="itemListUrl" value="${Mappings.ITEMS}" />
                        <h2><a href="${itemListUrl}">Items</a></h2>

        </div>


    </body>
</html>