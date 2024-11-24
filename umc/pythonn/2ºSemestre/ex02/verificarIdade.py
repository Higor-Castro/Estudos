pessoa = []
nome = []
ano_atual = int(input("Informe o ano em que você está usando o nosso desktop: "))
n = int(input("Informe a quantidade de pessoas: "))

for i in range(n):
    ano_nascimento = int(input(f"Informe o ano de nascimento da {i + 1}ª pessoa: "))
    idade = ano_atual - ano_nascimento
    nome_pessoa = input("Informe seu nome: ")
    pessoa.append(idade)
    nome.append(nome_pessoa)

for i in range(n):
    print(f"A idade de {nome[i]} é {pessoa[i]}")
    print(f"A idade de {nome[i]} em 50 anos será {pessoa[i] + 50}")