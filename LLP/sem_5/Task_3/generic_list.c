#include <stdint.h>
#include <inttypes.h>
#include <stdio.h>
#include <stdlib.h>

void error(const char *s) {
  fprintf(stderr, "%s\n", s);
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
  };

#define DEFINE_LIST_OPERATIONS(type)                                    \
    void list_##type##_push(struct list_##type *head, type val) {       \
        struct list_##type *curr = head;                                \
        while(curr->next != 0) {                                        \
            curr = curr->next;                                          \
        }                                                               \
        struct list_##type *newVal = malloc(sizeof(struct list_##type ));\
        newVal->value = val;                                            \
        curr->next = newVal;                                            \
        };                                                              \
    void list_##type##_print(struct list_##type *head) {                \
        struct list_##type *curr = head;                                \
        while(curr != 0) {                                              \
            type##_print(curr->value);                                  \
            newline_print();                                            \
            curr = curr->next;                                          \
        }                                                               \
    };

DEFINE_LIST(int64_t)
DEFINE_LIST(double)
DEFINE_LIST(char)

DEFINE_LIST_OPERATIONS(int64_t)
DEFINE_LIST_OPERATIONS(double)

#undef DEFINE_LIST_OPERATIONS

#define list_print(x)                                                   \
  _Generic((x),                                                         \
           struct list_int64_t* : list_int64_t_print(x),                \
           struct list_double* : list_double_print(x),                  \
           default : error("Unsupported print operation"))

#define list_push(head, x)                                              \
  _Generic((head),                                                      \
           struct list_int64_t* : list_int64_t_push(head, x),           \
           struct list_double* : list_double_push(head, x),             \
           default : error("Unsupported push operation"))


int main() {
    printf("Double List:\n");
    struct list_double ld = {5.23};
    list_push(&ld, 42.4242);
    list_push(&ld, 77.777);
    list_print(&ld);
    newline_print();

    printf("Int64_t List:\n");
    struct list_int64_t li = {100};
    list_push(&li, 200);
    list_push(&li, 300);
    list_push(&li, 400);
    list_print(&li);
    newline_print();

    printf("Char List:\n");
    struct list_char lc = {'H'};
    list_push(&lc, 'e');
    list_push(&lc, 'l');
    list_push(&lc, 'l');
    list_push(&lc, 'o');
    list_print(&lc);
}
