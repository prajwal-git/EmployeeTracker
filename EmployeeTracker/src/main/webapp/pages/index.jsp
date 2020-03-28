<%-- 
    Document   : index
    Created on : Aug 22, 2018, 10:27:20 PM
    Author     : Jayandra
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<html>

<head>
  <title>Weclome to My First Project</title>
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
        <h1>Welcome to to My Project</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam pellentesque, lorem et euismod tristique, 
            dolor ipsum facilisis turpis, non faucibus risus mauris ut massa. Nulla sollicitudin tortor ut turpis 
            fermentum, eu feugiat tellus accumsan. Praesent ut justo at ante convallis tincidunt. Morbi dictum bibendum 
            lorem vel dictum. Praesent fermentum, sapien quis porta rutrum, magna nisi maximus lacus, sit amet euismod 
            dui nisl quis arcu. Duis porttitor lacus eget nulla volutpat, quis fermentum felis facilisis. Maecenas at 
            imperdiet est, id elementum massa. Nam tincidunt tellus eget malesuada pulvinar. Nunc sodales volutpat est 
            in auctor. Sed nec nibh nibh. Pellentesque habitant morbi tristique senectus et netus et malesuada fames 
            ac turpis egestas. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis 
            egestas. Proin id quam at sapien egestas scelerisque....</p>

      </div>
    </div>
    <!-- Footer-->
   <jsp:include page="includes/footer.jsp"/>
  </div>
</body>
</html>
