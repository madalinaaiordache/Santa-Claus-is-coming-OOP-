IORDACHE Madalina Gabriela 323CA
# Proiect - Etapa 1 POO

## Design Patterns
 Am ales sa folosesc Factory ca Design Pattern, din necesitatea de
a sorta tipurile de cadouri, astfel incat sa se aleaga cadoul cu 
pretul cel mai mic din cateogoria necesara. De asemenea, am folosit
Singleton pentru a crea clasa de Factory, deoarece este necesara o
singura instanta a fabricii. Pentru ca sunt rulate mai multe teste 
in program, am facut o metoda de clean, ca sa curat listele de cadouri
pentru testele urmatoare.  Pentru a putea folosi metoda readValue
din clasa ObjectMapper, clasa Present nu putea fi una abstracta, asa
ca am creat o noua clasa, PresentInput, in care am citit din fisiere,
pe care ulterior am mostenit-o in clasa Present folosita pentru Factory.

## Informatii relevenate
  Pentru a tine main-ul cat mai curat, am creat clasele FlowInfo si 
ProjectFlow. FlowInfo este o clasa care tine toate informatiile necesara 
rularii unui fisier, inclusiv majoritatea metodole necesare pe parcursul 
anului, iar ProjectFlow este cea in care se ruleaza, de fapt, trecerea anilor.
 
## Flow-ul programului
 Am creat clasa InputFilesParserWriter, unde exista 2 metode: una de
citire dintr-un fisier si una de scrie. In main se parcurge numarul 
fisierelor si se face citirea din fiecare fisier. Apoi este apelata metoda 
runAllYears, din clasa projectFlow, care itereaza toate rundele. Se 
parcurge astfel:
 - (fara runda initiala) se incrementeaza cu 1 varsta tuturor copiilor'
 - (toate rundele) se stabileste categoria de varsta printr-o metoda
din clasa Child si se elimina cei din categoria Young Adult;
 - (fara runda initiala) se recreeaza listele din fiecare copil;
 - (doar runda initiala) se adauga scorul initial si se copiaza categoriile
preferate
 - (fara runda initiala) se citesc update-urile si se modifica pentru
fiecare tip de update
 - (toate rundele) se calculeaza scorul fiecarul copil, unitatea de buget
si se seteaza bugetul alocat fiecarui copil.
 - (toate rundele) se impart cadourile astfel: se parcurge intr-un while 
bugetul, atata timp cat nu se ajunge la 0 si se ia cate o categorie, pe
rand, din lista de preferinte. Deoarece listele de cadouri sunt sortate
mereu dupa pret, trebuie verificat doar daca pretul primului obiect
intra in buget. In functie de caz, se adauga sau nu cadoul in lista. 
 - (toate rundele) se creeaza o instanta a clasei ChildrenOut, care tine 
informatii despre toate cadourile primite,  instanta scrisa in fisier 
folosind writerWithDefaultPrettyPrinter, tot din ObjectMapper.
