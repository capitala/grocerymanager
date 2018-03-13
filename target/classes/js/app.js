var app=angular.module('myApp', ['ngResource']);
app.factory("getAvailableItems", function($resource) {
    return $resource("http://localhost:8080/getAvailableItems");
});
/*app.factory("getFinishedItems", function($resource) {
    return $resource("http://localhost:8080/getFinishedItems");
});
app.factory("getHaveToBuyItems", function($resource) {
    return $resource("http://localhost:8080/getHaveToBuyItems");
});
app.factory("getAboutToFinishItems", function($resource) {
    return $resource("http://localhost:8080/getAboutToFinishItems");
});*/
app.controller('formCtrl', function($scope) {
	getAvailableItems.query(function(data) {
	        $scope.groceryItems = data;
	    }, function(err) {
	        console.error("Error occured: ", err);
	    });
});

