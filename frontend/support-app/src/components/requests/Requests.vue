<script setup>
import { ref, onMounted, watch } from 'vue';

const apiUrl = 'http://localhost:8080';

const isPopupVisible = ref(false);
const isDetailPopupVisible = ref(false);
const applicantName = ref('');
const requestDate = ref('');
const requestTopic = ref('');
const requestDescription = ref('');
const selectedRequest = ref(null);
const requests = ref([]);

onMounted(() => {
  loadRequestsFromLocalStorage();
});

watch(requests, () => {
  saveRequestsToLocalStorage();
});

const openPopup = () => {
  isPopupVisible.value = true;
};

const closePopup = () => {
  isPopupVisible.value = false;
};

const submitRequest = async () => {
  if (applicantName.value && requestDate.value && requestTopic.value && requestDescription.value) {
    const newRequest = {
      name: applicantName.value,
      date: requestDate.value,
      topic: requestTopic.value,
      description: requestDescription.value,
    };

    try {
      const response = await fetch(`${apiUrl}/api/solicitudes`, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
        },
        body: JSON.stringify(newRequest),
      });

      if (!response.ok) {
        throw new Error(`Error al enviar la solicitud al servidor. Código: ${response.status}`);
      }

      const data = await response.json();
      requests.value.push(data);

      applicantName.value = '';
      requestDate.value = '';
      requestTopic.value = '';
      requestDescription.value = '';
      closePopup();
    } catch (error) {
      console.error('Error al enviar la solicitud al servidor:', error);
      alert('Hubo un error al enviar la solicitud.');
    }
  } else {
    alert('Por favor, complete todos los campos del formulario.');
  }

  saveRequestsToLocalStorage();

};

const loadRequestsFromLocalStorage = () => {
  const storedRequests = localStorage.getItem('requests');
  if (storedRequests) {
    requests.value = JSON.parse(storedRequests);
  }
};

const saveRequestsToLocalStorage = () => {
  localStorage.setItem('requests', JSON.stringify(requests.value));
};

const deleteRequest = (request) => {
  const indexToDelete = requests.value.findIndex(req => req.id === request.id);
  
  if (indexToDelete !== -1) {
    requests.value.splice(indexToDelete, 1);
    console.log(`Solicitud eliminada: ${request.topic}`);
  }

  saveRequestsToLocalStorage();

};

const openDetailPopup = (request) => {
  selectedRequest.value = request;
  isDetailPopupVisible.value = true;
};

const closeDetailPopup = () => {
  selectedRequest.value = null;
  isDetailPopupVisible.value = false;
};

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
        <button @click="openPopup">Nueva solicitud</button>
      </div>

      <div id="activeRequests">
      <div v-for="request in requests" :key="request.id" :class="'request' + (request.id % 2 + 1)">
        <p>Solicitud: {{ request.topic }}</p>
        <div class="icons">
          <img @click.prevent="deleteRequest(request)" src="/assets/images/trash.png" alt="">
          <img @click.prevent="openDetailPopup(request)" src="/assets/images/see.png" alt="">
        </div>
      </div>
    </div>

    </div>

    <div v-if="isPopupVisible" class="popupOverlay">
      <div class="popup">
        <span class="closePopup" @click="closePopup">&times;</span>
        <h2>NUEVA SOLICITUD</h2>

        <form @submit.prevent="submitRequest">
          <label for="applicantName">NOMBRE DEL SOLICITANTE:</label>
          <input type="text" v-model="applicantName" required />

          <label for="requestDate">FECHA DE LA SOLICITUD:</label>
          <input type="date" v-model="requestDate" required />

          <label for="requestTopic">TEMA DE LA CONSULTA:</label>
          <input type="text" v-model="requestTopic" required />

          <label for="requestDescription">DESCRIPCIÓN</label>
          <textarea v-model="requestDescription" required></textarea>

          <button type="submit" @click.prevent="submitRequest">ENVIAR SOLICITUD</button>

        </form>

      </div>

      <div v-if="isDetailPopupVisible" class="popupOverlay">
        <div class="popup">
          <span class="closePopup" @click="closeDetailPopup">&times;</span>
          <h2>Detalles de la Solicitud</h2>
            <p><strong>Nombre del Solicitante:</strong> {{ selectedRequest.name }}</p>
            <p><strong>Fecha de la Solicitud:</strong> {{ selectedRequest.date }}</p>
            <p><strong>Tema de la Consulta:</strong> {{ selectedRequest.topic }}</p>
            <p><strong>Descripción:</strong> {{ selectedRequest.description }}</p>
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

.popupOverlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  justify-content: center;
  align-items: center;
}

.popup {
  background: white;
  padding: 40px;
  border-radius: 10px;
  box-shadow: 0 0 20px rgba(0, 0, 0, 0.5);
  max-width: 80%;
  width: 600px;
  text-align: center;
  position: relative;
}

.closePopup {
  position: absolute;
  top: 10px;
  right: 10px;
  font-size: 20px;
  cursor: pointer;
}

form {
  display: flex;
  flex-direction: column;
  align-items: center;

  label {
    margin-top: 10px;
  }

  input,
  textarea {
    width: 100%;
    padding: 10px;
    margin-top: 5px;
    box-sizing: border-box;
  }

  button {
    width: 100%;
    padding: 10px;
    margin-top: 15px;
    background-color: black;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }

  button:hover {
    background-color: gray;
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

  .popup {
    max-width: 60%;
  }
}

@media only screen and (min-width: 1024px) {
  .popup {
    max-width: 50%;
  }
}
</style>