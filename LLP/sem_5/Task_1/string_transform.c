#define print_var(x) printf(#x " is %d\n", x )
#define constant 404

int main() {
    int x = 777;
    print_var(x);
    print_var(42);
    print_var(constant);
}
