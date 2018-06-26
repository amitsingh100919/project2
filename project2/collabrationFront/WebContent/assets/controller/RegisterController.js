app.controller('regCtrl', function($scope,regService) {
	$scope.user={"email":"","password":"","firstname":"","lastname":"","mobile":"","isOnline":false,"isActive":true};
	console.log("In register Controller");
	
	$scope.register=function(){
		userService.register($scope.user).then(
		 function(response){
			alert('Registered successfully.. please login..')
			$location.path('/signin')
		 }
		,function(response){
			$scope.error=response.data  //ErrorClazz object
		})
	}
	
});
