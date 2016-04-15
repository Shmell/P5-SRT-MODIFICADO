/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.*;
import java.util.List;
import java.io.*;
import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.*;
import static java.lang.Thread.sleep;

import javax.swing.text.BadLocationException;

/**
 *
 * @author SAM
 */
public class Ventana extends javax.swing.JFrame implements Runnable{

    
    public Ventana() 
    {
        initComponents();
        setLocation(400, 0) ;
        setTitle("SRT Prioridades");

          Creador=new Thread(this);
  
          auto=new Automatico();
          auto.start();
        
    }

/////////////////////////////////////////////////////////

 

//////////////////////////////////////////////////////////////////

public void run()
{
 boolean aumento=false; 
 int aux_status;

 
 
 while(true)
 {
     
    if(Ventana.entrar==true)
      {   
       entrar=false;
       
       
       Collections.sort(indice);
     
       for(int i=0;i<indice.size();i++)
       {
         aux_status=ListaProcesos.get(indice.get(i).numProceso-1).status;
         
        if(aux_status==1)
        {
         ListaProcesos.get(indice.get(i).numProceso-1).start();
         i=indice.size();
        }   
       }
            entrar=true;
         
        //mayor=false;

        try
          {
            sleep(5000); 
          }
        catch (InterruptedException e)
          {
           System.out.println("pr9oblemilla");
          }	
       }


  
      
 }
     
  /*System.out.println("Vhaaa"); 
     
     try
          {
            Creador.sleep(2000);
            
          }
        catch (InterruptedException e)
          {
           System.out.println("pr9oblemilla");
          }	*/
     
 
 
 
 
 
 
 
 
 
 
 
 /*
 while(contador_pos<contador)
	   {
	   if(contador_pos==0)
	   	{
	   	 ListaProcesos.get(contador_pos).start();
	   	 contador_pos++;
	   	 
	   	}	   	
	   else
	   	{
	   	
	   		  while(ListaProcesos.get(contador_pos-1).alive==0)
		   		 {
		   		  
		   		  ListaProcesos.get(contador_pos).start();
		   		  contador_pos++;
		   		  break;
		   		 }
	   	}
	   }
 */

}

//////////////////////////////////////////////////////////////////
/*
public void funciona() throws InterruptedException
{
int contador=nlista;

while(contador<ListaProcesos.size())
{
ListaProcesos.get(nlista).start();
//ListaProcesos.get(nlista).join();;


contador++;
}


}*/
//////////////////////////////////////////////////////////////
public static void crea()
{
 Proceso aux; 
 int prio;

 Random tiempo_random=new Random();
 int tiempo=1 + tiempo_random.nextInt(15);
 
 if(mayor==true)
 {
  Random prio_random=new Random();
  prio=(ListaProcesos.get(0).prioridad) + prio_random.nextInt(15); 
 }
 else
 {
  Random prio_random=new Random();
  prio=1 + prio_random.nextInt(15); 
 }
 
  contador++;
  ListaProcesos.add((new Proceso(contador,tiempo,prio)));
  indice.add((new Referencia(contador,prio)));
  
 
  ListaProcesos.get(contador-1).imprimeListo();    
    
}

//////////////////////////////////

//////////////////////////////////

public void proceso_ejecutandose(int posicion)
{

	  ListaProcesos.get(posicion-1).start();
    // imprimeEjecucion(posicion);
	
	
}

//////////////////////////////////////////

public void retardo_bloqueo(int tiempo)
{
 try //Tiempo de retardo para la creacion de un nuevo hilo
	{
	 Thread.sleep(tiempo);
	}
 catch(InterruptedException er)
	{
	 System.out.println(er);
	}
 
}







////////////////////////////////////
public void imprimeListo(int posicion)
{
int posInicio=(posicion-1)*29;
int posFinal=posInicio+29;

 String pos=Integer.toString(posicion);
 String listo="Listo";

 
 
 
 if(posicion<=9)
	 {
	  pos="0"+Integer.toString(posicion);
	 }
 
 if(posicion==1)
	 texto.append("Proceso "+pos+"\t"+listo);
 else
	 texto.append("\n"+"Proceso "+pos+"\t"+listo);
	  

 
 
 /*
 if(posicion==1)
	 texto.replaceRange("Proceso "+pos+"\t"+ejecutandose,posInicio,posFinal);
 else
	 texto.replaceRange("\n"+"Proceso "+pos+"\t"+ejecutandose,posInicio,posFinal);

*/
 
 
}

////////////////////////////////////
public void imprimeEjecucion(int posicion) 
{
String pos=Integer.toString(posicion);
String vieja,nueva,aux,aux2;

if(posicion<=9)
	  pos="0"+Integer.toString(posicion);

vieja="Proceso "+pos+"\t"+"Listo";
nueva="Proceso "+pos+"\t"+"En ejecucion";


aux=texto.getText();
aux2=aux.replaceFirst(vieja, nueva);

if(aux.equals(aux2))
	{
	 vieja="Proceso "+pos+"\t"+"Bloqueado";
	 aux2=aux.replaceFirst(vieja, nueva);
	}
texto.setText(aux2);


}


//////////////////////////////////////////////
public void imprimeReanudado(int posicion) 
{
String pos=Integer.toString(posicion);
String vieja,nueva,aux,aux2;

if(posicion<=9)
	  pos="0"+Integer.toString(posicion);

vieja="Proceso "+pos+"\t"+"Listo";
nueva="Proceso "+pos+"\t"+"En ejecucion";


aux=texto.getText();
aux2=aux.replaceFirst(vieja, nueva);

if(aux.equals(aux2))
	{
           
            
	 vieja="Proceso "+pos+"\t"+"Bloqueado";
	 aux2=aux.replaceFirst(vieja, nueva);
	}
texto.setText(aux2);


ListaProcesos.get(posicion-1).status=2;
ListaProcesos.get(posicion-1).resume();


}

/////////////////////////////////////////////////
public String completarEstado(String estado)
{
 String cadena="";
 
	 
 for(int i=estado.length();i<20;i++)
	 {
	  cadena=cadena.concat(".");
	 }

 return estado.concat(cadena);
}

 //////////////////////////////////////

public void ponerStatusAleatorio() 
{
 Random randomLista=new Random();
 Random randomStatus=new Random();

 int aLista=randomLista.nextInt(ListaProcesos.size()-1);
 int aStatus=1 + randomLista.nextInt(5);
 
 
 if(aStatus==1 || aStatus==2)
	 proceso_bloqueado(aLista+1);
 else if(aStatus==3 || aStatus==4)
	 		proceso_eliminado(aLista+1);
 		else
 			proceso_ejecutandose(aLista+1);
}	
 
 //////////////////////////////////////////////////

public void proceso_bloqueado(int nLista) 
{

/* 
try
	{
	ListaProcesos.get(nLista).sleep(15000);
	}
catch (InterruptedException e)
	{
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	*/
 imprimeBloqueado(nLista);
 
}
 

////////////////////////////////////////////////
public void imprimeBloqueado(int posicion) 
{
String pos=Integer.toString(posicion);
String vieja,nueva,aux;;

if(posicion<=9)
	  pos="0"+Integer.toString(posicion);

vieja="Proceso "+pos+"\t"+"En ejecucion";
nueva="Proceso "+pos+"\t"+"Bloqueado";

aux=texto.getText().replaceFirst(vieja, nueva);

texto.setText(aux);

ListaProcesos.get(posicion-1).status=3;
ListaProcesos.get(posicion-1).suspend();


}
 
//////////////////////////////////////////////////

public void proceso_eliminado(int nLista) 
{
ListaProcesos.get(nLista-1).stop();
imprimeEliminado(nLista);

}


////////////////////////////////////////////////
public void imprimeEliminado(int posicion) 
{
String pos=Integer.toString(posicion);
String vieja,nueva,aux,aux2;

if(posicion<=9)
	  pos="0"+Integer.toString(posicion);

vieja="Proceso "+pos+"\t"+"En ejecucion";
nueva="Proceso "+pos+"\t"+"Eliminado";

aux=texto.getText();
aux2=aux.replaceFirst(vieja, nueva);

if(aux.equals(aux2))
	{
	 vieja="Proceso "+pos+"\t"+"Bloqueado";
	 aux2=aux.replaceFirst(vieja, nueva);
	}


texto.setText(aux2);
}
    
    
    
    
    
    
    
    
    

    
 
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        texto = new javax.swing.JTextArea();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtNumero = new javax.swing.JTextPane();
        reanudar = new javax.swing.JButton();
        pausar = new javax.swing.JButton();
        informacion = new javax.swing.JButton();
        finalizar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel1.setText("Proceso");

        jLabel2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel2.setText("Estado");

        texto.setColumns(20);
        texto.setRows(5);
        jScrollPane1.setViewportView(texto);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        txtNumero.setBorder(null);
        txtNumero.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        txtNumero.setForeground(new java.awt.Color(255, 0, 0));
        txtNumero.setToolTipText("Numero de Proceso");
        txtNumero.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txtNumero.setMargin(new java.awt.Insets(15, 3, 3, 3));
        jScrollPane2.setViewportView(txtNumero);

        reanudar.setBackground(new java.awt.Color(51, 51, 51));
        reanudar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        reanudar.setForeground(new java.awt.Color(255, 255, 255));
        reanudar.setText("Reanudar");
        reanudar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reanudarActionPerformed(evt);
            }
        });

        pausar.setBackground(new java.awt.Color(51, 51, 51));
        pausar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        pausar.setForeground(new java.awt.Color(255, 255, 255));
        pausar.setText("Bloquear");
        pausar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pausarActionPerformed(evt);
            }
        });

        informacion.setBackground(new java.awt.Color(153, 153, 153));
        informacion.setText("Info");
        informacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                informacionActionPerformed(evt);
            }
        });

        finalizar.setBackground(new java.awt.Color(51, 51, 51));
        finalizar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        finalizar.setForeground(new java.awt.Color(255, 255, 255));
        finalizar.setText("Eliminar");
        finalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(informacion))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(reanudar, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
                            .addComponent(jScrollPane2))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(pausar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(finalizar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(reanudar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pausar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(finalizar, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(informacion))
        );

        jLabel3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        jLabel3.setText("Prioridad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(41, 41, 41)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addGap(56, 56, 56)))
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void reanudarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reanudarActionPerformed
       
        if(txtNumero.getText().isEmpty())
           JOptionPane.showMessageDialog(null, "No se ha ingresado el numero de proceso");

        
        
        
        imprimeReanudado(Integer.parseInt(txtNumero.getText()));
       txtNumero.setText("");				        

    }//GEN-LAST:event_reanudarActionPerformed

    private void informacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_informacionActionPerformed
			        	JOptionPane.showMessageDialog(null, "Desarrollado por:\nSamuel Ramirez Torres\nCodigo:304454235\nBibliogafia:\nSistemas.Operativos\nWilliam Stallings\n2000 2da Edicion Prentice Hall ");
        
    }//GEN-LAST:event_informacionActionPerformed

    private void pausarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pausarActionPerformed
      
        if(txtNumero.getText().isEmpty())
           JOptionPane.showMessageDialog(null, "No se ha ingresado el numero de proceso");
        
        proceso_bloqueado(Integer.parseInt(txtNumero.getText()));
      txtNumero.setText("");	
    }//GEN-LAST:event_pausarActionPerformed

    private void finalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarActionPerformed
        
        if(txtNumero.getText().isEmpty())
           JOptionPane.showMessageDialog(null, "No se ha ingresado el numero de proceso");
        
        proceso_eliminado(Integer.parseInt(txtNumero.getText()));
        txtNumero.setText("");	
    }//GEN-LAST:event_finalizarActionPerformed

    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Ventana().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton finalizar;
    private javax.swing.JButton informacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton pausar;
    private javax.swing.JButton reanudar;
    public static javax.swing.JTextArea texto;
    private javax.swing.JTextPane txtNumero;
    // End of variables declaration//GEN-END:variables
    
 
    
    
 static ArrayList<Proceso> ListaProcesos=new ArrayList<Proceso>();
 static ArrayList<Referencia> indice=new ArrayList<Referencia>();
 
 int contAleatorio=0;
 static Thread Creador;
 
 Thread auto;
 
 static int contador=0;
 static int contador_pos=0;

 public static boolean mayor=false;
 public static boolean entrar=true;

}
