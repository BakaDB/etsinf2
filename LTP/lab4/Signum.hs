module Signum where

sign :: Int -> Int
sign n
	| n < 0 = -1
	| n == 0 = 0
	| otherwise = 1
