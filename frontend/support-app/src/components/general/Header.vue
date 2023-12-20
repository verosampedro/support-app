<script setup>

</script>

<template>


    <header class="wrapper">

      <div id="headerContainer">

        <img src="/assets/images/logo.png" alt="">

        <RouterLink class="routerLink" to="/">LOG OUT</RouterLink>

      </div>

    </header>


</template>

<style lang="scss" scoped>

@import url('https://fonts.googleapis.com/css2?family=League+Spartan&family=Neucha&display=swap');

#headerContainer {
  background-color: black;
  display: flex;
  justify-content: space-between;
  align-items: center;

  .routerLink {
    text-decoration: none;
    color: white;
    padding: 10px;

    font-family: 'League Spartan', sans-serif;
    align-content: center;
  }

  img {
    width: 20%;
    padding: 10px;
  }
}

@media only screen and (min-width: 768px) {

  #headerContainer {

    img {
      width: 6%;
      margin-left: 10px;
    }

    .routerLink {
      margin-right: 15px;
      font-size: 1.3rem;
    }
  }
}

</style>