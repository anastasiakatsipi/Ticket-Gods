<template>
  <div class="full-screen" :style="{backgroundImage: 'url(' + currentImage + ')', backgroundSize: 'cover'}">
    <router-view/>
  </div>
  <audio ref="audioPlayer" controls autoplay loop style="display: none;">
    <source :src="musicLink" type="audio/mpeg">
  </audio>
  <button @click="toggleMusic" style="position: fixed; bottom: 20px; right: 20px; border: none; background: none; padding: 0;">
  <img src="../src/assets/speaker.png" style="width: 50px; height: 50px;">
  </button>
</template>

<script>


import Login from './components/Login.vue';
import Signup from './components/Signup.vue';
import Home from './components/Home.vue';

export default{
  name: 'App',
  components:{
    Home,
    Login,
    Signup
  },
    data() {
        return {
            images: [
                require('@/assets/theater.jpg'),
                require('@/assets/stadium.jpg'),
                require('@/assets/concert.jpg'),
                require('@/assets/museum.jpg')
            ],
            currentImageIndex: 0,
            musicLink: require("@/assets/music.mp3"), 
            isPlaying: true,
        }
    },
    mounted() {//Ένταση
      this.$refs.audioPlayer.volume = 0.5;
    },
    computed: {
        currentImage() {//αλλαγή εικόντας
            return this.images[this.currentImageIndex];
        }
    },
    created() {
        setInterval(() => {
            this.currentImageIndex = (this.currentImageIndex + 1) % this.images.length;
        }, 5000); //Αλλαγή ανα 5sec
    },
    methods: {
      toggleMusic() {//Κουμπί μουσικής
        this.isPlaying = !this.isPlaying;
        this.$refs.audioPlayer.volume = 0.5;
        this.isPlaying ? this.$refs.audioPlayer.play() : this.$refs.audioPlayer.pause();
      }
    }
}
</script>

<style>
.full-screen {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-repeat: no-repeat;
}
#app{
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  text-align: center;
  color: black;
  margin-top: auto;
  margin-bottom: auto;
}
.art{
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  text-align: center;
  color: white;
  margin-top: auto;
  margin-bottom: auto;
  text-shadow: -1px -1px 0 black, 1px -1px 0 black, -1px 1px 0 black, 1px 1px 0 black;
}

</style>