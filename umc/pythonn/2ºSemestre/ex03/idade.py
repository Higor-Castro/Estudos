altura= []

idade = []

n =2

i=0

while i < n:

    idade.append(int(input("Informe a idade:")))

    altura.append(float(input("Informe a altura:")))

    i = i + 1

media =0

i=0

while i < n:

    media += altura[i]

i = i + 1

media = media / n

i = 0

quantidade1 =0

quantidade2=0

quantidade3=0

while i < n:

    if idade[i] > 13 and altura[i] > 1.80:

        quantidade1 = quantidade1 + 1

    if idade[i] < 13 and altura[i] > 1.80:

        quantidade2 = quantidade2 + 1

    if idade[i] == 13 and altura[i] == 1.80:

        quantidade3 = quantidade3 + 1

i = i+1

print(quantidade1)

print(quantidade2)

print(quantidade3)