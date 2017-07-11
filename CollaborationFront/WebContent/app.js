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

	.when('/forum', {
		templateUrl : 'Forum/Forum.html',
		controller : 'ForumController',
			controllerAs : 'fc'
	})
     .when('/viewforum', {
		templateUrl : 'Forum/ViewForum.html',
		controller : 'ForumController',
			controllerAs : 'fc'
	})
    .when('/friend', {
		templateUrl : 'Friend/friends.html',
		controller : 'FriendController',
		controllerAs : 'frc'

	})
	
	.otherwise({
		resirectTo : '/'
	});
});
