function teste(cb){
    console.log("Funcao teste")
   console.log(cb)
   if(typeof cb === "function"){
        cb(30)
   }   
}


const fn = function(param){
    console.log("2Funcao anonima de callback")
    console.log(param)
}
teste(fn)
