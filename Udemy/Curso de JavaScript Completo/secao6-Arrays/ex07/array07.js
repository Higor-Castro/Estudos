    //Minnha versao
const numeros = [1,3,4,1,4,5,3,5,8,9]
let numerosUnicos = numeros.reduce(function(numerosAcumuladdos, numeroAtual){
    if(!numerosAcumuladdos.includes(numeroAtual)){
        numerosAcumuladdos.push(numeroAtual)
    }
    return numerosAcumuladdos
},[])
console.log("Minha versao")
console.log("Numeros filtrados:", numerosUnicos)

    //Versao do professor
const numeros2 = [1,3,4,1,4,5,3,5,8,9]
let numerosUnicos2 = numeros2.reduce(function(numerosAcumuladdos, numeroAtual){
    if(numerosAcumuladdos.indexOf(numeroAtual) < 0){
        numerosAcumuladdos.push(numeroAtual)
    }
    return numerosAcumuladdos
},[])
console.log("Versao do professor") 
console.log("Numeros filtrados:", numerosUnicos2)