algoritmo "Enquanto"

var
maisNovo, maisVelho, qtdEntrevistados, idadeInformada : inteiro
porcentagemMenorIdade, mediaIdade, qtdMenoresIdade, somaIdades : real

inicio

maisNovo <- 9999
maisVelho <- 0
qtdEntrevistados <- 0
qtdMenoresIdade <- 0
enquanto qtdEntrevistados < 5 faca
         escreval("Favor, informe sua Idade")
         leia(idadeInformada)
         
         se idadeInformada >= maisVelho entao
            maisVelho <- idadeInformada
         fimse
         se idadeInformada <= maisNovo entao
            maisNovo <- idadeInformada
         fimse
         se idadeInformada < 18 entao
            qtdMenoresIdade <- qtdMenoresIdade + 1
         fimse
somaIdades <- somaIdades + idadeInformada
qtdEntrevistados <- qtdEntrevistados + 1
fimenquanto

Escreval("Mais Novo: ", maisNovo)
Escreval("Mais Velho: ", maisVelho)
porcentagemMenorIdade <- (qtdMenoresIdade / 5) * 100
Escreval("Porcentagem Menor Idade: ", porcentagemMenorIdade, "%")
mediaIdade <- somaIdades / 5
Escreval("Média de Idade: ", mediaIdade)

fimalgoritmo
