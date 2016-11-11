package org.simple.coollection.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class Phanton<T> {
	
	private final T target;
	private Class<?> clazz;

	private Phanton(T target) {
		this.target = target;
		clazz = target.getClass();
	}
	
	public static <T> Phanton<T> from(T target) {
		return new Phanton<T>(target);
	}
	
	public Object call(String name) {
		if(name==null || "".equals(name.trim()) || "$".equals(name)) return target;
		return invoke(name);
	}

	private Object invoke(String name){
		Object nestedTarget = target;
		Object returnValue = null;
		
		Class<? extends Object> nestedTargetClazz = clazz;
		for (String nestedName : name.split("\\.")) {
			Member m = getMember(nestedName, nestedTargetClazz);

			if(nestedTargetClazz.isArray() || returnValue instanceof Iterable){
				ArrayList<Object> ret = new ArrayList<Object>();
				for (Object	subItem : (Iterable<?>)nestedTarget) {
					ret.add(from(subItem).invoke(nestedName));
				}
				return ret;
			}

			if(m instanceof Field){
				try {
					Field field = (Field)m;
					field.setAccessible(Boolean.TRUE);
					returnValue = field.get(nestedTarget);
				}catch (Exception e1) {throw new RuntimeException(e1);}
				
			}else if(m instanceof Method){
				try {
					Method method = (Method) m;
					returnValue = method.invoke(nestedTarget);
				}catch (Exception e1) {throw new RuntimeException(e1);}
				
			}
			
			
			if(returnValue==null) break;
			nestedTarget = returnValue;
			nestedTargetClazz = nestedTarget.getClass();
		}
		
		return returnValue;
	}
	
	
	private Field findField(String fieldName, Class<?> clazz) {
		Field field = null;
		try {
			field = clazz.getField(fieldName);
		} catch (NoSuchFieldException e2) {
		} catch (SecurityException e2) {
		}
		if(field==null) {
			try {
				field = clazz.getDeclaredField(fieldName);
			} catch (NoSuchFieldException e2) {
			} catch (SecurityException e2) {
			}
		}

		if(field==null && clazz.getSuperclass()!=Object.class) {
			field = findField(fieldName, clazz.getSuperclass());
		}
		
		return field;
		
	}

	private Member getMember(String memberName, Class<?> clazz) {
		Member returnValue = null;
		try {
			return clazz.getField(memberName);
		} catch (NoSuchFieldException e2) {
		} catch (SecurityException e2) {}
		
		if(returnValue==null) {
			try {
				return clazz.getDeclaredField(memberName);
			} catch (NoSuchFieldException e2) {
			} catch (SecurityException e2) {
			}
		}

		if(returnValue==null) {
			try {
				return clazz.getMethod(memberName);
			} catch (NoSuchMethodException e) {
			} catch (SecurityException e2) {
			}
		}

		if(returnValue==null) {
			try {
				return clazz.getDeclaredMethod(memberName);
			} catch (NoSuchMethodException e) {
			} catch (SecurityException e2) {
			}
		}

		if(clazz == Object.class) return null;
		
		return getMember(memberName, clazz.getSuperclass());
		
	}

	
	public void set(String name, Object newValue) {
		invoke(name, newValue);
	}
	private void invoke(String name, Object newValue){
		Object nestedTarget = target;

		Class<? extends Object> nestedTargetClazz = clazz;
		String[] nestedNames = name.split("\\.");

		if(nestedNames.length>1){
			nestedTarget = invoke(name.substring(0, name.lastIndexOf(".")));
			if(nestedTarget==null) return;
			
			nestedTargetClazz = nestedTarget.getClass();
			nestedNames = new String[]{name.substring(name.lastIndexOf(".")+1)};
		}

		String nestedName = nestedNames[0];

		if(nestedTargetClazz.isArray() || nestedTarget instanceof Iterable){
			for (Object	subItem : (Iterable<?>)nestedTarget) {
				from(subItem).invoke(nestedName, newValue);
			}
			return;
		}

		try {
			Method m = nestedTargetClazz.getMethod(nestedName, newValue.getClass());
			m.invoke(nestedTarget, newValue);
		} catch (Exception e) {
			Field field = findField(nestedName, nestedTargetClazz);

			if(field==null) throw new RuntimeException(e);
			
			try {
				field.setAccessible(Boolean.TRUE);
				field.set(nestedTarget, newValue);
			}catch (Exception e1) {
				throw new RuntimeException(e1);
			}
		}

	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	public T getTarget() {
		return target;
	}
}