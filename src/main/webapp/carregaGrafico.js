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
	
	let data = [];
			
	let label;
	let price;
	
	for(let i = 0; i < data.length ; i++){
                   
         label = data[i].modelo;
         price = data[i].preco;

         data.push({label: label, y: price});
        }
      

        let chart = new CanvasJS.Chart("graficoContainer", {
		title:{
			text: "Valor dos veículos por modelo"              
		},
		data: [              
		{
			// Change type to "doughnut", "line", "splineArea", etc.
			type: "column",
			dataPoints: data
		}
		]
	});
	chart.render();
       
     
   }).catch(error => 
    console.log(error)
   );
	
})
