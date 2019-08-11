/*
Francis Rukab
N00961805
COP3530
*/

#include "main.h"

void swap(int* arrayPointer, int indexA, int indexB)
{
	// Create a temporary buffer and store the value from arrayPointer[indexA].
	int temp = arrayPointer[indexA];
	// Store the value from arrayPointer[indexB] at arrayPointer[indexA].
	arrayPointer[indexA] = arrayPointer[indexB];
	// Store the value from the temporary buffer at arrayPointer[indexB].
	arrayPointer[indexB] = temp;
}
