$(function() {
 
 	let url = 'https://localhost:8080/CRUDVEICULOSN1/vehicle';
    let html = '';

    const myRequest = new Request(url, {method: 'GET'});
 
      fetch(myRequest)
     .then(function(response){
      if (response.status === 200) {
            return response.json();   
      } else {
        Swal.fire({
            icon: 'error',
            title: 'Veiculos não encontrada!',
            showConfirmButton: true
          });
      }
    })
    .then(function(data) {
      

        for(var i = 0; i < data.length ; i++){
          html += '<ul class="list-group list-group-flush">';
          html += `<li class="list-group-item"><p id="modelo_veiculo" class="card-title">${data[i].modelo}</p></li>`;
          html += `<li class="list-group-item"><p id="marca_veiculo" class="card-title">${data[i].marca}</p></li>`;
          html += `<li class="list-group-item"><p id="valor_veiculo" class="card-text">${data[i].preco}</p></li>`;
          html += `<li class="list-group-item"><p id="data_veiculo" class="card-text">${data[i].dataFabricacao}</p></li>`;
		  html += `<li class="list-group-item"><p id="chassi_veiculo" class="card-text">${data[i].chassi}</p></li>`;
          html += `<li class="list-group-item"><p id="placa_veiculo" class="card-text">${data[i].placa}</p></li>`;
          html += `<li class="list-group-item"><p id="cor_veiculo" class="card-text">${data[i].cor}</p></li>`;
		  html += `<li class="list-group-item"><p id="condicao_veiculo" class="card-text">${data[i].condicao}</p></li>`;
          html += `<a onclick="editarVeiculo(${data[i]})" class="card-link">Editar Veiculo</a>`;
		  html += `<a onclick="deletarVeiculo(${data[i].id})" class="card-link">Remover Veiculo</a>`;
          html += '</ul>';

        }
        
        $('#div_vehicle').html(html);

        html = '';
       
     
   }).catch(error => 
    console.log(error)
   );


function openNav() {
  document.getElementById("navLateral").style.width = "250px";
}

function closeNav(){
  document.getElementById("navLateral").style.width = "0";
  
}

function editarVeiculo(veiculo){
	
	let url = 'https://localhost:8080/CRUDVEICULOSN1/vehicle';		
	
	const putMethod = {
 	method: 'PUT', 
 	headers: {
  	'Content-type': 'application/json'  
 	},
 	body: JSON.stringify(veiculo) 
	}

	
	fetch(url, putMethod)
	.then(response => response.json())
	.then(data => console.log(data)) // Manipulate the data retrieved back, if we want to do something with it
	.catch(err => console.log(err))
	
}

function deletarVeiculo(id){
	
	let url = 'https://localhost:8080/CRUDVEICULOSN1/vehicle/';
	
	fetch(url + id, {
  			method: 'DELETE',
		 })
.then(res => res.text()) // or res.json()
.then(res => console.log(res))
	
}

});