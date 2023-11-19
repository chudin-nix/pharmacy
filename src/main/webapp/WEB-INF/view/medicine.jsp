<%@ page contentType="text/html; charset=UTF-8" isELIgnored="false" %>
<html>
<head><link rel="stylesheet" href="static/styles/style.css"/></head>
    <body>
    <div class="container">
        <table>
            <tr>
                <th>Name</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Dosage</th>
            </tr>
            <tr>
                <td>${medicine.name}</td>
                <td>${medicine.price}</td>
                <td>${medicine.quantity}</td>
                <td>${medicine.dosage}</td>
            </tr>
        </table>
    </div>
    </body>
</html>
