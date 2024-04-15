algoritmo "Estruturas Condicionais II"

var
nota1, nota2, nota3, media: real
inicio
     Escreval ("Informe nota 1")
     leia(nota1)
     Escreval ("Informe nota 2")
     leia(nota2)
     Escreval ("Informe nota 3")
     leia(nota3)
     media <- (nota1+nota2+nota3)/3
     
     se media >= 7 entao
          Escreval ("Você passou com a média: ", media)
     senao
          se media < 5 entao
             Escreval ("Você reprovou com a média: ", media)
          senao
               Escreval ("Você está de recuperação com a média: ", media)
          fimse
     fimse
fimalgoritmo
