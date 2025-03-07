<template>
  <div>
    <h1>Sua Localização</h1>
    <p v-if="errorMessage" style="color: red;">{{ errorMessage }}</p>
    <p v-if="city && country">
      Cidade: {{ city }} <br />
      País: {{ country }}
    </p>
    <button @click="getLocation">Obter Localização</button>

    <h2>encontre seu melhor quarto</h2>
    <flat-pickr 
      v-model="dateRange" 
      :config="config" 
      placeholder="Selecione as datas" 
    />
    <p>Data de entrada: {{ dateRange[0] }}</p>
    <p>Data de saída: {{ dateRange[1] }}</p>
  </div>
</template>

<script>
import axios from "axios";
import FlatPickr from 'vue-flatpickr-component';
import 'flatpickr/dist/flatpickr.css';

export default {
  components: {
    FlatPickr,
  },
  data() {
    return {
      city: null,
      country: null,
      errorMessage: "",
      dateRange: [],
      config: {
        mode: "range",
        dateFormat: "Y-m-d",
      },
    };
  },
  methods: {
    async getLocation() {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
          async (position) => {
            const { latitude, longitude } = position.coords;

            try {
              const response = await axios.get(
                `https://api.opencagedata.com/geocode/v1/json?q=${latitude}+${longitude}&key=20fb2055e4e643efa8908a10e26338c3`
              );

              const components = response.data.results[0].components;
              this.city =
                components.city || components.town || components.village;
              this.country = components.country;
              this.errorMessage = "";
            } catch (error) {
              this.errorMessage = "Erro ao obter a localização: " + error.message;
            }
          },
          (error) => {
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
