import { createApp } from 'vue'
import './style.css'
import App from './App.vue'

import { library } from '@fortawesome/fontawesome-svg-core';
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { faMapMarkerAlt } from '@fortawesome/free-solid-svg-icons';

createApp(App).mount('#app')

library.add(faMapMarkerAlt);

const app = createApp(App);

// Registre o componente Font Awesome globalmente
app.component('font-awesome-icon', FontAwesomeIcon);

app.mount('#app');