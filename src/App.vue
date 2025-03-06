<template>
  <div>
    <h1>Sua Localização</h1>
    <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    <p v-if="city && country">
      Cidade: {{ city }} <br />
      País: {{ country }}
    </p>
    <button @click="getLocation">Obter Localização</button>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      city: null, // Nome da cidade
      country: null, // Nome do país
      errorMessage: "", // Para mensagens de erro
    };
  },
  methods: {
    async getLocation() {
      // Verifica se o navegador suporta a API de Geolocalização
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          async (position) => {
            const { latitude, longitude } = position.coords;

            try {
              // Faz uma requisição à API do OpenCage
              const response = await axios.get(
                
  `https://api.opencagedata.com/geocode/v1/json?q=${latitude}+${longitude}&key=20fb2055e4e643efa8908a10e26338c3`
              );

              // Extrai a cidade e o país da resposta
              const components = response.data.results[0].components;
              this.city = components.city || components.town || components.village;
              this.country = components.country;
              this.errorMessage = "";

            } catch (error) {
              this.errorMessage = "Erro ao obter a localização: " + error.message;
            }
          },
          (error) => {
            // Tratamento de erros de geolocalização
            switch (error.code) {
              case error.PERMISSION_DENIED:
                this.errorMessage = "Permissão negada pelo usuário.";
                break;
              case error.POSITION_UNAVAILABLE:
                this.errorMessage = "Localização indisponível.";
                break;
              case error.TIMEOUT:
                this.errorMessage = "Tempo para obter localização esgotado.";
                break;
              default:
                this.errorMessage = "Ocorreu um erro desconhecido.";
            }
          }
        );
      } else {
        this.errorMessage = "Geolocalização não suportada no navegador.";
      }
    },
  },
};
</script>

<style scoped>
button {
  margin-top: 10px;
  padding: 10px 20px;
  background-color: #42b883;
  color: white;
  border: none;
  border-radius: 5px;
  cursor: pointer;
}
button:hover {
  background-color: #339c70;
}
</style>
