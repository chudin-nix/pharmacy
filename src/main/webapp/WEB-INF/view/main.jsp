<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
        <style>

        * {
          box-sizing: border-box;
        }

        /* Style the body */
        body {
          font-family: Arial;
          margin: 0;
        }

        /* Header/logo Title */
        .header {
          padding: 60px;
          text-align: center;
          background: #1abc9c;
          color: white;
        }

        /* Style the top navigation bar */
        .navbar {
          display: flex;
          background-color: #333;
        }

        /* Style the navigation bar links */
        .navbar a {
          color: white;
          padding: 14px 20px;
          text-decoration: none;
          text-align: center;
        }

        /* Change color on hover */
        .navbar a:hover {
          background-color: #ddd;
          color: black;
        }

        .user-link {
          color: white;
        /*  padding: 14px 20px;  */
          margin-left: 850px;
          text-decoration: none;
          text-align: center;
        }

        .user-link a:hover {
          background-color: #ddd;
          color: black;
        }



        /* Column container */
        .row {
          display: flex;
          flex-wrap: wrap;
        }

        /* Create two unequal columns that sits next to each other */
        /* Sidebar/left column */
        /*.side {
          flex: 30%;
          background-color: white;
          padding: 20px;
        } */

        .side {
          display: block;
          width: 60px;
        }

        .side {
            display: flex;
            background-color: #333;
        }

        /* Main column */
        .main {
          flex: 70%;
          background-color: white;
          padding: 20px;
        }

        /* Fake image, just for this example */
        .fakeimg {
          background-color: #aaa;
          width: 100%;
          padding: 20px;
        }

        /* Footer */
        /* .footer {
          padding: 20px;
          text-align: center;
          background: #ddd;
        } */


        .footer {
            padding: 48px 0;
            background-color: #ddd;
        }

        .mt-4, .my-4 {
            margin-top: 4px!important;
        }
        article, aside, figcaption, figure, footer, header, hgroup, main, nav, section {
            display: block;
        }
        *, :before, :after {
            box-sizing: border-box;
        }
        *, ::before, ::after {
            box-sizing: border-box;
        }
        user agent stylesheet
        footer {
            display: block;
        }

        .footer--menu ul li {
            list-style: none;
            padding: 5px 0 4px;
            right: 0;
        }

        *, :before, :after {
            box-sizing: border-box;
        }
        *, ::before, ::after {
            box-sizing: border-box;
        }
        user agent stylesheet
        li {
            display: list-item;
            text-align: -webkit-match-parent;
        }

        /* Responsive layout - when the screen is less than 700px wide, make the two columns stack on top of each other instead of next to each other */
        @media screen and (max-width: 700px) {
          .row, .navbar {
            flex-direction: column;
          }
        }
        </style>
        <title>Page Title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
    </head>
    <body>

<!-- Note -->

<!-- Header -->
<div class="header">
  <h1>Онлайн аптека</h1>
</div>

<!-- Navigation Bar -->
<div class="navbar">
  <a href="#">Лекарства</a>
  <a href="#">БАДы</a>
  <a href="#">Рецепты</a>
  <a href="#">О компании</a>
  <a class="user-link" href="#">User: ${sessionScope.user_login}</a>
</div>

<!-- The flexible grid (content) -->
<div class="row">
  <div class="main">
    <table>
        <c:forEach var="item" items="${medicineList}" varStatus="loop">
            <c:if test="${loop.index % 2 == 0}">
                <tr>
            </c:if>
            <td>
            <form method="POST" action="controller?command=buyMedicine">
                <a href="controller?command=medicinePage&id=${item.id}">${item.name}</a><br>
                ${item.price}<br>
                <img src="images/${item.id}.jpg" alt="${item.name}" style="height:200px;"><br>
                <input type="number" size="3" name="quantity" min="1" max="10" value="1"><br>
                <input type="hidden" value="${item.id}" name="medicine_id"/>
                <input type="hidden" value="${sessionScope.user_id}" name="user_id"/>
                <button>Купить</button>
            </form>
            </td>
            <c:if test="${loop.index % 2 != 0 or loop.last}">
                </tr>
            </c:if>
        </c:forEach>
    </table>
    <br>
  </div>
</div>

</body>
</html>