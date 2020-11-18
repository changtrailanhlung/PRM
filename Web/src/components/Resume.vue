<template>
  <div class="resume" id="resume2">
    <div class="left-column">
      <div>
        <div class="headline">
          <span> [First name] [Middle name] </span>
          <span class="uppercase"> [Last name]</span>
        </div>

        <p>
          <span class="txt-full-white"> [Position]] </span>
          <br/>
          <span> [Address] </span>
        </p>
      </div>

      <div class="multi-line-txt">
        [About Info]
      </div>

      <div class="multi-line-txt">
       [Knowledge]
      </div>

      <a href="">
        <div class="block-marged txt-full-white">
          [Email]
        </div>
      </a>

      <div class="block-marged txt-full-white">
        [Phone]
      </div>

      <div class="social-container">
        <a href="">

          <div class="block-marged txt-full-white">
            <i class="fa fa-globe contact-icon"></i>
            [Website]
          </div>
        </a>

        <a href="" class="external-link">

          <i class="fa fa-github contact-icon"></i>
          <span class="block-marged txt-full-white">
           [Github]
          </span>
        </a>

        <a class="external-link">

          <svg width="20" height="20" viewBox="0 0 24 24"
            class="contact-icon-svg">
            <path d="M12 15.2L9.2 4.8 0 3.2l1.7 2.6 5.7.7.7 2.3-3.7-.4 1.3 2 3 .3L12 20.8l3.3-10.1 3-.3 1.3-2-3.7.4.7-2.3 5.7-.7L24 3.2l-9.2 1.6">
            </path>
          </svg>

          <span class="block-marged txt-full-white">
           
          </span>
        </a>

        <a class="external-link">
          <i class="fab fa-medium contact-icon"></i>
          <span class="block-marged txt-full-white">
            
          </span>
        </a>
      </div>

      <div class="hobbies-container">
        <!-- <span class="subheadline">Hobbies</span> -->
        <div class="hobbies-content">
          <a class="hobby-item">

            <i ></i>

            <span class="hobby-item__icon-label"> [Hobby] </span>
          </a>
        </div>
      </div>
    </div>

    <div class="left-column-bg">
      <!-- <div><a href="/otot">toto</a></div> -->
    </div>

    <div class="right-column">
      <div class="experience-section section">
        <div class="icon">
          <i class="material-icons small-icon">work</i>
          <span class="section-headline">[Experience]</span>
        </div>

        <div class="section-content">
          <a class="section-content__item">

            <span class="section-content__header"> [Company]</span>
            <span class="section-content__subheader"> [Position]</span>
            <div class="section-content__text">[Time period]]</div>
            <span class="section-content__text--light"> [Work description]</span>
          </a>
        </div>
      </div>

      <div class="education-section section">
        <div class="icon">
          <i class="material-icons">school</i>
          <span class="section-headline">[Edutcation]</span>
        </div>

        <div class="section-content">
          <a class="section-content__item">

            <span class="section-content__header">[School] </span>
            <span class="section-content__subheader">[Major]</span>
            <span class="section-content__text">[Time period] </span>
            <span class="section-content__text--light">[Description] </span>
          </a>
        </div>
      </div>

      <div class="projects-section section">
        <div class="icon">
          <i class="material-icons">code</i>
          <span class="section-headline">[Project]</span>
        </div>

        <div class="section-content">
          <a class="section-content__item">

            <span class="section-content__header">[Project name]</span>
            <span class="section-content__subheader">[Platform]</span>
            <span class="section-content__text"> [Description] </span>
            <span class="section-content__text--light"> [url]</span>
          </a>
        </div>
      </div>

      <div 
        class="skills-section section">
        <div class="icon">
          <i class="material-icons">done_all</i>
          <span class="section-headline"> [Skills] </span>
        </div>

        <div class="section-content-grid">
          <a class="grid-item">

            <i ></i>

            <span > [Skill]</span>
          </a>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default{
    
}
</script>

<style lang="less" scoped>

@accent-color: #A800FA;

.resume {
  display: flex;
  position: relative;

  font-family:'Roboto' !important;
  font-size: 0.9em;
}

.left-column {
  width: 30%;
  height: 100%;
  padding: 30px;
  padding-top: 45px;
  text-align: left;

  color: #ffffff;
  color:rgba(255,255,255,0.59);
  background-color: @accent-color;
  overflow: hidden;
  display: block;
  z-index: 2;

  opacity: 1; // lower this value (0.7 approx.) to see the cover image
  position: absolute;
}

// Background cover displayed on the left-column side
// ------------
.left-column-bg {
  // You can put your own cover image in the url path
  // --------------------------------------
  // background: url('../assets/cover.jpg');
  background-repeat: no-repeat;
  background-size: cover;
  background-position: 25% 25%;
  opacity: .4; // up this value to contrast the cover image

  height: 100%;
  width: 35%;
  padding: 30px;
  padding-top: 45px;

  display: block;
  overflow: hidden;
  position: relative;
  top: 0;
  z-index: 1;
}

.right-column {
  display: flex;
  flex-direction: column;
  padding: 30px;

  height: 100%;
  width: 65%;
}

a {
  color: inherit;
  cursor:pointer;
  text-decoration-line: none;

  &:visited {
    color: inherit;
  }
}

.material-icons {
  color: @accent-color;
  position: relative;
  top: 5px;
}

.font-awesome-icons {
  color: @accent-color;
  font-size: 1.3em;
  margin-right: 6px;
}

.small-icon {
  top: 2.5px;
  font-size: 1.4em;
}

.contact-icon {
  color: white;
  font-size: 1.5em;
  margin-right: 10px;

  top: 2px;
  position: relative;
}

.contact-icon-svg {
  margin-top: -2.5px;
  margin-right: 10px;

  transform: scale(1);

  top: 5px;
  position: relative;
}

.contact-icon-svg path {
  fill: white;
}

.external-link {
  display: block;
  margin-bottom: 5px;
}

.block-marged {
  margin-top: 15px;
  margin-bottom: 15px;
}

.multi-line-txt {
  margin-top: 30px;
  margin-bottom: 20px;
}

.social-container {
  margin-top: 30px;
  margin-bottom: 30px;
}

.headline {
  color: white;
  font-size: 1.3em;
  font-weight: bold;
}

.txt-full-white {
  color: white;
}

.uppercase {
  text-transform: uppercase;
}

.section-headline {
  color: @accent-color;
  display: inline-block;
  font-size: 1.2em;
  margin-left: 5px;
}

.section-content {
  margin-top: 10px;
  padding-left: 32px;
}

.section-content__item {
  display: block;
  margin-bottom: 10px;
}

.section-content__item-grid {
  flex: 1 1 0;

  margin-bottom: 10px;
  padding-right: 10px;
}

.section-content-grid {
  display: flex;
  flex-wrap: wrap;
  justify-content: space-between;

  margin-top: 10px;
  margin-bottom: 10px;
  padding-left: 32px;
}

.grid-item {
  padding-right: 20px;
}

.section-content__header {
  display: block;

  font-size: 1.1em;
  font-weight: 500;
}

.squarred-grid-item {
  display: block;

  border: 1px solid @accent-color;

  background-color: @accent-color;
  color: white;

  margin-top: 5px;
  padding: 5px;

  transition: .5s;

  &:hover {
    background-color: transparent;
    color: @accent-color;
    transition: .5s;
  }
}

.section-content__subheader {
  display: block;
  font-weight: 400;
}

.section-content__text {
  display: block;
  font-weight: 300;
}

.section-content__text--light {
  color: rgba(0,0,0,0.42);
  font-weight: 300;
}

.section-content__subheader,
.section-content__text--light,
.section-content__header {
  line-height: 1.5em;
}

.section {
  margin-top: 10px;
  margin-bottom: 10px;
}

.lang-icon {
  color: rgba(0,0,0,0.72);
  font-size: 3em;

  &:hover {
    color: @accent-color;
  }
}

.hobbies-container {
  margin-top: 30px;
}

.hobbies-content {
  display: flex;
  flex-direction: column;
}

.hobby-item {
  display: grid;
  grid-template-columns: 30px auto;

  color: rgba(255, 255, 255, .6);

  margin-right: 25px;
  margin-bottom: 10px;

  transition: .5s;

  &:hover {
    color: rgba(255, 255, 255, .8);
    transition: .5s;
  }
}

.hobby-item__icon {
  font-size: 1.3em;
}

.hobby-item__icon-label {
  top: 2.5px;
  position: relative;
}

.subheadline {
  color: rgba(255, 255, 255, .8);
  font-size: 1.2em;

  display: block;
  margin-bottom: 10px;
}

</style>
