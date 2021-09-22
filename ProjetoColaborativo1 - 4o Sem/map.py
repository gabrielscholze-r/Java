import os
from typing import Text, final 

entrar = str(input("Digite 'sent' ou '_sent_mail': "))

if entrar == "sent":
    palavra = -5
    nome = "dadosEmail.txt"
    fim = "dadosFinal.txt"
elif entrar== "_sent_mail":
    palavra = -11
    nome = "dadosEmail2.txt"
    fim = "dadosFinal2.txt"



dadosSalvos = open(f"C:/Users/alex-/Desktop/VsCode/grafo/{nome}", "w+")

for diretorio, subpastas, arquivos in os.walk('grafo\maildir'):

    if diretorio[palavra:] == f'\{entrar}':
        for x in arquivos:
            arquivo = diretorio + "\\" + x # pegar o caminho do arquivo
            arquivoAberto = open(arquivo, "r")

            linhas = arquivoAberto.readlines()
            for i in range(0, len(linhas)):
                linha = linhas[i]

                if linha[0:5] == "From:":
                    emailFrom = linha[5:].strip() 
          
                if linha[0:3] == "To:":
                    emailTo = linha[3:].strip()

                    for y in range(i+1, len(linhas)): #caso tenha mais de um destinatario
                        linha = linhas[y]
                        if linha[0:8] != "Subject:":
                            emailTo += linha.strip()
                        else:
                            break

                if linha[0:8] == "Subject:":
                    break

            arquivoAberto.close()
        
            emails = emailTo.split(",")
            for j in emails: # escrever no arquivo 1 o remetente e o destinatario 
                variavel = ""
                variavel = emailFrom + " " + j.strip() + "\n"
                dadosSalvos.write(variavel)
            

dadosSalvos.close()

#reduce
dadosSalvos = open(f"C:/Users/alex-/Desktop/VsCode/grafo/{nome}", "r")
arquivoFinal = open(f"C:/Users/alex-/Desktop/VsCode/grafo/{fim}", "w+")

dicionario = {}

linhas = dadosSalvos.readlines()
for i in range(0, len(linhas)):
    linha = linhas[i]

    linha = linha.strip("\n")

    print(linha)
    
    if linha not in dicionario:
        dicionario[linha] = 1
    
    else:
        dicionario[linha] += 1

print(dicionario)

for keys, value in sorted(dicionario.items()):
    arquivoFinal.write(keys + " " + str(value) + "\n")

dadosSalvos.close()
arquivoFinal.close()

print("Fim da execução!!!!")
