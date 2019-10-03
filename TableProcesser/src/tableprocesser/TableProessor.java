package tableprocesser;
import java.lang.annotation.*;
import java.io.File;
import java.util.List;





public class TableProessor {
	public String process(String url) throws Exception{
		List<File> classFiles = Scanner.getClassFiles(url);
		StringBuilder sql= new StringBuilder();
		
		for(File file:classFiles) {
			Class<?>clazz = ClassFileLoader.loadClass(file);
			TableInfo Table = new TableInfo();
			TableInfo table = Table.parse(clazz);
			if(table != null)
				sql.append(table.toString());
		}
		return sql.toString();
	}
}
