module ToSolveTree where

data Tree a = Leaf a | Branch (Tree a) (Tree a) deriving Show
--data TreeInt a = LeafInt Int | BranchInt TreeInt TreeInt
data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt

numLeaves :: Tree a -> Int
numLeaves (Leaf x) = 1
numLeaves (Branch a b) = numLeaves a + numLeaves b

symmetric :: Tree a -> Tree a
symmetric (Leaf x) = Leaf x
symmetric (Branch a b) = Branch (symmetric b) (symmetric a)

list2Tree :: [a] -> Tree a
list2Tree [x] = Leaf x
list2Tree (x:xs) = Branch (Leaf x) (list2Tree xs)

tree2List :: Tree a -> [a]
tree2List (Leaf x) = [x]
tree2List (Branch a b) = tree2List a ++ tree2List b

insTree :: Int -> BinTreeInt -> BinTreeInt
insTree x Void = Node x Void Void
insTree x (Node y left right)
	| x < y = insTree x left
	| otherwise = insTree x right

creaTree :: [Int] -> BinTreeInt
creaTree (x:[]) = insTree x Void
creaTree (x:xs) = insTree x (creaTree xs)

treeElem :: Int -> BinTreeInt -> Bool
treeElem x Void = False
treeElem x (Node y left right)
	| x > y = treeElem x right
	| x < y = treeElem x left
	| otherwise = True
