app.service("UserService",function()
		{
	
	this.validate = function(username,password)
	    {
		
		if(username=="mano" && password=="mano")
		{
          alert("valid");
        }
		else{
			alert("invalid");
		}
		
	}
	
})