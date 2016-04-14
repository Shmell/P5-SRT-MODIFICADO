

public class Automatico extends Thread
{
	static int limite=0;
	
	
	
	
	
	
	public void run()
	{
		
            while(true)   
            {
                if(Ventana.entrar==true)
		{
			if(Ventana.contador==0)
	  	   	 {   
                          Ventana.entrar=false;  
                          
                          Ventana.crea();
                          Ventana.crea();
                          
                          Ventana.entrar=true; 
			  Ventana.Creador.start();
                          
                          
	  	   	 }
                        else
                         {
                          Ventana.entrar=false;  
                          Ventana.crea(); 
                          Ventana.entrar=true;  
                         }
                            

			try 
                        {
		         this.sleep(1500);
			} 
                        catch (InterruptedException e) 
                        {
                         e.printStackTrace();
			}
		}
            
            
            
            
            
            
            
            
            }
            
            
		//while(limite++ < 10)
		
		
	 
		
		
		
		
	}

}