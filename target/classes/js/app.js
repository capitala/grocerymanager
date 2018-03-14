var app=angular.module('groceryManager', ['ngRoute']);
app.config(function($routeProvider){
	$routeProvider
	.when("/Finished",{
		templateUrl:"data.html",
		controller:"finishedController"
		
	})
	.when("/AboutToFinish",{
		templateUrl:"data.html",
		controller:"aboutToFinishController"
		
	})
	.when("/Available",{
		templateUrl:"data.html",
		controller:"availableController"
		
	})
	.when("/HaveToBuy",{
		templateUrl:"data.html",
		controller:"haveToBuyController"
		
	})
		.when("/AddGrocery",{
		templateUrl:"add-grocery.html",
		controller:"addGroceryController"
		
	})
	.otherwise({
		redirectTo: '/Available'
	});
	
});
app.controller('availableController', function($scope,$http) {
    $http.get('http://localhost:8080/getAvailableItems').
    then(function(response) {
        $scope.groceryItems = response.data;
    },
    function(err) {
        $scope.message = err.statusText;
    }
    );
});
app.controller('finishedController', function($scope,$http) {
    $http.get('http://localhost:8080/getFinishedItems').
    then(function(response) {
        $scope.groceryItems = response.data;
    },
    function(err) {
        $scope.message = err.statusText;
    }
    );
});
app.controller('aboutToFinishController', function($scope,$http) {
    $http.get('http://localhost:8080/getAboutToFinishItems').
    then(function(response) {
        $scope.groceryItems = response.data;
    },
    function(err) {
        $scope.message = err.statusText;
    }
    );
});
app.controller('haveToBuyController', function($scope,$http) {
    $http.get('http://localhost:8080/getHaveToBuyItems').
    then(function(response) {
        $scope.groceryItems = response.data;
    },
    function(err) {
        $scope.message = err.statusText;
    }
    );
});
app.controller('addGroceryController', function($scope,$http) {

	$scope.addGrocery=function(){
		var config = {
                headers : {
                	'Content-Type': 'application/json',
                	'Accept': 'application/json'
                }
        }
		var data = {
	            name: $scope.grocery.name,
	            price: $scope.grocery.age,
	            quantity:$scope.grocery.quantity
	        };
	    $http.post('http://localhost:8080/addAnItem',data,config).
	    then(function(response) {
	        $scope.groceryItems = response.data;
	    },
	    function(err) {
	        $scope.message = err.statusText;
	    }
	    );
	}
});


