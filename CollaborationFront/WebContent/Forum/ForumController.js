'use strict';


app.controller('ForumController', ['$scope','ForumService','$location','$rootScope','$cookieStore','$http',
	function($scope, ForumService, $location, $rootScope, $cookieStore,$http) {
	console.log("ForumController...")
	var self = this;
	
	this.forum={forumid:'',forumname : '',forumcontent : '',userid:'',username:'',
		errorCode : '',
		errorMessage : ''};
	
	
	self.forums = [];
	self.submit = submit;
	
	 self.AcceptedForums = AcceptedForums;
	 self.notAcceptedForums = notAcceptedForums;
	 
	 fetchAllForums();
		AcceptedForums();
		reset();
		
		function fetchAllForums() {
			console.log("fetchingAllForums...")
			ForumService.fetchAllForums().then(function(d) {
				self.forums = d;
				console.log(self.forums)
			}, function(errResponse) {
				console.error('Error while fetching Forums');
			});
		};
		
		function AcceptedForums() {
			console.log("AcceptedForums...")
			ForumService.AcceptedForums().then(function(d) {
								
				console.log(d)
								self.forumsAccept = d;
							},
							function(errResponse) {
								console.error('Error while creating Acceptedforums.');
							});
		};
		function notAcceptedForums() {
			console.log("notAcceptedForums...")
			ForumService.notAcceptedForums().then(function(d) {
							
				console.log(d)
								self.forumsNotAccepted = d;
								console.log(self.forumsNotAccepted)
							},
							function(errResponse) {
								console.error('Error while creating notAcceptedForums.');
							});
		};

		function createForum(forum){
			console.log("createForum...")
			ForumService.createForum(forum).then(function(d) {
				self.forum = d;
				/*$scope.cforum = self.forum;
				$rootScope.currentForum = $scope.cforum;*/
				alert("Thank you for creating message")
				$location.path("/index")
			}, function(errResponse) {
				console.error('Error while creating Forum.');
			});
		};
		
		function reject(id){
			console.log("reject...")
			var reason = prompt("Please enter the reason");
			ForumService.reject(id, reason).then(function(d) {
				self.forum = d;
				self.fetchAllForums
				$location.path("/manage_Forums")
				alert(self.forum.errorMessage)

			}, null);
		};

		function updateForum(currentForum){
			console.log("updateForum...")
			ForumService.updateForum(currentForum).then(
					self.fetchAllForums, null);
		};

		function update() {
			{
				console.log('Update the Forum details',
						$rootScope.currentForum);
				updateForum($rootScope.currentForum);
			}
			reset();
		};
		function accept(viewForums) {
			{
				console.log('accept the Forum details')
					
				ForumService.accept(viewForums);
				console.log(viewForums)
				$location.path("/admin")
			}
			
		};
		 function submit() {
				{
					console.log('Saving New Forum', self.forum);
					createForum(self.forum);
				}
				reset();
			};

			 function reset() {
				self.forum = {forumid:'',forumname : '',forumcontent : '',userid:'',username:'',errorCode : '',
						errorMessage : ''};
 };
			 } ]);