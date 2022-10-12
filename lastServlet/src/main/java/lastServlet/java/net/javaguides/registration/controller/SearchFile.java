package lastServlet.java.net.javaguides.registration.controller;



public class SearchFile {

	public static boolean SearchTextFile(String [][] data, String userName, String emailAddress) {
		
		for ( int i =0; i < data.length; i ++  )
		{
			for ( int j = 0; j < data[i].length;j ++)
			{
				//System.out.println("data = " + data[i][j] + " this is i = " + i + " this is j =" + j);
				if ( data[i][j] == null || data[i][j].isEmpty())
					return false; 
				if ( data[i][j].equals("userName") || data[i][j].equals(emailAddress))
				{
//					System.out.println("The username was : " + userName + "and the emailAddress was " + emailAddress + "and the array is" + data[i][j]);
					return true; 
				}
			}
		}
		return false; 
	}

//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}
}
