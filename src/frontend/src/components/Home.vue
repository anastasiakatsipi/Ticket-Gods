<template>
    <Header />
    <img alt="Logo" src="../assets/logo.png">
    <div class="art">
        <h1>Welcome to TicketGods.com</h1>
    </div>
</template>

<script>
import Header from './Header.vue'

export default {
    name:'Home',
    components:{
        Header
    }
};
</script>

<style scoped>
.full-screen {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background-repeat: no-repeat;
}
</style>