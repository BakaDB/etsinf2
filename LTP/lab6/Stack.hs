module Stack (Stack, empty, push, pop, top, isEmpty) where

data Stack a = EmptyStack | Stk a (Stack a) deriving Show

push x s = Stk x s
top (Stk x s) = x
pop (Stk _ s) = s
empty = EmptyStack
isEmpty EmptyStack = True
isEmpty (Stk x s) = False
instance (Eq a) => Eq (Stack a) where
	EmptyStack == EmptyStack = True
	EmptyStack == Stk _ _ = False
	Stk _ _ == EmptyStack = False
	Stk x xs == Stk y ys = (x == y) && (xs == ys)
	a /= b = not (a == b)

{-
data Stack a = Stk [a]	-- implementation as a list to hide structure details
						-- 		and the definition of the function

empty = Stk []
push x (Stk xs) = Stk (x:xs)
pop (Stk (x:xs)) = Stk xs
top (Stk (x:xs)) = x
isEmpty (Stk xs) = null xs
-}
