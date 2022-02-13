
import java.io.File;
import java.io.IOException;
import java.nio.file.DirectoryNotEmptyException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Scanner;
import java.nio.file.*;

public class lockedme {
	
	public static void readList() {
		Scanner f=new Scanner(System.in);
		System.out.println("Enter file location");
		String filename=f.next();
	    String[] pathnames;

        File file = new File(filename);

        pathnames = file.list();
        int n;
        n=pathnames.length;
        String temp;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                // to compare one string with other strings
                if (pathnames[i].compareTo( pathnames[j]) > 0) {
                    // swapping
                    temp =  pathnames[i];
                    pathnames[i] =  pathnames[j];
                    pathnames[j] = temp;
                }
            }
        }
        System.out.println("\n***Files in ASC Order***\n");
        for (String pathname : pathnames) {
          
            System.out.println(pathname);
        }
		
	}
	
	public static void addFile() throws IOException {
		System.out.println("\n***Add Files***\n");
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter file path");
		String path=s1.next();
		Scanner s2=new Scanner(System.in);
		System.out.println("Enter file name to add:");
		String filename=s2.next();
		String path1=path+filename;
		System.out.println(path1);
		File file=new File(path1);
		if(file.createNewFile()) {
		System.out.println("File Added Successfully");

	
		}else {
			System.out.println("File already exists");
		}
		}

		public static void deleteFile(){
		
				System.out.println("\n***Delete Files***\n");
				Scanner s3=new Scanner(System.in);
				System.out.println("Enter file path");
				String filename1=s3.next();
				Scanner s4=new Scanner(System.in);
				System.out.println("Enter file name to delete:");
				String inputFile1 =s4.next();
				String path2=filename1+inputFile1;
			
				 File files= new File(path2);
			 
				  if (files.delete()) {
			            System.out.println("File deleted successfully");
			        }
			        else {
			            System.out.println("Failed to delete the file");
			        }
	
			

	}
		public static void searchFile()throws IOException{
			System.out.println("\n***Search Files***\n");
			Scanner sc5= new Scanner(System.in);
			System.out.println("Enter file path for search:");
			String path= sc5.next();
			File directory = new File(path);
			Scanner sc6= new Scanner(System.in);
			System.out.println("Enter file name to search:");
			String fname=sc6.next();
			
			  
	        String[] flist = directory.list();
	        int flag = 0;
	        if (flist == null) {
	            System.out.println("Empty directory.");
	        }
	        else {
	  
	            // Linear search in the array
	            for (int i = 0; i < flist.length; i++) {
	                String filename = flist[i];
	                if (filename.equalsIgnoreCase(fname)) {
	                    System.out.println(filename + " found");
	                    flag = 1;
	                }
	            }}
	        
	        if (flag == 0) {
	            System.out.println("File Not Found");
	        }
			
		}
	public static void main(String args[]) throws IOException {
		    System.out.println("\n**************************************\n");
	        System.out.println("\tLockers Pvt. Ltd. \n \tDeveloped by : Er. Saurabh R. Shinde ");
	        System.out.println("\n**************************************\n");
	        while(true) {
	        Scanner sc=new Scanner(System.in);
	        System.out.println("\n 1.Show files in ASC order \n 2.Add File \n 3.Delete File \n 4.Search File \n 5.Close App \n");
	        System.out.println("Enter operations:");
	        int ch=sc.nextInt();
	
	        
	        switch(ch) {
	        case 1:
	        	
	        	readList();
	        	
	        	break;
	        	
	        case 2:
	        
	        	addFile();
	        	break;
	        case 3:
	        	
	        	deleteFile();
	        	break;
	        case 4:
	        	
	        	searchFile();
	        	break;
	        case 5:
	        	System.out.println("Closing your application... \nThank you!");
	        	System.exit(0);
	        	break;
	        default:
	        	System.out.println("Wrong choice....");
	        	break;
	        	
	        }
	     
	        	
	}      
		
	}

}
