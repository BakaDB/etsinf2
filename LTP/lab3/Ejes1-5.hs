module Ejes1 where
  	data BinTree = Node BinTree BinTree | Leaf Int

	data Arbol a = Hoja a | Nodo (Arbol a) a (Arbol a)

  	instance Show BinTree where
		show (Leaf n) = show n
		show (Node n m) = "(N "++(show n)++" "++(show m)++")"
 
	addNodes :: BinTree -> Int
	addNodes (Leaf n) = n
	addNodes (Node n m)  = addNodes n + addNodes m

	maxTree :: BinTree -> Int
	maxTree a = maximum (toList a)
		where toList (Leaf n) = [n];
			  toList (Node n m) = (toList n) ++ (toList m)

	maxTree2 :: BinTree -> Int
	maxTree2 (Leaf n) = n
	maxTree2 (Node n m) = max (maxTree2 n) (maxTree2 m)
	

	ramaIzq :: Arbol a -> [a]
	ramaIzq (Hoja n) = n
	ramaIzq (Nodo i n _) = n : ramaIzq i
