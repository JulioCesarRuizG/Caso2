package caso2;

public class ActualizarBits extends Thread{
	public static int[] R;
	public static int[] M;
	public int cantidad;
	
	public ActualizarBits(int[] R, int[] M, int cantidad) {
		ActualizarBits.R = R;
		ActualizarBits.M = M;
		this.cantidad = cantidad;
		inicio();
		this.start();
	}
	
	public void run() {
		while(true)
		{
			try {
				sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for(int i=0 ; i< cantidad ; i++)
			{
				R[i] = 0;
			}
		}
	}
	
	public void inicio()
	{
		for(int i=0 ; i< cantidad ; i++)
		{
			R[i] = 0;
			M[i] = 0;
		}
	}
}
