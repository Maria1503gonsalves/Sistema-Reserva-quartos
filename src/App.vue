<template>
  <div>
    <!-- Navegação -->
    <nav>
      <button @click="changePage('localizacao')">Localização</button>
      <button @click="changePage('datas')">Datas</button>
      <button @click="changePage('cadastro')">Cadastro</button>
      <button @click="changePage('login')">Login</button>
    </nav>

    <!-- Renderização de Componentes -->
    <Localizacao v-if="currentPage === 'localizacao'" />
    <Calendario v-if="currentPage === 'datas'" />
    <Cadastro v-if="currentPage === 'cadastro'" />
    <Login v-if="currentPage === 'login'" />
  </div>
</template>

<script>
import Localizacao from './components/localizacao.vue';
import Calendario from './components/calendario.vue';
import Cadastro from './components/cadastro.vue';
import Login from './components/Login.vue';

export default {
  name: "App",
  components: {
    localizacao,
    calendario,
    cadastro,
    login,
  },
  data() {
    return {
      currentPage: "localizacao", // Página padrão
    };
  },
  methods: {
    changePage(page) {
      console.log(`Mudando para a página: ${page}`); // Log para depuração
      this.currentPage = page;
    },
  },
};
</script>

<style scoped>
nav {
  margin-bottom: 20px;
}

button {
  margin-right: 10px;
}
</style>
