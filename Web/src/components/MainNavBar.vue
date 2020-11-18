<template>
  <div id="app">
    <md-toolbar class="md-transparent" md-elevation="10">
      <div class="md-toolbar-section-start">
          <h1 class="md-title font_title" style="">Hololike - Tớ Mang Clip Hololive Về Dịch</h1>
      </div>
    </md-toolbar>
  </div>
</template>

<script>
export default {
  name: "MainNavbar",
};
</script>

<style lang="scss" scoped>
.md-toolbar + .md-toolbar {
  margin-top: 16px;
}
.font_title {
  font-family: "Roboto";
}
.font_name {
  font-size: 72px;
  font-family: "000 Chinacat [TeddyBear]";
  color: #46c3f2;
  text-shadow: gray;
  border-radius: 75%;
  border-color: gray;
}
.bottom-gradient {
  background-image: linear-gradient(
    to top,
    rgba(0, 0, 0, 0.4) 0%,
    transparent 72px
  );
}

.repeating-gradient {
  background-image: repeating-linear-gradient(
    -45deg,
    rgba(255, 0, 0, 0.25),
    rgba(255, 0, 0, 0.25) 5px,
    rgba(0, 0, 255, 0.25) 5px,
    rgba(0, 0, 255, 0.25) 10px
  );
}
</style>
