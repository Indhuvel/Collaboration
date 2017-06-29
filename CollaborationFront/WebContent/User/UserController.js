app.controller("UserController",["$scope","UserService",function($scope,UserService){
	
	console.log ("UserController")
	$scope.validate=function()
	{
		console.log("USERNAME:"+$scope.username)
		console.log("PASSWORD:"+$scope.password)

		UserService.validate($scope.username,$scope.password)		
	}
	
	
}
])