#include <stdio.h>

void reverse(char *str) {
	int i, j, k;
	char temp;

	if (!str)
		return;

	for (i = 0; str[i] != '\0'; i++)
		;
	for (j = 0, k = i - 1; j < k; j++, k--) {
		temp = str[j];
		str[j] = str[k];
		str[k] = temp;
	}
}

int main() {
	char str[] = "abcdef";
	printf("Before reverse: %s\n", str);
	reverse(str);
	printf("After reverse: %s\n", str);
	return 0;
}
	
