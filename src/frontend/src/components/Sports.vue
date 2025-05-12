<template>
    <div>
      <Header/>
      <div class="art">
        <h1 class="centered-text">Sports Events</h1>
        <table class="centered-table"><!-- Πινακας στοιχείων -->
          <thead>
            <tr>
              <th>Event Name</th>
              <th>Times</th>
              <th>Seats</th>
              <th>Price</th>
              <th>Book Now</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="sport in sports" :key="sport.gameNames">
              <td>{{ sport.gameNames }}</td>
              <td>{{ sport.gameTimes }}</td>
              <td>{{ sport.gameSeats }}</td>
              <td>{{ sport.gamePrice }} €</td>
              <td><button @click="bookNow(sport); refreshPage()">Book Now</button></td>
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
    name: 'Sports',
    components:{
      Header
    },
    data() {
      return {
        sports: []
      }
    },
    methods: {
      fetchData() {//Get request για να λάβουμε όλα τα sport
        axios.get('http://localhost:8080/api/spoapi/Sport', {
        })
        .then(response => {
          this.sports = response.data;
        })
        .catch(error => {
          console.error(error);
        });
      },
      bookNow(sport) {
            axios.post('http://localhost:8080/api/spoapi/Book', {//Post request για κράτηση sport
                username: this.message ,
                bookId: sport.gameCode,
                bookNames: sport.gameNames,
                bookTimes: sport.gameTimes,
                bookSeats: sport.gameSeats,
                bookPrice: sport.gamePrice
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