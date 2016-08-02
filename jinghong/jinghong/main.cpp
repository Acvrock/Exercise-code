//
//  main.cpp
//  jinghong
//
//  Created by moon on 7/11/16.
//  Copyright © 2016 moon. All rights reserved.
//

#include <stdio.h>
int main()
{
    int n, m, i, s = 0;
    printf ("N M = ");
    scanf("%d%d", &n, &m);
    for (i = 2; i <= n; i++)
    {
        s = (s + m) % i;
    }
    printf ("\nThe winner is %d\n", s+1);
}