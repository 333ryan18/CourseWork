/*
Francis Rukab
N00961805
COP3530
*/

#include "main.h"

int* parseFile(char* filePath, int* sizePointer)
{
	// Open file.
	FILE* inputFile    = fopen(filePath, "r");
	int*  arrayPointer = NULL;
	int   j;

	// Get the first integer and record it as the array size.
	fscanf(inputFile, " %d", sizePointer);

	// Allocate contiguous memory for the array.
	arrayPointer = (int*)calloc(*sizePointer, sizeof(int));

	// Parse the remainder of the file.
	for (j = 0; j < (*sizePointer); j++)
	{
		fscanf(inputFile, " %d", &arrayPointer[j]);
	}

	// Close the file.
	fclose(inputFile);

	// Return a pointer to the newly constructed array.
	return arrayPointer;
}
