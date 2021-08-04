$(function() {
	
	let url = 'https://localhost:8080/CRUDVEICULOSN1/marca';
    let html = '';

    const myRequest = new Request(url, {method: 'GET'});
 
      fetch(myRequest)
     .then(function(response){
      if (response.status === 200) {
            return response.json();   
      } else {
        Swal.fire({
            icon: 'error',
            title: 'Marcas não encontradas!',
            showConfirmButton: true
          });
      }
    })
    .then(function(data) {
      

       html = '<option value="">Selecionar a marca do Veiculo</option>';
     for(let i = 0; i < data.length; i++){
        html += '<option value='+ data[i].id +'>'+ data[i].descricaoMarca + '</option>';
     }

     $('#vehicle-marca').html(html);
        html = '';
       
     
   }).catch(error => 
    console.log(error)
   );
	
	
})