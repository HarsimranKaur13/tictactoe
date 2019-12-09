import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
class TicTacToe implements ActionListener
{
	JButton b[][]=new JButton[3][3];
	JFrame jf=new JFrame("TIC TAC TOE");
	JPanel p[]=new JPanel[2];
	JLabel ta=new JLabel("GAME-TIC TAC TOE   (GREEN-WON,RED-DRAW)");
	JButton tb[]=new JButton[2];
	String x[]=new String[3];
	int i,j,u,v,m,n,gx,gy;
	static int count;
	int flag=0,prob=0,won=0;
	int arr[][]={{0,0,0},{0,0,0},{0,0,0}};
	int arr_check[][]={{0,0,0},{0,0,0},{0,0,0}};

	TicTacToe(int ff)
	{
		if(ff==1)
			{x[0]="DOUBLE PLAYER";
			x[1]="SINGLE PLAYER";
			x[2]="RESET";}
		else
			{x[0]="SINGLE PLAYER";
			x[1]="DOUBLE PLAYER";
			x[2]="RESET";}
		p[0]=new JPanel();
		for(i=0;i<b.length;i++)
		{
			for(j=0;j<b[i].length;j++)
			{
			b[i][j]=new JButton();
			b[i][j].addActionListener(this);
			p[0].add(b[i][j]);
			}
		}
		p[1]=new JPanel();
		tb[0]=new JButton(x[0]);
		tb[1]=new JButton(x[2]);
		for(i=0;i<tb.length;i++)
		{
			
			tb[i].addActionListener(this);
			p[1].add(tb[i]);
		}
		p[1].setLayout(new FlowLayout(FlowLayout.CENTER));
		p[0].setLayout(new GridLayout(3,3));

		jf.add(ta,BorderLayout.NORTH);
		jf.add(p[0],BorderLayout.CENTER);
		jf.add(p[1],BorderLayout.SOUTH);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setSize(300,300);
		jf.setVisible(true);
	}
	public void check(String str,int u,int v){
		int caught=0,mark=0;
		if(u-v>=0||v-u>=0){
			if(u==0)
				if(b[u+1][v].getText()==str&&b[u+2][v].getText()==str) {b[u+1][v].setBackground(Color.green);b[u+2][v].setBackground(Color.green);caught=1;}
			if(u==1)
				if(b[u-1][v].getText()==str&&b[u+1][v].getText()==str) {b[u-1][v].setBackground(Color.green);b[u+1][v].setBackground(Color.green);caught=1;}
			if(u==2)
				if(b[u-1][v].getText()==str&&b[u-2][v].getText()==str) {b[u-1][v].setBackground(Color.green);b[u-2][v].setBackground(Color.green);caught=1;}
			if(v==0)
				if(b[u][v+1].getText()==str&&b[u][v+2].getText()==str) {b[u][v+1].setBackground(Color.green);b[u][v+2].setBackground(Color.green);caught=1;};
			if(v==1)
				if(b[u][v-1].getText()==str&&b[u][v+1].getText()==str) {b[u][v-1].setBackground(Color.green);b[u][v+1].setBackground(Color.green);caught=1;}
			if(v==2)
				if(b[u][v-1].getText()==str&&b[u][v-2].getText()==str) {b[u][v-1].setBackground(Color.green);b[u][v-2].setBackground(Color.green);caught=1;}
		}
		if(u-v==2||v-u==2||v-u==0||v-u==0){
			if(u==0){
					if(v==0)
						if(b[u+1][v+1].getText()==str&&b[u+2][v+2].getText()==str) {b[u+1][v+1].setBackground(Color.green);b[u+2][v+2].setBackground(Color.green);caught=1;}					
					if(v==2)
						if(b[u+1][v-1].getText()==str&&b[u+2][v-2].getText()==str) {b[u+1][v-1].setBackground(Color.green);b[u+2][v-2].setBackground(Color.green);caught=1;}
				}				
			if(u==1){
					if(v==1)
						{if(b[u-1][v-1].getText()==str&&b[u+1][v+1].getText()==str) {b[u-1][v-1].setBackground(Color.green);b[u+1][v+1].setBackground(Color.green);caught=1;}
						if(b[u-1][v+1].getText()==str&&b[u+1][v-1].getText()==str) {b[u-1][v+1].setBackground(Color.green);b[u+1][v-1].setBackground(Color.green);caught=1;}}
				}
			if(u==2){
					if(v==0)
						if(b[u-1][v+1].getText()==str&&b[u-2][v+2].getText()==str) {b[u-1][v+1].setBackground(Color.green);b[u-2][v+2].setBackground(Color.green);caught=1;}
					if(v==2)
						if(b[u-1][v-1].getText()==str&&b[u-2][v-2].getText()==str) {b[u-1][v-1].setBackground(Color.green);b[u-2][v-2].setBackground(Color.green);caught=1;}
				}
		}
		if(caught==1) {System.out.println("WIN"); b[u][v].setBackground(Color.green); won=1;}
		else {for(i=0;i<arr.length;i++)
			for(j=0;j<arr[i].length;j++)
			{if(arr[i][j]==0) mark=1;
		}
		if(caught==0&&mark==0){
			System.out.println("DRAW");
			for(i=0;i<b.length;i++)
				for(j=0;j<b[i].length;j++)
				b[i][j].setBackground(Color.red);
			won=1;
		}}
	}
	public int decide(String str, int c,int d)
	{
		int ch=0,p=0,q=0;
		if(str=="X") {p=m; q=n;m=c; n=d;}
				if(c==0){
					if(b[c+1][d].getText()==str&&arr[c+2][d]==0) {m=m+2; ch=1;}
					if(b[c+2][d].getText()==str&&arr[c+1][d]==0) {++m; ch=1;}	
					if(d==1){
						if(b[c][d+1].getText()==str&&arr[c][d-1]==0) {--n; ch=1;}
						if(b[c][d-1].getText()==str&&arr[c][d+1]==0) {++n; ch=1;}
						}
					if(d==0){
						if(b[c][d+1].getText()==str&&arr[c][d+2]==0){n=n+2; ch=1;}
						if(b[c][d+2].getText()==str&&arr[c][d+1]==0){++n; ch=1;}
						}
					if(d==2){
						if(b[c][d-1].getText()==str&&arr[c][d-2]==0){n=n-2; ch=1;}
						if(b[c][d-2].getText()==str&&arr[c][d-1]==0){--n; ch=1;}				
						}
					}
				if(c==1){
					if(b[c-1][d].getText()==str&&arr[c+1][d]==0) {++m; ch=1;}
					if(b[c+1][d].getText()==str&&arr[c-1][d]==0) {--m; ch=1;}
					if(d==0){
						if(b[c][d+1].getText()==str&&arr[c][d+2]==0) {n=n+2; ch=1;}
						if(b[c][d+2].getText()==str&&arr[c][d+1]==0) {++n; ch=1;}
						}
					if(d==1){
						if(b[c][d+1].getText()==str&&arr[c][d-1]==0) {--n; ch=1;}
						if(b[c][d-1].getText()==str&&arr[c][d+1]==0) {++n; ch=1;}
						}
					if(d==2){
						if(b[c][d-1].getText()==str&&arr[c][d-2]==0) {n=n-2; ch=1;}
						if(b[c][d-2].getText()==str&&arr[c][d-1]==0) {--n; ch=1;}
						}
					}
				if(c==2){
					if(b[c-1][d].getText()==str&&arr[c-2][d]==0) {m=m-2; ch=1;}
					if(b[c-2][d].getText()==str&&arr[c-1][d]==0) {--m; ch=1;}
					if(d==1){
						if(b[c][d-1].getText()==str&&arr[c][d+1]==0) {++n; ch=1;}
						if(b[c][d+1].getText()==str&&arr[c][d-1]==0) {--n; ch=1;}
						}
					if(d==0){
						if(b[c][d+1].getText()==str&&arr[c][d+2]==0) {n=n+2; ch=1;}
						if(b[c][d+2].getText()==str&&arr[c][d+1]==0) {++n; ch=1;}
						}
					if(d==2){
						if(b[c][d-1].getText()==str&&arr[c][d-2]==0) {n=n-2; ch=1;}
						if(b[c][d-2].getText()==str&&arr[c][d-1]==0) {--n; ch=1;}
						}
					}
		if(c-d!=1||d-c!=1){
				if(c==0){
					if(d==0){if(b[c+1][d+1].getText()==str&&arr[c+2][d+2]==0) {m=m+2; n=n+2; ch=1;}
					 	if(b[c+2][d+2].getText()==str&&arr[c+1][d+1]==0) {++m; ++n; ch=1;}}
					if(d==2){if(b[c+1][d-1].getText()==str&&arr[c+2][d-2]==0){m=m+2; n=n-2; ch=1;}
					 	if(b[c+2][d-2].getText()==str&&arr[c+1][d-1]==0){++m; --n; ch=1;}}
					}
				if(c==1&&d==1){
					if(b[c-1][d-1].getText()==str&&arr[c+1][d+1]==0){++m; ++n; ch=1;}
					if(b[c+1][d+1].getText()==str&&arr[c-1][d-1]==0){--m; --n; ch=1;}
					if(b[c-1][d+1].getText()==str&&arr[c+1][d-1]==0){++m; --n; ch=1;}
					if(b[c+1][d-1].getText()==str&&arr[c-1][d+1]==0){--m; ++n; ch=1;}
					      }
				if(c==2){
					if(d==0){if(b[c-1][d+1].getText()==str&&arr[c-2][d+2]==0){m=m-2; n=n+2; ch=1;}
						 if(b[c-2][d+2].getText()==str&&arr[c-1][d+1]==0){--m; ++n; ch=1;}}
					if(d==2){if(b[c-1][d-1].getText()==str&&arr[c-2][d-2]==0){m=m-2; n=n-2; ch=1;}
						if(b[c-2][d-2].getText()==str&&arr[c-1][d-1]==0){--m; --n; ch=1;}}
					}
				}
		if(str=="X"&&ch==0)
		{
			m=p; n=q;
		}
		return(ch);
	}
	public int trying(String str,int g,int h)
	{
		int got=0,check=0;
		System.out.println(g+","+h);
		if(flag==3&&((u==0&&v==1&&gx==1&&gy==0)||(u==1&&v==0&&gx==0&&gy==1)))
		{
			m=0; n=0; got=1;
		}
		else{
		if(g==0){
				if(arr[g+1][h]==0&&arr[g+2][h]==0) {++m; got=1;}
				else{
					if(h==0){
						if(arr[g][h+1]==0&&arr[g][h+2]==0) {++n; got=1;}
						}
					if(h==1){
						if(arr[g][h-1]==0&&arr[g][h+1]==0) {++n; got=1;}	
						}
					if(h==2){
						if(arr[g][h-1]==0&&arr[g][h-2]==0) {--n; got=1;}
						}	
				}	
			}
		if(g==1){
				if(arr[g-1][h]==0&&arr[g+1][h]==0) {++m; got=1; if(h==1) check=1;}
				else{
					if(h==0){
						if(arr[g][h+1]==0&&arr[g][h+2]==0) {++n; got=1;}		
						}
					if(h==1){
						if(arr[g][h-1]==0&&arr[g][h+1]==0) {++n; got=1; check=1;}	
						}
					if(h==2){
						if(arr[g][h-1]==0&&arr[g][h-2]==0) {--n; got=1;}
						}
				     }
			}
		if(g==2){
				if(arr[g-1][h]==0&&arr[g-2][h]==0) {--m; got=1;}
				else{
					if(h==0){
						if(arr[g][h+1]==0&&arr[g][h+2]==0) {++n; got=1;}
						}
					if(h==1){
						if(arr[g][h-1]==0&&arr[g][h+1]==0) {++n; got=1;}
						}
					if(h==2){
						if(arr[g][h-1]==0&&arr[g][h-2]==0) {--n; got=1;}	
						}
				     }
			}
		if(g-h==0||h-g==0||h-g==2||g-h==2){
			if(g==0){
				if(h==0){if(arr[g+1][h+1]==0&&arr[g+2][h+2]==0) {++m; ++n; got=1;}}
				if(h==2){if(arr[g+1][h-1]==0&&arr[g+2][h-2]==0) {++m; --n; got=1;}}
				}
			if(g==1&&check==0){
				if(arr[g-1][h-1]==0&&arr[g+1][h+1]==0){++m; ++n; got=1;}
				else { if(arr[g+1][h-1]==0&&arr[g-1][h+1]==0){++m; --n; got=1;} }
					  }	
			if(g==2){
				if(h==0){if(arr[g-1][h+1]==0&&arr[g-2][h+2]==0){--m; ++n;got=1;}}
				if(h==2){if(arr[g-1][h-1]==0&&arr[g-2][h-2]==0){--m; --n;got=1;}}
				}
						 }
		}
		return(got);
	}
	public void actionPerformed(ActionEvent e)
	{
		//int ff_copy=ff;
		JButton btn=(JButton)e.getSource();
		if(won==0)
		{			//won
		if(btn.getParent()==p[0]){		//zero panel
					for(i=0;i<b.length;i++)
						for(j=0;j<b[i].length;j++){			//position of x
							if(b[i][j]==btn){u=i; v=j; }		
								          }			//position of x end
					btn.removeActionListener(this);
					if(tb[0].getText()=="DOUBLE PLAYER"){  		 	//double player
						if(arr[u][v]==0)
						{
						++flag;
						if(flag%2!=0){	
							btn.setText("X");
							arr[u][v]=1;
							check("X",u,v);
							     }
						else{
							btn.setText("O");
							arr[u][v]=1;
							check("O",u,v);
						    } 
						}	
									   }	//double player end
					else{					//single player
						if(arr[u][v]==0){		//print x
							++flag;
							btn.setText("X");
							arr[u][v]=1;
								}		//print x end
						if(flag==1){		//flag=1	
							if(u==1&&v==1)
								{m=0; n=0; prob=1;}
							else
								{if(u-v==1) {gx=u; gy=v;} m=1;n=1;}
					   	  	   }			//flag=1 end
						else {				//flag!=1
							if(decide("O",m,n)==1){System.out.println("O"+m+","+n);}
							else if(decide("X",u,v)==1){System.out.println("X"+m+","+n);}
							else if(flag==3&&prob==1&&(u-v==0||v-u==0||u-v==2||v-u==2)) 
								{ System.out.println("hurray"); if(arr[0][2]==0) {m=0; n=2;}}
							
							else if(trying("O",m,n)==1){System.out.println("trying");}
							else{
									for(i=0;i<b.length;i++)	
										for(j=0;j<b[i].length;j++){
											if(arr[i][j]==0){m=i;n=j;}
													   }		
							     }
						     }		//flag!=1 end
						b[m][n].setText("O"); arr[m][n]=1; ++flag;
						check("O",m,n);b[m][n].removeActionListener(this);
					     }			//single player end
					}			//zero panel end
		if(btn.getParent()==p[1]){
			if(btn.getText()=="SINGLE PLAYER")
				{
				new TicTacToe(1);
				}
			else if(btn.getText()=="DOUBLE PLAYER")
				{
				new TicTacToe(0);}	
			else{
				if(btn.getText()=="RESET") ;
				{
				if(tb[0].getText()=="DOUBLE PLAYER")
				new TicTacToe(1);
				else
				new TicTacToe(0);
				}
			    }
				jf.setVisible(false);
				
					 }
	} //won end
	else
	{
		
		jf.setVisible(false);
		if(tb[0].getText()=="DOUBLE PLAYER")
				new TicTacToe(1);
				else
				new TicTacToe(0);
	}
	}		//action performed end
	public static void main(String args[]){
	new TicTacToe(1);	
	}
}