#include <stdio.h>

int fun(int x) {
    if (x == 0)
        return 0;
    else
        return 2 * fun(x - 1) + x * x;
}

int main() {
    printf("fun(20) is %d.\n", fun(20));
    return 0;
}


