#!/bin/bash

cd $HOME/Desktop

rm -rf repo3

git init repo3
cd repo3

echo "Ciao!" > oldName.txt
git add oldName.txt
git commit -m "Aggiunto vecchio nome"

res=$(grep "Ciao" oldName.txt)

# L'opzione -n controlla se la variabile posta alla sua dx non sia vuota
# true se variabile non vuota, false altrimenti
if [ -n $res ]
then
    git mv oldName.txt newName.txt
else
    echo "Nessun rename necessario"
fi
