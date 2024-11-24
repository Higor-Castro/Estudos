from index import Animal

class Gato(Animal):
    def __init__(self, nome, cor):
        super().__init__(nome, cor)

gato = Gato("Bichano", "Branco")

gato.comer()
gato.andar()
gato.dormi()
gato.fugir()
