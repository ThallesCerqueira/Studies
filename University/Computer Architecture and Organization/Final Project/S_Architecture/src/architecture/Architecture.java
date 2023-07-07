package architecture;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


import components.Bus;
import components.Memory;
import components.Register;
import components.Ula;

public class Architecture {
	
	private boolean simulation=false; //this boolean indicates if the execution is done in simulation mode.
								//simulation mode shows the components' status after each instruction
	
	
	private boolean halt;
	private Bus extbus1;
	private Bus intbus1;
	private Bus intbus2;
	private Memory memory;
	private int memorySize;
	private Register PC;
	private Register IR;
	private Register RPG;
	private Register RPG1;
	private Register RPG2;
	private Register RPG3;
	private Register Flags;
	private Ula ula;
	private Bus demux; //only for multiple register purposes
	
	private ArrayList<String> commandsList;
	private ArrayList<Register> registersList;
	
	
	


	/**
	 * Instanciates all components in this architecture
	 */

	private void componentsInstances() {
		//don't forget the instantiation order
		//buses -> registers -> ula -> memory
		extbus1 = new Bus();
		intbus1 = new Bus();
		intbus2 = new Bus();
		PC = new Register("PC", extbus1, intbus2);
		IR = new Register("IR", extbus1, intbus2);
		RPG = new Register("RPG0", extbus1, intbus1);
		RPG1 = new Register ("RPG1", extbus1, intbus1);
		RPG2 = new Register("RPG2", extbus1, intbus1);
		RPG3 = new Register ("RPG3", extbus1, intbus1);
		Flags = new Register(2, intbus2);
		fillRegistersList();
		ula = new Ula(intbus1, intbus2);
		memorySize = 128;
		memory = new Memory(memorySize, extbus1);
		demux = new Bus(); //this bus is used only for multiple register operations
		
		fillCommandsList();
		setImulLoopCommands();
	}

	/**
	 * This method fills the registers list inserting into them all the registers we have.
	 * IMPORTANT!
	 * The first register to be inserted must be the default RPG
	 */
	private void fillRegistersList() {
		registersList = new ArrayList<Register>();
		registersList.add(RPG);
		registersList.add(RPG1);
		registersList.add(RPG2);
		registersList.add(RPG3);
		registersList.add(PC);
		registersList.add(IR);
		registersList.add(Flags);
	}

	/**
	 * Constructor that instanciates all components according the architecture diagram
	 */
	public Architecture() {
		componentsInstances();
		
		//by default, the execution method is never simulation mode
		simulation = false;
	}

	
	public Architecture(boolean sim) {
		componentsInstances();
		
		//in this constructor we can set the simoualtion mode on or off
		simulation = sim;
	}



	//getters
	
	protected Bus getExtbus1() {
		return extbus1;
	}

	protected Bus getIntbus1() {
		return intbus1;
	}

	protected Bus getIntbus2() {
		return intbus2;
	}

	protected Memory getMemory() {
		return memory;
	}

	protected Register getPC() {
		return PC;
	}

	protected Register getIR() {
		return IR;
	}
	protected Register getRPG() {
		return RPG;
	}
	protected Register getRPG0() {
		return RPG;
	}
	protected Register getRPG1() {
		return RPG1;
	}
	protected Register getRPG2() {
		return RPG2;
	}
	protected Register getRPG3() {
		return RPG3;
	}
	protected Register getFlags() {
		return Flags;
	}

	protected Ula getUla() {
		return ula;
	}

	public ArrayList<String> getCommandsList() {
		return commandsList;
	}



	//all the microprograms must be impemented here
	//the instructions table is
	/*
	 *
			add addr (rpg <- rpg + addr)
			sub addr (rpg <- rpg - addr)
			jmp addr (pc <- addr)
			jz addr  (se bitZero pc <- addr)
			jn addr  (se bitneg pc <- addr)
			read addr (rpg <- addr)
			store addr  (addr <- rpg)
			ldi x    (rpg <- x. x must be an integer)
			inc    (rpg++)
			move regA regB (regA <- regB)
	 */
	
	/**
	 * This method fills the commands list arraylist with all commands used in this architecture
	 */
	protected void fillCommandsList() {
		commandsList = new ArrayList<String>();
		commandsList.add("addRegReg");//0
		commandsList.add("addMemReg");//1    
		commandsList.add("addRegMem");//2
		

		commandsList.add("subRegReg");//3
		commandsList.add("subMemReg");//4
		commandsList.add("subRegMem");//5
		
		commandsList.add("imulMemReg");//6
		commandsList.add("imulRegMem");//7
		commandsList.add("imulRegReg");//8

		commandsList.add("moveMemReg");//9
		commandsList.add("moveRegMem");//10
		commandsList.add("moveRegReg");//11
		commandsList.add("moveImmReg");//12

		commandsList.add("incReg");//13
		commandsList.add("incMem"); //14

		commandsList.add("jmpMem");//15 
		commandsList.add("jnMem");//16
		commandsList.add("jzMem");//17
		commandsList.add("jnzMem");//18

		commandsList.add("jeqRegReg");//19 
		commandsList.add("jgtRegReg"); //20
		commandsList.add("jlwRegReg"); //21
		commandsList.add("ldiImmReg");//22
		commandsList.add("addImmReg");//23
		commandsList.add("moveMemMemREsp");//24
		commandsList.add("moveMemMemMEsp");//25
		commandsList.add("subImmReg");//26
	}

	private void setImulLoopCommands() {
				memory.getDataList()[77] = 26;  //<tratamento_rpg3_negativo> inverte o sinal de RPG3
				memory.getDataList()[78] = 0;
				memory.getDataList()[79] = 3;
				memory.getDataList()[80] = 26;
				memory.getDataList()[81] = 0;
				memory.getDataList()[82] = 2;
				memory.getDataList()[83] = 26;
				memory.getDataList()[84] = 0;
				memory.getDataList()[85] = 1;
				memory.getDataList()[86] = 15;
				memory.getDataList()[87] = 92 ;  //<inicio da execução>
				memory.getDataList()[88] = 21  ; //onde tudo deve começar PC DESVIADO PARA AQUI
				memory.getDataList()[89] = 3;
				memory.getDataList()[90] = 0;
				memory.getDataList()[91] = 77;   //<tratamento_rpg3_negativo>
				memory.getDataList()[92] = 23 ;  //<inicio da execução>
				memory.getDataList()[93] = -1;
				memory.getDataList()[94] = 3;
				memory.getDataList()[95] = 19;
				memory.getDataList()[96] = 3;
				memory.getDataList()[97] = 0;
				memory.getDataList()[98] = 107;   //<desvio para dps do loop>
				memory.getDataList()[99] = 0;   // inicio do loop
				memory.getDataList()[100] = 2;
				memory.getDataList()[101] = 1;
				memory.getDataList()[102] = 23;
				memory.getDataList()[103] = -1;
				memory.getDataList()[104] = 3;
				memory.getDataList()[105] = 18;
				memory.getDataList()[106] = 99 ; //"desvia pro inicio do loop"
				memory.getDataList()[107] = 10  ; //<depois do loop>
				memory.getDataList()[108] = 1;
				memory.getDataList()[109] = 76;   //<resultado>
				memory.getDataList()[110] = 9;
				memory.getDataList()[111] = 70;   //<valorantigoRPG0>
				memory.getDataList()[112] = 0;
				memory.getDataList()[113] = 9;
				memory.getDataList()[114] = 71;   //<valorantigoRPG1>
				memory.getDataList()[115] = 1;
				memory.getDataList()[116] = 9;
				memory.getDataList()[117] = 72;   //<valorantigoRPG2>
				memory.getDataList()[118] = 2;
				memory.getDataList()[119] = 9;
				memory.getDataList()[120] = 73;   //<valorantigoRPG3>
				memory.getDataList()[121] = 3;
				memory.getDataList()[122] = 24;
				memory.getDataList()[123] = 76 ;  //<resultado>
				memory.getDataList()[124] = 75  ; //<ID_registrador_resultado>
				memory.getDataList()[125] = 9;
				memory.getDataList()[126] = 74;   //<valorantigoPC>
				memory.getDataList()[127] = 4;

	}
	
	/**
	 * This method is used after some ULA operations, setting the flags bits according the result.
	 * @param result is the result of the operation
	 * NOT TESTED!!!!!!!
	 */
	private void setStatusFlags(int result) {
		Flags.setBit(0, 0);
		Flags.setBit(1, 0);
		if (result==0) { //bit 0 in flags must be 1 in this case
			Flags.setBit(0,1);
		}
		if (result<0) { //bit 1 in flags must be 1 in this case
			Flags.setBit(1,1);
		}
	}

	/**
	 * This method implements the microprogram for
	 * 					ADD address
	 * In the machine language this command number is 0, and the address is in the position next to him
	 *    
	 * where address is a valid position in this memory architecture
	 * The method reads the value from memory (position address) and 
	 * performs an add with this value and that one stored in the RPG (the first register in the register list).
	 * The final result must be in RPG (the first register in the register list).
	 * The logic is
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the parameter
	 * 6. rpg -> intbus1 //rpg.read() the current rpg value must go to the ula 
	 * 7. ula <- intbus1 //ula.store()
	 * 8. pc -> extbus (pc.read())
	 * 9. memory reads from extbus //this forces memory to write the data position in the extbus
	 * 10. memory reads from extbus //this forces memory to write the data value in the extbus
	 * 11. rpg <- extbus (rpg.store())
	 * 12. rpg -> intbus1 (rpg.read())
	 * 13. ula  <- intbus1 //ula.store()
	 * 14. Flags <- zero //the status flags are reset
	 * 15. ula adds
	 * 16. ula -> intbus1 //ula.read()
	 * 17. ChangeFlags //informations about flags are set according the result 
	 * 18. rpg <- intbus1 //rpg.store() - the add is complete.
	 * 19. pc -> intbus2 //pc.read() now pc must point the next instruction address
	 * 20. ula <- intbus2 //ula.store()
	 * 21. ula incs
	 * 22. ula -> intbus2 //ula.read()
	 * 23. pc <- intbus2 //pc.store() 
	 * end
	 * @param address
	 */
	/*
	 * RegB <- RegA - RegB
	 */

	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void subRegReg() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //Aponta para o Reg1
		
		//Joga o ID do Reg da memória e faz cospe esse no barramento interno
		//para armazenar na ULA
		PC.read();
		memory.read();
		demux.put(this.extbus1.get());
		registersInternalRead();
		this.ula.store(0);
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //Aponta para o ID de Reg 2 na memória
		
		PC.read();
		memory.read();
		demux.put(this.extbus1.get());
		registersInternalRead();
		this.ula.store(1);
		
		//Subtrai
		this.ula.sub();
		//Cospe o resultado no barramento externo da ULA
		this.ula.read(1);
		setStatusFlags(this.intbus1.get()); // Mudando a flag devido ao fim da operação
		//Demux já está setado com o ID do Reg2 que estava no extbus1
		// só salvar no registrador previamente selecionado no demux
		demux.put(this.extbus1.get());
		registersInternalStore();
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //PC aponta para a próxima instrução
	}
	public void subImmReg() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //Aponta para o Reg1
		
		//Joga o ID do Reg da memória e faz cospe esse no barramento interno
		//para armazenar na ULA
		PC.read();
		memory.read();
		IR.store();
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //Aponta para o ID de Reg 2 na memória
		
		PC.read();
		memory.read();
		demux.put(this.extbus1.get());
		
		//Seta o Imm na posição 0 da ula
		IR.internalRead();
		ula.internalStore(0);
		//Seta o Reg na posição 1 da ula
		registersInternalRead();
		ula.store(1);
		
		//Subtrai
		this.ula.sub();
		//Cospe o resultado no barramento externo da ULA
		this.ula.read(1);
		setStatusFlags(this.intbus1.get()); // Mudando a flag devido ao fim da operação
		//Demux já está setado com o ID do Reg2 que estava no extbus1
		// só salvar no registrador previamente selecionado no demux
		registersInternalStore();
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //PC aponta para a próxima instrução
	}
	public void subMemReg() {
		// sub <mem> %<regA>      ||  RegA <- memória[mem] - RegA
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //PC aponta para <mem>
		
		PC.read();
		memory.read();
		memory.read(); // Coloca o dado de fato no extbus1
		//extbus1 = memoria[mem]
		// O valor desse dado será destruido se for pegar a proxima instrução(Pc->extbus1)
		// Se for utilizado Reg para poder passar para a ULA poderá perder o dado que
		// será operado
		//Solução: Usar o registrador IR para esse pivo até a ULA	
		IR.store();
		IR.internalRead();
		ula.internalStore(0);
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //PC aponta para %<reg>
		
		PC.read();
		memory.read();
		demux.put(extbus1.get());
		registersInternalRead();
		ula.store(1);
		
		ula.sub();
		ula.read(1);
		setStatusFlags(intbus1.get());
		registersInternalStore();
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
		
	}
	
	public void subRegMem() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // Aponta para %<reg>
		
		PC.read();
		memory.read();
		demux.put(extbus1.get());
		registersInternalRead();
		ula.store(0);
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // Aponta para mem
		
		PC.read();
		memory.read();
		//Armazena o endereço de <mem> no registrador a ser utilizado 
		//cujo valor já está na ULA
		registersStore();
		memory.read();
		IR.store();
		IR.internalRead();
		ula.internalStore(1);
		
		//Seta a memoria para store no endereço que ficou em %<reg>
		registersRead();
		memory.store();
		//Volta o valor original de %<reg> temporariamente usado para armazenar <mem>
		ula.read(0);
		registersInternalStore();
		
		//Efetua a operação e devolve o dado por IR e armazena na memoria ja em stand-by
		ula.sub();
		ula.internalRead(1);
		setStatusFlags(intbus2.get());
		IR.internalStore();
		IR.read();
		memory.store();
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
		
		
	}

	

	public void imulRegReg() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // PC aponta para regA
		
		//Primeiro, salvar o conteúdo dos registradores na memória
		memory.getDataList()[70] = RPG.getData();
		demux.put(0);
		extbus1.put(0);
		registersStore();
		memory.getDataList()[71] = RPG1.getData();
		memory.getDataList()[72] = RPG2.getData();
		memory.getDataList()[73] = RPG3.getData();
		
		//Alterando o comando move para salvar dado em registrador
		memory.getDataList()[122]=24;
		
		
		//Segundo, setar os registradores a serem operados pelo código de loop
			PC.read();
			memory.read();
			demux.put(extbus1.get());
			registersRead();
			IR.store();
			
		//Terceiro, seta o RPG3 com o valor do ultimo %reg lido	
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
			
			PC.read();
			memory.read();
			memory.getDataList()[75] = extbus1.get(); //Salva o ID do registrador a ser salvo
			demux.put(extbus1.get());
			registersRead();
			
			demux.put(1);
			registersStore();
			demux.put(2);
			registersStore();
			demux.put(3);
			IR.read();
			registersStore();
		
		/*
		 * O PC tem que ser salvo aqui porque quando é restaurado seu valor através do move,
		 * há um incremento do próprio move	
		 */
		memory.getDataList()[74] = PC.getData();	
			
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
			
		
		extbus1.put(88);
		PC.store();
		
	}

	public void imulRegMem() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // PC aponta para regA
		
		//Primeiro, salvar o conteúdo dos registradores na memória
		memory.getDataList()[70] = RPG.getData();
		demux.put(0);
		extbus1.put(1);
		registersStore();
		memory.getDataList()[71] = RPG1.getData();
		memory.getDataList()[72] = RPG2.getData();
		memory.getDataList()[73] = RPG3.getData();
		
		//Alterando o comando move para salvar dado em memória
		memory.getDataList()[122]=25;
		
		
		//Segundo, setar os registradores a serem operados pelo código de loop
			PC.read();
			memory.read();
			demux.put(extbus1.get());
			registersRead();
			IR.store();
			
		//Terceiro, seta o RPG3 com o valor do ultimo %reg lido	
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
			
			PC.read();
			memory.read();
			
			memory.getDataList()[75] = extbus1.get(); //Salva o ID do registrador a ser salvo ou endereço de memória
			memory.read();//cospe o dado no barramento
			
			demux.put(1);
			registersStore();
			demux.put(2);
			registersStore();
			demux.put(3);
			IR.read();
			registersStore();
		
		/*
		 * O PC tem que ser salvo aqui porque quando é restaurado seu valor através do move,
		 * há um incremento do próprio move	
		 */
		memory.getDataList()[74] = PC.getData();	
			
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
			
		
		extbus1.put(88);
		PC.store();
		
	}

	public void imulMemReg() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // PC aponta para regA
		
		//Primeiro, salvar o conteúdo dos registradores na memória
		memory.getDataList()[70] = RPG.getData();
		demux.put(0);
		extbus1.put(1);
		registersStore();
		memory.getDataList()[71] = RPG1.getData();
		memory.getDataList()[72] = RPG2.getData();
		memory.getDataList()[73] = RPG3.getData();
		
		//Alterando o comando move para salvar dado em registrador
		memory.getDataList()[122]=24;

		//Segundo, setar os registradores a serem operados pelo código de loop
			PC.read();
			memory.read();
			memory.read();
			IR.store();
			
		//Terceiro, seta o RPG3 com o valor do ultimo %reg lido	
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
			
			PC.read();
			memory.read();
			memory.getDataList()[75] = extbus1.get(); //Salva o ID do registrador a ser salvo
			demux.put(extbus1.get());
			registersRead();
			
			demux.put(1);
			registersStore();
			demux.put(2);
			registersStore();
			demux.put(3);
			IR.read();
			registersStore();
		
		/*
		 * O PC tem que ser salvo aqui porque quando é restaurado seu valor através do move,
		 * há um incremento do próprio move	
		 */
		memory.getDataList()[74] = PC.getData();	
			
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
			
		
		extbus1.put(88);
		PC.store();
		
	}
	
	public void moveMemMemREsp() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Pegando pegando o dado do registrador e guardando em IR
		PC.read();
		memory.read();
		memory.read();
		IR.store();

		// Fazendo PC apontar para o próximo endereço de memória indireto
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Pegando da memória o endereço do Reg e jogando o dado de IR no registrador
		PC.read();
		memory.read();
		memory.read(); 
		demux.put(extbus1.get());

		// Jogando o dado de IR no barramento e o outro reg consumindo
		IR.read();
		registersStore();

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

	}
	public void moveMemMemMEsp() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Pegando pegando o dado do registrador e guardando em IR
		PC.read();
		memory.read();
		memory.read();
		IR.store();

		// Fazendo PC apontar para o próximo endereço de memória indireto
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Pegando da memória o endereço do Reg e jogando o dado de IR no registrador
		PC.read();
		memory.read();
		memory.read(); 
		memory.store();

		// Jogando o dado de IR no barramento e o outro reg consumindo
		IR.read();
		memory.store();

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

	}
	public void moveMemReg() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); 

		// Memória joga o conteúdo da posição X no barramento.
		PC.read();
		memory.read();
		memory.read();

		// Guardando o conteúdo da Memória em IR
		IR.store();

		// Fazendo PC apontar para o endereço de memória que está o Reg.
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazendo a memória colocar no barramento o endereço do Reg
		PC.read();
		memory.read();

		// Fazendo a seleção do Reg e guardando nele.
		demux.put( extbus1.get() ); 
		IR.read();
		registersStore();

		// Fazer PC apontar para a próxima instrução
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

	}

	public void moveRegMem() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer a memória colocar na barramento qual registrador deve mandar o dado.
		PC.read();
		memory.read();

		// Jogando o dado do registrador no barramento.
		demux.put( extbus1.get() );
		registersRead();
		
		// Guardando o dado no IR.
		IR.store();

		// Fazer PC apontar para o endereço indireto em que devemos armazenar o dado.
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer a memória colocar no barramento o endereço que devemos armazenar o dado.
		PC.read();
		memory.read();

		// Colocar na posição X o dado que está agora no barramento.
		memory.store();
		IR.read();
		memory.store();

		// Fazer PC apontar para a próxima instrução.
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

	}

	public void moveRegReg() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer a memória colocar na barramento qual registrador deve mandar o dado.
		PC.read();
		memory.read();

		// Jogando o dado do registrador no barramento e guardando em IR.
		demux.put( extbus1.get() );
		registersRead();
		IR.store();

		// Fazer PC apontar para o endereço do registrador que vai receber o dado.
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		/// Fazendo a memória colocar no barramento qual registrador deve receber o dado.
		PC.read();
		memory.read();

		// Colocando o dado no registrador.
		demux.put( extbus1.get() );
		IR.read();
		registersStore();

		// Fazendo PC apontar para a próxima instrução.
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

	}

	public void moveImmReg() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer a memória colocar no barramento o dado que é para ser colocado no registrador.
		PC.read();
		memory.read();

		// Armazenar o dado no IR
		IR.store();

		// Fazer PC apontar para o endereço do Registrador.
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer a memória devolver o Registrador para armazenar o dado
		PC.read();
		memory.read();

		// Habilitar o registrador para receber o dado
		demux.put( extbus1.get() );

		// Colocando o dado no barramento e consumindo a partir do Registrador.
		IR.read();
		registersStore();

		// Fazendo PC apontar para a próxima instrução.
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

	}

	public void jeqRegReg() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer demux jogar o dado do RegA no barramento e guardar na ula(0).
		PC.read();
		memory.read();
		demux.put( extbus1.get() );
		registersInternalRead();
		ula.store(0);

		// Fazer PC apontar para o próximo Registrador
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer demux jogar o dado do RegB no barramento e guardar na ula(1).
		PC.read();
		memory.read();
		demux.put( extbus1.get() );
		registersInternalRead();
		ula.store(1);

		// Subtraindo e settando o status Flag
		ula.sub();
		ula.internalRead(1);
		setStatusFlags( intbus2.get() );

		if( Flags.getBit(0) == 1 ) {

			// Fazer a memória devolver o endereço que deve estar em PC e PC apontar para ela.
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();

			PC.read();
			memory.read();
			PC.store();
			
		}else {
			// Fazer PC apontar para a próxima instrução
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
		}

	}

	public void jgtRegReg() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer demux jogar o dado do RegA no barramento e guardar na ula(0).
		PC.read();
		memory.read();
		demux.put( extbus1.get() );
		registersInternalRead();
		ula.store(0);

		// Fazer PC apontar para o próximo Registrador
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer demux jogar o dado do RegB no barramento e guardar na ula(1).
		PC.read();
		memory.read();
		demux.put( extbus1.get() );
		registersInternalRead();
		ula.store(1);

		// Subtraindo e settando o status Flag
		ula.sub();
		ula.internalRead(1);
		setStatusFlags( intbus2.get() );

		if( Flags.getBit(0) == 0 && Flags.getBit(1) == 0 ) {

			// Fazer a memória devolver o endereço que deve estar em PC e PC apontar para ela.
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
			PC.read();
			memory.read();
			PC.store();
				
		}else {
			// Fazer PC apontar para a próxima instrução
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
		}

	}

	public void jlwRegReg() {

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer demux jogar o dado do RegA no barramento e guardar na ula(0)
		PC.read();
		memory.read();
		demux.put( extbus1.get() );
		registersInternalRead();
		ula.store(0);

		// Fazer PC apontar para o próximo Registrador
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Fazer demux jogar o dado do RegB no barramento e guardar na ula(1).
		PC.read();
		memory.read();
		demux.put( extbus1.get() );
		registersInternalRead();
		ula.store(1);

		// Subtraindo e settando o status Flag
		ula.sub();
		ula.internalRead(1);
		setStatusFlags( intbus2.get() );

		if( Flags.getBit(1) == 1 ) {

			// Fazer a memória devolver o endereço que deve estar em PC e PC apontar para ela.
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
			PC.read();
			memory.read();
			PC.store();
			
		}else {
			// Fazer PC apontar para a próxima instrução
			PC.internalRead();
			ula.internalStore(1);
			ula.inc();
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
		}

	}

	public void addRegReg() {
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // now PC points to the parameter address
		
		PC.read();
		memory.read();
		
		demux.put(extbus1.get());
		registersInternalRead();
		ula.store(0);
		
		PC.internalRead(); // we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
		
		PC.read();
		memory.read();
		
		demux.put(extbus1.get());
		registersInternalRead();
		ula.store(1);
		ula.add();
		ula.read(1);		
		setStatusFlags(intbus1.get());
		registersInternalStore();
		
		PC.internalRead(); // we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
		
	}
	
	public void addImmReg() {
		
		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Pegando valor do immediante na memória e guardando em IR
		PC.read();
		memory.read();
		IR.store();

		// Fazendo pc apontar para próximo endereço, o do Reg
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		// Pegando o endereco do Reg e colocando na Ula
		PC.read();
		memory.read();
		demux.put( extbus1.get() );
		registersInternalRead();
		ula.store(1);

		// Jogando o dado de IR na ula e fazendo a soma
		IR.internalRead();
		ula.internalStore(0);
		ula.add();
		ula.read(1);
		setStatusFlags(intbus1.get());
		registersInternalStore();

		// PC++
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

	}

	public void addRegMem() {

		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // now PC points to the parameter address

		PC.read();
		memory.read();
		memory.read();
		IR.store();
		IR.internalRead();
		ula.internalStore(0);

		PC.internalRead(); // we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		PC.read();
		memory.read();

		demux.put(extbus1.get());
		registersInternalRead();
		ula.store(1);
		ula.add();
		ula.internalRead(1);
		setStatusFlags(intbus2.get());
	

		
		IR.internalStore();
		IR.read();
		memory.store();
		memory.store();

		PC.internalRead(); // we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // now PC points to the next instruction. We go back to the FETCH status.

	}
	
	public void incReg() {

		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // now PC points to the parameter address
		
		PC.read();
		memory.read();

		demux.put(extbus1.get());
		registersInternalRead();
		ula.store(1);
		ula.inc();
		ula.read(1);
		setStatusFlags(intbus1.get());
		registersInternalStore();

		PC.internalRead(); // we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); 
		
	}
	
	public void incMem() {
	
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // now PC points to the parameter address
		
		PC.read();
		memory.read();
		memory.read();
		IR.store();
		IR.internalRead();
		ula.internalStore(1);
		ula.inc();
		
		ula.internalRead(1);
		setStatusFlags(intbus2.get());
		
		IR.internalStore();
		IR.read();
		memory.store();
		memory.store();
		

		PC.internalRead(); // we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // now PC points to the next instruction. We go back to the FETCH status.
		
	}

	public void addMemReg() {

		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // now PC points to the parameter address

		PC.read();
		memory.read();
		memory.read();
		IR.store();
		IR.internalRead();
		ula.internalStore(0);

		PC.internalRead(); // we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();

		PC.read();
		memory.read();

		demux.put(extbus1.get());
		registersInternalRead();
		ula.store(1);
		ula.add();
		ula.read(1);
		setStatusFlags(intbus1.get());
		registersInternalStore();

		PC.internalRead(); // we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); // now PC points to the next instruction. We go back to the FETCH status.

	}
	
	public void jmpMem() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		
		PC.read();
		memory.read();
		PC.store();
		
	}

	public void jnMem() {

		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
		//Flags.setBit(1, 1); // PARA TESTE
		if(Flags.getBit(1) == 1) {
			PC.read();
			memory.read();
			PC.store();
		}
		else {
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
		}
		
		
	}

	public void jzMem() {

		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
		//Flags.setBit(0, 1); // PARA TESTE
		if(Flags.getBit(0) == 1 ) {
			PC.read();
			memory.read();
			PC.store();
		}
		else {
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
		}
		
		
	}

	public void jnzMem() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
		//Flags.setBit(0, 1); // PARA TESTE
		if(Flags.getBit(0)==0) {
			PC.read();
			memory.read();
			PC.store();
		}
		else {
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
		}
		
		
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void add() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		RPG.internalRead();
		ula.store(0); //the rpg value is in ULA (0). This is the first parameter
		PC.read(); 
		memory.read(); // the parameter is now in the external bus. 
						//but the parameter is an address and we need the value
		memory.read(); //now the value is in the external bus
		RPG.store();
		RPG.internalRead();
		ula.store(1); //the rpg value is in ULA (0). This is the second parameter 
		ula.add(); //the result is in the second ula's internal register
		ula.internalRead(1);; //the operation result is in the internalbus 2
		setStatusFlags(intbus2.get()); //changing flags due the end of the operation
		RPG.internalStore(); //now the add is complete
		PC.internalRead(); //we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the next instruction. We go back to the FETCH status.
	}
	

	/**
	 * This method implements the microprogram for
	 * 					SUB address
	 * In the machine language this command number is 1, and the address is in the position next to him
	 *    
	 * where address is a valid position in this memory architecture
	 * The method reads the value from memory (position address) and 
	 * performs an SUB with this value and that one stored in the rpg (the first register in the register list).
	 * The final result must be in RPG (the first register in the register list).
	 * The logic is
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the parameter
	 * 6. rpg -> intbus1 //rpg.read() the current rpg value must go to the ula 
	 * 7. ula <- intbus1 //ula.store()
	 * 8. pc -> extbus (pc.read())
	 * 9. memory reads from extbus //this forces memory to write the data position in the extbus
	 * 10. memory reads from extbus //this forces memory to write the data value in the extbus
	 * 11. rpg <- extbus (rpg.store())
	 * 12. rpg -> intbus1 (rpg.read())
	 * 13. ula  <- intbus1 //ula.store()
	 * 14. Flags <- zero //the status flags are reset
	 * 15. ula subs
	 * 16. ula -> intbus1 //ula.read()
	 * 17. ChangeFlags //informations about flags are set according the result 
	 * 18. rpg <- intbus1 //rpg.store() - the add is complete.
	 * 19. pc -> intbus2 //pc.read() now pc must point the next instruction address
	 * 20. ula <- intbus2 //ula.store()
	 * 21. ula incs
	 * 22. ula -> intbus2 //ula.read()
	 * 23. pc <- intbus2 //pc.store() 
	 * end
	 * @param address
	 */
	public void sub() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		
		PC.read();
		demux.put(this.extbus1.get());
		registersInternalRead();
		
		ula.store(0); //the rpg value is in ULA (0). This is the first parameter
		PC.read(); 
		memory.read(); // the parameter is now in the external bus. 
						//but the parameter is an address and we need the value
		memory.read(); //now the value is in the external bus
		RPG.store();
		RPG.internalRead();
		ula.store(1); //the rpg value is in ULA (0). This is the second parameter
		ula.sub(); //the result is in the second ula's internal register
		ula.internalRead(1);; //the operation result is in the internalbus 2
		setStatusFlags(intbus2.get()); //changing flags due the end of the operation
		RPG.internalStore(); //now the sub is complete
		PC.internalRead(); //we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the next instruction. We go back to the FETCH status.
	}
	
	/**
	 * This method implements the microprogram for
	 * 					JMP address
	 * In the machine language this command number is 2, and the address is in the position next to him
	 *    
	 * where address is a valid position in this memory architecture (where the PC is redirecto to)
	 * The method reads the value from memory (position address) and 
	 * inserts it into the PC register.
	 * So, the program is deviated
	 * The logic is
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the parameter
	 * 6. pc -> extbus //pc.read()
	 * 7. memory reads from extbus //this forces memory to write the data position in the extbus
	 * 8. pc <- extbus //pc.store() //pc was pointing to another part of the memory
	 * end
	 * @param address
	 */
	public void jmp() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		PC.read();
		memory.read();
		PC.store();
	}
	
	/**
	 * This method implements the microprogram for
	 * 					JZ address
	 * In the machine language this command number is 3, and the address is in the position next to him
	 *    
	 * where address is a valid position in this memory architecture (where 
	 * the PC is redirected to, but only in the case the ZERO bit in Flags is 1)
	 * The method reads the value from memory (position address) and 
	 * inserts it into the PC register if the ZERO bit in Flags register is setted.
	 * So, the program is deviated conditionally
	 * The logic is
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the parameter
	 * 6. If FLAGS.bit0 is 1 (bit 0 is ZERO flag) then PC must be updated according the parameter
	 * 7. 	pc -> extbus //pc.read()
	 * 8. 	memory reads from extbus //this forces memory to write the data position in the extbus
	 * 9. 	pc <- extbus //pc.store() //pc was pointing to another part of the memory
	 * 10.ELSE //Flags.Bit0 is not 0. So, PC must be incremented to the next position
	 * 11.  ula incs //the position just after PC
	 * 12.  ula -> intbus2 //uma.read()
	 * 13.  pc <- intbus2 
	 * end
	 * @param address
	 */
	public void jz() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		if (Flags.getBit(0)==1) { 
			PC.read();
			memory.read();
			PC.store();
		}
		else {
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
		}
	}
	
	/**
	 * This method implements the microprogram for
	 * 					jn address
	 * In the machine language this command number is 4, and the address is in the position next to him
	 *    
	 * where address is a valid position in this memory architecture (where 
	 * the PC is redirected to, but only in the case the NEGATIVE bit in Flags is 1)
	 * The method reads the value from memory (position address) and 
	 * inserts it into the PC register if the NEG bit in Flags register is setted.
	 * So, the program is deviated conditionally
	 * The logic is
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the parameter
	 * 6. If FLAGS.bit1 is 1 (bit 1 is NEGATIVE flag) then PC must be updated according the parameter
	 * 7. 	pc -> extbus //pc.read()
	 * 8. 	memory reads from extbus //this forces memory to write the data position in the extbus
	 * 9. 	pc <- extbus //pc.store() //pc was pointing to another part of the memory
	 * 10.ELSE //Flags.Bit1 is not 0. So, PC must be incremented to the next position
	 * 11.  ula incs //the position just after PC
	 * 12.  ula -> intbus2 //ula.read()
	 * 13.  pc <- intbus2 
	 * end
	 * @param address
	 */
	public void jn() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		if (Flags.getBit(1)==1) { 
			PC.read();
			memory.read();
			PC.store();
		}
		else {
			ula.inc();
			ula.internalRead(1);
			PC.internalStore();
		}
	}
	
	/**
	 * This method implements the microprogram for
	 * 					read address
	 * In the machine language this command number is 5, and the address is in the position next to him
	 *    
	 * where address is a valid position in this memory architecture 
	 * The method reads the value from memory (position address) and 
	 * inserts it into the RPG register (the first register in the register list)
	 * The logic is
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the parameter
	 * 6. pc -> extbus //(pc.read())the address where is the position to be read is now in the external bus 
	 * 7. memory reads from extbus //this forces memory to write the address in the extbus
	 * 8. memory reads from extbus //this forces memory to write the stored data in the extbus
	 * 9. RPG <- extbus //the data is read
	 * 10. pc -> intbus2 //pc.read() now pc must point the next instruction address
	 * 11. ula <- intbus2 //ula.store()
	 * 12. ula incs
	 * 13. ula -> intbus2 //ula.read()
	 * 14. pc <- intbus2 //pc.store() 
	 * end
	 * @param address
	 */
	public void read() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		PC.read(); 
		memory.read(); // the address is now in the external bus.
		memory.read(); // the data is now in the external bus.
		RPG.store();
		PC.internalRead(); //we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the next instruction. We go back to the FETCH status.
	}
	
	/**
	 * This method implements the microprogram for
	 * 					store address
	 * In the machine language this command number is 6, and the address is in the position next to him
	 *    
	 * where address is a valid position in this memory architecture 
	 * The method reads the value from RPG (the first register in the register list) and 
	 * inserts it into the memory (position address) 
	 * The logic is
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the parameter
	 * 6. pc -> extbus //(pc.read())the parameter address is the external bus
	 * 7. memory reads // memory reads the data in the parameter address. 
	 * 					// this data is the address where the RPG value must be stores 
	 * 8. memory stores //memory reads the address and wait for the value
	 * 9. RPG -> Externalbus //RPG.read()
	 * 10. memory stores //memory receives the value and stores it
	 * 11. pc -> intbus2 //pc.read() now pc must point the next instruction address
	 * 12. ula <- intbus2 //ula.store()
	 * 13. ula incs
	 * 14. ula -> intbus2 //ula.read()
	 * 15. pc <- intbus2 //pc.store() 
	 * end
	 * @param address
	 */
	public void store() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		PC.read(); 
		memory.read();   //the parameter address (pointing to the addres where data must be stored
		                 //is now in externalbus1
		memory.store(); //the address is in the memory. Now we must to send the data
		RPG.read();
		memory.store(); //the data is now stored
		PC.internalRead(); //we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the next instruction. We go back to the FETCH status.
	}
	
	/**
	 * This method implements the microprogram for
	 * 					ldi immediate
	 * In the machine language this command number is 7, and the immediate value
	 *        is in the position next to him
	 *    
	 * The method moves the value (parameter) into the internalbus1 and the RPG 
	 * (the first register in the register list) consumes it 
	 * The logic is
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the parameter
	 * 6. pc -> extbus //(pc.read())the address where is the position to be read is now in the external bus 
	 * 7. memory reads from extbus //this forces memory to write the stored data in the extbus
	 * 8. RPG <- extbus //rpg.store()
	 * 9. 10. pc -> intbus2 //pc.read() now pc must point the next instruction address
	 * 10. ula <- intbus2 //ula.store()
	 * 11. ula incs
	 * 12. ula -> intbus2 //ula.read()
	 * 13. pc <- intbus2 //pc.store() 
	 * end
	 * @param address
	 */
	public void ldi() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		PC.read(); 
		memory.read(); // the immediate is now in the external bus.
		RPG.store();   //RPG receives the immediate
		PC.internalRead(); //we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the next instruction. We go back to the FETCH status.
	}
	public void ldiImmReg() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the parameter address
		
		PC.read(); 
		memory.read(); // the immediate is now in the external bus.
		
		IR.store(); // Immediate is located temporary in IR
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //PC points to Reg
		
		PC.read();
		memory.read();
		
		demux.put(extbus1.get());
		IR.read();
		registersStore();
		
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore();
		
		
	}
	
	/**
	 * This method implements the microprogram for
	 * 					inc 
	 * In the machine language this command number is 8
	 *    
	 * The method moves the value in rpg (the first register in the register list)
	 *  into the ula and performs an inc method
	 * 		-> inc works just like add rpg (the first register in the register list)
	 *         with the mumber 1 stored into the memory
	 * 		-> however, inc consumes lower amount of cycles  
	 * 
	 * The logic is
	 * 
	 * 1. rpg -> intbus1 //rpg.read()
	 * 2. ula  <- intbus1 //ula.store()
	 * 3. Flags <- zero //the status flags are reset
	 * 4. ula incs
	 * 5. ula -> intbus1 //ula.read()
	 * 6. ChangeFlags //informations about flags are set according the result
	 * 7. rpg <- intbus1 //rpg.store()
	 * 8. pc -> intbus2 //pc.read() now pc must point the next instruction address
	 * 9. ula <- intbus2 //ula.store()
	 * 10. ula incs
	 * 11. ula -> intbus2 //ula.read()
	 * 12. pc <- intbus2 //pc.store()
	 * end
	 * @param address
	 */
	public void inc() {
		RPG.internalRead();
		ula.store(1);
		ula.inc();
		ula.read(1);
		setStatusFlags(intbus1.get());
		RPG.internalStore();
		PC.internalRead(); //we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the next instruction. We go back to the FETCH status.
	}
	
	/**
	 * This method implements the microprogram for
	 * 					move <reg1> <reg2> 
	 * In the machine language this command number is 9
	 *    
	 * The method reads the two register ids (<reg1> and <reg2>) from the memory, in positions just after the command, and
	 * copies the value from the <reg1> register to the <reg2> register
	 * 
	 * 1. pc -> intbus2 //pc.read()
	 * 2. ula <-  intbus2 //ula.store()
	 * 3. ula incs
	 * 4. ula -> intbus2 //ula.read()
	 * 5. pc <- intbus2 //pc.store() now pc points to the first parameter
	 * 6. pc -> extbus //(pc.read())the address where is the position to be read is now in the external bus 
	 * 7. memory reads from extbus //this forces memory to write the parameter (first regID) in the extbus
	 * 8. pc -> intbus2 //pc.read() //getting the second parameter
	 * 9. ula <-  intbus2 //ula.store()
	 * 10. ula incs
	 * 11. ula -> intbus2 //ula.read()
	 * 12. pc <- intbus2 //pc.store() now pc points to the second parameter
	 * 13. demux <- extbus //now the register to be operated is selected
	 * 14. registers -> intbus1 //this performs the internal reading of the selected register 
	 * 15. PC -> extbus (pc.read())the address where is the position to be read is now in the external bus 
	 * 16. memory reads from extbus //this forces memory to write the parameter (second regID) in the extbus
	 * 17. demux <- extbus //now the register to be operated is selected
	 * 18. registers <- intbus1 //thid rerforms the external reading of the register identified in the extbus
	 * 19. 10. pc -> intbus2 //pc.read() now pc must point the next instruction address
	 * 20. ula <- intbus2 //ula.store()
	 * 21. ula incs
	 * 22. ula -> intbus2 //ula.read()
	 * 23. pc <- intbus2 //pc.store()  
	 * 		  
	 */
	public void moveRegReg_() {
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the first parameter (the first reg id)
		PC.read(); 
		memory.read(); // the first register id is now in the external bus.
		PC.internalRead();
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the second parameter (the second reg id)
		demux.put(extbus1.get()); //points to the correct register
		registersInternalRead(); //starts the read from the register identified into demux bus
		PC.read();
		memory.read(); // the second register id is now in the external bus.
		demux.put(extbus1.get());//points to the correct register
		registersInternalStore(); //performs an internal store for the register identified into demux bus
		PC.internalRead(); //we need to make PC points to the next instruction address
		ula.internalStore(1);
		ula.inc();
		ula.internalRead(1);
		PC.internalStore(); //now PC points to the next instruction. We go back to the FETCH status.
	}
	
	
	public ArrayList<Register> getRegistersList() {
		return registersList;
	}

	/**
	 * This method performs an (external) read from a register into the register list.
	 * The register id must be in the demux bus
	 */
	private void registersRead() {
		registersList.get(demux.get()).read();
	}
	
	/**
	 * This method performs an (internal) read from a register into the register list.
	 * The register id must be in the demux bus
	 */
	private void registersInternalRead() {
		registersList.get(demux.get()).internalRead();
	}
	
	/**
	 * This method performs an (external) store toa register into the register list.
	 * The register id must be in the demux bus
	 */
	private void registersStore() {
		registersList.get(demux.get()).store();
	}
	
	/**
	 * This method performs an (internal) store toa register into the register list.
	 * The register id must be in the demux bus
	 */
	private void registersInternalStore() {
		registersList.get(demux.get()).internalStore();;
	}


	/**
	 * This method reads an entire file in machine code and
	 * stores it into the memory
	 * NOT TESTED
	 * @param filename
	 * @throws IOException 
	 */
	public void readExec(String filename) throws IOException {
		   BufferedReader br = new BufferedReader(new		 
		   FileReader(filename+".dxf"));
		   String linha;
		   int i=0;
		   while ((linha = br.readLine()) != null) {
			     extbus1.put(i);
			     memory.store();
			   	 extbus1.put(Integer.parseInt(linha));
			     memory.store();
			     i++;
			}
			br.close();
	}
	
	/**
	 * This method executes a program that is stored in the memory
	 */
	public void controlUnitEexec() {
		halt = false;
		while (!halt) {
			fetch();
			decodeExecute();
		}

	}
	

	/**
	 * This method implements The decode proccess,
	 * that is to find the correct operation do be executed
	 * according the command.
	 * And the execute proccess, that is the execution itself of the command
	 */
	private void decodeExecute() {
		IR.internalRead(); //the instruction is in the internalbus2
		int command = intbus2.get();
		simulationDecodeExecuteBefore(command);
		switch (command) {
		case 0:
			addRegReg();
			break;
		case 1:
			addMemReg();
			break;
		case 2:
			addRegMem();
			break;
		case 3:
			subRegReg();
			break;
		case 4:
			subMemReg();
			break;
		case 5:
			subRegMem();
			break;
		case 6:
			imulMemReg();
			break;
		case 7:
			imulRegMem();
			break;
		case 8:
			imulRegReg();
			break;
		case 9:
			moveMemReg();
			break;
		case 10:
			moveRegMem();
			break;
		case 11:
			moveRegReg();
			break;
		case 12:
			moveImmReg();
			break;
		case 13:
			incReg();
			break;
		case 14:
			incMem();
			break;
		case 15:
			jmpMem();
			break;
		case 16:
			jnMem();
			break;
		case 17:
			jzMem();
			break;
		case 18:
			jnzMem();
			break;
		case 19:
			jeqRegReg();
			break;
		case 20:
			jgtRegReg();
			break;
		case 21:
			jlwRegReg();
			break;
		case 22:
			ldiImmReg();
			break;
		case 23:
			addImmReg();
			break;
		case 24:
			moveMemMemREsp();
			break;
		case 25:
			moveMemMemMEsp();
			break;
		case 26:
			subImmReg();
			break;
		default:
			halt = true;
			break;
		}
		//if (simulation)
			//simulationDecodeExecuteAfter();
	}

	/**
	 * This method is used to show the components status in simulation conditions
	 * NOT TESTED
	 * @param command 
	 */
	private void simulationDecodeExecuteBefore(int command) {
		System.out.println("----------BEFORE Decode and Execute phases--------------");
		String instruction;
		int parameter = 0;
		for (Register r:registersList) {
			System.out.println(r.getRegisterName()+": "+r.getData());
		}
		if (command !=-1)
			instruction = commandsList.get(command);
		else
			instruction = "END";
		if (hasOperands(instruction)) {
			parameter = memory.getDataList()[PC.getData()+1];
			System.out.println("Instruction: "+instruction+" "+parameter);
		}
		else
			System.out.println("Instruction: "+instruction);
		if ("read".equals(instruction))
			System.out.println("memory["+parameter+"]="+memory.getDataList()[parameter]);
		
	}

	/**
	 * This method is used to show the components status in simulation conditions
	 * NOT TESTED 
	 */
	private void simulationDecodeExecuteAfter() {
		String instruction;
		System.out.println("-----------AFTER Decode and Execute phases--------------");
		System.out.println("Internal Bus 1: "+intbus1.get());
		System.out.println("Internal Bus 2: "+intbus2.get());
		System.out.println("External Bus 1: "+extbus1.get());
		for (Register r:registersList) {
			System.out.println(r.getRegisterName()+": "+r.getData());
		}
		Scanner entrada = new Scanner(System.in);
		System.out.println("Press <Enter>");
		String mensagem = entrada.nextLine();
	}

	/**
	 * This method uses PC to find, in the memory,
	 * the command code that must be executed.
	 * This command must be stored in IR
	 * NOT TESTED!
	 */
	private void fetch() {
		PC.read();
		memory.read();
		IR.store();
		simulationFetch();
	}

	/**
	 * This method is used to show the components status in simulation conditions
	 * NOT TESTED!!!!!!!!!
	 */
	private void simulationFetch() {
		if (simulation) {
			System.out.println("-------Fetch Phase------");
			System.out.println("PC: "+PC.getData());
			System.out.println("IR: "+IR.getData());
		}
	}

	/**
	 * This method is used to show in a correct way the operands (if there is any) of instruction,
	 * when in simulation mode
	 * NOT TESTED!!!!!
	 * @param instruction 
	 * @return
	 */
	private boolean hasOperands(String instruction) {
		if ("inc".equals(instruction)) //inc is the only one instruction having no operands
			return false;
		else
			return true;
	}

	/**
	 * This method returns the amount of positions allowed in the memory
	 * of this architecture
	 * NOT TESTED!!!!!!!
	 * @return
	 */
	public int getMemorySize() {
		return memorySize;
	}
	
	public static void main(String[] args) throws IOException {
		Architecture arch = new Architecture(true);
		arch.readExec("program");
		arch.controlUnitEexec();
	}
	

}
