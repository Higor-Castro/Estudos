
class Animal ():
    def __init__(self, nome, cor):
        self.__nome = nome
        self.__cor = cor

    def getNome(self):
        return self.__nome
    def getCor(self):
        return self.__cor

    def comer(self):
        print(f"O {self.__nome} está comendo")
    def andar(self):
        print(f"O {self.__nome} esta andando.")
    def dormi(self):
        print(f"Depois de {self.__nome} comer ele vai dormi.")
    def fugir(self):
        print(f"O {self.__nome} Fugiu!!")


