<template>
    <div>
      <h2>Login</h2>
      <form @submit.prevent="handleLogin">
        <label for="username">Usuário:</label>
        <input type="text" id="username" v-model="username" />
        <label for="password">Senha:</label>
        <input type="password" id="password" v-model="password" />
        <button type="submit">Entrar</button>
      </form>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        username: "",
        password: "",
      };
    },
    methods: {
      handleLogin() {
        alert(`Usuário: ${this.username},
         Senha: ${this.password}`);
      },
    },
  };
  </script>
  