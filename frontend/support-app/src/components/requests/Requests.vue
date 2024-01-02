<script setup>

</script>

<template>

  <div class="container">

        <div class="column">

          <img src="/assets/images/icon.png" alt="Foto de perfil">
          <h3>Empleada</h3>
          <p>Verónica Sampedro</p>

        </div>

        <div class="separator"></div>

        <div id="rightContainer">

        <div class="requestsContainer">

          <h2>SOLICITUDES ACTIVAS</h2>
          <button>Nueva solicitud</button>

        </div>

        <div id="activeRequests">

            <div class="request1">

                <p>Solicitud: Pantallazo azul</p>
                <img src="/assets/images/trash.png" alt="">

            </div>

            <div class="request2">

                <p>Solicitud: No se mueve el cursor</p>
                <img src="/assets/images/trash.png" alt="">

            </div>

        </div>
    </div>

      </div>
</template>

<style lang="scss">

@import url('https://fonts.googleapis.com/css2?family=League+Spartan&family=Neucha&display=swap');

.container {
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center; 
}

.column {
  display: flex;
  flex-direction: column;
  align-items: center;

  padding: 5px;
  font-family: 'League Spartan', sans-serif;
}

.column img {
  width: 70px;
  border-radius: 50%; 
  margin-bottom: 10px; 
}

.column h3 {
    font-weight: bolder;
}

.separator {
  height: 90.6vh; 
  width: 1px; 
  background-color: black; 
  margin: 0 20px; 
}

.requestsContainer {
  display: flex;
  flex-direction: column;
  align-items: center;
  text-align: center; 


h2 {
  font-family: 'League Spartan', sans-serif;
  padding: 10px;
  font-size: 20px;
  margin-bottom: 10px;
}

button {
  background-color: #828282;
  font-family: 'League Spartan', sans-serif;
  width: 35%;
  padding: 5px;
  color: white;
  border-radius: 5px;
  border: 1px solid black;
}
}

#rightContainer {
    display: flex;
    flex-direction: column;
}

#activeRequests {
    display: flex;
    flex-direction: column;
    padding: 20px;

    .request1 {
        display: flex;
        justify-content: space-between;
        text-align: center;
        align-items: center;

        border-radius: 5px;
        border: 1px solid black;

        margin-bottom: 10px;
        padding: 5px;

        img {
            width: 10%;
        }
    }

    .request2 {
        display: flex;
        justify-content: space-between;
        text-align: center;
        align-items: center;

        border-radius: 5px;
        border: 1px solid black;

        margin-bottom: 10px;
        padding: 5px;

        img {
            width: 10%;
        }
    }
}

@media only screen and (min-width: 768px) {
  .container {
    justify-content: flex-start;
  }

  .column {
    margin-left: 10px;
  }

  .requestsContainer {
    width: 70%; 
    align-items: flex-start;
    justify-content: space-between;
    flex-direction: row;
    align-content: center;

    button {
        width: 30%;
        padding: 5px;
    }

    h2 {
        font-size: 2rem;
    }

  }
}
</style>