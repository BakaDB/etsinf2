/* range_processes.c */
#include <stdio.h>
#include <stdlib.h>

int main(int argc, char *argv[])
{
    int i;
    printf("I'm the parent %d\n", (long)getpid());
    for(i=0; i<5; i++) {
        int pid = fork();
        if (pid==0) {
        printf("Child %d created with pid %d\n", i, (long)getpid());
        exit(i);
        }
        
    }
    
    sleep(10);
    exit(0);
}