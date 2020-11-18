import { firebase } from "@firebase/app";
import "@firebase/firestore";

const firebaseApp = firebase.initializeApp({
  apiKey: "AIzaSyCiV6CdUeTA17KmBqBgWWblO_4ApSIF5iA",
    authDomain: "job-application-6fb97.firebaseapp.com",
    databaseURL: "https://job-application-6fb97.firebaseio.com",
    projectId: "job-application-6fb97",
    storageBucket: "job-application-6fb97.appspot.com",
    messagingSenderId: "802247926405",
    appId: "1:802247926405:web:3be6d69d979f35f0acffec"
});

export const db = firebaseApp.firestore();