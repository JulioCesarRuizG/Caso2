package caso2;

import java.util.ArrayList;
import java.util.Stack;

public class ActualizarTabla extends Thread{
		
	public Stack<String> paginas;
	public int tam;
	public static int[] marcos;
	public static int[] R;
	public static int[] M;
	public static int errores = 0;
	
	public ActualizarTabla(Stack<String> datos, int cantidad, int[] R, int[] M)
	{
		paginas = datos;
		marcos = new int[cantidad];
		tam = cantidad;
		ActualizarTabla.R = R;
		ActualizarTabla.M = M;
		this.start();
	}

	@Override
	public void run(){
		boolean contiene = false;
		while(!paginas.isEmpty())
		{
			contiene = false;
			String actual = paginas.pop();
			String[] partes = actual.split(",");
			int pagina = Integer.parseInt(partes[0]);
			String tipo = partes[1];
			for(int i=0 ; i< tam ; i++)
			{
				if(marcos[i] == pagina)
				{
					if(tipo.equals("m")){
						if(M[i] == 0)
						{
							M[i] = 1;
							errores++;
						}
					}
					R[i] = 1;
					contiene = true;
				}
			}
			if(contiene == false)
			{
				errores++;
				int clase0 = -1;
				int clase1 = -1;
				int clase2 = -1;
				int clase3 = -1;
				for(int i=0 ; i< tam ; i++)
				{
					if(R[i] == 0 && M[i] == 0){
						clase0 = i;
					}
					else if(R[i] == 0 && M[i] == 1){
						clase1 = i;
					}
					else if(R[i] == 1 && M[i] == 0){
						clase2 = i;
					}
					else {
						clase3 = i;
					}
				}
				int def;
				if(clase0 != -1){
					def = clase0;
				}
				else if(clase1 != -1){
					def = clase1;
				}
				else if(clase2 != -1){
					def = clase2;
				}
				else {
					def = clase3;
				}
				marcos[def] = pagina;
				if(tipo.equals("r"))
				{
					R[def] = 1;
				}
				else
				{
					R[def] = 1;
					M[def] = 1;
				}
			}
			try {
				sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("errores: " + errores);
	}
}
