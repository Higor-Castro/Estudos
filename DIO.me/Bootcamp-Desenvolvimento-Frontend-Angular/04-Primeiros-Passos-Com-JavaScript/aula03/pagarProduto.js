const valor_produto = 100
const codigo = 4

if (codigo == 1){
    var desconto = valor_produto - (valor_produto * (10 / 100))
    console.log(`O valor do protudo passa ser: ${desconto} reais`)

}
else if(codigo ==2){
    desconto = valor_produto - (valor_produto * (15 / 100)  )
    console.log(`O valor do protudo passa ser: ${desconto} reais`)

}
else if (codigo == 3){
    desconto = valor_produto
    console.log(`O valor do protudo passa ser: ${desconto} reais`)

}
else if ( codigo == 4){
    var juros = valor_produto + (valor_produto * (10 / 100))
    console.log(`O valor do protudo passa ser: ${juros} reais`)
}
else {
    console.log('Opção invalida')
}

