<template>
    <div>
      <Header/>
      <div class="art">
        <h1 class="centered-text">Movies</h1>
        <table class="centered-table"><!-- Πινακας στοιχείων -->
          <thead>
            <tr>
              <th>Title</th>
              <th>Times</th>
              <th>Seats</th>
              <th>Price</th>
              <th>Book Now</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="cinema in cinemas" :key="cinema.cinemaNames">
              <td>{{ cinema.cinemaNames }}</td>
              <td>{{ cinema.cinemaTimes }}</td>
              <td>{{ cinema.cinemaSeats }}</td>
              <td>{{ cinema.cinemaPrice }} €</td>
              <td><button @click="bookNow(cinema); refreshPage()">Book Now</button></td>
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
    name: 'Cinema',
    components:{
      Header
    },
    data() {
      return {
        cinemas: []
      }
    },
    methods: {
      fetchData() {//Get request για να λάβουμε όλες τις ταινίες
        axios.get('http://localhost:8080/api/cineapi/Cinema', {
        })
        .then(response => {
          this.cinemas = response.data;
        })
        .catch(error => {
          console.error(error);
        });
      },
      bookNow(cinema) {
            axios.post('http://localhost:8080/api/cineapi/Book', {//Post request για κράτηση ταινιών
                username: this.message ,
                bookId: cinema.cinemaCode,
                bookNames: cinema.cinemaNames,
                bookTimes: cinema.cinemaTimes,
                bookSeats: cinema.cinemaSeats,
                bookPrice: cinema.cinemaPrice
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
    computed: {//global μεταβλιτη για το username
    ...mapGetters({ message: "getMessage" })
    },
    created() {
      this.fetchData(); // Καλούμε τη μέθοδο μόλις δημιουργηθεί το components
    },
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
