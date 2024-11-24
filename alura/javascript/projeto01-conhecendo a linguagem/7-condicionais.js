 console.log(`Trabalhando com condicionais`);

const listaDeDestinos = new Array (
    `Salvador`,
    `São Paulo`,
    `Rio de Janeiro`, );

    const idadeComprador = 15;
    const estaAcompanhada = true;
    const temPassagemComprada = true;



    console.log( "Destinos possíveis:"); 
console.log(listaDeDestinos);

if( 
    idadeComprador >=18  ||estaAcompanhada 
    ) {
    console.log("Boa Viagem!!");
    listaDeDestinos.splice(1,1 );//removendo item
}
else{
    //A pessoa é menor de iadeda
    console.log( "Não e maior de Idade e não posso  vender");
   
}
 

console.log("Embarque: \n\n");
if( idadeComprador >18 && temPassagemComprada){
    console.log("Boa viagem");
}
else{
    console.log("Você não pode embarcar");
}
 
console.log(listaDeDestinos);

// console.log( idadeComprador > 18);
// console.log(idadeComprador <18);
// console.log(idadeComprador<=18);
// console.log(idadeComprador >=18);
// console.log(idadeComprador ==18);