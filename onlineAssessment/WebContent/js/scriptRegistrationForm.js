function myfunction()
		{
			var x = document.getElementById("myInput");
			var y = document.getElementById("eye1");
			var z = document.getElementById("eye2");
			
			if(x.type ==='password')
			{
				x.type="text";
				y.style.display="block";
				z.style.display="none";
			}
			else{
				x.type="password";
				y.style.display="none";
				z.style.display="block";
			}
		}	