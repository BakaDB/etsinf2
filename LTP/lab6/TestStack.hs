import Stack

main = do
	-- putStrLn show (isEmpty (EmptyStack))
	-- Error data constructor EmptyStack not in scope

	putStrLn (show (top (push 5 empty)))
