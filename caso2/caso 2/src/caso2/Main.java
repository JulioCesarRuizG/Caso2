package caso2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.CyclicBarrier;

public class Main {
	public final static String FILE_PATH = "." + File.separator + "data" + File.separator + "referencias8_128_75.txt";
	public static int numMarcosPagina;
	public static int numPaginasProceso;
	public static int numReferencias;
	public static Stack<String> secuenciaReferencia;
	public static int[] R;
	public static int[] M;
	public static ActualizarTabla tabla;
	public static ActualizarBits bits;
	

	public static void main(String[] args)
	{
		readFile();
		R = new int[numMarcosPagina];
		M = new int[numMarcosPagina];
		tabla = new ActualizarTabla(secuenciaReferencia, numMarcosPagina, R, M);
		bits = new ActualizarBits(R, M, numMarcosPagina);
		
	}

	public static void readFile()
	{
		try
		{
			File archivo = new File(FILE_PATH);
			FileReader fr = new FileReader (archivo);
			BufferedReader br = new BufferedReader(fr);
			String linea;
			linea = br.readLine();
			numMarcosPagina = Integer.parseInt(linea);
			linea = br.readLine();
			numPaginasProceso = Integer.parseInt(linea);
			linea = br.readLine();
			numReferencias = Integer.parseInt(linea);
			secuenciaReferencia = new Stack<String>();
			for(int i=0 ; i<numReferencias ; i++)
			{
				linea = br.readLine();
				secuenciaReferencia.push(linea);
			}
			br.close();	
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}
}
