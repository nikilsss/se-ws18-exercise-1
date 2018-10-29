import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Image{

	public int width;
	public int height;
	public byte[] data;
	public int pos;
	public int valRgb, maxval=255;
	int rgbmax=0xFFFFFF;
	
	public Image(int width, int height) {
		
		this.width = width;
		this.height = height;
		this.data=new byte[width*height*3];
	}
	


		public void set(int x, int y, int maxval) {
		// TODO Auto-generated method stub
		
	
		valRgb=rgbmax & maxval;
		String string="0x"+ Integer.toHexString(valRgb);
		pos=x*width*3+y*3;
		data[pos]=(byte)(maxval>>8); 
		data[pos+1]=(byte)(maxval>>8);
		data[pos+2]=(byte)(maxval>>8);
	}
	
	public void write(String filename) throws IOException {	
		
		FileWriter filewriter = new FileWriter(filename);
		BufferedWriter bufferwriter= new BufferedWriter(filewriter);
		String assingment="p6\t" + width + "\t" + height + "\t" ;
		bufferwriter.write(assingment);
		 for(int i=0;i<height;i++){
			 bufferwriter.newLine();
			 for(int j=0;j<width;j++){
				 int pos = i * width * 3 + j * 3;
				 bufferwriter.write((((byte)(data[pos]))+"\t"));
				 bufferwriter.write((((byte)(data[pos + 1]))+"\t"));
				 bufferwriter.write((((byte)(data[pos + 2]))+"\t"));
				 
			 }
	 }
		bufferwriter.close();
		
	}




	
	
	
}
	
	
	
	
	

	
	
	
	
	
	
	

	
	
	

