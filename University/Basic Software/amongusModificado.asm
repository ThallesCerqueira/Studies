# Demo for painting
#
# Bitmap Display Configuration:
# - Unit width in pixels: 8					     
# - Unit height in pixels: 8
# - Display width in pixels: 256
# - Display height in pixels: 256
# - Base Address for Display: 0x10008000 ($gp)
#
# - Discente: Samyr Ribeiro dos Santos
# - Matricula: 202010637

# Instruções: para se movimentar use as teclas 'a' e 'd', elas vão alternar entre o anterior(a) e o próximo(w) frame. 
# ou seja, não necessariamente a tecla 'w' vai pra direita, ela vai para o próximo frame.
# 
# Fim do programa: o programa encerra após chegar no último frame, que eh uma pixel art de encerramento.

.data
displayAddress:	.word	0x10008000
frames: .word frame1, frame2, frame3, frame4, frame5, frame6, frame7, frame8, frame9, frame10
colors: .word 0x808000,0x00FFFF,0xFF0000, 0x800080,0xFF00FF,0xFFFF00,0x7FFFD4,0x7CFC00,0xADFF2F,0xD2691E,0xF4A460

#######################
# Program Entry Point #
#######################

.text
.globl main
	
main:

# Configurando endereço do registrador especial
li $a0, 0xffff0000

# Habilitando interrupções do teclado
lw $t0, 0($a0)
ori $t0, 0x02  # use keyboard interrupts
sw $t0, 0($a0)

# Configurando o registrador de status para habilitar interrupções
mfc0 $t0, $12  # Status
ori $t0, 0x01  # interrupts enable
mtc0 $t0, $12  # Status

# Carrega o endereço base para o display em $t0
lw $t0, displayAddress	

#Carrega o endereço do vetor de cores e seta variável de incremento
la $s3,colors
li $s4,0
					
# Armazena o enderecos das labels dos frames em um vetor
la $t2, frames

# Carrega o endereço da label frame1 em $t3 e armazena no primeiro elemento do vetor frames
la $t3, frame1
sw $t3, ($t2)

# Carrega o endereço da label frame2 em $t3 e armazena no segundo elemento do vetor frames
la $t3, frame2
sw $t3, 4($t2)

la $t3, frame3
sw $t3, 8($t2)

la $t3, frame4
sw $t3, 12($t2)

la $t3, frame5
sw $t3, 16($t2)

la $t3, frame6
sw $t3, 20($t2)

la $t3, frame7
sw $t3, 24($t2)

la $t3, frame8
sw $t3, 28($t2)

la $t3, frame9
sw $t3, 32($t2)
	
la $t3, frame10
sw $t3, 36($t2)

li $s0, 0
	
# Após interrupção, atualiza o frame atual
loop_fora:
lw $s1, ($t2)
jal jump_frame
li $s2, 1
	
# Loop aguardando interrupção
loop:
nop
beq $s2, 1, loop
j loop_fora
	
jump_frame:
jr $s1
jr $ra

frame1:	
addi $sp, $sp, -4
sw $ra, 0($sp)

li $a0, 11
li $a1, 27
li $t1, 0x000000
jal limpa_boneco
	
#Carrega a cor do vetor
sll $t4,$s4,2
add $t4,$s3,$t4
lw $t4,0($t4)
move $t1, $t4
move $s5,$t4 #salva a cor previamente acessada
	
	li $a0, 2
	li $a1, 29
	jal boneco_facing_east
	li $t1, 0x874022
   	jal fundo
    	
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	jr $ra
	
frame2:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $a0, 2
	li $a1, 29
	li $t1, 0x000000
	jal limpa_boneco
	li $a0, 19
	li $a1, 25
	jal limpa_boneco
	#Carrega a cor do vetor
	sll $t4,$s4,2
	add $t4,$s3,$t4
	lw $t4,0($t4)
	move $t1, $t4
	move $s5,$t4 #salva a cor previamente acessada
        
	li $a0, 11
   	li $a1, 27
	jal boneco_facing_east

	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	jr $ra
  
 frame3:
 	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $a0, 11
	li $a1, 27
	li $t1, 0x000000
	jal limpa_boneco
	li $a0, 28
	li $a1, 21
	jal limpa_boneco
	#Carrega a cor do vetor
	sll $t4,$s4,2
	add $t4,$s3,$t4
	lw $t4,0($t4)
	move $t1, $t4
	move $s5,$t4 #salva a cor previamente acessada
        
	li $a0, 19
	li $a1, 25
	jal boneco_facing_east

	lw $ra, 0($sp)
	addi $sp, $sp, 4

	jr $ra

frame4:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $a0, 19
	li $a1, 25
	li $t1, 0x000000
	jal limpa_boneco
	#Carrega a cor do vetor
	sll $t4,$s4,2
	add $t4,$s3,$t4
	lw $t4,0($t4)
	move $t1, $t4
	move $s5,$t4 #salva a cor previamente acessada
        
	li $a0, 28
	li $a1, 21
	jal boneco_facing_east
        
	lw $ra, 0($sp)
	addi $sp, $sp, 4

	jr $ra

frame5:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $a0, 28
	li $a1, 21
	li $t1, 0x000000
	jal limpa_boneco
	li $a0, 19
	li $a1, 17
	jal limpa_boneco
	#Carrega a cor do vetor
	sll $t4,$s4,2
	add $t4,$s3,$t4
	lw $t4,0($t4)
	move $t1, $t4
	move $s5,$t4 #salva a cor previamente acessada
	
	li $a0, 28
	li $a1, 21
	jal boneco_facing_west

	lw $ra, 0($sp)
	addi $sp, $sp, 4

	jr $ra

frame6:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $a0, 28
	li $a1, 21
	li $t1, 0x000000
	jal limpa_boneco
	li $a0, 11
	li $a1, 15
	jal limpa_boneco
	#Carrega a cor do vetor
	sll $t4,$s4,2
	add $t4,$s3,$t4
	lw $t4,0($t4)
	move $t1, $t4
	move $s5,$t4 #salva a cor previamente acessada
        
	li $a0, 19
	li $a1, 17
	jal boneco_facing_west

	lw $ra, 0($sp)
	addi $sp, $sp, 4

	jr $ra

frame7:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $a0, 19
	li $a1, 17
	li $t1, 0x000000
	jal limpa_boneco
	li $a0, 2
	li $a1, 13
	jal limpa_boneco
	#Carrega a cor do vetor
	sll $t4,$s4,2
	add $t4,$s3,$t4
	lw $t4,0($t4)
	move $t1, $t4
	move $s5,$t4 #salva a cor previamente acessada
        
	li $a0, 11
	li $a1, 15
	jal boneco_facing_west

	lw $ra, 0($sp)
	addi $sp, $sp, 4    

	jr $ra

frame8:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $a0, 11
	li $a1, 15
	li $t1, 0x000000
	jal limpa_boneco
	li $a0, 2
	li $a1, 13
	jal limpa_boneco
	#Carrega a cor do vetor
	sll $t4,$s4,2
	add $t4,$s3,$t4
	lw $t4,0($t4)
	move $t1, $t4
	move $s5,$t4 #salva a cor previamente acessada
        
	li $a0, 2
	li $a1, 13
	jal boneco_facing_west

	lw $ra, 0($sp)
	addi $sp, $sp, 4

	jr $ra
	
frame9:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $a0, 11
	li $a1, 15
	li $t1, 0x000000
	jal limpa_boneco
	#Carrega a cor do vetor
	sll $t4,$s4,2
	add $t4,$s3,$t4
	lw $t4,0($t4)
	move $t1, $t4
	move $s5,$t4 #salva a cor previamente acessada
        
	li $a0, 2
	li $a1, 13
	jal boneco_facing_east

	lw $ra, 0($sp)
	addi $sp, $sp, 4

	jr $ra

frame10:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	# Limpar tela
	jal limpa_tela

	li $a0, 8	# Posicao inicial da pixel art (Inferior esquerda)
	li $a1, 26
	jal frame_final

	lw $ra, 0($sp)
	addi $sp, $sp, 4

	j Exit
	
Exit:
	li $v0, 10 # terminate the program gracefully
	syscall
	
linhah:	
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	li $t5, 0
	sll $t6, $a1, 7 
	sll $t7, $a0, 2  
	addu $t4, $t6, $t7 
	addu $t4, $t4, $t0
	Linha:
		addiu $t5,$t5, 1

		blt $t5, 5, continue
		li $t1, 0x9c5a3c
		bne $t5, 7, continue
		li $t1, 0xb07963
		
		continue:
			sw $t1, ($t4)	
			li $t1, 0x874022
			addiu $t4, $t4, 4
			bne $t5, 7, Linha
		
			lw $ra, 0($sp)
			addi $sp, $sp, 4
		
		jr $ra
	
boneco_facing_east:
	addi $sp, $sp, -4
	sw $ra, 0($sp)
	
	sll $t6, $a1, 7
	sll $t7, $a0, 2  
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7 
	sll $t7, $a0, 2  
	addu $t4, $t6, $t7 
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7  
	sll $t7, $a0, 2  
	addu $t4, $t6, $t7 
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 4($t4)
	li $t1, 0x1a1a1a
	sw $t1, 8($t4)
	move $t1, $s5
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	li $t1, 0x1a1a1a
	sw $t1, 4($t4)
	li $t1, 0xffffff
	sw $t1, 8($t4)
	move $t1, $s5
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, 4($t4)
	
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	jr $ra

boneco_facing_west:

	addi $sp, $sp, -4
	sw $ra, 0($sp)
	
	
	sll $t6, $a1, 7		# Linha 1 do boneco
	sll $t7, $a0, 2  
	addu $t4, $t6, $t7 
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7		# Linha 2 do boneco
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7		# Linha 3 do boneco
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	li $t1, 0x1a1a1a
	sw $t1, ($t4)
	move $t1,$s5
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7		# Linha 4 do boneco
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	li $t1, 0xffffff
	sw $t1, ($t4)
	li $t1, 0x1a1a1a
	sw $t1, 4($t4)
	move $t1, $s5
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7		# Linha 5 do boneco
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	move $t1,$s5
	sw $t1, 4($t4)
	
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	jr $ra
	
limpa_boneco:

	addi $sp, $sp, -4
        sw $ra, 0($sp)
	
	sll $t6, $a1, 7 
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	
	addi $a1, $a1, -1
	
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0
	sw $t1, 4($t4)
	
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	jr $ra

limpa_tela:
    li $t1, 0x000000
           
    li $a0, 0
    li $a1, 31
    
    li $t5, 0
    
    lin:
        addi $a1, $a1, -1
        addiu $t5,$t5, 1
        
        sll $t6, $a1, 7
        sll $t7, $a0, 2
        addu $t4, $t6, $t7
        addu $t4, $t4, $t0
        
        li $t6, 0
        
        col:
            addiu $t6,$t6, 1
            sw $t1, ($t4)
            addiu $t4, $t4, 4
            bne $t6, 32, col
                   
            bne $t5, 32, lin
    
    jr $ra

	
fundo:

	addi $sp, $sp, -4
    	sw $ra, 0($sp)

	li $a0, 1
    	li $a1, 30	# Plataforma 1
	jal linhah
	
	li $a0, 9
	li $a1, 28	# Plataforma 2
	jal linhah
	
	li $a0, 17
	li $a1, 26	# Plataforma 3
	jal linhah
	
	li $a0, 25
	li $a1, 22	# Plataforma 4
	jal linhah

	li $a0, 17
	li $a1, 18	# Plataforma 5
	jal linhah

	li $a0, 9
	li $a1, 16	# Plataforma 6
	jal linhah

	li $a0, 1
	li $a1, 14	# Plataforma 7
	jal linhah
	
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	jr $ra

# Essa label eh grande pois desenha pixel a pixel, linha a linha, o frame final (eh uma pixel art)
# Fim da label na linha 1237
frame_final:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	# -------------------- Linha 1
	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	sw $t1, 12($t4)

	li $t1, 0x190161
	sw $t1, 16($t4)
	sw $t1, 20($t4)
	sw $t1, 24($t4)

	li $t1, 0x000000
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)

	li $t1, 0x190161
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x000000
	sw $t1, 56($t4)
	
	# -------------------- Linha 2
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)
	sw $t1, 20($t4)
	sw $t1, 24($t4)

	li $t1, 0x190161
	sw $t1, 28($t4)

	li $t1, 0x000000
	sw $t1, 32($t4)
	sw $t1, 36($t4)

	li $t1, 0x190161
	sw $t1, 40($t4)

	li $t1, 0x023799
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 3
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)
	sw $t1, 20($t4)
	sw $t1, 24($t4)

	li $t1, 0x190161
	sw $t1, 28($t4)

	li $t1, 0x000000
	sw $t1, 32($t4)
	sw $t1, 36($t4)

	li $t1, 0x190161
	sw $t1, 40($t4)

	li $t1, 0x023799
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 4
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)

	li $t1, 0x190161
	sw $t1, 32($t4)
	sw $t1, 36($t4)

	li $t1, 0x023799
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 5
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)

	li $t1, 0x190161
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 6
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x190161
	sw $t1, ($t4)

	li $t1, 0x023799
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 7
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x190161
	sw $t1, ($t4)

	li $t1, 0x023799
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)
	sw $t1, 20($t4)
	sw $t1, 24($t4)

	li $t1, 0x0069bf
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)

	li $t1, 0x023799
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 8
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x190161
	sw $t1, ($t4)

	li $t1, 0x023799
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)
	sw $t1, 20($t4)

	li $t1, 0x0069bf
	sw $t1, 24($t4)
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)

	li $t1, 0x023799
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 9
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x190161
	sw $t1, ($t4)

	li $t1, 0x023799
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)

	li $t1, 0x023799
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 10
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x190161
	sw $t1, ($t4)

	li $t1, 0x023799
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 11
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x190161
	sw $t1, ($t4)

	li $t1, 0x023799
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)
	sw $t1, 32($t4)

	li $t1, 0x190161
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)

	li $t1, 0x023799
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)

	# -------------------- Linha 12
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x190161
	sw $t1, ($t4)

	li $t1, 0x0069bf
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)
	sw $t1, 24($t4)

	li $t1, 0x190161
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	
	li $t1, 0x18476e
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)

	li $t1, 0x190161
	sw $t1, 52($t4)
	sw $t1, 56($t4)

	# -------------------- Linha 13
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x190161
	sw $t1, ($t4)

	li $t1, 0x0069bf
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)
	sw $t1, 24($t4)

	li $t1, 0x190161
	sw $t1, 28($t4)
	
	li $t1, 0x18476e
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)
	sw $t1, 56($t4)

	li $t1, 0x190161
	sw $t1, 60($t4)

	# -------------------- Linha 14
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)

	li $t1, 0x190161
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)

	li $t1, 0x190161
	sw $t1, 24($t4)
	
	li $t1, 0x18476e
	sw $t1, 28($t4)
	sw $t1, 32($t4)


	li $t1, 0x47b8cf
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)
	sw $t1, 56($t4)

	li $t1, 0x190161
	sw $t1, 60($t4)

	# -------------------- Linha 15
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)

	li $t1, 0x190161
	sw $t1, 24($t4)
	
	li $t1, 0x18476e
	sw $t1, 28($t4)


	li $t1, 0x47b8cf
	sw $t1, 32($t4)
	sw $t1, 36($t4)

	li $t1, 0xffffff
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)
	sw $t1, 56($t4)

	li $t1, 0x190161
	sw $t1, 60($t4)

	# -------------------- Linha 16
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)

	li $t1, 0x190161
	sw $t1, 12($t4)

	li $t1, 0x023799
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)
	sw $t1, 24($t4)

	li $t1, 0x190161
	sw $t1, 28($t4)

	li $t1, 0x47b8cf
	sw $t1, 32($t4)
	sw $t1, 36($t4)

	li $t1, 0xffffff
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	li $t1, 0x190161
	sw $t1, 56($t4)


	# -------------------- Linha 17
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	sw $t1, 12($t4)

	li $t1, 0x190161
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)

	li $t1, 0x190161
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	sw $t1, 48($t4)
	sw $t1, 52($t4)

	# -------------------- Linha 18
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	sw $t1, 12($t4)

	li $t1, 0x190161
	sw $t1, 16($t4)

	li $t1, 0x0069bf
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	li $t1, 0x190161
	sw $t1, 48($t4)

	# -------------------- Linha 19
	addi $a1, $a1, -1
	sll $t6, $a1, 7
	sll $t7, $a0, 2
	addu $t4, $t6, $t7
	addu $t4, $t4, $t0

	li $t1, 0x000000
	sw $t1, ($t4)
	sw $t1, 4($t4)
	sw $t1, 8($t4)
	sw $t1, 12($t4)
	sw $t1, 16($t4)

	li $t1, 0x190161
	sw $t1, 20($t4)
	sw $t1, 24($t4)
	sw $t1, 28($t4)
	sw $t1, 32($t4)
	sw $t1, 36($t4)
	sw $t1, 40($t4)
	sw $t1, 44($t4)
	

	lw $ra, 0($sp)
	addi $sp, $sp, 4
	
	jr $ra

################
# Handler Data #
################

.kdata
ktemp:	.space 16

##########################
# Handler Implementation #
##########################

	# Overwrites previous handler defined in exceptions.s
	.ktext 0x80000180
	
	move $k0, $at
	
	la $k1, ktemp
	sw $a0, 0($k1)
	sw $a1, 4($k1)
	sw $v0, 8($k1)
	sw $ra, 12($k1)
	
	# hardware interrupt
		mfc0 $a0, $13  # Cause
		#jal print_hex
		andi $v0, $a0, 0x0100
		beq $v0, $zero, e_int_keyrecv_end
		# keyboard receive interrupt

		xor $a0, $a0, $v0
		mtc0 $a0, $13  # Cause

		li $a0, 0xffff0000
		lw $v0, 4($a0) #valor digitado
		sb $v0, ($a0) #coloca o valor digitado no char
		
		
		li $s2, 0	# Apos a interrupcao, o programa vai carregar um novo frame,
				# antes de entrar em loop esperando por uma nova interrupcao
		
		# Tratamento quando aperta 'a'
		bne $v0, 97, prox
		beqz $s0, prox		# Nao pode ir para a esquerda se estiver no primeiro frame
		addi $s0, $s0, -1	# Decrementa o indice do vetor de frame a ser carregado
		li $s1, -4
		add $t2, $t2, $s1
		
		# Tratamento quando aperta 'd'
		prox:
		bne $v0, 100, press_s
		beq $s0, 9, press_s	# Nao pode ir para a direita se estiver no ultimo frame
		addi $s0, $s0, 1	# Incrementa o indice do vetor de frame a ser carregado
		li $s1, 4
		add $t2, $t2, $s1
		
		#Tratamento quando aperta 's', troca a skin do boneco
		press_s:
		bne $v0,115,saida
		addi $s4,$s4,1 #adiciona 1 no elemento do vetor de cores
		slti $s6,$s4,11
		bne $s6,$0,saida
		li $s4,0
		saida:
		jal print_string	# Imprime a tecla digitada
		
		

   e_int_keyrecv_end:

	la $k1, ktemp
	lw $a0, 0($k1)
	lw $a1, 4($k1)
	lw $v0, 8($k1)
	lw $ra, 12($k1)
	
	move $at, $k0
	
	mfc0 $k0, $12  # Status
	ori $k0, 0x01  # re-enable interrupts
	mtc0 $k0, $12  # Status
	eret

###############################
# print_string Implementation #
###############################

print_string: # $a0: string
	j ps_cond
ps_loop:
	lw $v0, 0xffff0008
	andi $v0, $v0, 0x01
	beq $v0, $zero, ps_loop
	sw $a1, 0xffff000c
ps_cond:
	lbu $a1, ($a0)
	addi $a0, $a0, 1
	bne $a1, $zero, ps_loop
	jr $ra
