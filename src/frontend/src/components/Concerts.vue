<template>
    <div>
      <Header/>
      <div class="art">
        <h1 class="centered-text">Concerts</h1>
        <table class="centered-table"><!-- Πινακας στοιχείων -->
          <thead>
            <tr>
              <th>Name</th>
              <th>Times</th>
              <th>Seats</th>
              <th>Price</th>
              <th>Book Now</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="concert in concerts" :key="concert.cinemaNames">
                <td>{{ concert.festivalName }}</td>
                <td>{{ concert.festivalTimes }}</td>
                <td>{{ concert.festivalSeats }}</td>
                <td>{{ concert.festivalPrice }} €</td>
                <td><button @click="bookNow(concert); refreshPage()">Book Now</button></td>
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
    name: 'Concerts',
    components:{
      Header
    },
    data() {
      return {
        concerts: []
      }
    },
    methods: {
      fetchData() {//Get request για να λάβουμε όλα τα festival
        axios.get('http://localhost:8080/api/conapi/Concert', {
        })
        .then(response => {
          this.concerts = response.data;
        })
        .catch(error => {
          console.error(error);
        });
      },
        bookNow(concert) {
            axios.post('http://localhost:8080/api/conapi/Book', {//Post request για κράτηση festival
                username: this.message ,
                bookId: concert.festivalCode,
                bookNames: concert.festivalName,
                bookTimes: concert.festivalTimes,
                bookSeats: concert.festivalSeats,
                bookPrice: concert.festivalPrice
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