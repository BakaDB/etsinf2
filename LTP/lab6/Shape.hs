module Shape (area, perimeter, volumePrism, 
				surfaceArea, (==), (/=), show) where

type Height = Float
type Width = Float
type Radius = Float

data Rectangle = Rectangle Height Width
data Circle = Circle Radius

class Shape a where
	area :: a -> Float
	perimeter :: a -> Float
	show :: a -> String
	rectangle :: Height -> Width -> a
	circle :: Radius -> a
	(==) :: a -> a -> Bool
	(/=) :: a -> a -> Bool	

instance Shape Rectangle where
	area (Rectangle h w) = h * w
	perimeter (Rectangle h w) = 2*(h + w)

instance Eq Rectangle where
	(Rectangle x y) == (Rectangle a b) = x == a && y == b

instance Show Rectangle where
	show (Rectangle x y) = ("Rectangle x=" ++ (show x) ++ ", y=" ++ (show y))

instance Shape Circle where
	area (Circle r) = pi * r**2
	perimeter (Circle r) = 2 * pi * r

instance Eq Circle where
	(Circle a) == (Circle b) =  a == b

instance Show Circle where
	show (Circle r) = ("Circle r= " ++ (show r))

type Volume = Float
volumePrism :: (Shape a) => a -> Height -> Volume
volumePrism base height = (area base) * height

surfacePrism :: (Shape a) => a -> Height -> Volume
surfacePrism base height = (area base)*2 + (perimeter base)*height


