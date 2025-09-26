#!/bin/bash

#1) chiedi all'utente percorso
read -p "Inserisci percorso directory" path

rm -rf $path

#mkdir $path
#cd $path
# git init

git init $path
cd $path
#POS???

#2) Aggiungete 10 file txt al repo, e 2 file .md
for i in {1..10};
do
	touch f$i.txt
done

touch m.md
touch x.md

git status

#3) add all txts
for i in $(seq 1 10)
do
	git add f$i.txt
done

git status

git commit -m "Aggiunti tutti i file txt"
echo #dicasi eko
echo

git log
