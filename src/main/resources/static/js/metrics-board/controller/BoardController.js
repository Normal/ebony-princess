
ebonyPrincessApp.controller('BoardController', function ($scope, $http) {

    var greenProject = {
        status: 'green',
        name: 'Green Project',
        code: 'GR-EEN',
        ep_metrics: {
            ciExists: true,
            buildStatus: 'Building',
            buildTime: 2,
            unitTestsCoverage: 80,
            numLocations: 2,
            criticalCodeViolations: 0
        }
    }

    var redProject = {
        status: 'green',
        name: 'Red Project',
        code: 'RED',
        ep_metrics: {
            ciExists: false,
            buildStatus: 'None',
            buildTime: 'None',
            unitTestsCoverage: 18,
            numLocations: 8,
            criticalCodeViolations: 7
        }
    }

    $http.get('/projects/AstralJet').success(function(data) {
        $scope.project = data;
    });
});