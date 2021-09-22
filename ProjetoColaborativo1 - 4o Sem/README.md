# Projeto Colaborativo 1


### Descrição:

O objetivo geral do trabalho consiste em desenvolver um analisador de contatos a partir da base de e-mails de benchmark conhecida como Enron Email Dataset. Essa base de e-mails é pública e está disponível em https://www.cs.cmu.edu/~./enron/ . Nesse projeto procura-se mostrar uma aplicação prática da teoria dos grafos que permite extrair informações úteis a partir da rede de contatos gerada com os e-mails da base.
#
### Requisitos e Funcionalidades do Analisador:
### - A partir das mensagens de e-mail da base, gere um grafo direcionado considerando o remetente e o(s) destinatários de cada mensagem. Vc deve escolher entre as mensagens do diretorio "sent" ou "sent_mail". O grafo deve ser ponderado, considerando a frequência com que um remetente envia uma mensagem para um destinatário e rotulado, considerando como rótulo o e-mail de cada usuário.
#### - Implemente métodos/funções para extrair as seguintes informações gerais:
      -> O n. de vértices do grafo
      -> O n. de arestas do grafo
      -> Os 20 indivíduos que possuem maior grau de saída e o valor correspondente;
      -> Os 20 indivíduos que possuem maior grau de entrada e o valor correspondente;
### - Implemente um método/função que percorre o grafo em PROFUNDIDADE e verifica se um indivíduo X pode alcançar um indivíduo Y retornando e mostrando o caminho percorrido (nós visitados) em uma lista.
### - Implemente um método/função que percorre o grafo em LARGURA e verifica se um indivíduo X pode alcançar um indivíduo Y retornando e mostrando o caminho percorrido (nós visitados) em uma lista.
### - Implemente um método/função que retorne uma lista com os nós que estão a uma distância de D arestas (D saltos) de um nó N. Considere que uma ligação entre os nós X e Y corresponde a uma distância 1 entre X e Y.
### - Considerando que o peso das arestas denota um grau de dependência de um indivíduo A em relação a um indivíduo B, implemente um método/função que determine entre um indivíduo A e um indivíduo C o caminho de maior dependência acumulada, mostrando os indivíduos do caminho e a dependência acumulada no caminho. Nessa questão vc pode aplicar o Dijkstra invertendo o peso das arestas: 1 / peso.
#
### Execução do projeto:
### - Foi feito o pré-processamento dos dados de emails tiradas do site mencionado no começo do documento via python (arquivo "map.py")
### - O restante foi feito em java, utilizando grafos, o projeto pode ser executado por meio da classe Grafos.java
