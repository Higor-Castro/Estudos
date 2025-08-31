
# Para poder rodar o modulo em MYSQL não precisa criar nenhuma tabela no servidor MYSQL, pois a tabelas ja foram criadas no proprio codigo PYTHON.  so presisa colocar os seguintes comandos no servidor MYSQL: "create database escola;"  "use escola;"
# Para fazer a conexão com o servidor precisa-se do  host,user,password,database. Para atribuir essa conexão precisa colocar essas informaçõe na linha 429 , 430 e 431





import sqlite3
import json
import os
import mysql.connector

class pessoa :
   def __init__(self ,nome="", idade=0, altura=0.0, peso=0.0) :
        self.nome = nome
        self.idade = idade
        self.altura = altura
        self.peso = peso

class Aluno:
    def __init__(self, nome="", idade=0, altura=0.0, peso=0.0, rgm=0):
        self.rgm = rgm
        pessoa.__init__(self ,nome, idade, altura, peso)

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
        dic["rgm"] = self.rgm
        texto_json = json.dumps(dic, indent = 3)
        return texto_json

    def deserializarJSON(self, texto_json):
        dic = json.loads(texto_json)
    
        self.nome = dic["nome"]
   
        self.idade = dic["idade"]
     
        self.altura = dic["altura"]
       
        self.peso = dic["peso"]
        
        self.rgm = dic["rgm"]


class Professor(pessoa):
    def __init__(self, nome="", idade=0, altura=0.0, peso=0.0, matricula=0):
        self.matricula = matricula
        pessoa.__init__(self ,nome, idade, altura, peso)
        

    def serializarProfJSON(self):
        dic = {
            "nome": self.nome,
            "idade": self.idade,
            "altura": self.altura,
            "peso": self.peso,
            "matricula": self.matricula
        }
        texto_json = json.dumps(dic, indent=3)
        return texto_json

    def desializarProfJSON(self, texto_json):
        dic = json.loads(texto_json)
        self.nome = dic["nome"]
        self.idade = dic["idade"]
        self.altura = dic["altura"]
        self.peso = dic["peso"]
        self.matricula = dic["matricula"]






class Disciplina:
  def __init__(self, codigo=0, nome="", cargaHoraria=160, turma="", notaMinima=7):
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

    self.codigo = dic["codigo"]

    self.nome = dic["nome"]

    self.cargaHoraria = dic["carga horaria"]

    self.turma = dic["turma"]

    self.notaMinima = dic["nota minima"]




class BancoDeDadosAlunos:
    def __init__(self, nome_banco):
        self.conn = sqlite3.connect(nome_banco)
        self.cursor = self.conn.cursor()
        self.criar_tabela_alunos()

    def criar_tabela_alunos(self):
        create_table_query = '''
        CREATE TABLE IF NOT EXISTS alunos (
            rgm INTEGER PRIMARY KEY,
            nome TEXT,
            idade INTEGER,
            altura REAL,
            peso REAL
        )
        '''
        self.cursor.execute(create_table_query)
        self.conn.commit()

    def criar_aluno(self, aluno):
        inserir_aluno_query = "INSERT INTO alunos (rgm, nome, idade, altura, peso) VALUES (?, ?, ?, ?, ?)"
        if not aluno.nome.isalpha():
            raise ValueError ("O nome so deve conter letras.")
        self.cursor.execute(inserir_aluno_query, (aluno.rgm,aluno.nome, aluno.idade, aluno.altura, aluno.peso ))
        self.conn.commit()
        
    def listar_alunos(self):
        listar_alunos_query = "SELECT * FROM alunos"
        self.cursor.execute(listar_alunos_query)
        return self.cursor.fetchall()

    def atualizar_aluno(self, rgm, novo_nome, nova_idade, nova_altura, novo_peso):
        atualizar_aluno_query = "UPDATE alunos SET nome = ?, idade = ?, altura = ?, peso = ? WHERE rgm = ?"
        self.cursor.execute(atualizar_aluno_query, (novo_nome, nova_idade, nova_altura, novo_peso, rgm))
        self.conn.commit()

    def excluir_aluno(self, rgm):
        excluir_aluno_query = "DELETE FROM alunos WHERE rgm = ?"
        self.cursor.execute(excluir_aluno_query, (rgm,))
        self.conn.commit()


    def fechar_conexao(self):
        self.conn.close()

class BancoDeDadosProfessores:
    def __init__(self, nome_banco):
        self.conn = sqlite3.connect(nome_banco)
        self.cursor = self.conn.cursor()
        self.criar_tabela_professores()

    def criar_tabela_professores(self):
        create_table_query = '''
        CREATE TABLE IF NOT EXISTS professores (
            matricula INTEGER PRIMARY KEY,
            nome TEXT,
            idade INTEGER,
            altura REAL,
            peso REAL
        )
        '''
        self.cursor.execute(create_table_query)
        self.conn.commit()

    def criar_professor(self, professor):
        inserir_professor_query = "INSERT INTO professores (matricula, nome, idade, altura, peso) VALUES (?, ?, ?, ?, ?)"
        self.cursor.execute(inserir_professor_query, (professor.matricula, professor.nome, professor.idade, professor.altura, professor.peso))
        self.conn.commit()

    def listar_professores(self):
        listar_professores_query = "SELECT * FROM professores"
        self.cursor.execute(listar_professores_query)
        return self.cursor.fetchall()

    def atualizar_professor(self, matricula, novo_nome, nova_idade, nova_altura, novo_peso):
        atualizar_professor_query = "UPDATE professores SET nome = ?, idade = ?, altura = ?, peso = ? WHERE matricula = ?"
        self.cursor.execute(atualizar_professor_query, (novo_nome, nova_idade, nova_altura, novo_peso, matricula))
        self.conn.commit()

    def excluir_professor(self, matricula):
        excluir_professor_query = "DELETE FROM professores WHERE matricula = ?"
        self.cursor.execute(excluir_professor_query, (matricula,))
        self.conn.commit()

    def fechar_conexao(self):
        self.conn.close()


class BancoDeDadosDisciplinas:
    def __init__(self, nome_banco):
        self.conn = sqlite3.connect(nome_banco)
        self.cursor = self.conn.cursor()
        self.criar_tabela_disciplinas()

    def criar_tabela_disciplinas(self):
        create_table_query = '''
        CREATE TABLE IF NOT EXISTS disciplinas (
            codigo INTEGER PRIMARY KEY,
            nome TEXT,
            cargaHoraria INTEGER,
            turma TEXT,
            notaMinima REAL
        )
        '''
        self.cursor.execute(create_table_query)
        self.conn.commit()

    def criar_disciplina(self, disciplina):
        inserir_disciplina_query = "INSERT INTO disciplinas (codigo, nome, cargaHoraria, turma, notaMinima) VALUES (?, ?, ?, ?, ?)"
        self.cursor.execute(inserir_disciplina_query, (disciplina.codigo, disciplina.nome, disciplina.cargaHoraria, disciplina.turma, disciplina.notaMinima))
        self.conn.commit()

    def listar_disciplinas(self):
        listar_disciplinas_query = "SELECT * FROM disciplinas"
        self.cursor.execute(listar_disciplinas_query)
        return self.cursor.fetchall()

    def atualizar_disciplina(self, codigo, novo_nome, nova_cargaHoraria, nova_turma, nova_notaMinima):
        atualizar_disciplina_query = "UPDATE disciplinas SET nome = ?, cargaHoraria = ?, turma = ?, notaMinima = ? WHERE codigo = ?"
        self.cursor.execute(atualizar_disciplina_query, (novo_nome, nova_cargaHoraria, nova_turma, nova_notaMinima, codigo))
        self.conn.commit()

    def excluir_disciplina(self, codigo):
        excluir_disciplina_query = "DELETE FROM disciplinas WHERE codigo = ?"
        self.cursor.execute(excluir_disciplina_query, (codigo,))
        self.conn.commit()

    def fechar_conexao(self):
        self.conn.close()


class AlunoDatabase:
    def __init__(self, host, user, password, database):
        self.conn = mysql.connector.connect(
            host=host,
            user=user,
            password=password,
            database=database
        )
        self.cursor = self.conn.cursor()
        self.criar_tabela_alunos()
        


    def criar_tabela_alunos(self):
        create_table_query = '''
        CREATE TABLE IF NOT EXISTS alunos (
            rgm INT PRIMARY KEY,
            nome VARCHAR(255),
            idade INT,
            altura FLOAT,
            peso FLOAT
        )
        '''
        self.cursor.execute(create_table_query)
        self.conn.commit()

    def cadastrar_aluno(self, aluno):
        inserir_aluno_query = "INSERT INTO alunos (rgm, nome, idade, altura, peso) VALUES (%s, %s, %s, %s, %s)"
        self.cursor.execute(inserir_aluno_query, (aluno.rgm, aluno.nome, aluno.idade, aluno.altura, aluno.peso))
        self.conn.commit()

    def listar_alunos(self):
        listar_alunos_query = "SELECT * FROM alunos"
        self.cursor.execute(listar_alunos_query)
        return self.cursor.fetchall()

    def atualizar_aluno(self, rgm, novo_nome, nova_idade, nova_altura, novo_peso):
        atualizar_aluno_query = "UPDATE alunos SET nome = %s, idade = %s, altura = %s, peso = %s WHERE rgm = %s"
        self.cursor.execute(atualizar_aluno_query, (novo_nome, nova_idade, nova_altura, novo_peso, rgm))
        self.conn.commit()

    def excluir_aluno(self, rgm):
        excluir_aluno_query = "DELETE FROM alunos WHERE rgm = %s"
        self.cursor.execute(excluir_aluno_query, (rgm,))
        self.conn.commit()

    def fechar_conexao(self):
        self.conn.close()

class ProfessoresDatabase:
    def __init__(self, host, user, password, database):
        self.conn = mysql.connector.connect(
            host=host,
            user=user,
            password=password,
            database=database
        )
        self.cursor = self.conn.cursor()
        self.criar_tabela_professores()

    def criar_tabela_professores(self):
        create_table_query = '''
        CREATE TABLE IF NOT EXISTS professores (
            matricula INTEGER PRIMARY KEY,
            nome TEXT,
            idade INTEGER,
            altura REAL,
            peso REAL
        )
        '''
        self.cursor.execute(create_table_query)
        self.conn.commit()

    def criar_professor(self, professor):
        inserir_professor_query = "INSERT INTO professores (matricula, nome, idade, altura, peso) VALUES (%s, %s, %s, %s, %s)"
        self.cursor.execute(inserir_professor_query, (professor.matricula, professor.nome, professor.idade, professor.altura, professor.peso))
        self.conn.commit()

    def listar_professores(self):
        listar_professores_query = "SELECT * FROM professores"
        self.cursor.execute(listar_professores_query)
        return self.cursor.fetchall()

    def atualizar_professor(self, matricula, novo_nome, nova_idade, nova_altura, novo_peso):
        atualizar_professor_query = "UPDATE professores SET nome = %s, idade = %s, altura = %s, peso = %s WHERE matricula = %s"
        self.cursor.execute(atualizar_professor_query, (novo_nome, nova_idade, nova_altura, novo_peso, matricula))
        self.conn.commit()

    def excluir_professor(self, matricula):
        excluir_professor_query = "DELETE FROM professores WHERE matricula = %s"
        self.cursor.execute(excluir_professor_query, (matricula,))
        self.conn.commit()

    def fechar_conexao(self):
        self.conn.close()

class disciplinaDatabase:
    def __init__(self, host, user, password, database):
        self.conn = mysql.connector.connect(
            host=host,
            user=user,
            password=password,
            database=database
        )
        self.cursor = self.conn.cursor()
        self.criar_tabela_disciplinas()

    def criar_tabela_disciplinas(self):
        create_table_query = '''
        CREATE TABLE IF NOT EXISTS disciplinas (
            codigo INTEGER PRIMARY KEY,
            nome TEXT,
            cargaHoraria INTEGER,
            turma TEXT,
            notaMinima REAL
        )
        '''
        self.cursor.execute(create_table_query)
        self.conn.commit()

    def criar_disciplina(self, disciplina):
        inserir_disciplina_query = "INSERT INTO disciplinas (codigo, nome, cargaHoraria, turma, notaMinima) VALUES (%s, %s, %s, %s, %s)"
        self.cursor.execute(inserir_disciplina_query, (disciplina.codigo, disciplina.nome, disciplina.cargaHoraria, disciplina.turma, disciplina.notaMinima))
        self.conn.commit()

    def listar_disciplinas(self):
        listar_disciplinas_query = "SELECT * FROM disciplinas"
        self.cursor.execute(listar_disciplinas_query)
        return self.cursor.fetchall()

    def atualizar_disciplina(self, codigo, novo_nome, nova_cargaHoraria, nova_turma, nova_notaMinima):
        atualizar_disciplina_query = "UPDATE disciplinas SET nome = %s, cargaHoraria = %s, turma = %s, notaMinima = %s WHERE codigo = %s"
        self.cursor.execute(atualizar_disciplina_query, (novo_nome, nova_cargaHoraria, nova_turma, nova_notaMinima, codigo))
        self.conn.commit()

    def excluir_disciplina(self, codigo):
        excluir_disciplina_query = "DELETE FROM disciplinas WHERE codigo = %s"
        self.cursor.execute(excluir_disciplina_query, (codigo,))
        self.conn.commit()

    def fechar_conexao(self):
        self.conn.close()




class ModuloAcademico:
    def __init__(self, ):
        self.opcao = 0
        self.listaAlunos = []
        self.listaProfessores = []
        self.listaDisciplinas = []
        self.db = BancoDeDadosAlunos("alunos.db")
        self.dbp = BancoDeDadosProfessores("professores.db")
        self.dbc = BancoDeDadosDisciplinas("disciplina.db")
        self.mysql_alunos = AlunoDatabase("localhost", "seu_username", "seu_password", "escola")
        self.mysql_professores= ProfessoresDatabase("localhost", "seu_username", "seu_password", "escola" )
        self.mysql_disciplina = disciplinaDatabase("localhost", "seu_username", "seu_password", "escola")
        self.RecuperarAlunos()
        self.recuperarProfessores()
        self.recuperarDisciplinas()
    

    def cadastrarAluno(self):
            nome = input("Digite o nome do aluno: ")
            idade = int(input("Digite a idade do aluno: "))
            altura = float(input("Digite a altura do aluno: "))
            peso = float(input("Digite o peso do aluno: "))
            RGM = int(input("Digite o RGM do aluno: ") )
            self.alunooo = Aluno(nome,idade,altura,peso,RGM)
            self.listaAlunos.append(self.alunooo)
            self.salvarAluno() 

    def cadastrarProfessor(self):
        nome = input("Digite o nome do professor: ")
        idade = int(input("Digite a idade do professor: "))
        altura = float(input("Digite a altura do professor: "))
        peso = float(input("Digite o peso do professor: "))
        matricula = int(input("Digite a matricula do professor: "))
        self.professorrr = Professor(nome, idade, altura, peso, matricula)
        self.listaProfessores.append (self.professorrr)
        self.salvarProf()
        
        

    def cadastrarDisciplina(self):
        codigo = int(input("Digite o codigo da disciplina: "))
        nome = input("Digite o nome da disciplina: ")
        cargaHoraria = int(input("Digite a carga horaria da disciplina: "))
        turma = input("Digite a turma da disciplina: ")
        notaMinima = float(input("Digite a nota minima da disciplina: "))
        self.disciplinaaa = Disciplina(codigo, nome, cargaHoraria, turma, notaMinima)
        self.listaDisciplinas.append (self.disciplinaaa)
        self.salvarCurso()
  


    def imprimirAluno(self):
        imprimir = int(input("Digite em qual tipo de arquivo deseja imprimir 1-(JSON)  2-(SQLITE) 3-(MYSQL): "))
        if imprimir == 2:
            if os.path.isfile("alunos.db"):
                alunos = self.db.listar_alunos()
                for aluno in alunos:
                    print(f"RGM: {aluno[0]}, Nome: {aluno[1]}, Idade: {aluno[2]}, Altura: {aluno[3]}, Peso: {aluno[4]}")
            else:
                print("Não tem este arquivo.")
        elif imprimir == 1:
            if os.path.isfile('alunos.json'):
                for a in self.listaAlunos :
                    print("Nome:",a.nome, "Idade:", a.idade, "Altura:", a.altura,  "Peso:", a.peso, "RGM:", a.rgm)
            else:
                print("Não tem este arquivo.")
        elif imprimir == 3:
            alunos = self.mysql_alunos.listar_alunos()
            for aluno in alunos:
                print(f"RGM: {aluno[0]}, Nome: {aluno[1]}, Idade: {aluno[2]}, Altura: {aluno[3]}, Peso: {aluno[4]}")
        else:
                print("Não tem este arquivo.")

  

    def imprimirProfessor(self):
        imprimir = int(input("Digite em qual tipo de arquivo deseja imprimir 1-(JSON)  2-(SQLITE) 3-(MYSQL): "))
        if imprimir == 2:
            if os.path.isfile("professores.db"):
                professores = self.dbp.listar_professores()
                for professor in professores:
                    print(f"Matrícula: {professor[0]}, Nome: {professor[1]}, Idade: {professor[2]}, Altura: {professor[3]}, Peso: {professor[4]}")
            else:
                print("Não tem este arquivo.")
        elif imprimir == 1:
            if os.path.isfile('professor.json'):
                for a in self.listaProfessores :
                    print("Nome:",a.nome, "Idade:", a.idade, "Altura:", a.altura, "Peso:", a.peso, "Matricula:", a.matricula)
            else:
                print("Não tem este arquivo.")
        if imprimir == 3:
                professores = self.mysql_professores.listar_professores()
                for professor in professores:
                    print(f"Matrícula: {professor[0]}, Nome: {professor[1]}, Idade: {professor[2]}, Altura: {professor[3]}, Peso: {professor[4]}")
                
        else:
            print("Não tem este arquivo.")

    def imprimirDisciplina(self):
        imprimir = int(input("Digite em qual tipo de arquivo deseja imprimir 1-(JSON)  2-(SQLITE) 3-(MYSQL): "))
        if imprimir == 2:
            if os.path.isfile("professores.db"):
                disciplinas = self.dbc.listar_disciplinas()
                for disciplina in disciplinas:
                    print(f"Código: {disciplina[0]}, Nome: {disciplina[1]}, Carga Horária: {disciplina[2]}, Turma: {disciplina[3]}, Nota Mínima: {disciplina[4]}")
            else:
                print("Não tem este arquivo.")
        elif imprimir == 1:
            if os.path.isfile('disciplina.json'):
                for a in self.listaDisciplinas :
                    print("Codigo:",a.codigo, "Nome:", a.nome, "CargaHoraria:", a.cargaHoraria, "Turma:", a.turma, "NotaMinima:", a.notaMinima)
            else:
                print("Não tem este arquivo.")
        elif imprimir == 3:
            disciplinas= self.mysql_disciplina.listar_disciplinas()
            for disciplina in disciplinas:
                print(f"Código: {disciplina[0]}, Nome: {disciplina[1]}, Carga Horária: {disciplina[2]}, Turma: {disciplina[3]}, Nota Mínima: {disciplina[4]}")
        else:
                print("Não tem este arquivo.")




    def removerAluno(self):
        remover = int(input("Digite e qual tipo de arquivo deseja remover 1-(JSON)  2-(SQLITE) 3-(MYSQL): "))
        RGM = int(input("Digite o RGM do aluno a ser removido: "))
        if remover == 2:
            if os.path.isfile("alunos.db"):
                alunos = self.db.listar_alunos()
                for aluno in alunos:
                    if aluno[0] == RGM:
                        self.db.excluir_aluno(RGM)
                        print("Aluno, RGM [", RGM, "], removido!")
                    else:
                        print("Aluno, RGM [", RGM, "], não encontrado!")
        elif remover == 1:

            if os.path.isfile('alunos.json'):
                i = 0
                while i < len(self.listaAlunos):
                    if self.listaAlunos[i].rgm == RGM:
                        del self.listaAlunos[i]
                        print("Aluno, RGM [", RGM, "], removido!")
                        self.alunooo=None
                        self.salvarAluno()
                        break
                    else:
                        i = i + 1
                        print("Aluno, RGM [", RGM, "], nao encontrado!")
        elif remover == 3:
                alunos = self.mysql_alunos.listar_alunos()
                for aluno in alunos:
                    if aluno[0] == RGM:
                        self.mysql_alunos.excluir_aluno(RGM)
                        print("Aluno, RGM [", RGM, "], removido!")
                    else:
                        print("Aluno, RGM [", RGM, "], não encontrado!")
        else:
            print("Opção invalida")
        
    
    def removerProfessor(self):
        remover = int(input("Digite e qual tipo de arquivo deseja remover 1-(JSON)  2-(SQLITE)  3-(MYSQL): "))
        matricula = int(input("Digite a marticula do professor a ser removido: "))
        if remover ==2:
            if os.path.isfile("professores.db"):
                profs = self.dbp.listar_professores()
                for prof in profs:
                    if prof[0] == matricula:
                        self.dbp.excluir_professor(matricula)
                        print("Professor, matricula [", matricula, "], removido!")
                       
                    else:
                        print("Professor, matricula [", matricula, "], nao encontrado!")
        elif remover == 1:
            if os.path.isfile('professor.json'):
                i = 0
                while i < len(self.listaProfessores):
                    if self.listaProfessores[i].matricula == matricula:
                        del self.listaProfessores[i]
                        print("Professor, matricula [", matricula, "], removido!")
                        self.salvarProf()
                        break
                    else:
                        i = i + 1
                        print("Professor, matricula [", matricula, "], nao encontrado!")

        elif remover ==3:
                profs = self.mysql_professores.listar_professores()
                for prof in profs:
                    if prof[0] == matricula:
                        self.mysql_professores.excluir_professor(matricula)
                        print("Professor, matricula [", matricula, "], removido!")
        else:
            print("Opção invalida")
    
        


        

    def removerDisciplina(self):
        remover = int(input("Digite e qual tipo de arquivo deseja remover 1-(JSON)  2-(SQLITE) 3-(MYSQL): "))
        codigo = int(input("Digite oo codigo da disciplina a ser removida: "))
        if remover ==2:
            if os.path.isfile("professores.db"):
                disci = self.dbc.listar_disciplinas()
                for discis in disci:
                    if discis[0]== codigo:
                        self.dbc.excluir_disciplina(codigo)
                        print("Disciplina, codigo [", codigo, "], removida!")
                    else:
                        print("Disciplina, codigo [", codigo, "], nao encontrado!")
        elif remover ==1:
            if os.path.isfile('disciplina.json'):
                i = 0
                while i < len(self.listaDisciplinas):
                    if self.listaDisciplinas[i].codigo == codigo:
                        del self.listaDisciplinas[i]
                        print("Disciplina, codigo [", codigo, "], removida!")
                        self.salvarCurso()
                        break
                    else:
                        i = i + 1
                        print("Disciplina, codigo [", codigo, "], nao encontrado!")
        elif remover ==3:
                disci = self.mysql_disciplina.listar_disciplinas()
                for discis in disci:
                    if discis[0]== codigo:
                        self.mysql_disciplina.excluir_disciplina(codigo)
                        print("Disciplina, codigo [", codigo, "], removida!")
                    else:
                        print("Disciplina, codigo [", codigo, "], nao encontrado!")
        else:
            print("Opção invalida")
        

            

    def RecuperarAlunos(self):
            if os.path.isfile('alunos.json'):
                self.listaAlunos.clear()
                arquivo = open("alunos.json", 'r')
                lista_de_jsons_text = json.load(arquivo)
                for text in lista_de_jsons_text:
                    a = Aluno()
                    a.deserializarJSON(text)
                    self.listaAlunos.append(a)

    def recuperarProfessores(self):
            if os.path.isfile('professor.json'):
                self.listaProfessores.clear()
                arquivo = open("professor.json", 'r')
                lista_de_jsons_text = json.load(arquivo)
                for text in lista_de_jsons_text:
                    a = Professor()
                    a.desializarProfJSON(text)
                    self.listaProfessores.append(a)  


    def recuperarDisciplinas(self):
            if os.path.isfile('disciplina.json'):
                self.listaDisciplinas.clear()
                arquivo = open("disciplina.json", 'r')
                lista_de_jsons_text = json.load(arquivo)
                for text in lista_de_jsons_text:
                    a = Disciplina()
                    a.desializarDisciplinaSON(text)
                    self.listaDisciplinas.append(a)


    def salvarAluno (self):
        salvar = int(input("Informe o numero que deseja Salvar 1-(JSON) 2-(SQLITE) 3-(MYSQL): "))
        if salvar == 1:
            lista = []
            arquivo = open("alunos.json", 'w')
            for a in self.listaAlunos :
                 lista.append(a.serializarJSON())
            json.dump(lista, arquivo)
            print("Salvo!")
        elif salvar == 2:
            self.db.criar_aluno(self.alunooo)
        elif salvar == 3:
            self.mysql_alunos.cadastrar_aluno(self.alunooo)
        else:
            print("Opção invalida")
        

    def salvarProf(self): 
      salvar = int(input("Informe o numero que deseja Salvar 1-(JSON) 2-(SQLITE) 3-(MYSQL): "))
      if salvar == 1:        
        lista = []
        arquivo = open("professor.json", 'w')
        for a in self.listaProfessores :
            lista.append(a.serializarProfJSON())
        json.dump(lista, arquivo)
        print("Salvo!")
      elif salvar == 2:
          self.dbp.criar_professor(self.professorrr)
      elif salvar == 3:
          self.mysql_professores.criar_professor(self.professorrr)
      else:
            print("Opção invalida")
    
    def salvarCurso(self):
        salvar = int(input("Informe o numero que deseja Salvar 1-(JSON) 2-(SQLITE) 3-(MYSQL): "))
        if salvar == 1:
            lista = []
            arquivo = open("disciplina.json", 'w')
            for a in self.listaDisciplinas :
                lista.append(a.serializarDiscipinaJSON())
            json.dump(lista, arquivo)
            print("Salvo!")
        elif salvar == 2 :
            self.dbc.criar_disciplina(self.disciplinaaa)
        elif salvar ==3:
            self.mysql_disciplina.criar_disciplina(self.disciplinaaa)
        else:
            print("Opção invalida")

    def atualizarAluno(self):
        atualiza = int(input("Digite e qual tipo de arquivo deseja atualiza 1-(JSON)  2-(SQLITE) 3-(MYSQL): "))
        RGM= int(input("Digite o RGM do aluno a ser atualizado: "))
        if atualiza == 2:
            if os.path.isfile("alunos.db"):
                alunos = self.db.listar_alunos()
                for aluno in alunos:
                    if aluno[0] == RGM:
                            novo_nome = input("Digite o novo nome do aluno: ")
                            novo_idade = int(input("Digite a nova idade do aluno: "))
                            novo_altura = float(input("Digite a nova altura do aluno: "))
                            novo_peso = float(input("Digite o novo peso do aluno: "))
                            self.db.atualizar_aluno(RGM,novo_nome,novo_idade,novo_altura,novo_peso)
                            print("Aluno com RGM [", RGM, "] atualizado!")
                            
                    else:
                        print("Aluno, RGM [", RGM, "], não encontrado!")
        elif atualiza == 1:
            
            if os.path.isfile('alunos.json'):
                r = 0
                for aluno in self.listaAlunos:
                    if self.listaAlunos[r].rgm== RGM:
                        aluno.nome = input("Digite o novo nome do aluno: ")
                        aluno.idade = int(input("Digite a nova idade do aluno: "))
                        aluno.altura = float(input("Digite a nova altura do aluno: "))
                        aluno.peso = float(input("Digite o novo peso do aluno: "))
                        self.salvarAluno()
                        break
                    else:
                        print("Aluno, RGM [", RGM, "], não encontrado!")
        elif atualiza == 3:
                alunos = self.mysql_alunos.listar_alunos()
                for aluno in alunos:
                    if aluno[0] == RGM:
                            novo_nome = input("Digite o novo nome do aluno: ")
                            novo_idade = int(input("Digite a nova idade do aluno: "))
                            novo_altura = float(input("Digite a nova altura do aluno: "))
                            novo_peso = float(input("Digite o novo peso do aluno: "))
                            self.mysql_alunos.atualizar_aluno(RGM,novo_nome,novo_idade,novo_altura,novo_peso)
                            print("Aluno com RGM [", RGM, "] atualizado!")         
                    else:
                        print("Aluno, RGM [", RGM, "], não encontrado!")

        else:
            print("Opção invalida")
        

  
    def atualizarProfessor(self):
        atualiza = int(input("Digite em qual tipo de arquivo deseja atualizar 1-(JSON)  2-(SQLITE) 3-(MYSQL): "))
        matricula = int(input("Digite a matricula do professor a ser atualizado: "))

        if atualiza == 2:
            if os.path.isfile("professores.db"):
                profs = self.dbp.listar_professores()
                professor_encontrado = None

                for prof in profs:
                    if prof[0] == matricula:
                        professor_encontrado = prof

                if professor_encontrado:
                    novo_nome = input("Digite o novo nome do professor: ")
                    nova_idade = int(input("Digite a nova idade do professor: "))
                    nova_altura = float(input("Digite a nova altura do professor: "))
                    novo_peso = float(input("Digite o novo peso do professor: "))

                    self.dbp.atualizar_professor(matricula, novo_nome, nova_idade, nova_altura, novo_peso)
                    print(f"Professor com matrícula [{matricula}] atualizado!")
                    
                else:
                    print(f"Professor com matrícula [{matricula}] não encontrado!")
            else:
                print("Arquivo de professores não encontrado.")

        elif atualiza == 1:
            if os.path.isfile('professor.json'):
                professor_encontrado = None
                for i, professor in enumerate(self.listaProfessores):
                    if professor.matricula == matricula:
                        professor_encontrado = professor

                if professor_encontrado:
                    for professor in self.listaProfessores:
                        professor.nome = input("Digite o novo nome do professor: ")
                        professor.idade = int(input("Digite a nova idade do professor: "))
                        professor.altura = float(input("Digite a nova altura do professor: "))
                        professor.peso = float(input("Digite o novo peso do professor: "))
                        break

                    self.salvarProf()
                    print(f"Professor com matrícula [{matricula}] atualizado!")
                else:
                    print(f"Professor com matrícula [{matricula}] não encontrado!")
            else:
                print("Arquivo JSON de professores não encontrado.")

        elif atualiza == 3:
                profs = self.mysql_professores.listar_professores()
                professor_encontrado = None

                for prof in profs:
                    if prof[0] == matricula:
                        professor_encontrado = prof

                if professor_encontrado:
                    novo_nome = input("Digite o novo nome do professor: ")
                    nova_idade = int(input("Digite a nova idade do professor: "))
                    nova_altura = float(input("Digite a nova altura do professor: "))
                    novo_peso = float(input("Digite o novo peso do professor: "))

                    self.mysql_professores.atualizar_professor(matricula, novo_nome, nova_idade, nova_altura, novo_peso)
                    print(f"Professor com matrícula [{matricula}] atualizado!")
        else:
            print("Opção inválida.")

        

    def atualizarDisciplina(self):
        atualiza = int(input("Digite em qual tipo de arquivo deseja atualizar 1-(JSON)  2-(SQLITE) 3-(MYSQL): "))
        codigo = int(input("Digite o código da disciplina a ser atualizada: "))
        
        if atualiza == 2:
            if os.path.isfile("disciplina.db"):
                disci = self.dbc.listar_disciplinas()
                disciplina_encontrada = None

                for discis in disci:
                    if discis[0] == codigo:
                        disciplina_encontrada = discis

                if disciplina_encontrada:
                    novo_nome = input("Digite o novo nome da disciplina: ")
                    novo_cargaHoraria = int(input("Digite a nova carga horária da disciplina: "))
                    novo_turma = input("Digite a nova turma da disciplina: ")
                    novo_notaMinima = float(input("Digite a nova nota mínima da disciplina: "))

                    self.dbc.atualizar_disciplina(codigo, novo_nome, novo_cargaHoraria, novo_turma, novo_notaMinima)
                    print(f"Disciplina com código [{codigo}] atualizada!")

                else:
                    print(f"Disciplina com código [{codigo}] não encontrada!")
            else:
                print("Arquivo de disciplinas não encontrado.")

        elif atualiza == 1:
            if os.path.isfile('disciplina.json'):
                disciplina_encontrada = None
                for i, disciplina in enumerate(self.listaDisciplinas):
                    if disciplina.codigo == codigo:
                        disciplina_encontrada = disciplina
                        break

                if disciplina_encontrada:
                    for disciplina in self.listaDisciplinas:
                        disciplina.nome = input("Digite o novo nome da disciplina: ")
                        disciplina.cargaHoraria = int(input("Digite a nova carga horária da disciplina: "))
                        disciplina.turma = input("Digite a nova turma da disciplina: ")
                        disciplina.notaMinima = float(input("Digite a nova nota mínima da disciplina: "))
                        break

                    self.salvarCurso()
                    print(f"Disciplina com código [{codigo}] atualizada!")
                else:
                    print(f"Disciplina com código [{codigo}] não encontrada!")
            else:
                print("Arquivo JSON de disciplinas não encontrado.")
        elif atualiza == 3:
                disci = self.mysql_disciplina.listar_disciplinas()
                disciplina_encontrada = None

                for discis in disci:
                    if discis[0] == codigo:
                        disciplina_encontrada = discis

                if disciplina_encontrada:
                    novo_nome = input("Digite o novo nome da disciplina: ")
                    novo_cargaHoraria = int(input("Digite a nova carga horária da disciplina: "))
                    novo_turma = input("Digite a nova turma da disciplina: ")
                    novo_notaMinima = float(input("Digite a nova nota mínima da disciplina: "))

                    self.mysql_disciplina.atualizar_disciplina(codigo, novo_nome, novo_cargaHoraria, novo_turma, novo_notaMinima)
                    print(f"Disciplina com código [{codigo}] atualizada!")

                else:
                    print(f"Disciplina com código [{codigo}] não encontrada!")
        else:
            print("Opção inválida.")


        
        
                

    def consultarAlunos65plus(self):
        contador = 0
        for a in self.listaAlunos :
            if a.peso > 65:
                contador += 1
        print("Quantidade de alunos > 65 kg eh: ", contador)
        for a in self.listaAlunos :
            if a.peso > 65:
                print("O aluno ", a.nome, " tem imc: ", a.imc())


    def executar(self):
        while True:
            print("|############################################################|")
            print("|    ----------     OOP PYTHON        ------- | ")
            print("|############################################################|")
            print("   -- ALUNOS --  ")
            print(" 1) Cadastrar Alunos")
            print(" 2) Imprimir Alunos")
            print(" 3) Remover Alunos")
            print(" 4) Atualizar Alunos")
            print(" 5) Consulta Alunos > 65 Kg:")
            print(" ")
            print("   -- PROFESSOR --  ")
            print(" 11) Cadastrar Professor")
            print(" 12) Imprimir Professor")
            print(" 13) Remover Professor")
            print(" 14) Atualizar Professor")
            print("")
            print("   -- DISCIPLINA --  ")
            print(" 21) Cadastrar Disciplina")
            print(" 22) Imprimir Disciplina")
            print(" 23) Remover Disciplina")
            print(" 24) Atualizar Disciplina")
            print("")
            print("0 - Sair")

            self.opcao = input("Escolha uma opcao: ")

            if self.opcao == "1":
                self.cadastrarAluno()
            elif self.opcao == "2":
                self.imprimirAluno()
            elif self.opcao == "3":
                self.removerAluno()
            elif self.opcao == "4":
                self.atualizarAluno()
            elif self.opcao == "5":
                self.consultarAlunos65plus()

            elif self.opcao == "11":
                self.cadastrarProfessor()
            elif self.opcao == "12":
                self.imprimirProfessor()
            elif self.opcao == "13":
                self.removerProfessor()
            elif self.opcao == "14":
                self.atualizarProfessor()

            elif self.opcao == "21":
                self.cadastrarDisciplina()
            elif self.opcao == "22":
                self.imprimirDisciplina()
            elif self.opcao == "23":
                self.removerDisciplina()
            elif self.opcao == "24":
                self.atualizarDisciplina()
            elif self.opcao == "0":
                break
            else:
                print("Opcao invûÀlida. Tente novamente.")



if __name__ == "__main__":
    modulo_academico = ModuloAcademico()
    modulo_academico.executar()

