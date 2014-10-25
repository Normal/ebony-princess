
metricsBoardApp.controller('BoardController', function ($scope) {

    var greenProject = {
        ciExists: true,
        status: 'Building',
        buildTime: 2,
        unitTestsCoverage: 80,
        numLocations: 2
    }

    var redProject = {
        ciExists: false,
        status: 'None',
        buildTime: 'None',
        unitTestsCoverage: 18,
        numLocations: 8
    }

    $scope.project = redProject;
});