<template>
    <div>
      <Header/>
      <div class="art">
        <h1 class="centered-text">Museums</h1>
        <table class="centered-table"><!-- Πινακας στοιχείων -->
          <thead>
            <tr>
              <th>Exhibit Title</th>
              <th>Price</th>
              <th>Book Now</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="museum in museums" :key="museum.galeryNames">
              <td>{{ museum.galeryNames }}</td>
              <td>{{ museum.museumPrice }} €</td>
              <td><button @click="bookNow(museum); refreshPage()">Book Now</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
</template>
  
  <script>
  import axios from 'axios';
  import Header from './Header.vue'
  import { mapGetters } from "vuex";
  
  export default {
    name: 'Museums',
    components:{
      Header
    },
    data() {
      return {
        museums: []
      }
    },
    methods: {
      fetchData() {
        axios.get('http://localhost:8080/api/musapi/Museum', {//Get request για να λάβουμε όλα τα μουσεία
        })
        .then(response => {
          this.museums = response.data;
        })
        .catch(error => {
          console.error(error);
        });
      },
      bookNow(museum) {
            axios.post('http://localhost:8080/api/musapi/Book', {//Post request για κράτηση μουσείων
                username: this.message ,
                bookId: museum.museumCode,
                bookNames: museum.galeryNames,
                bookPrice: museum.museumPrice,
            })
            .then(function (response) {

            })
            .catch(function (error) {
                  console.error(error);
            });
        },
        refreshPage() {//Reload της σέλιδας για το button
          window.location.reload();
        }
    },
    computed: {
    ...mapGetters({ message: "getMessage" })//global μεταβλιτη για το username
    },
    created() {
      this.fetchData(); // Καλούμε τη μέθοδο μόλις δημιουργηθεί το components
    }
  }
</script>
  
<style scoped>
  .centered-text {
  text-align: center;
  }
  .centered-table {
    width: 100%;
    text-align: center;
  }
  .centered-table th, .centered-table td {
    text-align: center;
  }
  .hover-pointer:hover {
    cursor: pointer;
  }
</style>