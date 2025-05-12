import { createRouter, createWebHashHistory } from "vue-router"
import Login from './components/Login.vue';
import Signup from './components/Signup.vue';
import Home from './components/Home.vue';
import Concerts from './components/Concerts.vue';
import Cinema from './components/Cinema.vue';
import Sports from './components/Sports.vue';
import Museums from './components/Museums.vue';
import MyBookings from './components/MyBookings.vue';

const routes = [
    {
        name: 'Home',
        component: Home,
        path: '/home'
    },
    {
        name: 'Signup',
        component: Signup,
        path: '/sign-up'
    },
    {
        name: 'Login',
        component: Login,
        path: '/'
    },
    {
        name: 'Concerts',
        component: Concerts,
        path: '/concerts'
    },
    {
        name: 'Cinema',
        component: Cinema,
        path: '/cinema'
    },
    {
        name: 'Sports',
        component: Sports,
        path: '/sports'
    },
    {
        name: 'Museums',
        component: Museums,
        path: '/museums'
    },
    {
        name:'MyBookings',
        component: MyBookings,
        path:'/my-bookings'
    }
];

const router = createRouter({
    history: createWebHashHistory(),
    routes
});

router.beforeEach((to, from, next) => {
    document.title = to.name;
    next();
  });
export default router;