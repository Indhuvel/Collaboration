'use strict';
app.controller('BlogController',['$scope', '$location', 'BlogService','$rootScope', '$cookieStore','$http',
	function($scope, $location, BlogService,$rootScope,$cookieStore,$http) {
	console.log("BlogController...")
	
	var self = this;
	self.blog = {blogid : '',blogname:'',title : '',status : '',description : '',createdate : '',username:'',likes:'',userid:''};
	
	self.blogs = [];
	self.submit = submit;
   
    self.get = get;
   
    self.AcceptedBlogs = AcceptedBlogs;
    self.notAcceptedBlogs = notAcceptedBlogs;
    self.adminGet = adminGet;
    self.accept = accept;
    self.rejectBlog = rejectBlog;
    self.editandupdateBlog=editandupdateBlog;
    
    fetchAllBlogs();
    AcceptedBlogs();
    reset();
    
    function fetchAllBlogs(){
    	BlogService.fetchAllBlogs()
            .then(function(d) {
                self.blogs = d;
            },
            function(errResponse){
                console.error('Error while fetching Blogs');
            });
    }
    function AcceptedBlogs() {
		console.log("AcceptedBlogs...")
		BlogService.AcceptedBlogs().then(function(d) {
							
			console.log(d)
							self.blogsAccept = d;
						},
						function(errResponse) {
							console.error('Error while creating AcceptedBlogs.');
						});
	};
	function notAcceptedBlogs() {
		console.log("notAcceptedBlogs...")
		BlogService.notAcceptedBlogs().then(function(d) {
							
			console.log(d)
							self.blogsNotAccepted = d;
							console.log(self.blogsNotAccepted)
						},
						function(errResponse) {
							console.error('Error while creating notAcceptedBlogs.');
						});
	};
	
    function createBlog(blog){
		console.log("createBlog...")
		BlogService.createBlog(blog).then(function(d) {
			alert("Thank you for creating message")
			$location.path("/viewblog")
		}, function(errResponse) {
			console.error('Error while creating Blog.');
		});
	};

   /* function deleteblog(blogid){
    	BlogService.deleteBlog(blogid)
            .then(fetchAllBlogs,
            function(errResponse){
                console.error('Error while deleting jobs');
            }
        );
    }*/
	function editandupdateBlog(blog){
		
		console.log(blog);
		$rootScope.blog=blog; // rootscope name MUST be blog only then it can be mapped with front end
		console.log(self.blog);
		$location.path("/blog");
		
};
    function remove(blogid){
        console.log('id to be deleted', blogid);
        if(self.blog.blogid === blogid) {
            reset();
        }
        deleteblog(blogid);
    }
    function accept(ViewBlogs) {
		{
			console.log('accept the Blog details')
				
			BlogService.accept(ViewBlogs);
			console.log(ViewBlogs)
			$location.path("/admin")
		}
		
	};
	function rejectBlog(ViewBlogs){
    	BlogService.deleteBlog(ViewBlogs.blogid).then(function(d) {
			self.deleteBlogRequestId = d;		    			
			console.log(self.deleteBlogRequestId);
    			$location.path("/admin")
    	}, function(errResponse){
                console.error('Error while deleting BlogRequest');
            });
    };
    function get(blog) {
    	$scope.bc=blog;
		console.log($scope.bc);
		$rootScope.blog=$scope.bc;
		$location.path("/viewBlog");
    	
	}
    function adminGet(blogs){
		$scope.bvv=blogs;
		console.log($scope.bvv);
		$rootScope.ViewBlogs=$scope.bvv;
		$location.path("/adminBlog");
	}
    function submit() {
        console.log('Creating New Blog', self.blog);
           createBlog(self.blog);
           reset();
   };
    function reset(){
    	self.blog={blogid : 'null',blogname:'',title : '',status : '',description : '',createdate : '',username:'',likes:'',userid:''};

       //$scope.myform.$setPristine(); //reset Form
    };
    
    
    
	
}]);