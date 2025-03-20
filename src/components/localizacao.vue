<template>
    <div>
      <h2>Sua localização</h2>
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
        city: null,
        country: null,
        errorMessage: "",
      };
    },
    methods: {
      async getLocation() {
        if (!navigator.geolocation) {
          this.errorMessage = "Geolocalização não suportada no navegador.";
          return;
        }
        navigator.geolocation.getCurrentPosition(
          async (position) => {
            const { latitude, longitude } = position.coords;
            try {
              const response = await axios.get(
                `https://api.opencagedata.com/geocode/v1/json?q=${latitude}+${longitude}&key=20fb2055e4e643efa8908a10e26338c3`
              );
              const components = response.data.results?.[0]?.components || {};
              this.city = components.city || "Desconhecido";
              this.country = components.country || "Desconhecido";
              this.errorMessage = "";
            } catch (error) {
              this.errorMessage = "Erro ao obter a localização: " + error.message;
            }
          },
          () => {
            this.errorMessage = "Erro ao acessar a localização.";
          }
        );
      },
    },
  };
  </script>
  