module StackLists where

import Stack

toList :: Stack a -> [a]
toList x
	| isEmpty x = []
	| otherwise = top x : (toList (pop x))

fromList :: [a] -> Stack a
fromList [] = empty
fromList (x:xs) = push x fromList xs
