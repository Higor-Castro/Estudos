from index import Animal

class Galinha(Animal):
    def __init__(self, nome, cor):
        super().__init__(nome, cor)
    def botaOvo(self):
        print(f"A {self.getNome} boto ovo")

galinha = Galinha("filo", "preto")

galinha.comer()
galinha.andar()
galinha.dormi()
galinha.fugir()
galinha.botaOvo()