
import os, time

import json
começo= 0
class pessoa:
    def __init__(self, idade = 0, altura = 0.0, nome = "", peso = 0.0):
        self.idade = idade
        self.altura = altura
        self.nome = nome
        self.peso = peso
    

class Aluno:

 

  def __init__(self,idade = 0, altura = 0.0, nome = "" , peso = 0.0,rgm=0.0):

    self.rgm=rgm
    pessoa.__init__(self, idade , altura , nome, peso)


 

  def imc(self):

    resultado = self.peso / (self.altura * self.altura)

    if resultado >= 40.0 :

      return "Obesidade classe III"

    elif resultado >= 35.0:

      return "Obesidade classe II"

    elif resultado >= 30.0 :

      return "Obesidade classe I"

    elif resultado >= 25.0:

      return "Excesso de Peso"

    elif resultado >= 18.5:

      return "Peso Normal"

    if resultado < 18.5:

      return "Abaixo do peso normal"

 
  def serializarJSON(self):
    dic = {}
    dic["nome"] = self.nome
    dic["idade"] = self.idade
    dic["altura"] = self.altura
    dic["peso"] = self.peso
    texto_json = json.dumps(dic, indent = 3)
    return texto_json

  def deserializarJSON(self, texto_json):
    dic = json.loads(texto_json)
    #print(dic)
    self.nome = dic["nome"]
    #print(dic["nome"])
    self.idade = dic["idade"]
    #print(dic["idade"])
    self.altura = dic["altura"]
    #print(dic["altura"])
    self.peso = dic["peso"]
    #print(dic["peso"])


class Professor:
  def __init__(self, idade = 0, altura = 0.0, peso = 0.0, nome = "", matricula = ""):
        self.matricula = matricula
        pessoa.__init__(self, idade , altura , nome, peso)

  def serializarProfJSON(self):

    dic = {}

    dic["nome"] = self.nome

    dic["idade"] = self.idade

    dic["altura"] = self.altura

    dic["peso"] = self.peso
    
    dic["matricula"] = self.matricula

    texto_json = json.dumps(dic, indent = 3)

    return texto_json

 

  def desializarProfJSON(self, texto_json):

    dic = json.loads(texto_json)

    #print(dic)

    self.nomeProf = dic["nome"]

    #print(dic["nome"])

    self.idadeProf = dic["idade"]

    #print(dic["idade"])

    self.alturaProf = dic["altura"]

    #print(dic["altura"])

    self.pesoProf = dic["peso"]

    #print(dic["peso"])

    self.matriculaProf = dic["matricula"]
    #print(dic["matricula"])

class disciplina:
  def __init__(self,codigo = "",nome = "",cargaHoraria = 0.0,turma = "",notaMinima = 0.0):
    self.codigo = codigo
    
    self.nome = nome
    
    self.cargaHoraria = cargaHoraria
    
    self.turma = turma
    
    self.notaMinima = notaMinima
  def serializarDiscipinaJSON(self):

    dic = {}

    dic["codigo"] = self.codigo

    dic["nome"] = self.nome

    dic["carga horaria"] = self.cargaHoraria

    dic["turma"] = self.turma
    
    dic["nota minima"] = self.notaMinima

    texto_json = json.dumps(dic, indent = 3)

    return texto_json

 

  def desializarDisciplinaSON(self, texto_json):

    dic = json.loads(texto_json)

    #print(dic)

    self.codigo = dic["codigo"]

    #print(dic["codigo"])

    self.nome = dic["nome"]

    #print(dic["nome"])

    self.cargaHoraria = dic["carga horaria"]

    #print(dic["carga horaria"])

    self.turma = dic["turma"]

    #print(dic["turma"])

    self.notaMinima = dic["nota minima"]
    #print(dic["nota minima"])


 

class ModuloAcademico:

    def __init__ (self):

        self.listaAlunos = []
        self.listaProf = []
        self.listaDisciplina = []
        if os.path.isfile('alunos.json'):
          self.RecuperarAlunos()

        if os.path.isfile('professor.json'):
          self.recuperarProfessores()

        if os.path.isfile('disciplina.json'):
          self.recuperarDisciplinas()

            

    def RecuperarAlunos (self):
          self.opcao = 1
          with open("alunos.json", 'r') as arquivo:
              lista_de_jsons_text = json.load(arquivo)
          
          for text in lista_de_jsons_text:
              dic2 = json.loads(text)

              idade = int(dic2["idade"])
              altura = float(dic2["altura"])
              peso = float(dic2["peso"])
              nome = dic2["nome"]
              rgm = int(dic2["rgm"])

              self.listaAlunos.append(Aluno(idade, altura, peso, nome, rgm))
      
    def recuperarProfessores (self ) :
            self.opcao = 6
            with open("professor.json", 'r') as arquivo:
                lista_de_jsons_text = json.load(arquivo)
            
            for text in lista_de_jsons_text:
                dic2 = json.loads(text)
                idade = int(dic2["idade"])
                altura = float(dic2["altura"])
                peso = float(dic2["peso"])
                nome = dic2["nome"]
                matricula = dic2["matricula"]

                self.listaProf.append(Professor(idade, altura, peso, nome, matricula))


    def recuperarDisciplinas (self):
            self.opcao = 10
            with open("disciplina.json", 'r') as arquivo:
                lista_de_jsons_text = json.load(arquivo)
            
            for text in lista_de_jsons_text:
                dic2 = json.loads(text)
                codigo = dic2["codigo"]
                nome = dic2["nome"]
                cargaHoraria = int(dic2["cargaHoraria"]) 
                turma = dic2["turma"] 
                notaMinima = float(dic2["notaMinima"])
                self.listaDisciplina.append(disciplina(codigo, nome, cargaHoraria, turma, notaMinima))

    def salvarAluno (self):
        lista = []
        arquivo = open("alunos.json", 'w')
        for a in self.listaAlunos :
          lista.append(a.serializarJSON())
        json.dump(lista, arquivo)
        print("Salvo!")

    def salvarProf(self):              
      lista = []
      arquivo = open("professor.json", 'w')
      for a in self.listaProf :
          lista.append(a.serializarProfJSON())
      json.dump(lista, arquivo)
      print("Salvo!")
    
    def salvarCurso(self):
        lista = []
        arquivo = open("disciplina.json", 'w')
        for a in self.listaDisciplina :
            lista.append(a.serializarDiscipinaJSON())
        json.dump(lista, arquivo)
        print("Salvo!")
    
  
        
 

    def cadastrarAluno(self):
        self.opcao = 1

        idade = int(input(f"Digite a idade:"))

        altura = float(input(f"Digite a altura:"))

        peso = float(input(f"Digite a peso:"))

        nome = input(f"Digite o nome:")
        
        rgm = int(input(f"Imforme o seu rgm:"))
        
        if os.path.isfile('alunos.json'):
           print("Cadastrado")
           return Aluno(idade, altura, peso, nome, rgm) 
       
        else:
            self.salvarAluno()
            return Aluno(idade, altura, peso, nome, rgm)
          

        

        

    def cadastrarProf(self):
            self.opcao = 6
            idade = int(input("Digite a idade: "))
            altura = float(input("Digite a altura: "))
            peso = float(input("Digite o peso: "))
            nome = input("Digite o nome: ")
            matricula = input("Informe a matrícula: ")
            if os.path.isfile('professor.json'):
                print("Cadastrado")
                return Professor(idade, altura, peso, nome, matricula) 
            
            else:
                self.salvarProf()
                return Professor(idade, altura, peso, nome, matricula)
          

    def cadastrarCurso(self):
          self.opcao = 10
        
          codigo = input(f"Digite o codigo:")

          nome = input(f"Digite o nome:")

          cargaHoraria = int(input(f"Digite a carga horaria:"))

          turma = input(f"Digite o turma:")
          
          notaMinima= int(input(f"Imforme a nota minima:"))
          
          # Salvar Curso
          if os.path.isfile('disciplina.json'):
              print("cadastrado")
              return disciplina(codigo,nome,cargaHoraria,turma,notaMinima)
          else:  
            self.salvarCurso()
            return disciplina(codigo, nome, cargaHoraria, turma, notaMinima)
       

 

    def imprimirAlunos(self):

        self.opcao = 1

        print("|Alunos:")

        print("|Nome|Altura|Idade|Peso|RGM")

        print("-------------------------------")

        for a in self.listaAlunos :

            print(a.nome, "|", a.altura, "|", a.idade, "|", a.peso,"|", a.rgm)


        print("-------------------------------")
        
        
    def imprimirProf(self):
        self.opcao = 6

        print("|Professores:")

        print("|Nome|Altura|Idade|Peso|Matricula")

        print("-------------------------------")

        for b in self.listaProf:

            print(b.nome, "|", b.altura, "|", b.idade, "|", b.peso,"|", b.matricula)
  

        print("-------------------------------")

    def imprimirCurso(self):

        self.opcao = 10

        print("|Disciplinas:")

        print("|Codigo| nome | carga Horaria | turma | nota Minima")

        print("-------------------------------")

        for a in self.listaDisciplina:

            print(a.codigo, "|", a.nome, "|", a.cargaHoraria, "|", a.turma,"|", a.notaMinima)
        print("-------------------------------")

 

    def Consulta_Peso(self):

        self.opcao = 1

        contador = 0

        for a in self.listaAlunos :

            if a.peso > 65:

                contador += 1

        print("Quantidade de alunos > 65 kg eh: ", contador)

        for a in self.listaAlunos :

            if a.peso > 65:

                print("O aluno ", a.nome, " tem imc: ", a.imc())
        

 

    def RemoverAluno(self): 
      if len(self.listaAlunos) == 0:
          print("Agenda vazia. Nenhum aluno para excluir.")
      else:
          deletar = input("Digite o rgm do aluno que deseja excluir: ")
          encontrou = False
          r = 0
          while r < len(self.listaAlunos):
            if self.listaAlunos[r].rgm == float(deletar):
              del self.listaAlunos [r]
              encontrou = True
              r = r + 1
              # Salvar Aluno
              if os.path.isfile('alunos.json'):
                print("Aluno cadastrado removido com sucesso!")
                break 
              else:
                self.cadastrarAluno()
                print("Aluno cadastrado removido com sucesso!")
                break
                
            if not encontrou:
              print("Contato não encontrado.")
              break
              
    def RemoverProf(self): 
      self.opcao=6
      if len(self.listaProf) == 0:
          print("Agenda vazia. Nenhum professor para excluir.")
      else:
          deletar = input("Digite o matricula do professor que deseja excluir: ")
          encontrou = False
          r = 0
          while r < len(self.listaProf):
            if self.listaProf[r].matricula == deletar:
              del self.listaProf [r]
              encontrou = True
              r = r + 1
              if os.path.isfile('professor.json'):
                  print("Professor removido com sucesso!")
                  break
              else:
                  self.salvarProf()
                  print("Professor removido com sucesso!")
                  break
                  
             
            if not encontrou:
              print("Contato não encontrado.")
              break
              
    def RemoverCurso(self): 
      self.opcao=10
      if len(self.listaDisciplina) == 0:
          print("Agenda vazia. Nenhuma Disciplina para excluir.")
      else:
          deletar = input("Digite o codigo da disciplina que deseja excluir: ")
          encontrou = False
          r = 0
          while r < len(self.listaDisciplina):
            if self.listaDisciplina[r].codigo == deletar:
              del self.listaDisciplina [r]
              encontrou = True
              r = r + 1
          # Salvar Curso
              if os.path.isfile('disciplina.json'):
                  print("Disciplina cadastrada removido com sucesso!")
                  break
              else:  
                self.salvarCurso()
                print("Disciplina cadastrada removido com sucesso!")
                break
            if not encontrou:
                print("Contato não encontrado.")
                break

          
          
                
                
    def updateAluno(self):
        if len(self.listaAlunos) == 0:
            print("Agenda vazia. Nenhum Professor para alterar.")
        else:
            alterar = input("Digite a matricula do aluno que deseja alterar: ")
            encontrou = False
            r = 0
            for lista in self.listaAlunos:
                if self.listaAlunos[r].rgm == float(alterar):
                    idade = int(input(f"Digite a idade:"))
                    altura = float(input(f"Digite a altura:"))
                    peso = float(input(f"Digite a peso:"))
                    nome = input(f"Digite o nome:")
                    rgm = int(input(f"Imforme o seu rgm:"))
                    encontrou = True
                    lista.idade= idade
                    lista.altura= altura
                    lista.peso= peso
                    lista.nome= nome
                    lista.rgm= rgm
                    if os.path.isfile('alunos.json'):
                      print("Contato alterado com sucesso!")
                      break 
                    else:
                      self.salvarAlun()
                      break
                if not encontrou:
                  print("Contato não encontrado.")
                  break
                  
              
    def updateProf(self):
        self.opcao=6
        if len(self.listaProf) == 0:
            print("Agenda vazia. Nenhum Professor para alterar.")
        else:
            alterar = input("Digite a matricula do professor que deseja alterar: ")
            encontrou = False
            r = 0
            for lista in self.listaProf:
                if self.listaProf[r].matriculaProf == alterar:
                    idade = int(input(f"Digite a idade:"))
                    altura = float(input(f"Digite a altura:"))
                    peso = float(input(f"Digite a peso:"))
                    nome = input(f"Digite o nome:")
                    matricula= input(f"Digite a matricul:")
                    encontrou = True
                    lista.idade= idade
                    lista.altura= altura
                    lista.peso= peso
                    lista.nome= nome
                    lista.matricula = matricula
                    if os.path.isfile('professor.json'):
                          print("Contato alterado com sucesso!")
                          break 
                      
                    else:
                          self.salvarProf()
                          print("Contato alterado com sucesso!")
                          break
                if not encontrou:
                  print("Contato não encontrado.")
                  break
                  
    def updateDisciplina(self):
        self.opcao=10
        if len(self.listaDisciplina) == 0:
            print("Agenda vazia. Nenhuma Disciplina para alterar.")
        else:
            alterar = input("Digite o codigo da disciplina que deseja alterar: ")
            encontrou = False
            r = 0
            for lista in self.listaDisciplina:
                if self.listaDisciplina[r].codigo == alterar:
                    codigo =input(f"Digite o  codigo:")
                    nome = input(f"Digite o nome:")
                    cargaHoraria = int(input(f"Digite a carga horia:"))
                    turma = input(f"Digite a turma:")
                    notaMinima= float(input(f"Imforme a nota minima:"))
                    encontrou = True
                    print("Contato alterado com sucesso!")
                    lista.codigo= codigo
                    lista.nome= nome
                    lista.cargaHoraria= cargaHoraria
                    lista.turma = turma
                    lista.notaMinima = notaMinima
                    
                      # Salvar Curso
                    if os.path.isfile('disciplina.json'):
                              print("cadastrado")
                              print("Disciplina cadastrada removido com sucesso!")
                              break
                    else:  
                            self.salvarCurso()
                            print("Disciplina cadastrada removido com sucesso!")
                            break
                if not encontrou:
                  print("Contato não encontrado.")
                  break

      
                  
             
 


    def show_menu(self):
        global opcao

        print("|############################################################|")

        print("|                        Cadastro Academico                  | ")

        print("|############################################################|")

        print("")

        print("")

        print("|                        Aluno                                | ")

        print("1) Cadastrar Alunos:")

        print("2) Imprimir Alunos:")

        print("3) Consulta Alunos > 65 Kg:")

        print("4) Remover alunos:")
        
        print("5) Autalizar Aluno:")

        print("|                        Professor                                | ")

        print("6) Cadastrar Professores:")
        
        print("7) Imprimir Professores: ")
        
        print("8) Remover Professores:")
        
        print("9) Autalizar Professor:")
      
        print("|                        Curso                                | ")
 
        print("10) Cadastrar Curso:")
        
        print("11) Imprimir Curso:")
        
        print("12) Remover Curso")
        
        print("13) Atualizar Curso:")
        
        print("14) Sair")

        

 

    def executar(self):
      

      while True:
            self.opcao = int(input("Qual eh a sua opcao?: "))
            
            self.show_menu()

            if self.opcao==1:

                aluno = self.cadastrarAluno()

                self.listaAlunos.append(aluno)

                time.sleep(1)
                return self.show_menu() , self.executar()

            elif  self.opcao==2:

                    self.imprimirAlunos()

                    time.sleep(1)
                    return self.show_menu() , self.executar()

            elif  self.opcao == 3:

                    self.Consulta_Peso()

                    time.sleep(1)
                    return self.show_menu() , self.executar()

  
            elif  self.opcao == 4:

                    self.RemoverAluno()

                    time.sleep(1)
                    return self.show_menu() , self.executar()
            elif  self.opcao == 5:

                      self.updateAluno()

                      time.sleep(1)
                      return self.show_menu() , self.executar()
            elif self.opcao==6:

                    professor = self.cadastrarProf()
                    self.listaProf.append(professor)

                    time.sleep(1)
                    return self.show_menu() , self.executar()
                    
            elif  self.opcao==7:

                    self.imprimirProf()

                    time.sleep(1)
                    return self.show_menu() , self.executar()
                    
            elif  self.opcao == 8:

                    self.RemoverProf()

                    time.sleep(1)
                    return self.show_menu() , self.executar()
                    
            elif  self.opcao == 9:

                      self.updateProf()

                      time.sleep(1)
                      return self.show_menu() , self.executar()

            elif self.opcao==10:

                disciplina = self.cadastrarCurso()

                self.listaDisciplina.append(disciplina)

                time.sleep(1)
                return self.show_menu() , self.executar()

            elif  self.opcao==11:

                    self.imprimirCurso()

                    time.sleep(1)
                    return self.show_menu() , self.executar()

            elif  self.opcao == 12:

                    self.RemoverCurso()

                    time.sleep(1)
                    return self.show_menu() , self.executar()
                    
            elif  self.opcao == 13:

                      self.updateDisciplina()

                      time.sleep(1)
                      return self.show_menu() , self.executar()



            elif  self.opcao == 14:

                    print("... SAINDO ... ")

                    exit(0)
                    
            else:
                print("Opção invalida tente novamente!!")
                return self.show_menu() , self.executar()

 

moduloA=ModuloAcademico()
moduloA.show_menu()
moduloA.executar()


