package org.simple.coollection.reflection;



import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class Utils {
	public static boolean isEmptyValue(Object value){
		if(value==null)return true;
		Object emptyValue = null;

		if(value instanceof String) 		emptyValue = new String("");
		else if(value instanceof Integer) 	emptyValue = new Integer(0);
		else if(value instanceof Long) 		emptyValue = new Long(0L);
		else if(value instanceof Float)  	emptyValue = new Float(0d);
		else if(value instanceof Double)  	emptyValue = new Double(0d);
		else if(value instanceof Byte)  	emptyValue = new Byte("0");
		else if(value instanceof Boolean)  	emptyValue = new Boolean(false);
		else if(value instanceof List<?>)  	return ((List<?>)value).isEmpty();
		else if(value.getClass().isArray()) 
			return ((Object[])value).length==0;
		else return false;
		
		return emptyValue.equals(value);
	}
	/**
	 * same negative as isEmptyValue
	 * @param value
	 * @return
	 */
	public static boolean hasValue(Object value){
		return !isEmptyValue(value);
	}

	public static <T> T castValue(Object value, Class<T> outClazz){
		return castValue(value, outClazz, null);
	}
	/**
	 * cast values <br> 
	 * @param value
	 * @param outClazz
	 * @param formats for the java.util.Date use SimpleDateFormat see <b>LocaleUtils.DEFAULT_FORMATS</b>
	 * @return
	 * Usage:
	 * <blockquote><code>getCellValue(poiRow.getCell(cellIndex), String.class);</code>
	 */
	
	@SuppressWarnings("unchecked")
	public static <T> T castValue(Object value, Class<T> outClazz, Format[] formats){
		if(!hasValue(value))return null;
		if(outClazz==value.getClass()) return (T) value;
		
		if(outClazz==String  .class) return (T) value.toString();
		
		try {
			if(outClazz==Integer .class) return (T) Integer.valueOf(Double.valueOf(value.toString()).intValue());
			if(outClazz==Long    .class) return (T) Long.valueOf(Double.valueOf(value.toString()).longValue());
			if(outClazz==Float   .class) return (T) Float.valueOf(Double.valueOf(value.toString()).floatValue());
			if(outClazz==Double  .class) return (T) Double.valueOf(value.toString());
			if(outClazz==Byte    .class) return (T) Byte.valueOf(Double.valueOf(value.toString()).byteValue());
			if(outClazz==Boolean .class) return (T) Boolean.valueOf(value.toString());
			if(outClazz==Date    .class){
				for (Format format : formats) {
					if(!(format instanceof SimpleDateFormat)) continue;
					try {
						Object v = format.parseObject(value.toString());
						return (T) v;
					} catch (Exception e) {}
				}
				return null;
			} 
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		return (T) value;		

	}
	
}
