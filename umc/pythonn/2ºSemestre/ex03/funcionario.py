class Funcionario:
    def __init__(self,nome,setor,chapa,cargo,salario):
        self.nome = nome
        self.setor = setor
        self.chapa = chapa
        self.cargo = cargo
        self.salario = salario
    def realizarTrabalho (self):
        print(f"O {self.nome} esta trabalhando no setor {self.setor}.")
    def funcao (self):
        print(f"O {self.nome} trabalha no cargo de {self.cargo}, registrado na matricula {self.chapa} , ganhamdo R${self.salario} ao mes ")
class Empressa :
    def __init__(self,cnpj,cep,fundacao,quamtiFuncionario,nomeEmpressa):
        self.cnpj = cnpj
        self.cep = cep
        self.fundacao = fundacao
        self.quinFuncionario = quamtiFuncionario
        self.nomeEmpressa = nomeEmpressa
        self.funcionarios = []
    def contratarFuncionario (self,funcionario):
        self.funcionarios.append(funcionario)
        print(f"A {self.nomeEmpressa} contratou o funcionario {funcionario.nome}")
        print(f"A {self.nomeEmpressa}, passa ter {float(self.quinFuncionario)+ 1} funcionarios")
    def localidade(self):
        print(f"A {self.nomeEmpressa} esta localizada no cep:{self.cep}, com seu cnpj:{self.cnpj} ")

listaFuncionario = ["nome","setor","chapa","cargo","salario" ]
lista1 = []
for i in range(5):
    pergunta = input(f"Informe {listaFuncionario[i]} do funcionario:")
    lista1.append(pergunta)
x= Funcionario(*lista1)
x.realizarTrabalho()
x.funcao()


listaEmpressa= ["cnpj","cep","fundação","quamtidade de funcionario","nome da empressa" ]
lista2 = []
for i in range(5):
    pergunta = input(f"Informe {listaEmpressa[i]} do empressa:")
    lista2.append(pergunta)
y= Empressa(*lista2)
y.contratarFuncionario(x)
y.localidade()


