from index import Animal

class Coelho(Animal):
    def __init__(self, nome, cor):
        super().__init__(nome, cor)

coelho = Coelho("Pernalonga", "Cinza")

coelho.comer()
coelho.andar()
coelho.dormi()
coelho.fugir()
