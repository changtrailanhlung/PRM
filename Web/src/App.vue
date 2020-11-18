<template>
<div class="home">
    <div class="container-fluid md-elevation-22">
        <!-- <b-tabs content-class="mt-3" fill>
        <b-tab title="Add Job" active>
          <AddJob></AddJob>
        </b-tab>
        <b-tab title="List Job"> -->
        <ListJob></ListJob>
        <!-- </b-tab>
      </b-tabs> -->
    </div>
</div>
</template>

<script>
import ListJob from "./components/ListJob";

export default {
    name: "TableCard",
    components: {
        ListJob,
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
