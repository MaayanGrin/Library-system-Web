<%-- 
    Document   : addbook
    Created on : 06/02/2018, 11:31:05
    Author     : Maayan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link href="css.css" type="text/css" rel="Stylesheet">
        <title>Add Book</title>
    </head>
    <body>
                <div class="heads"  id="headerDiv" style="background:#ef027d">
            <h>Welcome to the library </h>
        </div>
        
        <div id="middle" style="height: 600px; width: 100%; margin-top: 10px;">
            
         <div id="navigationDiv" class="navigationDiv">

             <form action="AddStudent.jsp" method="post">
            <input type="submit" value="Add Student" class="myButton"/> 
                </form>
            <form action="showstudent" method="post">
            <input type="submit" value="Show Student" class="myButton"/> 
                </form>
             <form action="addbook.jsp" method="post">
            <input type="submit" value="Add Book" class="myButton"/> 
                </form> 
            <form action="removebook.jsp" method="post">
            <input type="submit" value="Remove Book" class="myButton"/> 
                </form>           
            <form action="showbook" method="post">
            <input type="submit" value="Show Book" class="myButton"/> 
                </form>
                <form action="searchpage.jsp" method="post">
            <input type="submit" value="Search Book" class="myButton"/> 
                </form>
            <form action="getcatego" method="post">
            <input type="submit" value="Borrow Book" class="myButton"/> 
                </form>
            <form action="returnbook.jsp" method="post">
            <input type="submit" value="Return Book" class="myButton"/> 
                </form>
            <form action="showborrow" method="post">
            <input type="submit" value="Show Borrow" class="myButton"/> 
                </form>
                <form action="pay.jsp" method="post">
            <input type="submit" value=" pay penalty" class="myButton"/> 
                </form>
        
        </div>
          
            <div id="contentDiv" class="contentDiv"style="background: window">
            <form action="checking_detaild_book" method="POST">
            <div class="fontpage">
            <div style="color:#ef027d; font-size:50px; margin-top:10px ;text-align: left">
            <h>Add Book</h><br/>
            </div>
                ISBN(5 numbers): <input type="number"  maxlength="5" name="isbn" /><br/>
                   Name Book: <input type="text" name="namebook" /><br/>                    
                   author: <input type="text" name="author"/></br>
                   category: <input type="text" name="category"/></br>
                   Year of publication:<input type="number" min="1970" max="2018" name="year"/></br>
                   Number of copies per book:<input type="number" min="1" max="20" name="copy"/></br>
                   <br/>
                   <input type="submit" value="addbook" />   
            </div>
            </form>  
        
            </div>
           
            </div>
        
        </div>
               
        <div class="heads"id="header" style="background:#ef027d; font-size:15px; margin-top:10px ">
            <h> C Maayan Grinshtat 2017-2018</h>
        
        </div>
    </body>
</html>
