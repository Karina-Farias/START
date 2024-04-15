algoritmo "Estruturas Condicionais"

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
     
     se media < 7 entao
          Escreval ("Você está de Recuperação")
     senao
          Escreval ("Você passou!")
     fimse
fimalgoritmo
