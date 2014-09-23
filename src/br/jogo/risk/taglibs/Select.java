package br.jogo.risk.taglibs;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import org.apache.taglibs.standard.tag.common.core.ForEachSupport;

@SuppressWarnings("serial")
public class Select extends ForEachSupport {
	
	private String optionDisplay;
	private String optionValue;
	private String name;
	private String cssClass;
	private boolean disabled;
	private String texto;
	private String textoDefault;
	
	@Override
	public int doStartTag() throws JspException {
		try {
			// Get the writer object for output.
			JspWriter out = pageContext.getOut();
			
		
			// Perform substr operation on string.
			out.println("<div class='control-group'>");
				out.println("<label class='control-label' "+ Helpers.rawIf("for='%s'", id) +">"+ texto +": </label>");
				out.println("<div class='controls'>");
					out.print("<select name='"+ name + "'"
									+ Helpers.rawIf("class='%s'", cssClass));
									if (disabled) out.print(Helpers.rawIf("disabled='%s'", disabled));
									out.println( Helpers.rawIf("id='%s'", id) + ">");
						out.println(Helpers.rawIf("<option value>%s</option>", textoDefault));
						printOptions(out);
					out.println("</select>");
				out.println("</div>");
			out.println("</div>");				
		} catch (IOException e) {
			e.printStackTrace();
		}
		return SKIP_BODY;
	}
	
	public void setOptionDisplay(String optionDisplay) {
		this.optionDisplay = optionDisplay;
	}

	public void setOptionValue(String optionValue) {
		this.optionValue = optionValue;
	}

	public void setItems(Object items) {
		rawItems = items;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	public boolean getDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setTextoDefault(String textoDefault) {
		this.textoDefault = textoDefault;
	}

	public void printOptions( JspWriter jspWriter ) {
		try {
			ForEachIterator iterator = supportedTypeForEachIterator(rawItems);
			while ( iterator.hasNext() ) {
				Object object = iterator.next();
				Class clazz = object.getClass();
				String getMethodName = "get" + optionDisplay.substring(0, 1).toUpperCase() + optionDisplay.substring(1);
				String getMethodId = "get" + optionValue.substring(0, 1).toUpperCase() + optionValue.substring(1);
				Method methodName =  clazz.getDeclaredMethod(getMethodName, null);
				Method methodId = clazz.getDeclaredMethod(getMethodId, null);
				Object displayValue = methodName.invoke(object, null);
				Object valueId = methodId.invoke(object, null);
				jspWriter.println("<option value='"+ valueId +"'>"+ displayValue.toString() +"</option>");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}