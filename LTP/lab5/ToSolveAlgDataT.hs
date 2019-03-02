module AlgDataT where

type Person = String
type Book = String
type Database = [(Person, Book)]

exampleBase :: Database
exampleBase = 	[	("Alicia","El nombre de la rosa"),
					("Juan","La hija del canibal"),
					("Pepe","Odesa"),
					("Alicia","La ciudad de las bestias")
			  	]

obtain :: Database -> Person -> [Book]
obtain db thisPerson = [book | (person, book) <- db, person == thisPerson]

borrow :: Database -> Book -> Person -> Database
borrow db b thisPerson = (thisPerson, b) : db

return' :: Database -> (Person, Book) -> Database
return' [] (_,_) = []
return' (x:xs) (p,b)
	| x == (p,b) = xs
	| otherwise = x : return' xs (p,b)
