function escrever_Nome (nome) {
    return  `Seu nome é: ${nome},`
   
}

function verificarIdade (idade){
    if (idade >= 18){
        return ` Você tem +18 `
    }
    else {
        return ` Você tem -18`
    }
}

function main (){ 
    const idade = 19
    const nome = 'Higor'
    console .log( escrever_Nome(nome) + verificarIdade(idade))
}

main()
