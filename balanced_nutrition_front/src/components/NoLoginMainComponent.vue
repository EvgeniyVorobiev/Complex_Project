<template>
<body>
    <div class="container">
        <div class="row">
            <div class="col-8" id="table">
                <h6 style="margin-top: 30%; text-align: center;" v-if="authorisedUser">
                Здесь вы могли бы составить меню, нужно только</h6>
                <h6 style="text-align: center;" v-if="authorisedUser">войти</h6>
                <h6 style="text-align: center;" v-if="authorisedUser">в приложение</h6>
            </div>
            <div class="col-3" id="nutrients">
                
            </div>
        </div>
    </div>
</body>
            
</template>

<script>
//import App from '../App.vue'
    export default{
        data(){
        return {
            name: 'NoLoginMainComponent',
        }
        
    },
    props:{
        authorisedUser: null,
        userIsAuthorised: null,
    },
    methods:{
        showLoginModal() {
                console.log(this.authorisedUser)
            },
        
    }

    }
</script>

<style scoped>
#table{
    height: 500px;
    box-shadow: 0 5px 30px 0 rgba(0,0,0,0.2);
}
#nutrients{

    box-shadow: 0 5px 30px 0 rgba(0,0,0,0.2);
    margin-left:auto;
}
</style>