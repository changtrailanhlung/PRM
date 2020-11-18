import Vue from 'vue'
import App from './App.vue'
import VueFirestore from 'vue-firestore';
import VueMaterial from 'vue-material'
import 'vue-material/dist/vue-material.min.css'
import { BootstrapVue, IconsPlugin } from 'bootstrap-vue'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue/dist/bootstrap-vue.css'
import Vuetify from 'vuetify';
import 'vuetify/dist/vuetify.min.css';

Vue.config.productionTip = false

Vue.use(VueMaterial);

Vue.use(VueFirestore);

// Install BootstrapVue
Vue.use(BootstrapVue)
// Optionally install the BootstrapVue icon components plugin
Vue.use(IconsPlugin)

Vue.use(Vuetify)

new Vue({
  Vuetify,
  render: h => h(App),
}).$mount('#app')
