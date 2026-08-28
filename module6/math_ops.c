#include <stdio.h>

void print_math(int a, int b) {
    printf("Sum:       %d \n", a + b);
    printf("Product:   %d \n", a * b);
}

int main() {
    int num1;
    printf("Enter first number: ");
    scanf("%d", &num1);
    int num2;
    printf("Enter second number: ");
    scanf("%d", &num2);
    
    print_math(num1, num2);

    return 0;
}