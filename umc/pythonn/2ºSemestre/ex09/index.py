import sqlite3
import os
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

class Professor:
    def __init__(self, nome="", idade=0, altura=0.0, peso=0.0, matricula=0):
        self.matricula = matricula
        pessoa.__init__(self ,nome, idade, altura, peso)



class Disciplina:
  def __init__(self, codigo=0, nome="", cargaHoraria=160, turma="", notaMinima=7):
      self.codigo = codigo
      self.nome = nome
      self.cargaHoraria = cargaHoraria
      self.turma = turma
      self.notaMinima = notaMinima



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
        self.cursor.execute(inserir_aluno_query, (aluno.nome, aluno.idade, aluno.altura, aluno.peso, aluno.rgm))
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


class ModuloAcademico:
    def __init__(self):
        self.opcao = 0
        self.db = BancoDeDadosAlunos("alunos.db")
        self.dbp = BancoDeDadosProfessores("professores.db")
        self.dbc = BancoDeDadosDisciplinas("disciplina.db")
        self.RecuperarAlunos()
        self.recuperarProfessores()
        self.recuperarDisciplinas()
    

    def cadastrarAluno(self):
            nome = input("Digite o nome do aluno: ")
            idade = int(input("Digite a idade do aluno: "))
            altura = float(input("Digite a altura do aluno: "))
            peso = float(input("Digite o peso do aluno: "))
            RGM = int(input("Digite o RGM do aluno: ") )
            aluno = Aluno(nome,idade,altura,peso,RGM)
            self.db.criar_aluno(aluno) 

    def cadastrarProfessor(self):
        nome = input("Digite o nome do professor: ")
        idade = int(input("Digite a idade do professor: "))
        altura = float(input("Digite a altura do professor: "))
        peso = float(input("Digite o peso do professor: "))
        matricula = int(input("Digite a matricula do professor: "))
        professor = Professor(nome, idade, altura, peso, matricula)
        self.dbp.criar_professor(professor)
        

    def cadastrarDisciplina(self):
        codigo = int(input("Digite o codigo da disciplina: "))
        nome = input("Digite o nome da disciplina: ")
        cargaHoraria = int(input("Digite a carga horaria da disciplina: "))
        turma = input("Digite a turma da disciplina: ")
        notaMinima = float(input("Digite a nota minima da disciplina: "))
        disciplina = Disciplina(codigo, nome, cargaHoraria, turma, notaMinima)
        self.dbc.criar_disciplina(disciplina)


    def imprimirAluno(self):
       alunos = self.db.listar_alunos()
       for aluno in alunos:
        print(f"RGM: {aluno[4]}, Nome: {aluno[0]}, Idade: {aluno[1]}, Altura: {aluno[2]}, Peso: {aluno[3]}")

    def imprimirProfessor(self):
        professores = self.dbp.listar_professores()
        for professor in professores:
            print(f"Matrícula: {professor[0]}, Nome: {professor[1]}, Idade: {professor[2]}, Altura: {professor[3]}, Peso: {professor[4]}")

    def imprimirDisciplina(self):
        disciplinas = self.dbc.listar_disciplinas()
        for disciplina in disciplinas:
            print(f"Código: {disciplina[0]}, Nome: {disciplina[1]}, Carga Horária: {disciplina[2]}, Turma: {disciplina[3]}, Nota Mínima: {disciplina[4]}")



    def removerAluno(self):
        RGM = int(input("Digite o RGM do aluno a ser removido: "))
        alunos = self.db.listar_alunos()
        for aluno in alunos:
            if aluno[4] == RGM:
                self.db.excluir_aluno(RGM)
                print("Aluno, RGM [", RGM, "], removido!")
            else:
                print("Aluno, RGM [", RGM, "], não encontrado!")
    
    def removerProfessor(self):
        matricula = int(input("Digite a marticula do professor a ser removido: "))
        profs = self.dbp.listar_professores()
        for prof in profs:
          if prof[0] == matricula:
            self.dbp.excluir_professor(matricula)
            print("Professor, matricula [", matricula, "], removido!")
          else:
              print("Professor, matricula [", matricula, "], nao encontrado!")

    def removerDisciplina(self):
        codigo = int(input("Digite oo codigo da disciplina a ser removida: "))
        disci = self.dbc.listar_disciplinas()
        for discis in disci:
          if discis[0]== codigo:
            self.dbc.excluir_disciplina(codigo)
            print("Disciplina, codigo [", codigo, "], removida!")
          else:
            print("Disciplina, codigo [", codigo, "], nao encontrado!")
            

    def RecuperarAlunos(self):
        self.db = BancoDeDadosAlunos("alunos.db")
        self.db.listar_alunos()

    def recuperarProfessores(self):
        self.dbp = BancoDeDadosProfessores("professores.db")
        self.dbp.listar_professores()

    def recuperarDisciplinas(self):
        self.dbc = BancoDeDadosDisciplinas("disciplina.db")
        self.dbc.listar_disciplinas()
        

    def atualizarAluno(self):
        RGM= int(input("Digite o RGM do aluno a ser atualizado: "))
        alunos = self.db.listar_alunos()
        for aluno in alunos:
            if aluno[4] == RGM:
                    novo_nome = input("Digite o novo nome do aluno: ")
                    novo_idade = int(input("Digite a nova idade do aluno: "))
                    novo_altura = float(input("Digite a nova altura do aluno: "))
                    novo_peso = float(input("Digite o novo peso do aluno: "))
                    self.db.atualizar_aluno(RGM,novo_nome,novo_idade,novo_altura,novo_peso)
                    print("Aluno com RGM [", RGM, "] atualizado!")
    
            else:
                print("Aluno, RGM [", RGM, "], não encontrado!")

    def atualizarProfessor(self):
        matricula = input("Digite a matricula do professor a ser atualizado: ")
        profs = self.dbp.listar_professores()
        for prof in profs:
            if prof[0] == matricula:
                novo_nome = input("Digite o novo nome do professor: ")
                novo_idade = int(input("Digite a nova idade do professor: "))
                novo_altura = float(input("Digite a nova altura do professor: "))
                novo_peso = float(input("Digite o novo peso do professor: "))
                self.dbp.atualizar_professor(matricula,novo_nome,novo_idade,novo_altura,novo_peso)
            else:
               print("Professor, matricula [", matricula, "], nao encontrado!")

    def atualizarDisciplina(self):
        codigo = input("Digite o codigo da disciplina a ser atualizado: ")
        disci = self.dbc.listar_disciplinas()
        for discis in disci:
            if discis[0] == codigo:
                novo_nome = input("Digite o novo nome da disciplina: ")
                novo_cargaHoraria = int(input("Digite a nova carga horaria da disciplina: "))
                novo_turma = input("Digite a nova turma da disciplina: ")
                novo_notaMinima = float(input("Digite a nova nota minima da disciplina: "))
                self.dbc.atualizar_disciplina(codigo,novo_nome,novo_cargaHoraria,novo_turma,novo_notaMinima)

            else:
                print("Disciplina, codigo [", codigo, "], nao encontrado!")
                

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