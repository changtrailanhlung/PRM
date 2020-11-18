<template>
  <div id="app">
    <b-card border-variant="success" header="Add Post" class="card-add">
      <label for="input-live">Job ID</label>
      <b-form-input
        id="input-live"
        size="20"
        v-model="newJobid"
        aria-describedby="input-live-help input-live-feedback"
        trim
      ></b-form-input>

      <label for="input-live">Title</label>
      <b-form-input
        id="input-live"
        size="20"
        v-model="newTitle"
        aria-describedby="input-live-help input-live-feedback"
      ></b-form-input>

      <label for="input-live">Company</label>
      <b-form-input
        id="input-live"
        size="20"
        v-model="newCompany"
        aria-describedby="input-live-help input-live-feedback"
      ></b-form-input>

      <label for="input-live">Description</label>
      <b-form-textarea
        id="textarea-default"
        size="20"
        v-model="newDescription"
        aria-describedby="input-live-help input-live-feedback"
      ></b-form-textarea>

      <label for="input-live">Salary</label>
      <b-form-input
        id="input-live"
        size="20"
        type="number"
        v-model="newSalary"
        aria-describedby="input-live-help input-live-feedback"
        trim
      ></b-form-input>

      <br />
      <b-button variant="outline-success" @click="addPost">
        Add
      </b-button>
    </b-card>
    <br />
  </div>
</template>

<script>
import { db } from "../firebase";
import _ from "lodash";

export default {
  name: "TableCard",
  computed: {
    nameState() {
      return this.newName.length > 0 ? true : false;
    },
    ytState() {
      return this.newYT.length > 0 ? true : false;
    },
    orderedPosts: function() {
      return _.orderBy(this.posts, ["date"], ["desc"]);
    },
  },
  data() {
    return {
      posts: [],
      newJobid: "",
      newTitle: "",
      newCompany: "",
      newDescription: "",
      newSalary: "",
    };
  },
  firestore() {
    return {
      posts: db.collection("jobs"),
    };
  },
  methods: {
    addPost: function() {
      this.$firestore.posts.add({
        id: this.newJobid,
        title: this.newTitle,
        company: this.newCompany,
        description: this.newDescription,
        salary: this.newSalary,
        created: new Date(),
      });
      this.newJobid = "";
      this.newTitle = "";
      this.newCompany = "";
      this.newDescription = "";
      this.newSalary = "";
    },
    deletePost: function(post) {
      this.$firestore.posts.doc(post[".key"]).delete();
    },
  },
};
</script>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}

.card-add {
  width: 500px;
  position: relative;
  margin-left: auto;
  margin-right: auto;
}

.card-post {
  width: 800px;
  position: relative;
  margin-left: 50%;
  margin-right: 50%;
}
</style>
