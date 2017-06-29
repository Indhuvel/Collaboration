var app = angular.module("myApp", [ 'ngRoute' ]);

app.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'Home/Home.html'/*index.html'*/	
			})

	.when('/login', {
		templateUrl : 'User/Login.html'

	})
   .when('/register', {
		templateUrl : 'User/Register.html'

	})
	.when('/blog', {
		templateUrl : 'Blog/Blog.html'

	})
	.otherwise({
		resirectTo : '/'
	});
});
