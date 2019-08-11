// Write a program to sort the elements using insertion sort.The user has to input the numbers in array;
// use the function and use pointer type variables in array.The array should be one dimensional array

#include <stdio.h>

int sort(int *arr, int n)
{

    int i, j, a;

    for (i = 1; i < n; i++)
    {

        a = *(arr + i);

        j = i - 1;

        while (a < *(arr + j) && j >= 0)
        {

            *(arr + (j + 1)) = *(arr + j);

            j--;
        }

        *(arr + (j + 1)) = a;
    }

    return 0;
}

int main()
{

    int *arr, i, n;

    printf("Enter the number of elements you would like to sort:\n");

    scanf("%d", &n);

    arr = (int *)malloc(n * sizeof(int));

    printf("Enter the elements:\n");

    for (i = 0; i < n; i++)

        scanf("%d", (arr + i));

    sort(arr, n);

    printf("Your elements sorted are:\n");

    for (i = 0; i < n; i++)

        printf("%d\n", *(arr + i));

    return 0;