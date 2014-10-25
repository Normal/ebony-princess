
ebonyPrincessApp.controller('Controller', function ($scope, $http) {

    $http.get('/projects/AstralJet').success(function(data) {
        $scope.project = data;
    });


// This example adds an animated symbol to a polyline.

var line;

function initialize() {
  var mapOptions = {
    center: new google.maps.LatLng(57, 30),
    zoom: 6,
    mapTypeId: google.maps.MapTypeId.TERRAIN
  };

  window.map = new google.maps.Map(document.getElementById('map-canvas'),
      mapOptions);

  var lineCoordinates = [
    new google.maps.LatLng(59.9160703, 30.3543856),
    new google.maps.LatLng(53.9158179, 27.5930643),
    new google.maps.LatLng(59.9160703, 30.3543856)
  ];

  // Define the symbol, using one of the predefined paths ('CIRCLE')
  // supplied by the Google Maps JavaScript API.
  var lineSymbol = {
    path: google.maps.SymbolPath.CIRCLE,
    scale: 8,
    strokeColor: '#393'
  };

  // Create the polyline and add the symbol to it via the 'icons' property.
  line = new google.maps.Polyline({
    path: lineCoordinates,
    strokeColor: '#FF0000',
    icons: [{
      icon: lineSymbol,
      offset: '100%'
    }],
    map: map
  });

    function setDeveloperLocation (developerLocation){
        var myMarker1 = new google.maps.Marker({position: new google.maps.LatLng(developerLocation.lat, developerLocation.lng), map: map, title:developerLocation.name});
    }

    var showDeveloperLocations = function(data){
        $.each( data.employers_locations, function( i, developerLocation ) {
            setDeveloperLocation(developerLocation);
        })
    };

  function setNewProject(project){
  var icon;
  if(project.status =='red'){
    icon = '/img/pink__marker.png';
  } else {
    icon = '/img/green__marker.png'
  }
  var myMarker1 = new google.maps.Marker({position: new google.maps.LatLng(project.lat, project.lng), map: map,icon:icon, title:project.name});
  google.maps.event.addListener(myMarker1, 'click', function() {
    $.get("/projects/"+project.name).success(showDeveloperLocations);
  });
}


  var showAllProjects = function(data){
  $.each( data, function( i, project ) {
    setNewProject(project);
  })};

  $.get("/projects").success(showAllProjects);

  var myMarker1 = new google.maps.Marker({position: new google.maps.LatLng(59.9160703, 30.3543856), map: map,title:"Hello World!"});
  var myMarker1 = new google.maps.Marker({position: new google.maps.LatLng(53.9158179, 27.5930643), map: map, title:"Hello World!"});

  animateCircle();
}

// Use the DOM setInterval() function to change the offset of the symbol
// at fixed intervals.
function animateCircle() {
    var count = 0;
    window.setInterval(function() {
      count = (count + 1) % 200;
      var icons = line.get('icons');
      icons[0].offset = (count / 2) + '%';
      line.set('icons', icons);
  }, 20);
}



google.maps.event.addDomListener(window, 'load', initialize);

});


