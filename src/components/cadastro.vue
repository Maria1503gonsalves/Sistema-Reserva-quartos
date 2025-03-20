<template>
    <div>
      <h2>Cadastro de Usuário</h2>
      <form @submit.prevent="registerUser">
        <div>
          <label for="name">Nome:</label>
          <input type="text" v-model="user.name" id="name" required />
        </div>
        <div>
          <label for="email">E-mail:</label>
          <input type="email" v-model="user.email" id="email" required />
        </div>
        <div>
          <label for="password">Senha:</label>
          <input type="password" v-model="user.password" id="password" required />
        </div>
        <button type="submit">Cadastrar</button>
      </form>
      <p v-if="message">{{ message }}</p>
    </div>
  </template>
  
  <script>
  export default {
    data() {
      return {
        user: {
          name: "",
          email: "",
          password: "",
        },
        message: "",
      };
    },
    methods: {
      registerUser() {
        this.message = "Usuário cadastrado com sucesso!";
        this.user = { name: "", email: "", password: "" };
      },
    },
  };
  </script>
  