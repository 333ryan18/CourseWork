/* 

Program that puts entered numbers in ascending order. 

By: Ryan Rukab N00961805 

Date: 11/2/15 

*/ 

 

#include <stdio.h> 

 

main() 

{ 

  int i, readNum, numbers[1000]; 

 

    printf("How many numbers would you like to enter: "); 

    scanf("%d", &readNum); 

    printf("Enter the numbers: "); 

    for (i = 0; i < readNum; ++i) 

        scanf("%d", &numbers[i]); 

    for (i = 0; i < readNum; ++i); 

    printf("The numbers arranged in ascending order are given below: \n"); 

    for (i = 0; i < readNum; ++i) 

        printf("%d ", numbers[i]); 

    return 0; 

} 