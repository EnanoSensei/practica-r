var f = document.getElementById("formDregistro");
var b = document.getElementById("boton");


b.onclick = function Registrar() {
    var form = new FormData(f);
    fetch('http://localhost:9090/Registroweb2/Registro',{
        method: 'POST',
        body: form
    })
    .then((response) => {
    	console.log(response);
    })
}
  