package lel.singlethread;



public class Matrixthreadtext {
	public static void main(String[] args) {
	
	Matrixthread  matrixthread = new Matrixthread(4000);
	
	Thread thread = new Thread(matrixthread);
	thread.start();
}
}
