<script setup>

</script>

<template>

    <form class="loginForm">

    <h1>LOGIN</h1>

      <label for="usuario">Usuario:</label>
      <input type="text" id="usuario" name="usuario" v-model="usuario" required>
  
      <label for="contraseña">Contraseña:</label>
      <input type="password" id="contraseña" name="contraseña" v-model="contraseña" required>
  
      <div class="rememberPassword">
        <input type="checkbox" id="recordar" name="recordar" v-model="recordarContraseña">
        <label for="recordar">Recordar contraseña</label>
      </div>
  
      <button type="button" @click="enviarFormulario">ENTRAR</button>

    </form>

  </template>
  
  <style lang="scss" scoped>

    @import url('https://fonts.googleapis.com/css2?family=League+Spartan&family=Neucha&display=swap');
  
  .loginForm {
    background-color: white;
    max-width: 300px;
    margin: 20px auto;
    padding: 20px;
    border-radius: 8px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);

    font-family: 'League Spartan', sans-serif;

    h1 {
        text-align: center;
        font-size: 1.5rem;
        margin-bottom: 15px;
    }
  }
  
  .rememberPassword {
    display: flex;
    align-items: center;
    margin-bottom: 16px;
    margin-top: 10px;
    margin-right: 105px;
  }
  
  .rememberPassword input[type="checkbox"] {
    transform: scale(0.9);
    margin-right: 8px;
  }
  
  .rememberPassword label {
    white-space: nowrap; 
  }
  
  label {
    display: block;
    margin-bottom: 8px;
  }
  
  input {
    width: 100%;
    padding: 8px;
    margin-bottom: 8px;
    box-sizing: border-box;
  }
  
  button {
    background-color: black;
    color: white;
    padding: 10px;
    border: none;
    border-radius: 10px;
    cursor: pointer;

    margin-left: 90px;
  }
  </style>