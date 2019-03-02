import qualified Circle
import qualified Triangle

main = do
	putStrLn ("The area of a circle with radius 2 = " ++ show (Circle.area 2))
	putStrLn ("The area of a triangle with base 4 and height 5 = " ++ 												show (Triangle.area 4 5))
