%%
%% declarations
%%

isfather('juan', 'maria').		% juan is the father of maria
isfather('pablo', 'juan').		% pablo is the father of juan
isfather('pablo', 'marcela').
isfather('carlos', 'debora').
isfather('luisa', 'debora').

% A is the son of B if B is the father
isson(A,B) :- isfather(B,A).

% A is the granfather of B if A is the father of C and C the father of B
isgrandfather(A,B) :-
	isfather(A,C),
	isfather(C,B).

% A is the isgrandson of B if B is the grandfather of A
isgrandson(A,B) :- isgrandfather(B,A).

% A and B are brothers if the father of A and B is equal 
%								and A and B are not equal
isbrother(A,B) :-
	isfather(C,A),
	isfather(C,B),
	A \== B.

% A and B are family if A they have a 
%		father, brother, son or grandfather relation
isrelative(A,B) :-
	isfather(A,B).
isrelative(A,B) :-
	isson(A,B).
isrelative(A,B) :-
	isbrother(A,B).
isrelative(A,B) :-
	isgrandfather(A,B).
isrelative(A,B) :-
	isgrandson(A,B).
