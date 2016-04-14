/*
 STATUS

1 IISTO
2 EJECUTANDO
3 BLOQUEADO
4 ELIMINADO/TERMINADO

*/



public class Proceso extends Thread implements Comparable<Proceso>
{
//Thread hilo;
 
 private int numero;
 int duracion;
 
 int prioridad;
 
 int status;
	
 public Proceso(int numero,int tiempo,int prioridad)
 {
  this.numero=numero;
  duracion=tiempo;
  this.prioridad=prioridad;
  //Thread hilo=new Thread(this);

   status=1;
  
  
 }
 
 ///////////////////////////////////////////////////////////////
 
 public void run() 
 {
 /*
  imprimeListo();
  
  try
	 {
	 sleep(1000);
	 }
  catch (InterruptedException e1)
	 {
	 e1.printStackTrace();
	 }
  */
  
  try
	 {
	  imprimeEjecucion();
	 }
  catch (InterruptedException e)
	 {
	  e.printStackTrace();
	 } 	
	
  
  
  //alive=0;
 }
 
 ///////////////////////////////////////////////////////////////
 
 public  void imprimeEjecucion() throws InterruptedException 
 {
 String pos=Integer.toString(numero);
 String vieja,nueva,aux="",aux2="";
 int dura=duracion;

 if(numero<=9)
 	  pos="0"+Integer.toString(numero);

 
	  vieja="Proceso "+pos+"\t"+"Listo y en espera"+"\t"+prioridad;
	  nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura+"\t"+prioridad;
	 
	  while(dura!=-1)
		 {
		 aux=Ventana.texto.getText();
		 aux2=aux.replaceFirst(vieja, nueva);
		 
		 Ventana.texto.setText(aux2);
		  
		  
		  vieja=nueva;
		  dura--;
		  nueva="Proceso "+pos+"\t"+"En ejecucion"+"\t"+dura+"\t"+prioridad;
		  sleep(1000);
		  
		  if(dura <= 2)
			  Ventana.mayor=true;
		 }
	 
	  if(dura==-1)
		 {
		  vieja="Proceso "+pos+"\t"+"En ejecucion"+"\t"+(dura+1)+"\t"+prioridad;
		  nueva="Proceso "+pos+"\t"+"      Finalizado"+"\t\t"+prioridad;
		  
		  
		  aux=Ventana.texto.getText();
		  aux2=aux.replaceFirst(vieja, nueva);
		  Ventana.texto.setText(aux2);
		 }
	
	 
	 
  
 

 
 
 }
 
 /////////////////////////////////////////////////////////////////
 
 public  void imprimeListo()
 {
  String pos=Integer.toString(numero);
  String status="Listo y en espera";

  if(numero<=9)
 	 {
 	  pos="0"+Integer.toString(numero);
 	 }
  
  if(numero==1)
	  Ventana.texto.append("Proceso "+pos+"\t"+status+"\t"+prioridad);
  else
	  Ventana.texto.append("\n"+"Proceso "+pos+"\t"+status+"\t"+prioridad);
 	  
 }



public int compareTo(Proceso o) {
int a=this.prioridad;
int b=o.prioridad;
int respuesta=0;


if(a<b)
	respuesta= -1;
else if(a>b)
	respuesta= 1;
	  else if(a==b)
		  respuesta= -1;

return respuesta;
}
 
 /////////////////////////////////////////////////////////////////
 /*
 public void imprimeBloqueado()
 {
  String pos=Integer.toString(numero);
  String status="Bloqueado";

  if(numero<=9)
 	 {
 	  pos="0"+Integer.toString(numero);
 	 }
  
  if(numero==1)
	  Interfaz.texto.append("Proceso "+pos+"\t"+status);
  else
	  Interfaz.texto.append("\n"+"Proceso "+pos+"\t"+status);
 	  
 }
 */
}
