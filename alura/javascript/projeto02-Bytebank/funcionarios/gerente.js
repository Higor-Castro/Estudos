import { Funcionario } from "./funcionario.js";

export class Gerente extends Funcionario {
    constructor(nome,salario,cpf){
        super(nome , salario ,cpf);
        this.bonificacao = 1.1;
    }

}