#/bin/bash

cd $HOME/Desktop

rm -rf repoEs1

git init repoEs1
cd repoEs1

for i in {1..5}
do
    touch file$i.txt
    echo "Questo è il file $i" > file$i.txt
    git add file$i.txt
    git commit -m "Aggiunto file$i.txt
done
