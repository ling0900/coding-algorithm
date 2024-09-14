package lh.io.utils;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * The enum Calculator.
 */
public enum Calculator {
	/**
	 * Instance calculator.
	 */
	Instance;
	private final static ScriptEngine jse = new ScriptEngineManager().getEngineByName("JavaScript");

	/**
	 * Cal object.
	 *
	 * @param expression the expression
	 * @return the object
	 * @throws ScriptException the script exception
	 */
	public Object cal(String expression) throws ScriptException{
		return jse.eval(expression);
	}
}