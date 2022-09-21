package controller;

import java.util.concurrent.Semaphore;

public class Controller extends Thread{

	private int distancia;
	private int distanciaPercorrida;
	private Semaphore semaforo;
	
	public Controller(Semaphore semaforo) {
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		caminha();
		
		try {
			semaforo.acquire();
			abrePorta();
		} 
		catch (InterruptedException e) {
			
		}
		semaforo.release();
	}
	

	public void caminha() {
		while(distanciaPercorrida <= distancia) {
			distanciaPercorrida += 5;
			System.out.println("Pessoa " + getId() + " percorreu: " + distanciaPercorrida);
			
		try {
			sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	}
	
	public void abrePorta() {
		try {
			sleep(1500);
			System.out.println("Pessoa " + getId() + " abriu e cruzou a porta.");
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
