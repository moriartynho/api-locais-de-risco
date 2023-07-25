const url = "http://localhost:8080";
const iconLocalDeRisco = 'https://icons.veryicon.com/png/128/miscellaneous/linear-icon-ii/danger-20.png';

function inicializarMapa() {

    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(function (position) {
            var latitude = position.coords.latitude;
            var longitude = position.coords.longitude;

            var mapa = new google.maps.Map(document.getElementById('mapa'), {
                center: { lat: latitude, lng: longitude },
                zoom: 17
            });


            adicionarMarcadorUsuario(mapa, latitude, longitude, 'Localização do Usuário');
            carregarLocaisDeRisco(mapa)
        });
    } else {
        alert('Geolocalização não suportada pelo navegador.');
    }
}


function adicionarMarcadorUsuario(mapa, lat, lng, titulo) {
    var marcador = new google.maps.Marker({
        position: { lat: lat, lng: lng },
        map: mapa,
        title: titulo
    });
}

function adicionarMarcadorLocalDeRisco(local, mapa) {
    var marcador = new google.maps.Marker({
        position: { lat: local.latitude, lng: local.longitude },
        map: mapa,
        icon: iconLocalDeRisco,
        title: local.descricao
    });

    marcador.addListener('click', function () {
        mostrarInformacoesLocal(local);
    })

}

async function carregarLocaisDeRisco(mapa) {
    try {
        const response = await fetch(url + "/locais")
        const data = await response.json();

        data.map((local) => {
            adicionarMarcadorLocalDeRisco(local, mapa)
        })

    } catch (error) {
        console.error('Erro ao carregar locais de risco:', error);
    }
}

function mostrarInformacoesLocal(local) {
    const localInfo = document.getElementById('local-info');
    const localEndereco = document.getElementById('local-endereco');
    const localDescricao = document.getElementById('local-descricao');
    const localLatitude = document.getElementById('local-latitude');
    const localLongitude = document.getElementById('local-longitude');
  
    localDescricao.textContent = local.descricao;
    localEndereco.textContent = local.endereco;
    localLatitude.textContent = 'Latitude: ' + local.latitude;
    localLongitude.textContent = 'Longitude: ' + local.longitude;
  
    localInfo.style.display = 'block';
  }