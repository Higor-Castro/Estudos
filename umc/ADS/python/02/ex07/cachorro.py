from index import Animal

class Cachorro(Animal):
    def __init__(self, nome, cor):
        super().__init__(nome, cor)

cachorro = Cachorro("Totó", "Preto")

cachorro.comer()
cachorro.andar()
cachorro.dormi()
cachorro.fugir()