#include <stdint.h>
#include <inttypes.h>
#include <stdio.h>
#include <stdlib.h>

void error(const char *s) {
  fprintf(stderr, "%s", s);
  abort();
}

#define _print(type, x) type##_print(x)

void int64_t_print(int64_t i) { printf("%" PRId64, i); }
void double_print(double d) { printf("%lf", d); }
void char_print(char c) {printf("%c", c); }
void newline_print() { puts(""); }

#define DEFINE_LIST(type)                                               \
  struct list_##type {                                                  \
    type value;                                                         \
    struct list_##type* next;                                           \
  };                                                                    \
    void list_##type##_push(struct list_##type *head, type val) {       \
        struct list_##type *curr = head;                                \
        while(curr->next != 0) {                                        \
            curr = curr->next;                                          \
        }                                                               \
        struct list_##type *newVal = malloc(sizeof(struct list_##type ));\
        newVal->value = val;                                            \
        curr->next = newVal;                                            \
    };                                                                  \
    void list_##type##_print(struct list_##type *head) {                \
        struct list_##type *curr = head;                                \
        while(curr != 0) {                                              \
            type##_print(curr->value);                                  \
            newline_print();                                            \
            curr = curr->next;                                          \
        }                                                               \
    }

DEFINE_LIST(int64_t)
DEFINE_LIST(double)
DEFINE_LIST(char)

int main() {
    printf("Double List:\n");
    struct list_double ld = {5.23};
    list_double_push(&ld, 42.4242);
    list_double_push(&ld, 77.777);
    list_double_print(&ld);
    newline_print();

    printf("Int64_t List:\n");
    struct list_int64_t li = {1234};
    list_int64_t_push(&li, 4321);
    list_int64_t_push(&li, 1000);
    list_int64_t_print(&li);
    newline_print();

    printf("Char List:\n");
    struct list_char lc = {'H'};
    list_char_push(&lc, 'e');
    list_char_push(&lc, 'l');
    list_char_push(&lc, 'l');
    list_char_push(&lc, 'o');
    list_char_print(&lc);
    return 0;
}
