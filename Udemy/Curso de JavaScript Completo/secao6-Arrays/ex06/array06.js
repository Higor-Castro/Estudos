let arr = [1,2,3]
console.log("Reverse: ", arr.reverse())

soma = arr.reduce(function(acumulador, valorAtual,indice, array){
    console.log("Acumulador: ", acumulador, " ---- Valor Atual: ", valorAtual, " ---- Indice: ", indice," ---- Array: ", array)
    return acumulador + valorAtual
})
console.log("Reduce: ", soma)

const nome = ["Ana", "Bia", "Carlos", "Daniel", "Ana", "Bia", "Carlos", "Daniel", "Ana", "Bia", "Carlos", "Daniel"]

let nomesPorOrdem = nome.reduce(function(nomes, nomeAtual){
    let primeiraLetra = nomeAtual[0]
    if(nomes[primeiraLetra]){
        nomes[primeiraLetra] ++
    }
    else{
        nomes[primeiraLetra] = 1
    }
    return nomes
}, {})

console.log("Nomes por ordem: ", nomesPorOrdem)