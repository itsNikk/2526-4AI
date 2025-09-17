#!/bin/bash

cd $HOME/Desktop

#Rimuovo eventuali vecchi repo così da iniziare da nuovo.
#Git init se trova già una cartella con un determinato nome non riparte da zero.
rm -rf secretRepo2
git init secretRepo2

cd secretRepo2

echo "Non guardare!" > segreto.txt
git add segreto.txt
git commit -m "Added secret :)"


if [ -f segreto.txt ]
then
        git rm segreto.txt
        git commit -m "Segreto rimosso"
else
        echo "Nessun segreto trovato"
fi
