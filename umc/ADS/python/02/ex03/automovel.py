class automovel:
    def __init__ (self,modelo, arro, cor, cavalo ,porta, tamanho,peso, combustivel, transmissao, marca):
        self.modelo = modelo 
        self.arro = arro
        self.cor = cor
        self.cavalo = cavalo
        self.porta = porta
        self.tamanho = tamanho
        self.peso = peso
        self.combustivel = combustivel
        self.transmissao = transmissao
        self.marca= marca
    def expecificacao (self):
        print(f"""

                    Expecificação técnica:
                    Marca:{self.marca};
                    modelo:{self.modelo};
                    Cor:{self.cor};
                    Cavalaria:{self.cavalo} cavalos;
                    Portas:{self.porta};
                    Transmissão:{self.transmissao}.""")
    def quilometragem (self):
        calculo = float(self.cavalo) * 15
        print(f"""
                    Quilometros por hora:
                    {self.marca} {self.modelo} consegue atingir a marca de {calculo} Km/h.
        """)
    def medir (self):
        if float(self.peso) <= 3500:
            print(f"{self.marca} {self.modelo} e um carro leve")
            if float(self.tamanho) <= 5:
                print(f"{self.marca} {self.modelo} e um carro pequeno")
            elif float(self.tamanho) <= 6:
                print(f"{self.marca} {self.modelo} e um carro Medio")
            else:
                print(f"{self.marca} {self.modelo} e um carro grande")

        else:
            print(f"{self.marca} {self.modelo} e um carro pesado")
            if float(self.tamanho) <= 5:
                print(f"{self.marca} {self.modelo} e um carro pequeno")
            elif float(self.tamanho) <= 6:
                print(f"{self.marca} {self.modelo} e um carro Medio")
            else:
                print(f"{self.marca} {self.modelo} e um carro grande")
lista1 = [ "modelo", "arro", "cor", "cavalo" ,"porta", "tamanho","peso", "combustivel", "transmissao", "marca"]
lista2 = []
for i in range(10):
    pergunta = input(f"Informe {lista1[i]} do carro:")
    lista2.append(pergunta)

meuCarro = automovel(*lista2)
meuCarro.expecificacao()
meuCarro.quilometragem()
meuCarro.medir()
