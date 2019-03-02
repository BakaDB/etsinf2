module ToSolveExtra where

data BinTreeInt = Void | Node Int BinTreeInt BinTreeInt deriving Show
data Tree a = Leaf a | Branch a (Tree a) (Tree a) deriving Show

concat' :: [[a]] -> [a]
concat' (x:xs) = x ++ (concat' xs)

dupElem :: BinTreeInt -> BinTreeInt
dupElem Void = Void
dupElem (Node x a b) = Node (x*2) (dupElem a) (dupElem b)

countProperty :: (a -> Bool) -> (Tree a) -> Int
countProperty g (Leaf a)
	| g a = 1
	|otherwise = 0
countProperty g (Branch x a b)
	| g x = 1 + (countProperty g a) + (countProperty g b)
	| otherwise = (countProperty g a) + (countProperty g b)
