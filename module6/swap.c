#include <stdio.h>

void swap(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void broken_swap(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int x, y;
    printf("\nEnter first number: ");
    scanf("%d", &x);
    printf("\nEnter second number: ");
    scanf("%d", &y);

    printf("\nBefore swapping: x = %d, y = %d\n", x, y);
    swap(&x, &y);
    printf("After swapping:  x = %d, y = %d\n", x, y);

    // This will not swap the values of x and y in the main function because it only swaps copies of the values
    printf("\n*** Demonstrating broken swap *** \n");
    printf("Before swapping: x = %d, y = %d\n", x, y);
    broken_swap(x, y);
    printf("After broken swapping: x = %d, y = %d\n\n", x, y);

    return 0;
}