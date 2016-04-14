
public class Referencia implements Comparable<Referencia>
{
  int numProceso;
  int numPrioridad;
   
  public Referencia(int n,int p)
  {
     numProceso=n;
     numPrioridad=p;
  }

    
  public int compareTo(Referencia o) 
  {
    int a=this.numPrioridad;
    int b=o.numPrioridad;
    int respuesta=0;


    if(a<b)
	respuesta= -1;
    else if(a>b)
            respuesta= 1;
	  else if(a==b)
		  respuesta= -1;

    return respuesta;
  }
    
}
