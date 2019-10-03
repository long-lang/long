package tableprocesser;

import java.lang.annotation.Annotation;
import java.util.HashMap;
import java.util.Map;
import java.lang.reflect.Field;

public class TableInfo {
	private String tableName;
	private  Class<?> clazz;
	private boolean needPersist = false;
	private Map<String, ColumInfo> columns = new HashMap<String, ColumInfo>();

	public  TableInfo parse(Class<?> clazz) {
		this.clazz = clazz;
		this.tableName = this.clazz.getSimpleName();
		Annotation[] annotations = this.clazz.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(Entity.class)) {
				this.needPersist = true;
				Entity entity = (Entity) annotation;
				if (!entity.value().equals("")) {
					this.tableName = entity.value();
				}
				break;
			}
		}
		if (this.needPersist) {
			Field[] fields = this.clazz.getDeclaredFields();
			for (Field field : fields) {
				ColumInfo colum = new ColumInfo();
				colum = colum.parse(field);
				if (colum != null) {
					this.columns.put(field.getName(), colum);
				}
			}
			return this;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuilder sql = new StringBuilder();
		sql.append(Symbol.LINE);
		sql.append("CREATE TABLE");
		sql.append(this.tableName + Symbol.BLANK);
		sql.append("(");
		for (ColumInfo colum : this.columns.values()) {
			sql.append(Symbol.LINE);
			sql.append(Symbol.TAB);
			sql.append(colum.toString());
		}
		sql.append(Symbol.LINE);
		sql.append("):");
		return sql.toString();
	}
}
