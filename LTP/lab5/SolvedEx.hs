module SolvedEx where

decBin :: Int -> [Int]
decBin x = if x < 2 then [x] else (mod x 2) : decBin (div x 2)

binDec :: [Int] -> Int
binDec (x:[]) = x
binDec (x:y) = x + binDec y * 2
