const nota1 = 10
const nota2 = 1
const nota3 = 1

var media = (nota1 + nota2 + nota3) / 3


if (media < 5){
    console.log(media ,'Reprovado!!')
}

else if ( media >= 5 && media <= 7){
    console.log( media ,'Recuperação!!')
}

else{
    console.log( media ,"Aprovado!!")
}
