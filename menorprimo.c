#include <stdio.h>


int verificar_primo(int num) {
    if (num <= 1) return 0;
    for (int i = 2; i * i <= num; i++) {
        if (num % i == 0) return 0;
    }
    return 1;
}

int proximo_primo(int num) {
    for (int current = num + 1; ; current++) {
        if (verificar_primo(current)) return current;
    }
}

int main() {
    int n;
    int resultado;

    // Atualização ao pedir a entrada
    do {
        printf("Digite um numero inteiro: ");
        resultado = scanf("%d", &n);

        if (resultado != 1) { // Verifica se a entrada não é um inteiro 
            printf("Entrada inválida. Por favor, digite um número inteiro.\n"); // Se não for, exibe uma mensagem contendo essa informação
            while (getchar() != '\n');  // Esvazia o buffer de entrada nos casos em que a entrada for inválida, para que seja possível fazer uma nova leitura com o buffer limpo
        }
    } while (resultado != 1); // Continua solicitando a entrada até que ela seja válida (um número inteiro)

    int primo = proximo_primo(n);
    printf("O menor numero primo maior que %d eh: %d\n", n, primo);

    return 0;
}
