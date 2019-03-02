#include <stdio.h> 
#define SIZE_ROW 100
#define NUM_ROWS 10

struct ROW {
    float data[SIZE_ROW];
    float addition;
};

void add_row(struct ROW *pf) {
// B) Implement add_row
	int i;
	for (i = 0; i < SIZE_ROW; i++) {
		(*pf).addition += (*pf).data[i];
	}
}

// Initilize rows with value i * j
void init_row(struct ROW *pf, int i) {
    int j;
    for (j = 0; j < SIZE_ROW; j++) {
    	(*pf).data[j] = (float)i*j;
      
    }
}

main() { 
    // A) define a vector of structures ROW with size NUM_ROWS
    struct ROW rows[NUM_ROWS];
  
    int i;
    float total_add;
    
    // C) Complete the loop
    total_add = 0;
    for (i = 0; i < NUM_ROWS; i++) {
        // Call add_row
	init_row(&rows[i], i);
	add_row(&rows[i]);
        printf("Row %u addition result is %f\n", i, rows[i].addition);
        // update total_add with the actual row
	total_add += rows[i].addition;
    }

    printf("Final addition result is %f\n", total_add); 
}