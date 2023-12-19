<script setup>

</script>

<template>


    <img alt="" src="@/assets/logo.svg"/>

    <div class="wrapper">
      <HelloWorld msg="You did it!" />

      <nav>
        <RouterLink to="/">Home</RouterLink>
        <RouterLink to="/about">About</RouterLink>
      </nav>
    </div>


</template>

<style scoped>

header {
    background-color: white;
}
</style>