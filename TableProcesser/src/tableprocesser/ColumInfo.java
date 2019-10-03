package tableprocesser;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class ColumInfo {
	private String columName;
	private Class<?> type;
	private boolean isID = false;
	private boolean nullable = true;
	private int length = 32;
	private boolean needPersist = false;

	public ColumInfo parse(Field field) {
		this.columName = field.getName();
		this.type = field.getType();
		Annotation[] annotations = field.getAnnotations();
		for (Annotation annotation : annotations) {
			if (annotation.annotationType().equals(Colum.class)) {
				this.needPersist = true;
				Colum colum = (Colum) annotation;
				if (!colum.value().equals("")) {
					this.columName = colum.value();
				}
				this.nullable = colum.nullable();
				if (colum.length() != 1) {
					this.length = colum.length();
				}
			} else if (annotation.annotationType().equals(ID.class)) {
				this.needPersist = true;
				ID id = (ID) annotation;
				this.isID = true;
				if (!id.value().equals("")) {
					this.columName = id.value();
				}
			}
		}
		if (this.needPersist) {
			return this;
		} else {
			return null;
		}
	}

	@Override
	public String toString() {
		StringBuilder sql = new StringBuilder(columName);
		if (this.type.equals(String.class)) {
			sql.append(Symbol.BLANK + "VARCHER" + this.length + ")");
		} else if (this.type.equals(Integer.class)) {
			sql.append(Symbol.BLANK + "INT");
		}
		if (this.isID) {
			sql.append(Symbol.BLANK + "PRIMARY KEY");
		}
		if (!this.nullable) {
			sql.append(Symbol.BLANK + "NOT NULL");
		}
		sql.append(";");
		return sql.toString();
	}

}
