package com.priyasoft.jdbc;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DisplayData {

	public static void main(String[] args) {
		FileOutputStream fos;
		Connection con= null;
		Statement st=null;
		ResultSet rs=null;
		try{
			Class.forName("oracle.jdbc.OracleDriver");
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","admin");
			st=con.createStatement();
			rs=st.executeQuery("select * from emp1");
			String data="";
			
			data=data+"ENO,ENAME,ESAL,EADDR\n";
			while(rs.next()){
				
				data=data+rs.getInt("ENO")+",";
				data=data+rs.getString("ENAME")+",";
				data=data+rs.getFloat("ESAL")+",";
				data=data+rs.getString("EADDR")+".\n";
				
				
			}
			fos=new FileOutputStream("E:/document/emp.txt");
			byte[] b=data.getBytes();
			fos.write(b);
			System.out.println("Data Transfered to E:/Document/emp.txt");
		}catch(Exception e)
		{
			e.printStackTrace();
		}finally{
			try{
			rs.close();
			st.close();
			con.close();
			}catch(Exception e)
			{
				e.printStackTrace();
			}
		}

	}

}
