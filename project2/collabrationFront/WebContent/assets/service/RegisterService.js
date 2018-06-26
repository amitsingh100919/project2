app.factory('regService',function($http){
	var userService ={}
	var BASE_URL = "http://localhost:8022/collabrationMiddle/"
		
		userService.register=function(user){
		return $http.post(BASE_URL +"/register",user);
	}
	
	return userService;
})