class leite :
    def __init__(self,marca,fabrica,vitaminas,localFabri,dataFabri,tipo):
        self.marca=marca
        self.fabrica=fabrica
        self.vitaminas=vitaminas
        self.localFabri= localFabri
        self.dataFabri=dataFabri
        self.tipo=tipo
    def produtor (self):
        print(f"A marca do leite é: {self.marca} ")
        print(f"A fabricante do leite {self.marca} é {self.fabrica}")
        print(f"A {self.fabrica} fica localizada ná:{self.localFabri}")
    def info (self):
        print(f"""
                    O leite {self.marca} e produzido da {self.tipo}
                    tedendo como nutrientes {self.vitaminas}
              """)
leite1 = ("Italac","JUnca","A,B,ferro,calcio","Muriae,Mg",19/8/2023,"Vaca")
opa = leite(leite1)
opa.produtor()
opa.info()