class automovel:
    def __init__ ( self,ano,modelo,fabricante,cavalo,cilindros,combustivel,fipe,quilometros):
        self.ano = ano 
        self.modelo = modelo
        self.fabricante = fabricante
        self.cavalo = cavalo
        self.cilindros = cilindros
        self.combustivel = combustivel
        self.fipe = fipe
        self.quilometros = quilometros
    def expecificacao (self):
          print(f"""

                    Expecificação técnica:
                    Fabricante:{self.fabricante};
                    modelo:{self.modelo};
                    Cavalaria:{self.cavalo} cavalos;
                    Cilindros:{self.cilindros};
                    Valor:{self.fipe} R$.""")
    def potencia (self):
        if float(self.cavalo)>= 500:
              print(f"O motor {self.modelo} é muito forte!!")
        elif float(self.cavalo)<500:
                print(f"o motor {self.modelo} é um motor medio!!")
        else:
             print(f"O motor {self.modelo} é um motor fraco!!")
    def vidaUtil (self):
        if (2023 - float(self.ano)) * float(self.quilometros) >=  (2023 - float(self.ano)) * 15000:
              print(f"O motor {self.modelo} esta acima da media,  o motor  pode quebrar!!")
        elif( 2023 - float(self.ano)) * float(self.quilometros) == ( 2023 - float(self.ano)) * 15000:
               print(f"O motor {self.modelo} esta Na media,  o motor  pode quebrar ou não!!")
        else:
            print(f"O motor {self.modelo} esta abaixo da media, tem menos risco de quebrar!!")
lista1 = [ "Ano","Modelo","Fabricante","Cavalo","Cilindros","Combustivel","Fipe","Quilometros"]
lista2 = []
for i in range(8):
    pergunta = input(f"Informe {lista1[i]} do motor:")
    lista2.append(pergunta)
meuCarro = automovel(*lista2)
meuCarro.expecificacao()
meuCarro.potencia()
meuCarro.vidaUtil()
