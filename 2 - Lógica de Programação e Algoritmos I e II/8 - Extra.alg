algoritmo "Extra"

var
altura, peso, imc : real
inicio

Escreval("Altura: ")
leia(altura)
Escreval("Peso: ")
leia(peso)
imc <- peso / altura ^ 2 // ou poderia ser altura * altura;

se imc < 19 entao
   escreval ("Abaixo do peso")
senao
se imc < 24 entao
   escreval ("Peso ideal")
senao
     escreval("Acima do peso")
fimse
fimse
     
fimalgoritmo
