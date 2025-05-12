<template>
    <div class="art">
        <h1>Sign Up</h1>
    </div>
    <img alt="Logo" src="../assets/logo.png">
    <div class="signup"><!--Λήψη credentials-->
        <input type="text" v-model="username" placeholder="Enter Username">
        <input type="text" v-model="mail" placeholder="Enter Email">
        <input type="password" v-model="password" placeholder="Enter Password">
        <button v-on:click="signup">Sign Up</button>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Signup',
    data() {
        return {
            username: '',
            mail:'',
            password: ''
        }
    },
    methods: {
        signup() {
            axios.post('http://localhost:8080/api/auth/register', {//Post method για να σταλούν τα credentials
                username: this.username,
                mail: this.mail,
                password: this.password
            })
            .then(response => {
                this.$router.push({name:'Login'})//Rerouting στο login
            })
            .catch(error => {
                alert("Invalid User Data!");
            });
        }
    }
}
</script>

<style scoped>
.signup input{
    width: 300px;
    height: 40px;
    padding-left: 20px;
    display: block;
    margin-bottom: 20px;
    margin-right: auto;
    margin-left: auto;
    border: 1px solid burlywood;
}
.signup button{
    width: 250px;
    height: 40px;
    border: 1px solid burlywood;
    background-color: beige;
    cursor: pointer;
}
</style>
