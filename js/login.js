// Call the dataTables jQuery plugin
$(document).ready(function() {
//on ready
});
		async function iniciarSesion(){
	let datos = {};
	
	datos.email =document.getElementById("txtEmail").value;
	datos.password =document.getElementById("txtPassword").value;
	
	
	
		const request = await fetch('login', {
			    method: 'POST',
			    headers: {
			      'Accept': 'application/json',
			      'Content-Type': 'application/json'
			    },
			    body: JSON.stringify(datos)
			  });
			
			  const repuesta = await request.text();
			  if(repuesta!='FAIL'){
				  localStorage.token=repuesta;
				  localStorage.emaail=datos.email;
				  
				  window.location.href='/usuarios.html'
			  }else{
				  alert("Las credenciales son incorrectas.Por favor intente de nuevo ")
			  }
			  
		}
		
		
	