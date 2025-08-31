//Cria duas funções sum() e avarege() que recebem um array de números e retornam a soma e a média dos números, respectivamente.


    // Minha Versão
function sum (){
    let numeros = Array.from(arguments)
    let soma = 0
    for (n of numeros){
        soma += n
    }
    return soma
}

function avarege (){
    let numeeros = Array.from(arguments)
    let soma = 0
    for (n of numeeros){
        soma += n
    } 
    let media = soma / numeeros.length
    return media
}

console.log("Minha Versão",sum(1,2,3,4,5))
console.log("Minha Versão",avarege(1,2,3,4,5))


// Versão do professor
function sum2() {
    const number = [...arguments]
    return number.reduce(function(sum, atual) {
        return sum + atual
    }, 0)
}

function avarege2() {
    return sum2 (...arguments) / arguments.length
}

let soma = sum2(1, 2, 3, 4, 5)
console.log("Versão do professor",soma)
let media = avarege2(1, 2, 3, 4, 5) 
console.log("Versão do professor",media)