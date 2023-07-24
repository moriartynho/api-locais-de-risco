const url = "http://localhost:8080/locais";

async function inicializarMapa() {
    
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;

            var mapa = new google.maps.Map(document.getElementById('mapa'), {
                center: {lat: latitude, lng: longitude}, 
                zoom: 10 
            });

           
            adicionarMarcador(mapa, latitude, longitude, 'Localização do Usuário');
        });
    } else {
        alert('Geolocalização não suportada pelo navegador.');
    }
}


function adicionarMarcador(mapa, lat, lng, titulo) {
    var marcador = new google.maps.Marker({
        position: {lat: lat, lng: lng},
        map: mapa,
        title: titulo
    });
}

async function carregarLocaisDeRisco(){
    const response = await fetch(url)

    const data = await response.json();

    console.log(data)

    data.map((local)=>{
        console.log(local)
    })
   

}