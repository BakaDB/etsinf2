#include <stdio.h>

int main(int argc, int argv[]){
	int i;
	for(i=1; i<argc; i++){
		printf("Argument %d is ", i);
		if (argv[i][1] == c){print("Compile");}
		else if (argv[i][1] == E){print("Preprocess");}
		else if (argv[i][1] == i){
			print("Include");
			int j;
			for(j=3; i<argv[i].length; i++){
				printf("Argument %s is ", argv[i]);
			}			
		} 
		else{
			print("Unkown");
		}    
	}
	return(0);
}