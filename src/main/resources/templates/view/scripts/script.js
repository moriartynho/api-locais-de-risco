
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

        console.log(data)

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
    const localImagem = document.getElementById('local-imagem');

    localDescricao.textContent = "Descrição: " + local.descricao + " relatado em: " + local.data;
    localEndereco.textContent = "Endereço: " + local.endereco;
    localLatitude.textContent = 'Latitude: ' + local.latitude;
    localLongitude.textContent = 'Longitude: ' + local.longitude;

    fetch(`${url}/imagem/${BigInt(local.imagemId)}`) 
  .then(response => {
    if (!response.ok) {
      throw new Error('Erro ao buscar a imagem.');
    }
    return response.blob();
  })
  .then(blob => {
    const url = URL.createObjectURL(blob);
    localImagem.src = url;
  })
  .catch(error => {
    console.error('Erro:', error);
  });

    localInfo.style.display = 'block';
}


document.addEventListener('DOMContentLoaded', () => {
    const localForm = document.getElementById('local-form');
    const enderecoInput = document.getElementById("endereco");
    const descricaoInput = document.getElementById("descricao");
    const imagemInput = document.getElementById("imagem");


    localForm.addEventListener("submit", async (e) => {
        e.preventDefault();
        const formData = new FormData();
        formData.append("endereco", enderecoInput.value);
        formData.append("descricao", descricaoInput.value);
        formData.append("imagem", imagemInput.files[0]);
        console.log(formData)
        const response = await fetch(`${url}/locais`, {
            method: "POST",
            body: formData,
        });

        if (response.ok) {
            window.location.href = "index.html";
        } else {

            console.error("Erro ao enviar o local.");
        }
    });
})