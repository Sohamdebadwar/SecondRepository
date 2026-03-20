<%@ page language="java" contentType="text/html; charset=ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head><title>Booking Details</title></head>
<body>
<center>
  <h2>Train Ticket Booking Details</h2>
  <table border="1" cellpadding="10">
    <tr><th>Detail</th><th>Value</th></tr>
    <tr><td>Source</td><td>${source}</td></tr>
    <tr><td>Destination</td><td>${dest}</td></tr>
    <tr><td>Passenger</td><td>${name}</td></tr>
    <tr><td>Age</td><td>${age}</td></tr>
    <tr><td>Phone</td><td>${phone}</td></tr>
    <tr><td>Train</td><td>${train}</td></tr>
    <tr><td>No. of Passengers</td><td>${nop}</td></tr>
    <tr><td>Gender</td><td>${gender}</td></tr>
    <tr><td>Class Type</td><td>${classType}</td></tr>
    <tr><td>Seat Type</td><td>${seat}</td></tr>
    <tr><td>Berth No</td><td>${berth}</td></tr>
    <tr><td>Facilities</td>
      <td>
        <c:forEach var="f" items="${facilities}">
          ${f} <br>
        </c:forEach>
      </td>
    </tr>
    <tr><td>Total Price</td><td>Rs. ${total}</td></tr>
  </table>

</body>
</html>
