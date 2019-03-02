swap([],[]).
swap([X],[X]).
swap([X,Y|Z],[Y,X|Z]).

mistery([],0).
mistery([_|T],N) :- mistery(T,M), N is M + 1.

mysubset([],X).
mysubset([A|X],Y) :- member(A,Y), member(X,Y).

sorted([X]).
sorted([X,Y|Ys]) :- X =< Y, sorted([Y|Ys]).

remove(_,[],[]).
remove(C,[X|R],L) :- X == C, remove(C,R,L).
remove(C,[X|R],W) :- X \== C, remove(C,R,L), W = [X|L].

