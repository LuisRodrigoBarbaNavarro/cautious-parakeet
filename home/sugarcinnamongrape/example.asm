section .data
    message db 'Hello', 10 ; The message to print
    message_len equ $-message ; The length of the message

section .text
    global _start

_start:
    mov eax, 0 ; Initialize counter to 0
    jmp print_message ; Jump to print_message to print the message

print_loop:
    inc eax ; Increment counter
    cmp eax, 10 ; Compare counter to 10
    jne print_message ; Jump to print_message if counter is not equal to 10
    mov eax, 1 ; Set exit status to 1
    xor ebx, ebx ; Set EBX to 0
    int 0x80 ; Call kernel to exit the program

print_message:
    push eax ; Save the value of EAX
    mov eax, 4 ; Set EAX to 4 to indicate write system call
    mov ebx, 1 ; Set EBX to 1 to indicate standard output
    mov ecx, message ; Set ECX to the address of the message
    mov edx, message_len ; Set EDX to the length of the message
    int 0x80 ; Call kernel to print the message
    pop eax ; Restore the value of EAX
    jmp print_loop ; Jump to print_loop to check if counter is equal to 10