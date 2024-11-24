"""
  A classe Pessoa tem dois atributos: primeiro_nome e ultimo_nome.

  A classe Pessoa tem dois metodos: o Construtor() e o metodos ImprimirNome()

"""

class Pessoa:
  def __init__(self, primeiro_nome, ultimo_nome):
    self.primeiro_nome = primeiro_nome
    self.ultimo_nome = ultimo_nome

  def ImprimirNome(self):
    print(self.primeiro_nome, self.ultimo_nome)

x = Pessoa("John", "Doe")
x.ImprimirNome()

"""
  A classe Estudante tem apenas o metodo construtor implementado.

  A classe Estudante herda a classe Pessoa, dessa forma,
  herda os atributos e metodos de Pessoa

"""

class Estudante(Pessoa):
  def __init__(self, primeiro_nome, ultimo_nome, ano_graduacao):
    #Pessoa.__init__(self, primeiro_nome, ultimo_nome)
    super().__init__(primeiro_nome, ultimo_nome)
    self.ano_graduacao = ano_graduacao