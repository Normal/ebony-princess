
ebonyPrincessApp.controller('Controller', function ($scope, $http) {

    $http.get('/projects/AstralJet').success(function(data) {
        $scope.project = data;
    });
});