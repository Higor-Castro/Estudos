class Veiculo:
  def __init__(self, marca, modelo):
    self.marca = marca
    self.modelo = modelo
  def __str__(self):
     return f'Veiculo ({self.marca},{self.modelo})' 

  def mover(self):
    print("Movendo!")

class Carro(Veiculo):
  pass

class Bote(Veiculo):
  def mover(self):
    print("Velejando!")

class Aviao(Veiculo):
  def mover(self):
    print("Voando!")

carro1 = Carro("Ford", "Mustang") #Create a Car object
bote1 = Bote("Ibiza", "Touring 20") #Create a Boat object
aviao1 = Aviao("Boeing", "747") #Create a Plane object

for x in (carro1, bote1, aviao1):
  print(x.marca)
  print(x.modelo)
  x.mover()

print(carro1)
