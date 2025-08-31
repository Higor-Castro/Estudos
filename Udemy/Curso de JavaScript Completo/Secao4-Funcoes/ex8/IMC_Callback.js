// Minha Versão
function CalcularIMC(peso, altura, callback) {
    if (typeof peso !== "number" || typeof altura !== "number") {
        console.log("Erro: o tipo dos parâmetros deve ser número!!!!!");
        return;
    }

    let imc = peso / (altura * altura);

    if (typeof callback === "function") {
        return callback(imc);
    } else {
        return imc;
    }
}

function classificarIMC(imc) {
    if (typeof imc !== "number") {
        console.log("Erro: o tipo dos parâmetros deve ser número!!!");
        return;
    }

    if (imc < 16.9) {
        return 'Muito abaixo do peso!!!!!';
    } else if (imc >= 17 && imc <= 18.4) {
        return 'Abaixo do peso!!';
    } else if (imc >= 18.5 && imc <= 24.9) {
        return 'Peso Normal!!!';
    } else if (imc >= 25 && imc <= 29.9) {
        return 'Acima do peso!!!!';
    } else if (imc >= 30 && imc <= 34.9) {
        return 'Obesidade Grau 1 !!!!';
    } else if (imc >= 35 && imc <= 40) {
        return 'Obesidade Grau 2 !!!!!';
    } else {
        return 'Obesidade Grau 3 !!!!';
    }
}

let Aluno_imc = CalcularIMC(60, 1.60, classificarIMC);
console.log(Aluno_imc); 