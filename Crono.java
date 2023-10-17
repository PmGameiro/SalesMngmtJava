package li;


/**
* Crono = mede um tempo entre start() e stop()
* O tempo e medido em nanosegundos e convertido para 
*  um double que representa os segs na sua parte inteira.
* 
* @author FMM 
* @version 1.0 / 2006
*/
public class Crono {

private static long inicio = 0L;
private static long fim = 0L;

/** inicia a contagem de tempo */
public void start() { 
   fim = 0L; inicio = System.nanoTime();  
}

/** termina a contagem de tempo  e devolve diferenca em segs */
public double stop() { 
   fim = System.nanoTime();
   long elapsedTime = fim - inicio;
   double segs = elapsedTime / 1.0E09;
   return segs;
}

/** converte a diferenca numa string */
public String print() {
   return "" + stop();
}
}