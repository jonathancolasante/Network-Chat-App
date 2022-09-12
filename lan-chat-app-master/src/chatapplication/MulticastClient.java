package chatapplication;

import static chatapplication.MulticastClient.name;
import static chatapplication.MulticastClient.s;
import java.net.*;
import java.io.*;
import javax.swing.JOptionPane;

public  class MulticastClient extends javax.swing.JFrame { public static String name;
public static String message;
public static MulticastSocket socket=null;
public static InetAddress address ;  
public static DatagramSocket s=null;

    public MulticastClient()  {
        initComponents();
       this.setLocationRelativeTo(null);
}  

    @SuppressWarnings("unchecked")

    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Send");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setEditable(false);
        jTextArea1.setColumns(20);
        jTextArea1.setFont(new java.awt.Font("Calibri Light", 0, 18));
        jTextArea1.setRows(5);
        jTextArea1.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jScrollPane1.setViewportView(jTextArea1);

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Gabriola", 1, 24));
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jLabel1.setFont(new java.awt.Font("Gabriola", 1, 24));
        jLabel1.setText("Enter  your  message  here");

        jButton2.setText("Exit from Chat");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Gabriola", 1, 24));
        jLabel2.setText("Chat Window");

        jTextArea3.setEditable(false);
        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane3.setViewportView(jTextArea3);

        jLabel3.setFont(new java.awt.Font("Gabriola", 1, 24));
        jLabel3.setText("Online users");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(73, 73, 73)
                                .addComponent(jButton2)))
                        .addGap(0, 163, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 344, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButton2)))
                .addContainerGap())
        );

        pack();
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
      
         String x="***** "+name+" has logged out from the chat room *****";
         
            byte buf[]=x.getBytes();
              try{  InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);

               s.send(packet);
              }catch(Exception e){}
        x="exited";
        buf=x.getBytes();
        try{
        InetAddress group=InetAddress.getByName("230.0.0.2");
        DatagramPacket packet=new DatagramPacket(buf, buf.length,group,5000);
        s.send(packet);
            
          socket.leaveGroup(address);
           s.close();
     
          }
           catch(Exception e){}
        this.setVisible(false);
           new ChatApp().setVisible(true);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
      
        String text= jTextArea2.getText();
         if(!text.equals(""))
         {    message=name+": "+text;
    
         try {
                byte[] buf ;
                buf = message.getBytes();

                InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
               
              s.send(packet);
               }       
         catch (IOException e) {
                 MulticastClient.socket.close();
         }   }
    }

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                
                    new MulticastClient().setVisible(true);
                
                    }
               }
        );
    }

    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    public static javax.swing.JTextArea jTextArea1;
    public static javax.swing.JTextArea jTextArea2;
    public static javax.swing.JTextArea jTextArea3;

}

 class Client implements Runnable {
  
     Client(){
         try{
         MulticastClient.socket = new MulticastSocket(4446) ;
        MulticastClient. s=new DatagramSocket();
        
        MulticastClient. address=InetAddress.getByName("230.0.0.1");
      MulticastClient.socket.joinGroup(MulticastClient.address);
      }
        catch(Exception e)
        {JOptionPane.showMessageDialog(new ChatApp(), "Sorry,Cannot bind");}}
  @Override
  public void run(){
      Thread t3=new Thread(new OnlineStatus());
         
           t3.start();
       Thread t4=new Thread(new ReceiveOnlineStatus());
            t4.start();
       newUser();

      
  while(true)
      {  
          
      try{

         DatagramPacket packet;
       
         
         
         byte[] buf = new byte[256];
         packet = new DatagramPacket(buf, buf.length);
         
           MulticastClient.socket.receive(packet);
        
         String received = new String(packet.getData(), 0, packet.getLength());
         
     MulticastClient.jTextArea1.setText(MulticastClient.jTextArea1.getText()+received+"\n");
        
        MulticastClient.jTextArea2.setText("");
                  }catch(IOException e){System.err.println(e);}
       }  
 
 
 } void newUser(){String x="***** "+name+" has logged into the chat room *****";
            byte buf[]=x.getBytes();
              try{  InetAddress group = InetAddress.getByName("230.0.0.1");
                DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
              
             
               s.send(packet);
              }catch(Exception e){}}
  }
 
 
  








   
               

