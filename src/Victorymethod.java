package org.liky.game.frame;

public class Victorymethod {
	
	
	public  int Victory(int t[][]){
	int blackV=0;
	int whiteV=0;
	int bz=0;
	int wz=0;
	int bxf=0;
	int wxf=0;
	int bxz=0;
	int wxz=0;
	int fl=0;
	outter1:{for(int i=0;i<19;i++)
			{
			for(int j=0;j<19;j++)
				{
				if(t[i][j]==1&&whiteV<5)
					{blackV++;whiteV=0;}
				else 
					{
					if(t[i][j]==2&&blackV<5)
					{whiteV++;blackV=0;}
					else
					{whiteV=0;blackV=0;}
					}   
			if(blackV>=5) {fl= 1; break outter1;}
			if(whiteV>=5) {fl= 2; break outter1;}
			}
			
			}
	}
	outter2:{
		for(int i=0;i<19;i++)
		{
			for(int j=0;j<19;j++) 
			 {if(t[j][i]==1&&wz<5)
		    	{bz++;wz=0;}
		    else 
		    {
		    	if(t[j][i]==2&&bz<5)
		    		{wz++;bz=0;}
		    	else {wz=0;bz=0;}
		    }
		if(bz>=5) {fl= 1; break outter2;}
		if(wz>=5) {fl= 2; break outter2;}
		    }
	
	}
	}
	outter3: {
		for(int i=0;i<19;i++)
		 for(int j=0;j<19;j++)
		 {
			 if(t[i][j]==1&&wxf<5)
			 {	 
				 for(int m=i, n=j;m<19&&n<19;m++,n++)
				 {
					 if(t[m][n]==1)
					 { bxf++;wxf=0;}
					 else 
					 {
						 if(bxf<5) bxf=0;wxf=0;
					 }
				 }
			 }
			 else
			 { if(t[i][j]==2&&bxf<5)
			 {
				 for(int m=i, n=j;m<19&&n<19;m++,n++)
				 {
					 if(t[m][n]==2)
					 { wxf++;bxf=0;}
					 else 
					 { 
						 if(wxf<5) wxf=0;bxf=0;
						 }
				 }
			 }
			 else {bxf=0;wxf=0;}
			 }
			 if(bxf>=5){fl=1;break outter3;}
			 if(wxf>=5){fl=2;break outter3;}
		 }
	}
	
	
	
	 outter4:{
		for(int i=0;i<19;i++)
		 for(int j=0;j<19;j++)
		 {
			 if(t[i][j]==1&&wxz<5)
			 {	 
				 for(int m=i, n=j;m<19&&m>=0&&n<19&&n>=0;m++,n--)
				 {
					 if(t[m][n]==1)
					 { bxz++;wxz=0;}
					 else {
							 if(bxz<5) bxz=0;wxz=0;
						  }
				 }
			 }
			 else
			 { if(t[i][j]==2&&bxz<5)
			 {
				 for(int m=i, n=j;m<19&&m>=0&&n<19&&n>=0;m++,n--)
				 {
					 if(t[m][n]==2)
					 { wxz++;bxz=0;}
					 else {
						 if(wxz<5) wxz=0;bxz=0;
					 }
				 }
			 }
			 else {bxz=0;wxz=0;}
			 }
			 if(bxz>=5){fl=1;break outter4;}
			 if(wxz>=5){fl=2;break outter4;} 
		 }
	}
	
	 
	 
	 
	 return fl;
	        }
}

