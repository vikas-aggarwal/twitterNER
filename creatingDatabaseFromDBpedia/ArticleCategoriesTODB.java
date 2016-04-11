import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.jena.graph.Node;
import org.apache.jena.graph.Triple;
import org.apache.jena.query.Dataset;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.StmtIterator;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.system.StreamRDF;
import org.apache.jena.sparql.core.Quad;

public class ArticleCategoriesTODB
{

	public static void main(String[] args) throws SQLException, ClassNotFoundException
	{
		
	  
	      Class.forName("org.sqlite.JDBC");
	      final Connection c = DriverManager.getConnection("jdbc:sqlite:D:\\iiit\\title_cat.db");
	      c.setAutoCommit(false);
	      final PreparedStatement prep = c.prepareStatement("insert into title_category values(?,?)");
	      
	      
	    System.out.println("Opened database successfully");
		// TODO Auto-generated method stub
		RDFDataMgr.parse(new StreamRDF()
		{
			
			int noOfRecordsInBuffer;
			List<String []> buffer = new ArrayList<String[]>();
			
			@Override
			public void triple(Triple arg0)
			{
				// TODO Auto-generated method stub
				Node sub = arg0.getSubject();
				Node pred = arg0.getPredicate();
				Node obj = arg0.getObject();
				
				String subStr = sub.toString();
				subStr = subStr.substring(28);
				String objStr = obj.toString();
				objStr = objStr.substring(28);				
				//System.out.println(subStr+"  "+objStr);
				
				String [] data = new String[2];
				data[0]=subStr.toLowerCase();
				data[1] = objStr;
				
				buffer.add(data);
				noOfRecordsInBuffer++;
				
				if(noOfRecordsInBuffer < 1000000)
				{
					return;
				}

				for(int i = 0; i < noOfRecordsInBuffer; i++)
				{
					try
					{
						prep.setString(1, buffer.get(i)[0]);
					} catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					try
					{
						prep.setString(2, buffer.get(i)[1]);
					} catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					try
					{
						prep.execute();
					} catch (SQLException e)
					{
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				try
				{
					System.out.println("Committed");
					c.commit();
					buffer = new ArrayList<String[]>();
					noOfRecordsInBuffer=0;
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				return;
			}
			
			@Override
			public void start()
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void quad(Quad arg0)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void prefix(String arg0, String arg1)
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void finish()
			{
				// TODO Auto-generated method stub
				try
				{
					c.close();
				} catch (SQLException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			@Override
			public void base(String arg0)
			{
				// TODO Auto-generated method stub
				
			}
		},"D:\\iiit\\article-categories_en.nt") ;
	
	}

}
