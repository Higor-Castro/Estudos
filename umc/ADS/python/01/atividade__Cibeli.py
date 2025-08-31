

pessoas = []
while True:

    print('''Agenda Eletrônica
          
    1- Adicionar Contato
    2- Excluir Contato
    3- Listar todos os Contatos
    4- Alterar Contato
    5- Listar dados de um determinado contato
    6- Sair
    ''')

    opcao = int(input("Informe a opção desejada:"))

    while opcao < 1 or opcao > 6:
        opcao = int(input("Opção inválida. Informe a opção desejada:"))

    if opcao == 1:
        nome = input("Digite o nome desejado: ")
        tel = int(input("Digite o telefone:"))
        empresa = input("Informe a empresa:")
        pessoa = [nome, tel, empresa]
        pessoas.append(pessoa)
        print("Contato adicionado com sucesso!")

    elif opcao == 2:
        if len(pessoas) == 0:
            print("Agenda vazia. Nenhum contato para excluir.")
        else:
            nome = input("Digite o nome do contato que deseja excluir: ")
            encontrou = False
            for pessoa in pessoas:
                if pessoa[0] == nome:
                    pessoas.remove(pessoa)
                    encontrou = True
                    print("Contato removido com sucesso!")
            if not encontrou:
                print("Contato não encontrado.")

    elif opcao == 3:
        if len(pessoas) == 0:
            print("Agenda vazia.")
        else:
            print("Lista de Contatos:")
            for pessoa in pessoas:
                print("Nome:", pessoa[0])
                print("Telefone:", pessoa[1])
                print("Empresa:", pessoa[2])
                print()

    elif opcao == 4:
        if len(pessoas) == 0:
            print("Agenda vazia. Nenhum contato para alterar.")
        else:
            nome = input("Digite o nome do contato que deseja alterar: ")
            encontrou = False
            for pessoa in pessoas:
                if pessoa[0] == nome:
                    tel = int(input("Digite o novo telefone:"))
                    empresa = input("Informe a nova empresa:")
                    pessoa[1] = tel
                    pessoa[2] = empresa
                    encontrou = True
                    print("Contato alterado com sucesso!")

            if not encontrou:
                print("Contato não encontrado.")

    elif opcao == 5:
        if len(pessoas) == 0:
            print("Agenda vazia. Nenhum contato para listar.")
        else:
            nome = input("Digite o nome do contato que deseja listar: ")
            encontrou = False
            for pessoa in pessoas:
                if pessoa[0] == nome:
                    print("Nome:", pessoa[0])
                    print("Telefone:", pessoa[1])
                    print("Empresa:", pessoa[2])
                    encontrou = True
                   
            if not encontrou:
                print("Contato não encontrado.")

    elif opcao == 6:
        print("Encerrando a agenda eletrônica...")
        break
       

    print()  


       


        


