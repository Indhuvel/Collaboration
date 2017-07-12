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
	.when('/admin', {
		templateUrl : 'Admin/AdminPage.html'

	})
	.when('/adminBlog', {
		templateUrl : 'Admin/BlogDetails.html',
		controller : 'BlogController',
		controllerAs : 'bcc'
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

app.run( function ($rootScope, $location,$cookieStore, $http) {

	 $rootScope.$on('$locationChangeStart', function (event, next, current) {
		 console.log("$locationChangeStart")
		
		 var userPages = ['/myProfile','/create_blog','/add_friend','/search_friend','/view_friend', '/viewFriendRequest','/chat']
		 var adminPages = ["/post_job","/manage_users"]
		 
		
		 var currentPage = $location.path()
		 
		
		 var isUserPage = $.inArray(currentPage, userPages)
		 var isAdminPage = $.inArray(currentPage, adminPages)
		 
		 var isLoggedIn = $rootScope.currentUser.id;
	        
	     console.log("isLoggedIn:" +isLoggedIn)
	     console.log("isUserPage:" +isUserPage)
	     console.log("isAdminPage:" +isAdminPage)
	        
	        if(!isLoggedIn)
	        	{
	        	
	        	 if (isUserPage===0 || isAdminPage ===0) {
		        	  console.log("Navigating to login page:")
		        	  alert("You need to loggin to do this operation")

						            $location.path('/');
		                }
	        	}
	        
			 else
	        	{
	        	
				 var role = $rootScope.currentUser.role;
				 
				 if(isAdminPage===0 && role!='admin' )
					 {
					 
					  alert("You can not do this operation as you are logged as : " + role )
					   $location.path('/');
					 
					 }}}
				     
	        	
	        	      );
	 
	 
	 
    $rootScope.currentUser = $cookieStore.get('currentUser') || {};
    if ($rootScope.currentUser) {
        $http.defaults.headers.common['Authorization'] = 'Basic' + $rootScope.currentUser; 
    }

});
