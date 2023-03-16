// Call the dataTables jQuery plugin
$(document).ready(function() {
//on ready
});
		async function registrarUsuarios(){
	let datos = {};
	datos.nombre =document.getElementById("txtNombre").value;
	datos.apellido =document.getElementById("txtApellido").value;
	datos.email =document.getElementById("txtEmail").value;
	datos.password =document.getElementById("txtPassword").value;
	
	let repetirPass=document.getElementById("txtRepetirPassword").value;
		
	 if(repetirPass!=datos.password){
	    alert('La contraseña que escribiste es diferente');
           return;
}
		const request = await fetch('/usuarios/api', {
			    method: 'POST',
			    headers: {
			      'Accept': 'application/json',
			      'Content-Type': 'application/json'
			    },
			    body: JSON.stringify(datos)
			  });
			alert("La cuenta fue creada con exito !!");
			window.location.href='login.html'
		}
		
		
		
		
	