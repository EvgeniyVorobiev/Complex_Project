<template>
<body>
    <div class="container">
        <div class="row">
            <div class="col-8 gy-5" id="table">
                <h6 style="margin-top: 20%; text-align: center;">
                Здесь вы могли бы составить меню, нужно только</h6>
                <h6 style="text-align: center; color:blue; cursor: pointer;" @click="showLoginModal">войти</h6>
                <h6 style="text-align: center;">в приложение</h6>
            </div>
            <div class="col-3 gy-5" id="nutrients">
                
            </div>
        </div>
    </div>
</body>
</template>

<script>

    export default{
        data(){
        return {
            name: 'NoLoginMainComponent'
        }
        
    },
    methods:{
        showLoginModal() {
                this.$refs['login-modal'].show()
            }
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