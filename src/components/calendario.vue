<template>
  <div>
    <h2>Encontre seu melhor quarto</h2>
    <flat-pickr v-model="dateRange" :config="config" placeholder="Selecione as datas" />
    <p v-if="dateRange.length > 0">Data de entrada: {{ dateRange[0] }}</p>
    <p v-if="dateRange.length > 0">Data de saída: {{ dateRange[1] }}</p>
  </div>
</template>

<script>
import flatPickr from "vue-flatpickr-component";

export default {
  components: {
    flatPickr,
  },
  data() {
    return {
      dateRange: [],
      config: {
        mode: "range",
        dateFormat: "Y-m-d",
      },
    };
  },
};
</script>
