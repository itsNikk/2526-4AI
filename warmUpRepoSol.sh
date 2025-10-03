#!/bin/bash

#Possibile soluzione esemplare (e qualche nota)
#Supponendo di essere già dentro la root del progetto/repo

git status
git log --oneline --all --graph

ls -l

#Bonus se si esegue git status dopo ogni operazione sgnificativa. Lacunosa l'assenza.

#Primo commit atomico
git rm -r
git commit -m "[CLEANUP] removed notes directory"

git mv src/com/company/Helloworld.java src/com/company/Main.java
git commit -m "[RENAME] renamed Hellowrold.java to Main.java"

#In questo caso specifico bisogna anche controllare che il nome della classe contenuta nel file combaci con il nome del file (errore di compilazione, FIXARE assolutamente)

git status #Deve essere pulito

#Si può fare anche con nano
touch README_DEV.md
echo "Eseguire questo progetto con Intellij IDEA: aprire src/com/company/Main.java ed eseguire il main" > README_DEV.md

git add README_DEV.md
git commit -m "[DOCS] add basic developer guide"

#Qui si valuta positivamente il contenuto (sensato) del file di testo (non "ciao") e il contenuto del messaggio di commit

#Check stato repo
git status
git log --oneline --graph --all

#Ci aspettiamo 4 commit ben separati

git checkout -b feature/greet
#Successivamente, ocn Intellij IDEA, si modifichi il contenuto del Main
#L'idea è implementare una funzionalità Java, non lasciare placeholder come <username>

git add src/com/company/Main.java
git commit -m "[FEATURE] feature/greet: welcome messagge added"

echo "Ciao!" > greetings.txt
echo "Buongiorno!" >> greetings.txt
echo "Buonasera!" >> greetings.txt

git add greetings.txt
git commit -m "[ASSET] add greetings.txt with examples"

#NOTA: due commit, uno per il codice e uno per il documento.
# Se si fosse fatto un solo commit, MEH... non è atomico.

git checkout main
git merge feature/greet

#Se ci sono conflitti si risolveranno in questo momento da shell

#OPERAZIONI FINALI (non opzionali)
git log --oneline --graph --all

git status

ls -l
