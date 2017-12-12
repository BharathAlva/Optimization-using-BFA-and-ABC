
import java.awt.BorderLayout;
import java.awt.*;
import java.awt.Graphics;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JViewport;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sanket
 */
public abstract class ex2 extends javax.swing.JFrame
{
static int X,Y;
    
    /**
     * Creates new form ex2
     */
    public ex2() {
        initComponents();
       // super.paintComponents(g);
    //      add (new CraftingPanel (), BorderLayout.CENTER);
        setSize (2600, 1600);
        setLocationRelativeTo (null);
        setResizable (true);
        
        setDefaultCloseOperation (3);
        setVisible(true);
        
      
    }

    
 
    
    class CraftingPanel extends JPanel {
    BufferedImage image = null;
        public CraftingPanel () {
        try {
            image = ImageIO.read (new File ("C:/Users/sanket/Downloads/tower_2.png"));
        } catch (java.io.IOException ioe) 
        {
            System.err.println (ioe.getMessage ());
        }       
        }

        public void paintComponent (Graphics g,int x,int y) {
           
        g.drawImage (image, x, y, null);
        }
    };
    
    
          
    
    
    
    int s;
    Graphics g;
    int iparticleNo;
    int counter=0;
    int nodecounter=0;
    int pattern=0;
    ///
    int XArray[] = new int[1000]; 
    int YArray[] = new int[1000];
    int repaintcounter=0;
    int infoFlag=0;
    int nodeNumber[] = new int[1000];
    int showNodes=0;
    int stop=0;
     /*   void drawRegion(int x, int y, int i)
        {
 
        g.setColor(Color.black);
        g.drawString("R"+i,x+10,y+10);
        g.setColor(Color.blue);
        g.drawOval(x, y, 80, 80);   
        }
     */  

        
        
        void DrawNCounter (int x, int y)    //x y here is not the center but the cordinates of the nodes..
        {
            XArray[nodecounter]=x;
            YArray[nodecounter]=y;
            
            g.setColor(Color.yellow);
            g.fillOval(x, y, 20, 17);
            nodecounter++; 
            if(showNodes==1)
            {
            g.setColor(Color.black);
            g.drawString(""+nodecounter,x,y+14);
            }
        }
      
    
      void DrawNodes(int x, int y)
      {
         // pattern+=5;
          pattern%=4;
           //pattern 1
          if(pattern==0)
          { 
        DrawNCounter(x-40,y-40);
        
        DrawNCounter(x+30,y-40);
        
        DrawNCounter(x-40,y+40);
        
        DrawNCounter(x+40,y+40);
        
        DrawNCounter(x-5,y-80);
        
        DrawNCounter(x-5,y+75);
        
        DrawNCounter(x+60,y);
        
        DrawNCounter(x-70,y);
        
        pattern++;
          }
          
          else if(pattern==1)
          {
        
         DrawNCounter(x,y-80);
         DrawNCounter(x-65,y-45);
         DrawNCounter(x-70,y+30);
         DrawNCounter(x,y+70);
         DrawNCounter(x+60,y-45);
         DrawNCounter(x+50,y+45);
         DrawNCounter(x+15,y-45);
         DrawNCounter(x-25,y+25);
        pattern++;
          }
          else if(pattern==2)
          {
          DrawNCounter(x-8,y-90);
         DrawNCounter(x-65,y-45);
         DrawNCounter(x-70,y+30);
         DrawNCounter(x,y+70);
         DrawNCounter(x-40,y+40);
        
        DrawNCounter(x+40,y+40);
        
        DrawNCounter(x-5,y-55);
        
        DrawNCounter(x+30,y-15);
          pattern++;
          }
           else
          {
        
         DrawNCounter(x,y-60);
         DrawNCounter(x-25,y-45);
         DrawNCounter(x-50,y+30);
         DrawNCounter(x,y+70);
         DrawNCounter(x+60,y+35);
         DrawNCounter(x+10,y+45);
         DrawNCounter(x+45,y-45);
         DrawNCounter(x-25,y+25);
        pattern++;
          }
        
      }
      
      
      void DrawXNode(int x, int y)   // for regions which hav less than 8 nodes
      {
          
          if(s%8==1)
          {    
           DrawNCounter(x-40,y-40);
          }
          
          
        if(s%8==2)
       {
           DrawNCounter(x+30,y-40);
       
        
        DrawNCounter(x-40,y+40);
       }
        
        
        
        if(s%8==3)
        { DrawNCounter(x+40,y+40);
        
        DrawNCounter(x-5,y-80);
        
        DrawNCounter(x-5,y+75);
      }
        
        
        if(s%8==4)
        { 
            DrawNCounter(x+60,y);        
            DrawNCounter(x-70,y);
            DrawNCounter(x+30,y-40);
            DrawNCounter(x-40,y+40);
        }  
          
        
        if(s%8==5)
        {
        DrawNCounter(x+40,y+40);        
        DrawNCounter(x-5,y-80);        
        DrawNCounter(x-5,y+75);        
        DrawNCounter(x+30,y-40);              
        DrawNCounter(x-40,y+40);
        }
        
        if(s%8==6)
        {
        DrawNCounter(x+40,y+40);        
        DrawNCounter(x-5,y-80);        
        DrawNCounter(x-5,y+75);        
        DrawNCounter(x+30,y-40);              
        DrawNCounter(x-40,y+40);        
        DrawNCounter(x-40,y-40);     
        }
        
        if(s%8==7)
        {
        DrawNCounter(x+40,y+40);        
        DrawNCounter(x-5,y-80);        
        DrawNCounter(x-5,y+75);        
        DrawNCounter(x+30,y-40);               
        DrawNCounter(x-40,y+40);        
        DrawNCounter(x-40,y-40);        
        DrawNCounter(x+60,y);                
        }
        
        if(s%8==0)
        {
        
        DrawNCounter(x-40,y-40);        
        DrawNCounter(x+30,y-40);        
        DrawNCounter(x-40,y+40);        
        DrawNCounter(x+40,y+40);        
        DrawNCounter(x-5,y-80);        
        DrawNCounter(x-5,y+75);        
        DrawNCounter(x+60,y);        
        DrawNCounter(x-70,y);
        }
          
          
          
          
      }
      
      void DrawHexagon(int x,int y)
      {
        //g.setColor(Color.blue);  
        //g.drawString("R"+counter,x,y);
       /* g.setColor(Color.BLACK);
        g.drawLine(x,y-100,x-87,y-50);
        g.drawLine(x-87,y-50,x-87,y+50);
        g.drawLine(x-87,y+50,x,y+100);
        g.drawLine(x,y+100,x+87,y+50);
        g.drawLine(x+87,y+50,x+87,y-50);
        g.drawLine(x+87,y-50,x,y-100);   */
         counter++; 
         
         Polygon poly = new Polygon();  // declare and create
         poly.addPoint(x-87, y-50);  // add points to polygon
         poly.addPoint(x-87, y+50);
         poly.addPoint(x, y+100);
         poly.addPoint(x+87, y+50);
         poly.addPoint(x+87, y-50);
         poly.addPoint(x, y-100);

       
        g.setColor(Color.cyan);
        g.fillPolygon(poly);   //colouring pollygon..
        g.setColor(Color.red);
        g.drawPolygon(poly);    // polygon boundary
       
        //xternal gateway
        
        g.setColor(Color.MAGENTA);
        g.fillOval(x+42, y-79, 10, 8);
        g.fillOval(x-45, y-79, 10, 8);
        g.fillOval(x-90, y-4, 8, 10);
        g.fillOval(x-45, y+71, 10, 8);
        g.fillOval(x+42, y+71, 10, 8);
        g.fillOval(x+84, y-4, 8, 10);
       
        //REgion no.
        g.setColor(Color.blue);  
        g.drawString("R"+counter,x,y-15);
        
        
       CraftingPanel cp = new CraftingPanel();
       cp.paintComponent(g,x-10,y-5);
  
         
   /*     g.setColor(Color.GREEN);
        g.drawLine(x,y-100,x-87,y-50);
        g.drawLine(x-87,y-50,x-87,y+50);
        g.drawLine(x-87,y+50,x,y+100);
        g.drawLine(x,y+100,x+87,y+50);
        g.drawLine(x+87,y+50,x+87,y-50);
        g.drawLine(x+87,y-50,x,y-100);   */
         
      }
      
      public void nodeRepaint()
      {
          g=design.getGraphics();
            design.paint(g);
              infoFlag=0;
            repaint();
             try
            {
            
            for(int p=0;p<100;p++)
            {    
                Thread.sleep(6500);   
                if(stop==1)
                {    
                 break;
                }
                repaint();
                
               // g.drawString("repainting",200,500);
                //Thread.sleep(500);
                 //g.drawString("repainting sanket",200,x);
                 //x+=10;
                  //  g.drawString("repaint counter =" +repaintcounter,300,600);
            }
        }
        catch(InterruptedException e)
        {
        }
      }
      
      public void paint(Graphics g)
      {
          infoFlag=0;           // info panel is not being displayed
        repaintcounter++;
       counter=0;
nodecounter=0;
int x,y,z;
int count=0;

 s=iparticleNo;
 
 //if( s>220)
 //{
 //   g.drawString("ENTER STRING LESS THAN 220",400,400);
 //    return;
// }
     
/*
for(int i=0;i<(s/2);i++)
{
    
 drawRegion(x,y,z);
 
 y+=90;
 z+=90;
}
x=30;y=50;z=50;
for(int i=0;i<(s/2);i++)
{
   x+=90;
 z+=90; 
 drawRegion(x,y,z);
 
 
 
}*/


//drawing set of 4 regions each in 4 rows...
//it first draws horizontaly then goes next loop for new row 

x=100;y=100;
for(int i=0;i<s/32;i++)
{
    
    DrawHexagon(x,y);
    DrawNodes(x,y);
    x+=174;
    count++;
}

x=187;y=250;
for(int i=0;i<s/32;i++)
{
     DrawHexagon(x,y);
    DrawNodes(x,y);
    x+=174;
}
x=100;y=400;
for(int i=0;i<s/32;i++)
{
     DrawHexagon(x,y);
    DrawNodes(x,y);
    x+=174;
}
x=187;y=550;
for(int i=0;i<s/32;i++)
{
     DrawHexagon(x,y);
    DrawNodes(x,y);
    x+=174;
}


/*extra nodes*/
//for regions where nodes exceeding multiple of 32 nodes 0+ 32+ 64+ ......
int t=s%32;
int p;
if(t!=0)    //t is not zeroTh 32nd 64th ..... node
{   
    if(t%8!=0)    //t%8 is not zero i.e. not the 0 ,8th 16th 24th node...  
    {
        p=(t/8)+1;
    }      //gives the value from 0-3 and adding 1 gives 1-4 showing how many regions to add 
                    // for 1-7 gives 1 9-15 gives 2 ....and so on
    else
    {    
    p=t/8;
    }       // for 8th 16th 24th node gives 1,2,3.
}
else
{    
p=t/8; //for zero 32 64 nodes gives zero.
pattern++;
}




switch(p)
{
    
    //case 1 gives 1 region for next 8 nodes after multiple of 32
    case 1:  x=(count*174)+100;y=100;    
    
             {
              DrawHexagon(x,y);
                DrawXNode(x,y);
             x+=174;
             pattern++;
             }
             break;


    case 2:    //drawing 2 regions for next 16 nodes after multiple of 32.
                x=(count*174)+100;y=100;
                {
                     DrawHexagon(x,y);
                     DrawNodes(x,y);
                     x+=174;
                }
        
        
        
                x=(count*174)+187;y=250;
                {
                    DrawHexagon(x,y);
                    DrawXNode(x,y);
                   x+=174;
                }
                    break;

    case 3:   //drawing 3 regions for next 24 nodes after multiple of 32.
                x=(count*174)+100;y=100;
                {
                     DrawHexagon(x,y);
                    DrawNodes(x,y);
                    x+=174;
                }

        
        
                x=(count*174)+187;y=250;
                {
                     DrawHexagon(x,y);
                    DrawNodes(x,y);
                    x+=174;
                }
 
               
                x=(count*174)+100;y=400;
                {
                     DrawHexagon(x,y);
                    DrawXNode(x,y);
                    x+=174;
                    pattern++;
                }
                  break;
        
        
    case 4: //drawing 4 regions
        
                  x=(count*174)+100;y=100;
                 {
                      DrawHexagon(x,y);
                    DrawNodes(x,y);
                     x+=174;
                 }
        
        
        
                  x=(count*174)+187;y=250;   
                {
                    DrawHexagon(x,y);
                    DrawNodes(x,y);
                    x+=174;
                }
 
        
        
                x=(count*174)+100;y=400;
                {
                     DrawHexagon(x,y);
                    DrawNodes(x,y);
                    x+=174;
                }

        
 
                x=(count*174)+187;y=550;

                {
                 DrawHexagon(x,y);
                    DrawXNode(x,y);
                x+=174;
               
                }
                break;
        
        
      default: break;
           
 } 
/*

    int m=100,n=500;

int j=0;
    for(int i=0;i<nodecounter;i++)
    {  
        g.drawString("node"+(i+1)+"  x="+XArray[i],m,n);
        g.drawString("y="+YArray[i],m+150,n);
        n+=14;
        j++;
        if(j%30==0)
        {  m+=300;
            n=500;
        }
    
    }
    g.drawString("repaint paint counter =" +repaintcounter,500,300);

   */
      
}
      
      

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ok_button = new javax.swing.JButton();
        node = new javax.swing.JLabel();
        size = new javax.swing.JTextField();
        manet = new javax.swing.JButton();
        regionInfo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        stopMove = new javax.swing.JButton();
        showHide = new javax.swing.JButton();
        SPane = new javax.swing.JScrollPane();
        design = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 0, 0));
        jPanel1.setFocusCycleRoot(true);
        jPanel1.setFocusTraversalPolicyProvider(true);
        jPanel1.setName("PANEL"); // NOI18N
        jPanel1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jPanel1FocusGained(evt);
            }
        });

        ok_button.setBackground(new java.awt.Color(51, 0, 204));
        ok_button.setForeground(new java.awt.Color(255, 255, 0));
        ok_button.setText("build network");
        ok_button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ok_buttonActionPerformed(evt);
            }
        });

        node.setText("Total Nodes");

        size.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sizeActionPerformed(evt);
            }
        });

        manet.setText("start manet");
        manet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manetActionPerformed(evt);
            }
        });

        regionInfo.setText("show region info");
        regionInfo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regionInfoActionPerformed(evt);
            }
        });

        jLabel1.setText("Region info");

        stopMove.setText("stop Movemnet");
        stopMove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stopMoveActionPerformed(evt);
            }
        });

        showHide.setText("show/hide Nodes no.");
        showHide.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showHideActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(node, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)
                        .addComponent(regionInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ok_button, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(stopMove, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(showHide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(31, 31, 31)
                            .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(manet, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(node, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(size, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38)
                .addComponent(ok_button, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(manet)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(regionInfo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stopMove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(showHide)
                .addContainerGap(3613, Short.MAX_VALUE))
        );

        SPane.setToolTipText("");
        SPane.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        SPane.setAlignmentX(100);
        SPane.setAlignmentY(100);
        SPane.setAutoscrolls(false);
        SPane.setDoubleBuffered(true);
        SPane.setOpaque(false);
        SPane.setPreferredSize(new java.awt.Dimension(1600, 1600));

        design.setBackground(new java.awt.Color(255, 255, 255));
        design.setAutoscrolls(true);

        javax.swing.GroupLayout designLayout = new javax.swing.GroupLayout(design);
        design.setLayout(designLayout);
        designLayout.setHorizontalGroup(
            designLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 4548, Short.MAX_VALUE)
        );
        designLayout.setVerticalGroup(
            designLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 3941, Short.MAX_VALUE)
        );

        SPane.setViewportView(design);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(SPane, javax.swing.GroupLayout.PREFERRED_SIZE, 4038, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(326, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(SPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 3960, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jPanel1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jPanel1FocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel1FocusGained

    private void regionInfoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regionInfoActionPerformed
        // TODO add your handling code here:
        g=design.getGraphics();
        design.paint(g);
        infoFlag=1;
        stop=1;
        g.setColor(Color.blue);
        g.drawString("......The region information......",400,20);
        
        int m=50,n=50;

        int j=0;
        for(int i=0;i<nodecounter;i++)
        {
            if(i%8==0)
            {
                n+=10;
                g.setColor(Color.red);
                g.drawString("Region :"+((i/8)+1) ,m,n );
                n+=16;
            }
            
            g.setColor(Color.black);
            g.drawString("node"+(i+1)+"   x="+XArray[i]+ "  y="+YArray[i],m,n);
            n+=14;
            j++;

            if(j%40==0)
            {  m+=180;
                n=50;
            }

        }
        

    }//GEN-LAST:event_regionInfoActionPerformed

    private void manetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manetActionPerformed
        // TODO add your handling code here:
String siparticleNo=size.getText();
 iparticleNo=Integer.parseInt(size.getText());
        new Thread(
            new Runnable() {
                public void run() {
                    nodeRepaint();
                }
            }
        ).start();
    }//GEN-LAST:event_manetActionPerformed

    private void sizeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sizeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sizeActionPerformed

    private void ok_buttonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ok_buttonActionPerformed

        // TODO add your handling code here:

        String siparticleNo=size.getText();//Getting Values from Text box SWARM_SIZE
        //String silink=LINK.getText();//Getting Values from Text box LINK
        //String siIterNo=ITER.getText();//Getting Values from Text box ITER
        g=design.getGraphics();
        design.paint(g);//For drawing Object in Design PANEL
        SPane.revalidate(); //update the scrollpane to current panel size
        //  repaint();

        //  g=SPane.getGraphics();

        //SPane.paint(g);
        boolean bflag=true;//Validation

        //design.repaint();
        iparticleNo=Integer.parseInt(size.getText());
        s=iparticleNo;
//        if(s<10)
//        {    
//        JOptionPane.showMessageDialog (null, "s less than 10", "msg1", JOptionPane.INFORMATION_MESSAGE);
//        }
//        else if(s>100)
//        {
//            JOptionPane.showMessageDialog (null, "s less than 100", "msg2", JOptionPane.WARNING_MESSAGE);
//        }
//        else
//        {   
//            JOptionPane.showMessageDialog (null, "s more tha 100", "msg3", JOptionPane.ERROR_MESSAGE);
//        }
        repaint();
        infoFlag=0;
        
        //try
        //{
            /*    int x=300;
            for(int p=0;p<10;p++)
            {
                Thread.sleep(500);
                SPane.repaint();
                g.drawString("repainting",200,500);
                Thread.sleep(500);
                g.drawString("repainting sanket",200,x);
                x+=10;
                g.drawString("repaint counter =" +repaintcounter,300,600);
            }
        }
        catch(InterruptedException e)
        {
        }
        repaint();

        */

           

    }//GEN-LAST:event_ok_buttonActionPerformed

    private void stopMoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stopMoveActionPerformed
     stop=1;
        // TODO add your handling code here:
    }//GEN-LAST:event_stopMoveActionPerformed

    private void showHideActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showHideActionPerformed
        // TODO add your handling code here:
        ////...........toggle States show/hide.........////
       if(infoFlag!=1)
       {if(showNodes==0)
        
          showNodes=1;
        else
           showNodes=0;
        
          /////////////////////////////////
        
            if (showNodes==1)
            {
               g=design.getGraphics();
                for(int i=0;i<nodecounter;i++)
                {
                   g.drawString(""+(i+1),XArray[i],(YArray[i]+14)) ;
                   
                }
            }
            if(showNodes==0)
            {
                g=design.getGraphics();
                for(int i=0;i<nodecounter;i++)
                {
                g.setColor(Color.yellow);
                g.fillOval(XArray[i],YArray[i], 20, 17);
                }
            }
            
        
        
       }
    }//GEN-LAST:event_showHideActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ex2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ex2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ex2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ex2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ex2() {
                    

                    
                    
                }.setVisible(true);
            }
        });
        
    }
    
    
    /**
     *
     */
 
  

  
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JScrollPane SPane;
    public javax.swing.JPanel design;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton manet;
    private javax.swing.JLabel node;
    private javax.swing.JButton ok_button;
    private javax.swing.JButton regionInfo;
    private javax.swing.JButton showHide;
    private javax.swing.JTextField size;
    private javax.swing.JButton stopMove;
    // End of variables declaration//GEN-END:variables
}

