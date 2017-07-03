var app = angular.module("myApp", [ 'ngRoute','ngCookies' ]);

app.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'Home/Home.html'/*index.html'*/	
			})

	.when('/login', {
		templateUrl : 'User/Login.html',
		controller : 'UserController',
            controllerAs: 'vm'

	})
   .when('/register', {
		templateUrl : 'User/Register.html',
			controller : 'UserController',
			controllerAs: 'ctrl'

	})
	.when('/blog', {
		templateUrl : 'Blog/Blog.html'

	})
	.otherwise({
		resirectTo : '/'
	});
});
