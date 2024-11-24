import { Cliente} from "./Cliente.js";
import { Gerente } from "./funcionarios/gerente.js";
import { Diretor } from "./funcionarios/diretor.js";
import { SistemaAutoTendificacao } from "./SistemaAutoTendificacao.js"; 

const diretor = new Diretor ("Higor", 10000,12345678900);
diretor.cadastrarSenha("120");

const gerente = new Gerente ("Alice", 5000,123456989);
gerente.cadastrarSenha("123");

const cliente1 = new Cliente ("Lais",789456123,"456");

const diretorestaLogado = SistemaAutoTendificacao.login(diretor, "120");

const gerenteestaLogado = SistemaAutoTendificacao.login(gerente, "123");

const clienteEstaLogado = SistemaAutoTendificacao.login(cliente1,"456");

console.log(gerenteestaLogado,diretorestaLogado,clienteEstaLogado);