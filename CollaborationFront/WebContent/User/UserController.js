'use strict';

app.controller('UserController',['$scope', '$location', 'UserService', function($scope, $location, UserService) {

	console.log("UserController...")
      var self=this;
	
	this.user ={userid:'',username:'',email:'',contact:'',password:'',address:'',role:'',status:'',isonline:''};

	self.users=[];
	
	 self.submit = submit;
	 self.edit = edit;
     self.remove = remove;
	 self.reset = reset; 

	 /*fetchAllUsers();
	    reset();*/

	    function fetchAllUsers(){
	        UserService.fetchAllUsers()
	            .then(
	            function(d) { 	
	                self.users = d;
	            },
	            function(errResponse){
	                console.error('Error while fetching Users');
	            }
	        );
	    }
	   function createUser(user) {
			console.log("createUser...")  
			UserService.createUser(user).then(function(d) {
								self.cuser = d;
								console.log(self.cuser)  
								alert("Thank you for registration");
								$location.path("/login")
							}, 
							function(errResponse) {
								console.error('Error while creating User.');
							});
		};

		 function updateUser(user, id){
	        UserService.updateUser(user, id)
	            .then(
	            fetchAllUsers,
	            function(errResponse){
	                console.error('Error while updating User');
	            }
	        );
	    }
	    
	    function deleteUser(id){
	        UserService.deleteUser(id)
	            .then(
	            fetchAllUsers,
	            function(errResponse){
	                console.error('Error while deleting User');
	            }
	        );
	    }
	 
	    function submit() {
	       
	            console.log('Saving New User', self.user);
	            createUser(self.user);
	      
	    }
	 
	    function edit(id){
	        console.log('id to be edited', id);
	        for(var i = 0; i < self.users.length; i++){
	            if(self.users[i].userid === id) {
	                self.user = angular.copy(self.users[i]);
	                break;
	            }
	        }
	    }
	 
	    function remove(id){
	        console.log('id to be deleted', id);
	        if(self.user.userid === id) {//clean form if the user to be deleted is shown there.
	            reset();
	        }
	        deleteUser(id);
	    }
	 
	 
	    function reset(){
	    	self.user={userid:null,username:'',email:'',contact:'',password:'',address:'',role:'',status:'',isonline:''};
	       
	        //$scope.myForm.$setPristine(); //reset Form
	    }
}]);