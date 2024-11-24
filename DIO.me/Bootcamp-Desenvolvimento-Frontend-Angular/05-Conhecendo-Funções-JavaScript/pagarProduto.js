function aplicarTaxa(taxa,valor_produto,codigo){
    if(codigo ==1  || codigo == 2 ){
      return valor_produto - (valor_produto * (taxa / 100))  
    }
    else{
        return valor_produto + (valor_produto * (taxa/ 100))
    }
    
}

function calcularProduto (codigo,valor_produto){
    if (codigo == 1){
        return `O valor do protudo passa ser: ${ aplicarJuros (10,valor_produto,codigo)} reais`
    
    }
    else if(codigo ==2){  
        return `O valor do protudo passa ser: ${aplicarJuros (15,valor_produto,codigo)} reais`
    
    }
    else if (codigo == 3){
        return `O valor do protudo passa ser: ${valor_produto} reais`
    
    }
    else if ( codigo == 4){
        return `O valor do protudo passa ser: ${aplicarJuros(10,valor_produto,codigo)} reais`
    }
    else {
        return 'Opção invalida'
    }
}
function main (){
    const valor_produto = 100
    const codigo = 1
    console.log(calcularProduto(codigo,valor_produto))
}
main()