var app = angular.module("demo",["ngRoute"]);
 				app .config(function ($routeProvider){
					$routeProvider
					.when("/register",{
						templateUrl:"register.html"
						})
						.when("/signin",{
							templateUrl:"sign-in.html"
							})
							.when("/addblog",{
								templateUrl:"addBlog.html"
								})
								.when("/aboutus",{
									templateUrl:"aboutUs.html"
									})
									.when("/contactus",{
										templateUrl:"contactUs.html"
										});		
});
 				 