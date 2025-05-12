<template>
    <div class="nav"><!-- ανακατεύθησνση στις σελίδες -->
        <router-link  to="/home">Home</router-link>
        <router-link  to="/cinema">Cinema</router-link>
        <router-link  to="/sports">Sports</router-link>
        <router-link  to="/museums">Museums</router-link>
        <router-link  to="/concerts">Concerts</router-link>
        <router-link  to="/my-bookings">My Bookings</router-link>
        <a v-on:click="logout" href="/login">Log Out</a>
    </div>
</template>
<script>
export default{
    name:'Header',
    methods:{
        logout(){
            localStorage.clear();
            this.$router.push({name:'Login'})
        }
    }
}
</script>
<style>
.nav{
    background-color: #333;
    overflow: hidden;

}
.nav a{
    float: left;
    color: #ddd;
    padding: 14px 16px;
    text-align: center;
    font-size: 17px;
    text-decoration: none;
    margin-right: 5px;
}
.nav a:hover{
    background-color: #ddd;
    color: #333;
}
</style>