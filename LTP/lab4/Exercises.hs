module Exercises where

import Data.Char

nextchar :: Char -> Char
nextchar c = chr ((ord c) + 1)

fact :: Int -> Int
fact 0 = 1
fact n = n * fact(n-1)

numCbetw2 :: Char -> Char -> Int
numCbetw2 x y
	| x == y || (ord x) == ((ord y) +1) || ((ord x) + 1) == (ord y) = 0
	| otherwise = abs((ord x) - (ord y)) - 1

addRange :: Int -> Int -> Int
addRange x y
	| x == y = x
	| x > y = y + (addRange x (y+1))
	| x < y = y + (addRange x (y-1))

maxz :: Int -> Int -> Int
maxz x y
	| x >= y = x
	| otherwise = y

leapyear :: Int -> Bool
leapyear y = (mod y 400 == 0) || ((mod y 4 == 0) && (mod y 100 /= 0))

daysAMonth :: Int -> Int -> Int
daysAMonth m y
	| (elem m [1,3,5,7,8,10,12]) = 31
	| (elem m [4,6,9,11]) = 30
	| m == 2 && (leapyear y) = 29
	| otherwise = 28

reminder :: Int -> Int -> Int
reminder x y
	| x < y = x
	| otherwise = reminder (x-y) y

sumFacts :: Int -> Int
sumFacts 0 = 0
sumFacts x = fact x + sumFacts(x-1)
