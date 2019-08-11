/*
Francis Rukab
N00961805
COP3530
*/

// ***** Includes *****

#include <stdbool.h>
#include <stdarg.h>
#include <stddef.h>
#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <limits.h>
#include <math.h>

// ***** Prototypes *****

int* parseFile(char* filePath, int* sizePointer);
void sort(int* arrayPointer, int size);
void swap(int* arrayPointer, int indexA, int indexB);
