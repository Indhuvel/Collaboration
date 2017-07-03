app.controller("JobController",["$scope",function($scope){
	
	$scope.message="Job Details"

		$scope.job=
		{
			
			"id":"Job 123",
			"title":"Technical Lead",
			"qualification":"BE"
	}
	$scope.jobdetails="List of Job"
		$scope.jobs=
			[
				{"id":"Job 13","title":"Project Lead","qualification":"B.Tech"},

				{"id":"Job 14","title":"Team Lead","qualification":"BE"}

			]
}
])

