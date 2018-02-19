package io.github.caiwan.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Maps and invokes similar setters and getters of one object to another Only
 * maps basic class types from classpath java.lang
 * 
 * @author caiwan
 *
 */
public class MapperUtil {

	private static final Pattern getterPattern = Pattern.compile("get(\\w*)");
	private static final Pattern setterPattern = Pattern.compile("set(\\w*)");

	private static final Pattern baseTypePattern = Pattern.compile("java\\.lang\\.(\\w*)");

	private static Logger LOGGER = LoggerFactory.getLogger(MapperUtil.class);

	public static void mapObject(Object source, Object dst) {
		Class<? extends Object> srcClass = source.getClass();
		Class<? extends Object> dstClass = dst.getClass();

		for (Method getterMethod : srcClass.getDeclaredMethods()) {
			String otherMethodName = getterMethod.getName();

			Matcher setterMatcher = getterPattern.matcher(otherMethodName);
			if (!setterMatcher.matches())
				continue;

			Class<?> getterReturnType = getterMethod.getReturnType();

			Matcher baseTypeMatcher = baseTypePattern.matcher(getterReturnType.getCanonicalName());
			if (!baseTypeMatcher.matches()) {
				continue;
			}

			String fieldName = setterMatcher.group(1);
			Method setterMethod = null;
			try {
				setterMethod = dstClass.getMethod("set" + fieldName, getterReturnType);

				Object val = getterMethod.invoke(source);
				setterMethod.invoke(dst, val);

			} catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				String msg = String.format("Could not map methods %s -> %s", getterMethod.getName(),
						setterMethod == null ? "null" : setterMethod.getName());
				
				LOGGER.error(msg);
				throw new RuntimeException(msg, e);
			}

		}

	}

}
