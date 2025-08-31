import {AlunoModel} from "../model/CadastroModel.js";

const formAluno = document.getElementById("formAluno");
let msg = "";

// Adicionar o Aluno em forma de OBJ na lista do AlunoModel
    function adicionaAluno (e){
    e.preventDefault();
    //OBJ para adicionar ao AlunoModel.createAluno.
    let addAluno = {
        nome: e.target.nome.value,
        cpf: Number(e.target.cpf.value),
        email: e.target.email.value,
        senha: e.target.senha.value,
        telefone: Number(e.target.telefone.value)
    };

    // lista para validar os todos campos que vem do aluno
    const valores = ["nome", "cpf", "email", "senha", "telefone"];
    //Verrificar se estar faltando algum campo em forma de looping
    for(let campo of valores){
        if(!addAluno[campo]){
            msg = `Esta faltando Preencher esta valor: ${campo}`;
            return  alert(msg)
        }
    }

    AlunoModel.createAluno(addAluno);
    msg = `${addAluno.nome} Adicionado com Sucesso!!` ;
    alert(msg)
};

// Eventos teste
formAluno.addEventListener("submit", adicionaAluno);