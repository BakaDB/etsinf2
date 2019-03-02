countTo(1,[1]).
countTo(2,[1,2]).
countTo(3,[1,2,3]).
countTo(4,[1,2,3,4]).

mymember(E,[E|_]).
mymember(E,[_|L]) :- mymember(E,L).

myappend([],L,L).
myappend([E|L1],L2,[E|L3]) :- myappend(L1,L2,L3).

myflatten([],[]).
myflatten([X|L],[X|P]) :- atomic(X), flatten(L,P).
myflatten([X|L],P) :- not(atomic(X)), flatten(X,P_X), flatten(L,P_L), append(P_X,P_L,P).

mylast(U,[U]).
mylast(U,L) :- append(_,[U],L).

