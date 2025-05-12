<template>
    <div>
      <Header/>
      <div class="art">
        <h1>My Bookings</h1>
        <table class="centered-table">
          <thead>
            <tr><!--Πινακας στοιχείων-->
              <th>Booking Id</th>
              <th>Event name</th>
              <th>Time</th>
              <th>Seat</th>
              <th>Price</th>
              <th>Cancel Ticket</th>
            </tr>
          </thead>
          <tbody>
            <tr v-for="booking in bookings" :key="booking.bookNames">
                <td>{{ booking.bookId}}</td>
                <td>{{ booking.bookNames}}</td>
                <td>{{ booking.bookTimes }}</td>
                <td>{{ booking.bookSeats }}</td>
                <td>{{ booking.bookPrice}} €</td>
                <td><button @click="cancel(booking); refreshPage()">Cancel</button></td>
            </tr>
          </tbody>
        </table>
      </div>
    </div>
  </template>

<script>
import axios from 'axios';
import Header from './Header.vue'

export default {
  name: 'MyBookings',
  components:{
    Header
  },
  data() {
    return {
      bookings: []
    }
  },
  methods: {
    fetchData() {
      axios.get('http://localhost:8080/api/bookapi/Bookings', {//Get method για να λάβουμε τα στοιχεια του Bookings
      })
      .then(response => {
        this.bookings = response.data;
      })
      .catch(error => {
        console.error(error);
      });
    },
    cancel(booking) {
            axios.post('http://localhost:8080/api/bookapi/Cancel', {//Post method για να στείλουμε στοιχεια να αποθηκευτούν στο booking
                bookId: booking.bookId,
                bookNames: booking.bookNames,
                bookTimes: booking.bookTimes,
                bookSeats: booking.bookSeats,
                bookPrice: booking.bookPrice
            })
            .then(function (response) {

            })
            .catch(function (error) {
                  console.error(error);
            });
    },
    refreshPage() {
      window.location.reload();//reload παραθύρου απο το button
    }
  },
  created() {
    this.fetchData(); //Κλήση μεθόδου μόλις ξεκινήσει η εφαρμογή
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