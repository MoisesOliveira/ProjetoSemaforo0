package view;

import java.util.concurrent.Semaphore;

import controller.Controller;

public class Main {

	public static void main(String[] args) {

		Controller[] pessoas = new Controller[4];
		Semaphore semaforo = new Semaphore(1);
		
		for(int i = 0; i < 4; i++) {
			pessoas[i] = new Controller(semaforo);
			pessoas[i].start();
		}
	}

}
