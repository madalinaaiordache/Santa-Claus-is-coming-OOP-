IORDACHE Madalina Gabriela 323CA
============================== Etapa 2 POO ==============================

## Design Patterns
 ** Factory + Singletone
 Am folosit Factory din necesitatea de a sorta tipurile de cadouri, astfel 
incat sa se aleaga cadoul cu pretul cel mai mic din cateogoria necesara. 
De asemenea, am folosit Singleton pentru a crea clasa de Factory, deoarece 
este necesara o singura instanta a fabricii. Pentru ca sunt rulate mai multe 
teste in program, am facut o metoda de clean, ca sa curat listele de cadouri
pentru testele urmatoare.  
 ** Strategy
 Am creat cele 3 clase, CitiesStrategy, IdStrategy, NiceScoreStrategy, care
implements interfata Strategy, ce contine metoda shareGifts. In functie de caz,
fiecare strategie va sorta lista de copii dupa cerinta corespunzatoare, apoi
va impartine copiilor cadourile, folosind metoda giveChildPresents din FlowInfo.
 ** Observer
 Am folosit acest Design Pattern pentru a calcula niceScoreCity pentru fiecare
copil. Am creat clasa CityAverageCalculator, care retine toata lista de copii. 
Am creat interfata ChildObserver cu metoda update care primeste ca parametru un copil. 
Daca acesta este din acelasi oras, copilul a carui metoda este apelata va adauga la suma
si niceScore-ul primit si va recalcula media. In CityAverageCalculator, instantiata
de fiecare data cand avem strategie de tip NiceScoreCity, va fi apelata metoda
calculateAverages, care parcurge toata lista de copii si o da ca parametru in functia 
notify. Aici este parcursa lista din nou si apelata metoda update pentru toti copiii 
din lista. 

### Flow
 Am creat clasa InputFilesParserWriter, unde exista 2 metode: una de
citire dintr-un fisier si una de scriere. In main se parcurge numarul 
fisierelor si se face citirea din fiecare fisier. Apoi este apelata metoda 
runAllYears, din clasa projectFlow, care itereaza toate rundele. Se 
parcurge astfel:
 - (doar runda initiala) se initializeaza strategia la "ID".
 - (fara runda initiala) se incrementeaza cu 1 varsta tuturor copiilor
 - (toate rundele) se stabileste categoria de varsta printr-o metoda
din clasa Child si se elimina cei din categoria Young Adult;
 - (fara runda initiala) se recreeaza listele din fiecare copil;
 - (doar runda initiala) se adauga scorul initial si se copiaza categoriile
preferate
 - (fara runda initiala) se citesc update-urile si se modifica pentru
fiecare tip de update
 - (toate rundele) se creeaza strategia, in functie de tipul ei
 - (toate rundele) se calculeaza scorul fiecarul copil, folosind bonusul, 
unitatea de buget si se seteaza bugetul alocat fiecarui copil, modificand,
daca e cazul, in functie de elful asignat
 - (toate rundele) se impart cadourile (folosind metoda shareGifts suprascrisa
in clasa corespunzatoare fiecarui tip de strategie) astfel: se parcurge intr-un 
while bugetul, atata timp cat nu se ajunge la 0 si se ia cate o categorie, pe
rand, din lista de preferinte. Listele de cadouri sunt sortate dupa pret,
deci se va parcurge in ordine lista corespunzatoare categoriei cerute, pana
la cadoul care nu are cantitatea 0. In cazul in care intra in buget, este
scazuta cantitatea.
 - (toate rundele) elfii de tip YELLOW impart cadouri, daca e cazul
 - (toate rundele) se creeaza o instanta a clasei ChildrenOut, care tine 
informatii despre toate cadourile primite,  instanta scrisa in fisier 
folosind writerWithDefaultPrettyPrinter, tot din ObjectMapper.
