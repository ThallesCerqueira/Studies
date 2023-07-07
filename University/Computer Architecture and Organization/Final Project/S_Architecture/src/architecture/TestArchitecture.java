package architecture;

import static org.junit.Assert.*;
import java.io.IOException;
import java.util.ArrayList;
import org.junit.Test;

import components.Bus;
import components.Memory;
import components.Register;

public class TestArchitecture {

	// uncomment the anotation below to run the architecture showing components
	// status
	// @Test
	public void testShowComponentes() {

		// a complete test (for visual purposes only).
		// a single code as follows
		// ldi 2
		// store 40
		// ldi -4
		// point:
		// store 41 //mem[41]=-4 (then -3, -2, -1, 0)
		// read 40
		// add 40 //mem[40] + mem[40]
		// store 40 //result must be in 40
		// read 41
		// inc
		// jn point
		// end

		Architecture arch = new Architecture(true);
		arch.getMemory().getDataList()[0] = 7;
		arch.getMemory().getDataList()[1] = 2;
		arch.getMemory().getDataList()[2] = 6;
		arch.getMemory().getDataList()[3] = 40;
		arch.getMemory().getDataList()[4] = 7;
		arch.getMemory().getDataList()[5] = -4;
		arch.getMemory().getDataList()[6] = 6;
		arch.getMemory().getDataList()[7] = 41;
		arch.getMemory().getDataList()[8] = 5;
		arch.getMemory().getDataList()[9] = 40;
		arch.getMemory().getDataList()[10] = 0;
		arch.getMemory().getDataList()[11] = 40;
		arch.getMemory().getDataList()[12] = 6;
		arch.getMemory().getDataList()[13] = 40;
		arch.getMemory().getDataList()[14] = 5;
		arch.getMemory().getDataList()[15] = 41;
		arch.getMemory().getDataList()[16] = 8;
		arch.getMemory().getDataList()[17] = 4;
		arch.getMemory().getDataList()[18] = 6;
		arch.getMemory().getDataList()[19] = -1;
		arch.getMemory().getDataList()[40] = 0;
		arch.getMemory().getDataList()[41] = 0;
		// now the program and the variables are stored. we can run
		arch.controlUnitEexec();

	}

	@Test
	public void testAdd() {
		Architecture arch = new Architecture();
		// storing the number 5 in position 40
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(5);
		arch.getMemory().store();

		// moreover, the number 40 must be in the position next to PC. (to perform add
		// 40)
		// in this test, PC will point to 10 and the 40 will be in the position 11
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(40); // 40 is in position 11
		arch.getMemory().store();
		arch.getExtbus1().put(10);
		arch.getPC().store(); // PC points to position 10

		// storing the number 8 in the RPG
		arch.getExtbus1().put(8);
		arch.getRPG().store();
		// now we can perform the add method.
		// we will add the number 5 (stored in the 40th position in the memory)
		// with the number 8 (already stored in the rgp)
		// result must be into rpg
		// pc must be two positions ahead the original one
		arch.add();
		arch.getRPG().read();
		// the bus must contains the number 13
		assertEquals(13, arch.getExtbus1().get());
		// the flags bits 0 and 1 must be 0
		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(0, arch.getFlags().getBit(1));
		// PC must be pointing to 12
		arch.getPC().read();
		assertEquals(12, arch.getExtbus1().get());

	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testAddMemReg() {
		Architecture arch = new Architecture();

		// Na posição 11 da memoria, armazena 40(mem)
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(40);
		arch.getMemory().store();

		// Na posição 40 da memória(referenciada na posição 11), armazena o valor 14
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(25);
		arch.getMemory().store();

		// Seta o valor de PC em 10 para iniciar a execução da função
		arch.getExtbus1().put(10);
		arch.getPC().store();

		// now setting the registers values
		arch.getExtbus1().put(65);
		arch.getRegistersList().get(0).store(); // RPG0 has 65

		arch.addMemReg();

		// testing if both REG1 and REG0 store the same value: 99
		arch.getRegistersList().get(0).read();
		assertEquals(90, arch.getExtbus1().get());

		// Testing if PC points to 3 positions after the original
		// PC was pointing to 10; now it must be pointing to 13
		arch.getPC().read();
		assertEquals(13, arch.getExtbus1().get());
	}
	
	@Test
	public void testLdiImmReg() {
		Architecture arch = new Architecture();
		
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(17);
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(3);
		arch.getMemory().store();
		
		arch.getExtbus1().put(10);
		arch.getPC().store();
		
		arch.ldiImmReg();
		
		assertEquals(17,arch.getRPG3().getData());
		assertEquals(13,arch.getPC().getData());
		
	}
	
	
	@Test
	public void testAddRegMem() {
		Architecture arch = new Architecture();

		// Na posição 11 da memoria, armazena 40(mem)
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(0);
		arch.getMemory().store();
		// Na posição 40 da memória(referenciada na posição 11), armazena o valor 25
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(30);
		arch.getMemory().store();

		// Seta o valor de PC em 10 para iniciar a execução da função
		arch.getExtbus1().put(10);
		arch.getPC().store();

		// now setting the registers values
		arch.getExtbus1().put(20);
		arch.getRegistersList().get(0).store(); // RPG0 has 65

		arch.addRegMem();

		arch.getExtbus1().put(40);
		arch.getMemory().read();
		
		assertEquals(50, arch.getExtbus1().get());
		assertEquals(13, arch.getPC().getData());
		assertEquals(0, arch.getFlags().getBit(0));

	}

	@Test
	public void testAddRegReg() {

		Architecture arch = new Architecture();

		// storing the number 1 in the memory, in position 31
		arch.getMemory().getDataList()[31] = 1;
		// storing the number 0 in the memory, in position 32
		arch.getMemory().getDataList()[32] = 0;
		// making PC points to position 30
		arch.getExtbus1().put(30);
		arch.getPC().store();

		// now setting the registers values
		arch.getExtbus1().put(45);
		arch.getRegistersList().get(0).store(); // RPG0 has 45
		arch.getExtbus1().put(99);
		arch.getRegistersList().get(1).store(); // RPG1 has 99

		// executing the command move REG1 REG0.
		arch.addRegReg();

		// testing if both REG1 and REG0 store the same value: 99
		arch.getRegistersList().get(0).read();
		assertEquals(144, arch.getExtbus1().get());
		arch.getRegistersList().get(1).read();
		assertEquals(99, arch.getExtbus1().get());

		// Testing if PC points to 3 positions after the original
		// PC was pointing to 30; now it must be pointing to 33
		arch.getPC().read();
		assertEquals(33, arch.getExtbus1().get());

	}

	@Test
	public void testSubRegReg() {
		Architecture arch = new Architecture();
		// sub regA regB :::: regB <- regA - regB
		// RegA = 30
		// RegB = 10
		// Resultado = 30 - 10 = 20
		arch.getExtbus1().put(30);
		arch.getRPG3().store();
		arch.getExtbus1().put(10);
		arch.getRPG2().store();
		System.out.println("RPG0 =" + arch.getRPG0().getData());
		System.out.println("RPG1 =" + arch.getRPG1().getData());
		// Setando a memória com os endereços dos registradores a serem operados
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(3);
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(2);
		arch.getMemory().store();

		// PC aponta para 10
		arch.getExtbus1().put(10);
		arch.getPC().store();
		arch.subRegReg();

		assertEquals(20, arch.getRPG2().getData());
		assertEquals(30, arch.getRPG3().getData());
		assertEquals(13, arch.getPC().getData());

		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(0, arch.getFlags().getBit(1));

		// RegA = 50
		// RegB = 70
		// Resultado -> RegB = 50 - 70 = -20
		arch.getExtbus1().put(50);
		arch.getRPG1().store();
		arch.getExtbus1().put(70);
		arch.getRPG3().store();

		// Setando a memória com os endereços dos registradores a serem operados
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(1);
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(3);
		arch.getMemory().store();

		// PC aponta para 10
		arch.getExtbus1().put(10);
		arch.getPC().store();
		arch.subRegReg();

		assertEquals(-20, arch.getRPG3().getData());
		assertEquals(50, arch.getRPG1().getData());
		assertEquals(13, arch.getPC().getData());

		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(1, arch.getFlags().getBit(1));

	}
	@Test
	public void testSubImmReg() {
		Architecture arch = new Architecture();
		
		arch.getExtbus1().put(13);
		arch.getRPG2().store();
		
		// Setando a memória com os endereços dos registradores a serem operados
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(20);
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(2);
		arch.getMemory().store();

		// PC aponta para 10
		arch.getExtbus1().put(10);
		arch.getPC().store();
		arch.subImmReg();

		assertEquals(7, arch.getRPG2().getData());
		assertEquals(13, arch.getPC().getData());

		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(0, arch.getFlags().getBit(1));


	}
	@Test
	public void testSubMemReg() {
		Architecture arch = new Architecture();
		// sub mem regB :::: regB <- memoria[mem] - regB
		//

		arch.getExtbus1().put(20);
		arch.getRPG2().store();

		arch.getExtbus1().put(11);
		arch.getMemory().store();

		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(2);
		arch.getMemory().store();

		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(50);
		arch.getMemory().store();

		// PC aponta para 10
		arch.getExtbus1().put(10);
		arch.getPC().store();
		arch.subMemReg();

		assertEquals(30, arch.getRPG2().getData());
		assertEquals(13, arch.getPC().getData());

		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(0, arch.getFlags().getBit(1));

		// TESTE 2
		Architecture arch2 = new Architecture();
		// sub mem regB :::: regB <- memoria[mem] - regB
		//

		arch2.getExtbus1().put(50);
		arch2.getRPG1().store();

		arch2.getExtbus1().put(11);
		arch2.getMemory().store();
		arch2.getExtbus1().put(22);
		arch2.getMemory().store();
		arch2.getExtbus1().put(12);
		arch2.getMemory().store();
		arch2.getExtbus1().put(1);
		arch2.getMemory().store();

		arch2.getExtbus1().put(22);
		arch2.getMemory().store();
		arch2.getExtbus1().put(30);
		arch2.getMemory().store();

		// PC aponta para 10
		arch2.getExtbus1().put(10);
		arch2.getPC().store();
		arch2.subMemReg();

		assertEquals(-20, arch2.getRPG1().getData());
		assertEquals(13, arch2.getPC().getData());

		assertEquals(0, arch2.getFlags().getBit(0));
		assertEquals(1, arch2.getFlags().getBit(1));

	}

	@Test
	public void testSubRegMem() {
		Architecture arch = new Architecture();
		// sub regA mem :::: memoria[mem] <- regA - memoria[mem]

		arch.getExtbus1().put(21);
		arch.getRPG0().store();

		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(0);
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(41);
		arch.getMemory().store();

		arch.getExtbus1().put(41);
		arch.getMemory().store();
		arch.getExtbus1().put(-19);
		arch.getMemory().store();

		// PC aponta para 10
		arch.getExtbus1().put(10);
		arch.getPC().store();
		arch.subRegMem();

		assertEquals(21, arch.getRPG0().getData());
		arch.getExtbus1().put(41);
		arch.getMemory().read();
		assertEquals(40, arch.getExtbus1().get());
		assertEquals(13, arch.getPC().getData());

		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(0, arch.getFlags().getBit(1));
	}

	@Test
	public void testImulRegReg() {
		Architecture arch = new Architecture();
		arch.getExtbus1().put(-12);
		arch.getRPG2().store();
		arch.getExtbus1().put(-10);
		arch.getRPG1().store();

		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(2);
		arch.getMemory().store();
		arch.getExtbus1().put(13);
		arch.getMemory().store();
		arch.getExtbus1().put(1);
		arch.getMemory().store();

		arch.getExtbus1().put(11);
		arch.getPC().store();
		
		arch.getExtbus1().put(14);
		arch.getMemory().store();
		arch.getExtbus1().put(-1);
		arch.getMemory().store();
		
		arch.imulRegReg();
		arch.controlUnitEexec();
		
		assertEquals(120, arch.getRPG1().getData());
		assertEquals(-12, arch.getRPG2().getData());
		assertEquals(14, arch.getPC().getData());

		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(0, arch.getFlags().getBit(1));
	}

	@Test
	public void testImulRegMem() {
		Architecture arch = new Architecture();

		arch.getExtbus1().put(-30);
		arch.getRPG1().store();

		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(1);
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(40);
		arch.getMemory().store();

		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(-20);
		arch.getMemory().store();

		arch.getExtbus1().put(10);
		arch.getPC().store();

		arch.getExtbus1().put(13);
		arch.getMemory().store();
		arch.getExtbus1().put(-1);
		arch.getMemory().store();
		
		arch.imulRegMem();
		arch.controlUnitEexec();
		
		assertEquals(-30, arch.getRPG1().getData());
		arch.getExtbus1().put(40);
		arch.getMemory().read();
		assertEquals(600, arch.getExtbus1().get());
		assertEquals(13, arch.getPC().getData());
	}

	@Test
	public void testImulMemReg() {
		// imul mem reg -> reg = memoria[mem] * reg

		Architecture arch = new Architecture();

		// Seta o valor de RPG1 com valor -4
		arch.getExtbus1().put(-4);
		arch.getRPG1().store();

		// Na posição 11 da memoria, armazena 40(mem)
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		// Na posição 12 da memoria, armazena 1(reg)
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(1);
		arch.getMemory().store();

		// Na posição 40 da memória(referenciada na posição 11), armazena o valor 12
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(-10);
		arch.getMemory().store();

		arch.getExtbus1().put(13);
		arch.getMemory().store();
		arch.getExtbus1().put(-1);
		arch.getMemory().store();
		// Seta o valor de PC em 10 para iniciar a execução da função
		arch.getExtbus1().put(10);
		arch.getPC().store();

		arch.imulMemReg();
		arch.controlUnitEexec();
		
		arch.getExtbus1().put(40);
		arch.getMemory().read();
		assertEquals(-10,arch.getExtbus1().get());
		assertEquals(40, arch.getRPG1().getData());
		assertEquals(13, arch.getPC().getData());

	}

	@Test
	public void testMoveMemReg() {

		Architecture arch = new Architecture();

		// Setta o valor de PC em 10
		arch.getExtbus1().put(10);
		arch.getPC().store();

		// Setta o valor de RPG1 com valor 0
		arch.getExtbus1().put(0);
		arch.getRPG1().store();

		// Na posição 11 da memoria, armazena 40
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(40);
		arch.getMemory().store();

		// Na posição 12 da memoria, armazena 1(reg)
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(2);
		arch.getMemory().store();

		// Na posição 40 da memória (referenciada na posição 11), armazena o valor 100
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(101);
		arch.getMemory().store();

		// Executando o Microprograma
		arch.moveMemReg();

		// Fazendo as validações
		assertEquals(101, arch.getRPG2().getData());
		assertEquals(13, arch.getPC().getData());

	}

	@Test
	public void testMoveRegReg() {

		Architecture arch = new Architecture();

		// Setta o valor de PC em 10 para iniciar a execução do programa
		arch.getExtbus1().put(10);
		arch.getPC().store();

		// Seta o valor de RPG1 com valor 10
		arch.getExtbus1().put(100);
		arch.getRPG1().store();

		// Seta o valor de RPG2 com valor 0
		arch.getExtbus1().put(0);
		arch.getRPG2().store();

		// Na posição 11 da memoria, armazena 1 (REG1)
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(1);
		arch.getMemory().store();

		// Na posição 12 da memoria, armazena 2(REG2)
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(2);
		arch.getMemory().store();

		// Executando o Microprograma
		arch.moveRegReg();

		// Fazendo as validações
		assertEquals(100, arch.getRPG1().getData());
		assertEquals(100, arch.getRPG2().getData());
		assertEquals(13, arch.getPC().getData());

	}

	@Test
	public void testMoveRegMem() {

		Architecture arch = new Architecture();

		// Setta o valor de PC em 10
		arch.getExtbus1().put(10);
		arch.getPC().store();

		// Seta o valor de RPG1 com valor 100
		arch.getExtbus1().put(100);
		arch.getRPG1().store();

		// Na posição 11 da memoria, armazena 1 (Reg)
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(1);
		arch.getMemory().store();

		// Na posição 12 da memoria, coloca a posicao para armazenar
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(40);
		arch.getMemory().store();

		// Executando o Microprograma
		arch.moveRegMem();

		// Validação RPG
		assertEquals(100, arch.getRPG1().getData());

		// Validação Memória
		arch.getExtbus1().put(40);
		arch.getMemory().read();
		assertEquals(100, arch.getExtbus1().get());

		// Validação PC
		assertEquals(13, arch.getPC().getData());

	}

	@Test
	public void testMoveImmReg() {

		Architecture arch = new Architecture();

		// Na posição 11 da memoria, coloca o valor a ser movido.
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(300);
		arch.getMemory().store();

		// Settar 0 para o RPG1
		arch.getExtbus1().put(0);
		arch.getRPG2().store();

		// Na posição 12 da memoria, armazena 1 (Reg)
		arch.getExtbus1().put(12);
		arch.getMemory().store();
		arch.getExtbus1().put(2);
		arch.getMemory().store();

		// Setta o valor de PC em 10 para iniciar a execução do programa
		arch.getExtbus1().put(10);
		arch.getPC().store();

		// Executando o Microprograma
		arch.moveImmReg();

		// Validação RPG
		assertEquals(300, arch.getRPG2().getData());

		// Validação PC
		assertEquals(13, arch.getPC().getData());

	}

	@Test
	public void testJeqRegReg() {

		Architecture arch = new Architecture();
		int caso = 2;

		// Se CASO == 1 Iguais, senão diferentes

		if (caso == 1) {

			// Settar 150 para o RPG1
			arch.getExtbus1().put(150);
			arch.getRPG1().store();

			// Settar 150 para o RPG2
			arch.getExtbus1().put(150);
			arch.getRPG2().store();

			// Na posição 11 da memoria, armazena 1 (Reg)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(1);
			arch.getMemory().store();

			// Na posição 12 da memoria, armazena 2 (Reg)
			arch.getExtbus1().put(12);
			arch.getMemory().store();
			arch.getExtbus1().put(2);
			arch.getMemory().store();

			// Na posição 13 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(13);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();

			// Executando o Microprograma
			arch.jeqRegReg();

			// Validação RPGs
			assertEquals(150, arch.getRPG1().getData());
			assertEquals(150, arch.getRPG2().getData());

			// Validação PC
			assertEquals(40, arch.getPC().getData());

		} else {
			// Settar 150 para o RPG1
			arch.getExtbus1().put(150);
			arch.getRPG1().store();

			// Settar 100 para o RPG2
			arch.getExtbus1().put(100);
			arch.getRPG2().store();

			// Na posição 11 da memoria, armazena 1 (Reg)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(1);
			arch.getMemory().store();

			// Na posição 12 da memoria, armazena 2 (Reg)
			arch.getExtbus1().put(12);
			arch.getMemory().store();
			arch.getExtbus1().put(2);
			arch.getMemory().store();

			// Na posição 13 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(13);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();

			// Executando o Microprograma
			arch.jeqRegReg();

			// Validação RPGs
			assertEquals(150, arch.getRPG1().getData());
			assertEquals(100, arch.getRPG2().getData());

			// Validação PC
			assertEquals(14, arch.getPC().getData());
		}

	}

	@Test
	public void testJgtRegReg() {

		Architecture arch = new Architecture();
		int caso = 2;

		// Se CASO == 1, então RegA > RegB

		if (caso == 1) {

			// Settar 150 para o RPG1
			arch.getExtbus1().put(150);
			arch.getRPG1().store();

			// Settar 100 para o RPG2
			arch.getExtbus1().put(100);
			arch.getRPG2().store();

			// Na posição 11 da memoria, armazena 1 (Reg)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(1);
			arch.getMemory().store();

			// Na posição 12 da memoria, armazena 2 (Reg)
			arch.getExtbus1().put(12);
			arch.getMemory().store();
			arch.getExtbus1().put(2);
			arch.getMemory().store();

			// Na posição 13 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(13);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();

			// Executando o Microprograma
			arch.jgtRegReg();

			// Validação RPGs
			assertEquals(150, arch.getRPG1().getData());
			assertEquals(100, arch.getRPG2().getData());

			// Validação PC
			assertEquals(40, arch.getPC().getData());

		} else {
			// Settar 150 para o RPG1
			arch.getExtbus1().put(150);
			arch.getRPG1().store();

			// Settar 200 para o RPG2
			arch.getExtbus1().put(200);
			arch.getRPG2().store();

			// Na posição 11 da memoria, armazena 1 (Reg)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(1);
			arch.getMemory().store();

			// Na posição 12 da memoria, armazena 2 (Reg)
			arch.getExtbus1().put(12);
			arch.getMemory().store();
			arch.getExtbus1().put(2);
			arch.getMemory().store();

			// Na posição 13 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(13);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();

			// Executando o Microprograma
			arch.jeqRegReg();

			// Validação RPGs
			assertEquals(150, arch.getRPG1().getData());
			assertEquals(200, arch.getRPG2().getData());

			// Validação PC
			assertEquals(14, arch.getPC().getData());
		}

	}

	@Test
	public void testJlwRegReg() {

		Architecture arch = new Architecture();
		int caso = 2;

		// Se CASO == 1, então RegA < RegB

		if (caso == 1) {

			// Settar 100 para o RPG1
			arch.getExtbus1().put(100);
			arch.getRPG1().store();

			// Settar 200 para o RPG2
			arch.getExtbus1().put(200);
			arch.getRPG2().store();

			// Na posição 11 da memoria, armazena 1 (Reg)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(1);
			arch.getMemory().store();

			// Na posição 12 da memoria, armazena 2 (Reg)
			arch.getExtbus1().put(12);
			arch.getMemory().store();
			arch.getExtbus1().put(2);
			arch.getMemory().store();

			// Na posição 13 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(13);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();

			// Executando o Microprograma
			arch.jlwRegReg();

			// Validação RPGs
			assertEquals(100, arch.getRPG1().getData());
			assertEquals(200, arch.getRPG2().getData());

			// Validação PC
			assertEquals(40, arch.getPC().getData());

		} else {
			// Settar 200 para o RPG1
			arch.getExtbus1().put(200);
			arch.getRPG1().store();

			// Settar 100 para o RPG2
			arch.getExtbus1().put(100);
			arch.getRPG2().store();

			// Na posição 11 da memoria, armazena 1 (Reg)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(1);
			arch.getMemory().store();

			// Na posição 12 da memoria, armazena 2 (Reg)
			arch.getExtbus1().put(12);
			arch.getMemory().store();
			arch.getExtbus1().put(2);
			arch.getMemory().store();

			// Na posição 13 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(13);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();

			// Executando o Microprograma
			arch.jeqRegReg();

			// Validação RPGs
			assertEquals(200, arch.getRPG1().getData());
			assertEquals(100, arch.getRPG2().getData());

			// Validação PC
			assertEquals(14, arch.getPC().getData());
		}

	}

	@Test
	public void testJmpMem() {

		Architecture arch = new Architecture();

		// Setta o valor de PC em 10 para iniciar a execução do programa
		arch.getExtbus1().put(10);
		arch.getPC().store();

		// Na posição 11 da memoria, armazena 40 (Mem)
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(35);
		arch.getMemory().store();

		// Executando o Microprograma
		arch.jmpMem();

		// Validação PC
		assertEquals(35, arch.getPC().getData());

	}

	@Test
	public void testJnMem() {

		Architecture arch = new Architecture();
		

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();
			arch.getFlags().setBit(1, 1);
			
			// Na posição 11 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Executando o Microprograma
			arch.jnMem();

			// Validação PC
			assertEquals(40, arch.getPC().getData());

		

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();
			arch.getFlags().setBit(1, 0);
			// Na posição 11 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Executando o Microprograma
			arch.jnMem();

			// Validação PC
			assertEquals(12, arch.getPC().getData());
		
	}

	@Test
	public void testJzMem() {
		
		Architecture arch = new Architecture();
		

			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();
			arch.getFlags().setBit(0, 1);
			// Na posição 11 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(35);
			arch.getMemory().store();

			// Executando o Microprograma
			arch.jzMem();

			// Validação PC
			assertEquals(35, arch.getPC().getData());

		
			//CASO 2
			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();
			arch.getFlags().setBit(0, 0);
			// Na posição 11 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Executando o Microprograma
			arch.jzMem();

			// Validação PC
			assertEquals(12, arch.getPC().getData());
		

	}

	@Test
	public void testJnzMem() {
		
		Architecture arch = new Architecture();
		
		//CASO 1
			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();
			arch.getFlags().setBit(0, 0);
			// Na posição 11 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Executando o Microprograma
			arch.jnzMem();

			// Validação PC
			assertEquals(40, arch.getPC().getData());

		//CASO 2
			// Setta o valor de PC em 10 para iniciar a execução do programa
			arch.getExtbus1().put(10);
			arch.getPC().store();
			arch.getFlags().setBit(0, 1);
			// Na posição 11 da memória, armazena 40 (Mem)
			arch.getExtbus1().put(11);
			arch.getMemory().store();
			arch.getExtbus1().put(40);
			arch.getMemory().store();

			// Executando o Microprograma
			arch.jnzMem();

			// Validação PC
			assertEquals(12, arch.getPC().getData());
		
	}

	@Test
	public void testIncReg() {
		

		Architecture arch = new Architecture();

		// storing the number 1 in the memory, in position 31
		arch.getMemory().getDataList()[31] = 1;
	
		// making PC points to position 30
		arch.getExtbus1().put(30);
		arch.getPC().store();

		// now setting the registers values
		arch.getExtbus1().put(128);
		arch.getRegistersList().get(1).store(); // RPG1 has 99

		// executing the command move REG1 REG0.
		arch.incReg();

		// testing if both REG1 and REG0 store the same value: 99
		arch.getRegistersList().get(1).read();
		assertEquals(129, arch.getExtbus1().get());

		// Testing if PC points to 3 positions after the original
		// PC was pointing to 30; now it must be pointing to 32
		arch.getPC().read();
		assertEquals(32, arch.getExtbus1().get());
	}

	@Test
	public void testIncMem() {

		Architecture arch = new Architecture();

		// Na posição 11 da memoria, armazena 40(mem)
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(40);
		arch.getMemory().store();

		// Na posição 40 da memória(referenciada na posição 11), armazena o valor 14
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(14);
		arch.getMemory().store();

		// Seta o valor de PC em 10 para iniciar a execução da função
		arch.getExtbus1().put(10);
		arch.getPC().store();

		arch.incMem();
		
		arch.getExtbus1().put(40);
		arch.getMemory().read();
		assertEquals(15, arch.getExtbus1().get());
		assertEquals(12, arch.getPC().getData());
		assertEquals(0, arch.getFlags().getBit(0));

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Test
	public void testSub() {
		Architecture arch = new Architecture();

		/*************************
		 * first test: 5 (rpg) - 8 (mem-40) = -3 (rpg)
		 ***********************************************/

		// storing the number 8 i the memory, in position 40
		arch.getExtbus1().put(40);
		arch.getMemory().store();
		arch.getExtbus1().put(8);
		arch.getMemory().store();
		// storing the number 5 in the external bus
		arch.getExtbus1().put(5);
		// moving this number 5 into the rpg
		arch.getRPG().store();

		// moreover, the number 40 must be in the position next to PC. (to perform sub
		// 40)
		// in this test, PC will point to 10 and the 40 will be in the position 11
		arch.getExtbus1().put(11);
		arch.getMemory().store();
		arch.getExtbus1().put(40); // 40 is in position 11
		arch.getMemory().store();
		arch.getExtbus1().put(10);
		arch.getPC().store(); // PC points to position 10

		// now we can perform the sub method.
		// we will sub, from the number 5 (stored in the rpg)
		// the number 8 (stored in the memory, position 40)
		// result must be into rpg
		arch.sub();
		arch.getRPG().read();
		// the bus must contains the number -3
		assertEquals(-3, arch.getExtbus1().get());

		// flags bits must be 0 (bit zero) and 1 (bit negative)
		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(1, arch.getFlags().getBit(1));

		// PC must be pointing to 12
		arch.getPC().read();
		assertEquals(12, arch.getExtbus1().get());

		/*************************
		 * second test: 5 (rpg) - 5 (mem-50) = 0 (rpg)
		 ***********************************************/

		// storing the number 5 in the memory, in position 50
		arch.getExtbus1().put(50);
		arch.getMemory().store();
		arch.getExtbus1().put(5);
		arch.getMemory().store();
		// storing the number 5 in the external bus
		arch.getExtbus1().put(5);
		// moving this number 5 into the rpg
		arch.getRPG().store();

		// moreover, the number 50 must be in the position next to PC. (to perform sub
		// 50)
		// in this test, PC will point to 12 and the 50 will be in the position 13
		arch.getExtbus1().put(13);
		arch.getMemory().store();
		arch.getExtbus1().put(50); // 50 is in position 13
		arch.getMemory().store();
		arch.getExtbus1().put(12);
		arch.getPC().store(); // PC points to position 12

		// now we can perform the sub method.
		// we will sub, from the number 5 (stored in the rpg)
		// the number 5 (already stored in the memory, position 50)
		// result must be into rpg
		arch.sub();
		arch.getRPG().read();
		// the bus must contains the number 0
		assertEquals(0, arch.getExtbus1().get());

		// flags bits must be 1 (bit zero) and 0 (bit negative)
		assertEquals(1, arch.getFlags().getBit(0));
		assertEquals(0, arch.getFlags().getBit(1));

		// PC must be pointing to 14
		arch.getPC().read();
		assertEquals(14, arch.getExtbus1().get());

		/*************************
		 * third test: 5 (rpg) - 3 (mem-60) = 2 (rpg)
		 ***********************************************/

		// storing the number 3 in the memory, in position 60
		arch.getExtbus1().put(60);
		arch.getMemory().store();
		arch.getExtbus1().put(3);
		arch.getMemory().store();
		// storing the number 5 in the external bus
		arch.getExtbus1().put(5);
		// moving this number 5 into the rpg
		arch.getRPG().store();

		// moreover, the number 60 must be in the position next to PC. (to perform sub
		// 60)
		// in this test, PC will point to 14 and the 60 will be in the position 15
		arch.getExtbus1().put(15);
		arch.getMemory().store();
		arch.getExtbus1().put(60); // 60 is in position 15
		arch.getMemory().store();
		arch.getExtbus1().put(14);
		arch.getPC().store(); // PC points to position 14

		// now we can perform the sub method.
		// we will sub, from the number 5 (stored in the rpg)
		// the number 3 (already stored in the memory, position 60)
		// result must be into rpg
		arch.sub();
		arch.getRPG().read();
		// the bus must contains the number 2
		assertEquals(2, arch.getExtbus1().get());

		// flags bits must be 0 (bit zero) and 0 (bit negative)
		assertEquals(0, arch.getFlags().getBit(0));
		assertEquals(0, arch.getFlags().getBit(1));

		// PC must be pointing to 16
		arch.getPC().read();
		assertEquals(16, arch.getExtbus1().get());
	}

	@Test
	public void testJmp() {
		Architecture arch = new Architecture();
		// storing the number 10 in PC
		arch.getIntbus2().put(10);
		arch.getPC().internalStore();

		// storing the number 25 in the memory, in the position just before that one
		// adressed by PC
		arch.getExtbus1().put(11); // the position is 11, once PC points to 10
		arch.getMemory().store();
		arch.getExtbus1().put(25);
		arch.getMemory().store();

		// testing if PC stores the number 10
		arch.getPC().read();
		assertEquals(10, arch.getExtbus1().get());

		// now we can perform the jmp method.
		// we will move the the number 25 (stored in the 31th position in the memory)
		// into the PC
		arch.jmp();
		arch.getPC().internalRead();
		;
		// the internalbus2 must contains the number 25
		assertEquals(25, arch.getIntbus2().get());

	}

	@Test
	public void testJz() {
		Architecture arch = new Architecture();

		// storing the number 30 in PC
		arch.getIntbus2().put(30);
		arch.getPC().internalStore();

		// storing the number 25 in the into the memory, in position 31, the position
		// just after PC
		arch.getExtbus1().put(31);
		arch.getMemory().store();
		arch.getExtbus1().put(25);
		arch.getMemory().store();

		// now we can perform the jz method.

		// CASE 1.
		// Bit ZERO is equals to 1
		arch.getFlags().setBit(0, 1);

		// So, we will move the the number 25 (stored in the 31th position in the
		// memory)
		// into the PC

		// testing if PC stores the number 30
		arch.getPC().read();
		assertEquals(30, arch.getExtbus1().get());

		arch.jz();

		// PC must be storng the number 25
		arch.getPC().internalRead();
		assertEquals(25, arch.getIntbus2().get());

		// CASE 2.
		// Bit ZERO is equals to 0
		arch.getFlags().setBit(0, 0);
		// PC must have the number 30 initially (in this time, by using the external
		// bus)
		arch.getExtbus1().put(30);
		arch.getPC().store();
		// destroying the data in external bus
		arch.getExtbus1().put(0);

		// testing if PC stores the number 30
		arch.getPC().read();
		assertEquals(30, arch.getExtbus1().get());

		// Note that the memory was not changed. So, in position 31 we have the number
		// 25

		// Once the ZERO bit is 0, we WILL NOT move the number 25 (stored in the 31th
		// position in the memory)
		// into the PC.
		// The original PC position was 30. The parameter is in position 31. So, now PC
		// must be pointing to 32
		arch.jz();
		// PC contains the number 32
		arch.getPC().internalRead();
		assertEquals(32, arch.getIntbus2().get());
	}

	@Test
	public void testJn() {
		Architecture arch = new Architecture();

		// storing the number 30 in PC
		arch.getIntbus2().put(30);
		arch.getPC().internalStore();

		// storing the number 25 in the into the memory, in position 31, the position
		// just after PC
		arch.getExtbus1().put(31);
		arch.getMemory().store();
		arch.getExtbus1().put(25);
		arch.getMemory().store();

		// now we can perform the jn method.

		// CASE 1.
		// Bit NEGATIVE is equals to 1
		arch.getFlags().setBit(1, 1);

		// So, we will move the the number 25 (stored in the 31th position in the
		// memory)
		// into the PC

		// testing if PC stores the number 30
		arch.getPC().read();
		assertEquals(30, arch.getExtbus1().get());

		arch.jn();

		// PC must be storng the number 25
		arch.getPC().internalRead();
		assertEquals(25, arch.getIntbus2().get());

		// CASE 2.
		// Bit NEGATIVE is equals to 0
		arch.getFlags().setBit(1, 0);
		// PC must have the number 30 initially (in this time, by using the external
		// bus)
		arch.getExtbus1().put(30);
		arch.getPC().store();
		// destroying the data in external bus
		arch.getExtbus1().put(0);

		// testing if PC stores the number 30
		arch.getPC().read();
		assertEquals(30, arch.getExtbus1().get());

		// Note that the memory was not changed. So, in position 31 we have the number
		// 25

		// Once the ZERO bit is 0, we WILL NOT move the number 25 (stored in the 31th
		// position in the memory)
		// into the PC.
		// The original PC position was 30. The parameter is in position 31. So, now PC
		// must be pointing to 32
		arch.jn();
		// PC contains the number 32
		arch.getPC().internalRead();
		assertEquals(32, arch.getIntbus2().get());
	}

	@Test
	public void testRead() {
		Architecture arch = new Architecture();
		// storing the number 10 in RPG
		arch.getIntbus1().put(10);
		arch.getRPG().internalStore();
		// testing if RPG stores the number 10
		arch.getRPG().read();
		assertEquals(10, arch.getExtbus1().get());

		// storing the number 25 in the memory, in position 31
		arch.getExtbus1().put(31);
		arch.getMemory().store();
		arch.getExtbus1().put(25);
		arch.getMemory().store();

		// storing the number -100 in the memory, in position 25
		arch.getExtbus1().put(25);
		arch.getMemory().store();
		arch.getExtbus1().put(-100);
		arch.getMemory().store();

		// PC must be pointing to the address just before the parameter (where is the
		// instruction)
		arch.getExtbus1().put(30);
		arch.getPC().store();

		// now we can perform the read method.
		// scenery PC=30, mem[31]=25, mem[25]=-100 RPG=10
		// we will move the the number 25 (stored in the 31th position in the memory)
		// into the RPG by using the move command (move 31)

		arch.read();
		arch.getRPG().internalRead();
		// the internalbus1 must contain the number -100 (that is stored in position 25)
		assertEquals(-100, arch.getRPG().getData());

		// PC must be pointing two positions after its original value
		arch.getPC().read();
		assertEquals(32, arch.getExtbus1().get());

	}

	@Test
	public void testStore() {
		Architecture arch = new Architecture();

		// storing the number 25 in the memory, in position 31
		arch.getMemory().getDataList()[31] = 25;

		// now we can perform the store method.
		// store X stores, in the position X, the data that is currently in RPG

		// let's put PC pointing to the position 11
		arch.getExtbus1().put(11);
		arch.getPC().store();
		// now lets put the parameter (the position where the data will be stored) into
		// the position next to PC
		arch.getMemory().getDataList()[12] = 31;

		// storing the number 155 in RPG
		arch.getIntbus1().put(155);
		arch.getRPG().internalStore();

		// testing if memory contains the number 25 in the 31th position
		arch.getExtbus1().put(31);
		arch.getMemory().read();
		assertEquals(25, arch.getExtbus1().get());

		// So, PC is pointing to memory[11], memory[12] has 31, memory [31] has 25 and
		// RPG has 155

		// destroying data in externalbus 1
		arch.getExtbus1().put(0);

		arch.store();

		// now, memory[31] must be updated from 25 to 155
		assertEquals(155, arch.getMemory().getDataList()[31]);

		// PC must be pointing two positions after its original value
		arch.getPC().read();
		assertEquals(13, arch.getExtbus1().get());

	}

	@Test
	public void testLdi() {
		Architecture arch = new Architecture();
		// storing the number 10 in RPG
		arch.getIntbus1().put(10);
		arch.getRPG().internalStore();

		// the scenery: PC points to 50, mem[51] (parameter) is -40

		arch.getExtbus1().put(51);
		arch.getMemory().store();
		arch.getExtbus1().put(-40);
		arch.getMemory().store();

		arch.getExtbus1().put(50);
		arch.getPC().store();

		// destroying data in internalbus 1
		arch.getIntbus1().put(0);

		// now we can perform the ldi method.
		// we will move the the number -40 (immediate value)
		// into the rpg
		arch.ldi();

		arch.getRPG().read();
		// the externalbus1 must contains the number 44
		assertEquals(-40, arch.getExtbus1().get());

		// PC must be pointing two positions after its original value
		arch.getPC().read();
		assertEquals(52, arch.getExtbus1().get());

	}

	@Test
	public void testInc() {
		Architecture arch = new Architecture();
		// storing the number 10 in RPG
		arch.getExtbus1().put(10);
		arch.getRPG().store();
		// testing if RPG stores the number 10
		arch.getRPG().read();
		assertEquals(10, arch.getExtbus1().get());

		// destroying data in externalbus 1
		arch.getExtbus1().put(0);

		// pc points to 50 (where we suppose the instruction is
		arch.getExtbus1().put(50);
		arch.getPC().store();

		// now we can perform the inc method.
		arch.inc();
		arch.getRPG().read();
		// the externalbus1 must contains the number 11
		assertEquals(11, arch.getExtbus1().get());

		// PC must be pointing ONE position after its original value, because this
		// command has no parameters!
		arch.getPC().read();
		assertEquals(51, arch.getExtbus1().get());

	}

	@Test // Pode servir para a minha ARQUITETURA
	public void testMoveRegReg_() {
		Architecture arch = new Architecture();

		// storing the number 1 in the memory, in position 31
		arch.getMemory().getDataList()[31] = 1;
		// storing the number 0 in the memory, in position 32
		arch.getMemory().getDataList()[32] = 0;
		// making PC points to position 30
		arch.getExtbus1().put(30);
		arch.getPC().store();

		// now setting the registers values
		arch.getExtbus1().put(45);
		arch.getRegistersList().get(0).store(); // RPG0 has 45
		arch.getExtbus1().put(99);
		arch.getRegistersList().get(1).store(); // RPG1 has 99

		// executing the command move REG1 REG0.
		arch.moveRegReg();

		// testing if both REG1 and REG0 store the same value: 99
		arch.getRegistersList().get(0).read();
		assertEquals(99, arch.getExtbus1().get());
		arch.getRegistersList().get(1).read();
		assertEquals(99, arch.getExtbus1().get());

		// Testing if PC points to 3 positions after the original
		// PC was pointing to 30; now it must be pointing to 33
		arch.getPC().read();
		assertEquals(33, arch.getExtbus1().get());
	}

	@Test
	public void testFillCommandsList() {

		// all the instructions must be in Commands List
		/*
		 *
		 * add addr (rpg <- rpg + addr)
		 * sub addr (rpg <- rpg - addr)
		 * jmp addr (pc <- addr)
		 * jz addr (se bitZero pc <- addr)
		 * jn addr (se bitneg pc <- addr)
		 * read addr (rpg <- addr)
		 * store addr (addr <- rpg)
		 * ldi x (rpg <- x. x must be an integer)
		 * inc (rpg++)
		 */

		// Este teste foi alterado para a nossa arquitetura, mas faltam outros assert's.
		Architecture arch = new Architecture();
		ArrayList<String> commands = arch.getCommandsList();
		assertTrue("addRegReg".equals(commands.get(0)));
		assertTrue("addMemReg".equals(commands.get(1)));
		assertTrue("addRegMem".equals(commands.get(2)));
		assertTrue("subRegReg".equals(commands.get(3)));
		assertTrue("subMemReg".equals(commands.get(4)));
		assertTrue("subRegMem".equals(commands.get(5)));
		assertTrue("imulMemReg".equals(commands.get(6)));
		assertTrue("imulRegMem".equals(commands.get(7)));
		assertTrue("imulRegReg".equals(commands.get(8)));
	}

	@Test
	public void testReadExec() throws IOException {
		Architecture arch = new Architecture();
		arch.readExec("testFile");
		assertEquals(5, arch.getMemory().getDataList()[0]);
		assertEquals(4, arch.getMemory().getDataList()[1]);
		assertEquals(3, arch.getMemory().getDataList()[2]);
		assertEquals(2, arch.getMemory().getDataList()[3]);
		assertEquals(1, arch.getMemory().getDataList()[4]);
		assertEquals(0, arch.getMemory().getDataList()[5]);
	}

}
