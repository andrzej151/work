(function(){
    	var app=angular.module('myApp',[]);

    	app.controller('ProjCon',['$scope', function($scope){
    		$scope.projekty=<?php echo $dane;?>;
    	}]);

})();
    