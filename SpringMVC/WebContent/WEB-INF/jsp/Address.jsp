<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
          html { height: 100%; }
          body { height: 100%; margin: 0; padding: 0; }
          #MapCanvas { height: 90%; }
       </style>
       <script type="text/javascript"
          src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCU2OozEtJ6ZKRdY9wtwFSlIWIpTIdyAbM&sensor=false">
       </script>
       <script type="text/javascript">
          function GetMap() {
             var Latitude = "30.4391959";
             var Longitude = "-97.7587058";
             
             var myLatlng = new google.maps.LatLng(Latitude,Longitude);
             var mapOptions = {
                center: myLatlng,
                zoom: 16,
                mapTypeId: google.maps.MapTypeId.ROADMAP
             }
             
            
             var map = new google.maps.Map(document.getElementById("MapCanvas"),
             mapOptions);
             
             var marker = new google.maps.Marker({
                 position: myLatlng,
                 map: map,
                 title: 'Hello World!'
             });
             
          }
       </script>

</head>
<body onload="GetMap()">
       <h1 style="text-align:center;">Google Map Example</h1>
       <div id="MapCanvas" style="width:100%; height:90%"></div>
    </body>
</html>