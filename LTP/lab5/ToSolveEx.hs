module ToSolveEx where

divisors :: Int -> [Int]
divisors n = [x | x <- [1..n], mod n x == 0]

member :: Int -> [Int] -> Bool
member x [] = False
member x (y:ys)
	| x == y = True
	| otherwise = member x ys

isPrime :: Int -> Bool
isPrime x = (length (divisors x)) == 2

primes :: Int -> [Int]
primes n = take n [x | x <- [1..], isPrime x]

selectEven :: [Int] -> [Int]
selectEven [] = []
selectEven (x:xs)
	| mod x 2 == 0 = x : selectEven xs
	| otherwise = selectEven xs

selectEvenPos :: [Int] -> [Int]
selectEvenPos x = [y | y <- [0..((length x)-1)], mod (x !! y) 2 == 0]

ins :: Int -> [Int] -> [Int]
ins x [] = [x]
ins x (y:ys)
	| x <= y = (x:y:ys)
	| otherwise = y : (ins x ys)

iSort :: [Int] -> [Int]
iSort [] = []
iSort (x:xs) = ins x (iSort xs)

doubleAll :: [Int] -> [Int]
doubleAll x = map (*2) x

map' :: (a -> b) -> [a] -> [b]
map' f xs = [f x | x <- xs]

filter' :: (a -> Bool) -> [a] -> [a]
filter' g xs = [x | x <- xs, g x]
