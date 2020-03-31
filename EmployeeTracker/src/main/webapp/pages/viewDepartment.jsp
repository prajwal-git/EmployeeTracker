
<%-- 
    Document   : index
    Created on : Aug 22, 2018, 10:27:20 PM
    Author     : Jayandra
--%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
  <title>Department List</title>
 <!-- Head file-->  
 <jsp:include page="includes/headInclude.jsp" />
</head>

<body>
  <div id="main">
    <!--  header file--> 
    <jsp:include page="includes/header.jsp"/>
    <div id="site_content">
        <!-- Side Bar-->
        <jsp:include page="includes/rightCol.jsp"/>
      <div id="content">
        <!-- insert the page content here -->
        <h1>Department List</h1>

       <!-- Button-->
       <input type="button" value="Add Department" 
              onclick="window.location.href='showFormDepartment'"
              class ="add-student-button"/>
 
           <table>
            <tr id="tableBar">
                <th>Id</th>
                <th>Name</th>
                <th>Action</th>
            </tr>
           <c:forEach var="tempDept" items="${DeptObject}">
           		<!--  Delete Link -->
				<c:url var= "tempDelete" value ="deleteDepartment">
				<c:param name="id" value="${tempDept.did}"/>
				</c:url> 
				<!--  Update Link -->
				<c:url var= "tempUpdate" value ="showFormDepartmentUpdate">
				<c:param name="id" value="${tempDept.did}"/>	
				</c:url>
				
           <tr>
                <td>${tempDept.did}</td>
                <td> ${tempDept.deptName}</td>
               
                <td><a href="${tempUpdate}">Update</a> | <a href="${tempDelete}" onclick="if(!(confirm('Continue to Delete'))) return false">Delete</a></td>
            </tr>
           
           </c:forEach>
        </table>
      

      </div>
    </div>
    <!-- Footer-->
    <jsp:include page="includes/footer.jsp"/>
  </div>
</body>
</html>



