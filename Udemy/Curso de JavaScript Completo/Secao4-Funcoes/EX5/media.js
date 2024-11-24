
0//        Versão do professor

( function(){
    function calcularMedia(){
        let total = 0
        let qtd = arguments.length
        for(let i = 0; i<qtd ; i++){
            if(typeof arguments[i] !== "number"){
                throw Error("Only numbers")
            }
            total += arguments[i]
        }
        return total / qtd || 0
    }

    let media = calcularMedia(1,3,5,5)
    console.log(media)
})()



//          Minha versão

function calcularMedia (){
    let total = 0
    let x = 0
    //arguments esta fazendo o papel de uma lsta o while foi gerado para percorer em cada item do arguments
    while(x<arguments.length){
        if(typeof arguments[x] === "number"){ // typeof esta verificando qual o tipo de cada atributo do arguments, para poder verificar se é number
            total += arguments[x]
        }
        else{
            console.log("Erro o tipo não é numero !!!!!")
        }
        x++
    }
    if(x===0){
        return 0 
    }
    else{
        const media = total / x
        return media
    }
        

}
console.log(calcularMedia(1,[5,4,9]))
console.log(calcularMedia(1,14,14,2131,"dsds"))
console.log(calcularMedia())

