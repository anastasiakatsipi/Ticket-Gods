<template>
    <div class="art">
        <h1>Log In</h1>
    </div>
    <img alt="Logo" src="../assets/logo.png">
    <div class="login"><!--Απαραίτητα πεδια για να δωσει ο χρήστης credentials -->
        <input type="text" v-model="username" placeholder="Enter Username">
        <input type="password" v-model="password" placeholder="Enter Password">
        <button v-on:click="login">Log In</button>
        <button v-on:click="signup">Sign Up</button>
    </div>
</template>


<script>
import axios from 'axios'; 

export default {
    name: 'Login',
    data() {
        return {
            username: '',
            password: '',
        }
    },
    methods: {
        login() {
            axios.post('http://localhost:8080/api/auth/authenticate', {//Post method για να γινει authentication
                username: this.username,
                password: this.password,
            })
            .then(response => {
                this.$store.dispatch('setMessage', this.username),//global αποθηκευση του username
                this.$router.push({name:'Home'})//Ανακατεύθηνση στο home
            })
            .catch(error => {
                alert("Invalid User!");
            });
        },
        signup(){
            this.$router.push({name:'Signup'})//ανακατευθηση στο singup
        }
    }
}
</script>

<style scoped>
.login input{
    width: 300px;
    height: 40px;
    padding-left: 20px;
    display: block;
    margin-bottom: 20px;
    margin-right: auto;
    margin-left: auto;
    border: 1px solid burlywood;
}
.login button{
    width: 250px;
    height: 40px;
    padding-left: 20px;
    display: block;
    margin-bottom: 20px;
    margin-right: auto;
    margin-left: auto;
    border: 1px solid burlywood;
    background-color: beige;
    cursor: pointer;
}
.signup button {
    width: 250px;
    height: 40px;
    padding-left: 20px;
    display: block;
    margin-bottom: 20px;
    margin-right: auto;
    margin-left: auto;
    border: 1px solid burlywood;
    background-color: beige;
    cursor: pointer;
}
</style>
