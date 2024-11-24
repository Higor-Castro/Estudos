import random

perguntas = [
    "Telefonou para a vítima?",
    "Esteve no local do crime?",
    "Mora perto da vítima?",
    "Devia para a vítima?",
    "Já trabalhou com a vítima?"
]
contagem_sim = [0] * 5
contagem_cumplices = [0] * 5
contagem_suspeitos = [0] * 5
N = int(input("Informe o número de pessoas na simulação: "))

for _ in range(N):
    respostas = [random.randint(0, 1) for _ in range(5)]  
    for i, resposta in enumerate(respostas):
        contagem_sim[i] += resposta
    if sum(respostas) == 2:
        for i, resposta in enumerate(respostas):
            contagem_cumplices[i] += resposta
    elif sum(respostas) == 3 or sum(respostas) == 4:
        for i, resposta in enumerate(respostas):
            contagem_suspeitos[i] += resposta
porcentagens = [(sim / N) * 100 for sim in contagem_sim]
pergunta_mais_respondida = perguntas[porcentagens.index(max(porcentagens))]
pergunta_menos_respondida = perguntas[porcentagens.index(min(porcentagens))]
pergunta_mais_respondida_cumplices = perguntas[contagem_cumplices.index(max(contagem_cumplices))]
pergunta_menos_respondida_suspeitos = perguntas[contagem_suspeitos.index(min(contagem_suspeitos))]
print("\nResultado da simulação:")
for i, pergunta in enumerate(perguntas):
    print(f"{pergunta}: {porcentagens[i]:.2f}% de respostas SIM")
print(f"Pergunta mais respondida com SIM: {pergunta_mais_respondida}")
print(f"Pergunta menos respondida com SIM: {pergunta_menos_respondida}")
print(f"Pergunta mais respondida pelos Cúmplices: {pergunta_mais_respondida_cumplices}")
print(f"Pergunta menos respondida pelos Suspeitos: {pergunta_menos_respondida_suspeitos}")
