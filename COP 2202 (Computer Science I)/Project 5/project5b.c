// Write a program to show output like this. Use function for the program to be called in the main program. It should be the exact same output

// 1       2         3        4

// 1       2         3

// 1       2

// 1

#include <stdio.h>

int function()
{

    printf("1 2 3 4\n");

    printf("1 2 3\n");

    printf("1 2\n");

    printf("1\n");
}

int main()
{

    function();

    return 0;
}