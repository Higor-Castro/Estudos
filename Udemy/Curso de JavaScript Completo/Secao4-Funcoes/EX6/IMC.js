
        // Versão do professor

function CalcIMc(peso,altura){
    if (peso === undefined || altura === undefined){
        throw Error("need two parameters: weight and height")
    }
    return peso / (altura * altura)
}
function classificaIMC(imc){

    if (imc <= 16.9){
        return 'Muito abaixo do peso'
    }
    else if (imc <= 18.4){
        return 'Abaixo do peso'
    }
    else if  (imc <= 24.9){
        return 'Peso Nomal'
    }
    else if (imc <= 29.9){
        return 'Acima do peso'
    }
    else if (imc <= 34.9){
        return 'Obesidade Grau 1'
    }
    else if (imc <= 40){
        return 'Obesidade Grau 2'
    }
    else{
        return 'Obesidade Grau 3'
    }


}
let Prof_imc = CalcIMc(80,1.65)
console.log(Prof_imc)
console.log(classificaIMC(Prof_imc))





        // Minha Versão
function CalcularIMC(peso, altura) {
    // Verifica se ambos os parâmetros são números
    if (typeof peso === "number" && typeof altura === "number") {
            return peso / (altura * altura);

    } else {
        console.log("Erro: o tipo dos parâmetros deve ser número!!!!!");
    }


}
function classificarIMC (imc){
    // Verifica se ambos os parâmetros são números
    if (typeof imc === "number" ) {

            if (imc<16.9){
                console.log("Muito abaixo do peso!!!!!")

            }
            else if (imc > 17 && imc < 18.4){
                console.log("Abaixo do peso!!")
            }
            else if  (imc > 18.5 && imc < 24.9){
                console.log("Peso Nomal!!!")
            }
            else if (imc > 25 && imc < 29.9){
                console.log("Acima do peso!!!!")

            }
            else if (imc > 30 && imc < 34.9){
                console.log("Obesidade Grau 1 !!!!")
            }
            else if (imc >35 && imc < 40){
                console.log("Obesidade Grau 2 !!!!!")
            }
            else{
                console.log("Obesidade Grau 3 !!!!")
            }

        }
    // Caso o tipo do parametro não for Number da este erro 
    else {
        console.log("Erro: o tipo dos parâmetros deve ser número!!!");
    }

    // Verifica se algum parâmetro não foi fornecido
    if ( imc === null && imc === undefined) {
        console.log("Erro: parâmetros não fornecidos corretamente!");
    }


}


let Aluno_imc = CalcularIMC(60,1.60)
classificarIMC(Aluno_imc)
