algoritmo "Vetores"

var
nomes : vetor[1..5] de literal
pesquisa : literal
i, sucesso : inteiro

inicio

para i de 1 ate 5 faca
     Escreval ("Informe o nome a cadastrar")
     leia(nomes[i])
fimpara
limpatela

Escreval("Informe o nome a pesquisar")
leia(pesquisa)

sucesso <- 0

para i de 1 ate 5 faca
     se nomes[i] = pesquisa entao
      sucesso <- 1
     fimse
fimpara

se sucesso = 1 entao
   Escreval("Cliente encontrado")
senao
   Escreval("Cliente não encontrado")
fimse

fimalgoritmo

