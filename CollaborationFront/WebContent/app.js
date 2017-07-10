var app = angular.module("myApp", [ 'ngRoute','ngCookies' ]);

app.config(function($routeProvider) {
	$routeProvider
	.when('/', {
		templateUrl : 'Home/Home.html'/*index.html'*/	
			})

	.when('/login', {
		templateUrl : 'User/Login.html',
		controller : 'UserController',
            controllerAs: 'uc'

	})
   .when('/register', {
		templateUrl : 'User/Register.html',
			controller : 'UserController',
			controllerAs: 'ctrl'

	})
	.when('/blog', {
		templateUrl : 'Blog/Blog.html',
		controller : 'BlogController',
		controllerAs : 'bc'

	})
	.when('/viewblog', {
		templateUrl : 'Blog/ViewBlog.html',
		controller : 'BlogController',
		controllerAs : 'bc'

	})
	.when('/job', {
		templateUrl : 'Job/Job.html',
		controller : 'JobController',
			controllerAs : 'jc'
	})

	
    .when('/friend', {
		templateUrl : 'Friend/friends.html',
		controller : 'FriendController',
		controllerAs : 'fc'

	})
	
	.otherwise({
		resirectTo : '/'
	});
});
