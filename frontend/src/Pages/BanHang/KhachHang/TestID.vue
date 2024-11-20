<template>
    <div>
        <p>{{ID}}</p>
    </div>
</template>
<script>

export default {
    data(){
        return{
            ID: null,
        }
    },
    mounted(){
        this.ID = localStorage.getItem('userId');
    }
}
</script>
