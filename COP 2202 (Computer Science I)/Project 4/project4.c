#include <stdio.h>

#define MAX_ROWS 1

#define MAX_COLUMNS 3

int main()
{

    int table[MAX_ROWS][MAX_COLUMNS] = {

        {12, 45, 23, 10},

        {15, 89, 43, 38}};

    int i, j, a, row, column;

    for (row = 0; row < MAX_ROWS; row++)
    {

        for (column = 0; column < MAX_COLUMNS; column++)
        {

            for (i = 0; i < table[i][i]; ++i)

            {

                for (j = i + 1; j < table[i][i]; ++j)

                {

                    if (table[i] > table[j])

                    {

                        a = table[i][i];

                        table[i][i] = table[j][j];

                        table[j][j] = a;
                    }
                }
            }
        }
    }

    printf("%d", table[MAX_ROWS][MAX_COLUMNS]);

    return 0;
}