const valor_gasolina = 10
const valor_etanol = 5.6
const tipo_combustivel = 'gasolina'
const media = 5
const distancia = 100

if (tipo_combustivel === 'etanol'){
    var soma = valor_etanol * (distancia/media
    )
}

else if ( tipo_combustivel === 'gasolina'){
    var soma = valor_gasolina * (distancia/media
    )
}
else{
    console.log("Valor invalido!!")
}

console.log(`O valor que será gasto e de: ${soma} reais`)


