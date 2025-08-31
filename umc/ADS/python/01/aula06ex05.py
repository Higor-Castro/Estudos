print("valor total da sua estadio em nosso hotel")
tap = input("por favor informe o tipo do seu apartamento:")
du = int(input("por favor informe os dias utilizados:"))
consumoInterno= int(input("por favor informe o seu consumo interno:"))
if tap == 'a' or tap == 'b' or tap == 'c' or tap == 'd':
    if tap == 'a':
        vd = 150
    elif tap == 'b':
        vd = 100
    elif tap == 'c':
        vd = 75
    elif tap == 'd':
         vd = 50
         
  
    valorTotalDiarias = du*vd
    subtotal = consumoInterno + valorTotalDiarias
    taxa = subtotal*(10/100)
    total = subtotal + taxa
    
    print(" diaria R$",valorTotalDiarias)
    print(" total sem a taxa de serviço R$",subtotal)
    print(" taxa de serviço R$",taxa)
    print(" total R$",total)
else:
    print("por favor informe o tipo correto do seu apartamento")
  
    
    