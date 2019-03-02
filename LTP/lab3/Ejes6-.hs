module Ejes2 where
	
	reverses :: [a] -> [a]
	reverses xs = rev xs []	
	rev :: [a] -> [a] -> [a]
	rev [] acc = acc
	rev (x:xs) acc = rev xs (x:acc)

	mapB :: (a -> b -> c) -> [a] -> [b] -> [c]
	mapB f [] _ = []
	mapB f _ []	= []
	mapB f (x:xs) (y:ys) = f x y : mapB f xs ys

	t :: Int -> Int
	t x = x * (x+1)
	trans :: [Int] -> [Int]
	trans xs = map t xs

	myUnzip :: [(a,b)] -> ([a],[b])
	myUnzip ((x,y):rest) = (x:xs,y:ys)
		where (xs,ys) = myUnzip rest

	coords :: Int -> Int -> [(Int,Int)]
	coords x y = [(a,b) | a <- [1..y], b <- [1..y]]
	
	pyramid :: Int -> [[Int]]
	pyramid n =  [[1..x] | x <- [1..n]]


	foo :: IO ()
	foo = do {
		putStrLn "Name?";
		name <- getLine;
		putStrLn "Surname?";
		surname <- getLine;
		putStrLn("Hola "++name++" "++surname++", how are you?");
		}

	reveal :: IO()
	reveal = do {
				putStrLn "Insert a character: ";
				c <- getChar;
				if c=='q' then putStrLn "Bye"
				else do {
					putStrLn (show c);
					reveal
				}
			}

	type Area = Float
	type Volume = Float
	type Side = Float
	type Radius = Float
	data Square = ASquare Side deriving Show
	data Rectangle = ARectangle Side Side deriving Show
	data Circle = ACircle Radius deriving Show
	data Cube = ACube Side deriving Show
	data Sphere = ASphere Radius deriving Show

	class MyArea a where
		area:: a -> Area
	class MyVolume a where
		volume:: a -> Volume
	instance MyArea Square where
		area (ASquare l)= l * l
	instance MyArea Rectangle where
		area (ARectangle l m) = l * m
	instance MyArea Circle where
		area (ACircle r) = 3.14 * r * r
	instance MyVolume Cube where
		volume (ACube l) = l * l * l
	instance MyVolume Sphere where
		volume (ASphere r) = 3.14 * r * r * r

	data PrimaryColor = Violet|Indigo|Blue|Green|Yellow|Orange|Red deriving(Eq, Ord)

	type Nombre = String
	type Edad = Int
	type Empleado = (Nombre, Edad)

	masJoven::[Empleado] -> Empleado
	masJoven x = masJovenAux (head x) (tail x)
	masJovenAux x [] = x
	masJovenAux (n1,e1) ((n2, e2):xs)
		| e1>e2 = masJovenAux (n2,e2) xs
		|otherwise = masJovenAux (n1,e1) xs

	joven::Empleado -> Empleado -> Empleado
	joven (n1, e1) (n2, e2) = if e1<e2 then (n1,e1) else (n2, e2)

	masJoven2::[Empleado] -> Empleado
	masJoven2 [x]=x
	masJoven2 (x:y:xs) = masJoven2 ((joven x y):xs)
	