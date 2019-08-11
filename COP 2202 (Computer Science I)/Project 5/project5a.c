// Write a program to find factorial of a number using function. The input of a number is to be entered by the user and should be an integer and should be pointer type variable.

// Factorial of a number is calculated as : e.g.Number is 5 so factorial is 5.4.3.2.1 -----(.represents * / times)

#include <stdio.h>

int main()
{

    int n, c, answer = 1;

    printf("Enter a number to find the factorial: ");

    scanf("%d", &n);

    for (c = 1; c <= n; c++)

        answer = answer * c;

    printf("The factorial of %d is: %d", n, answer);

    return 0;
}