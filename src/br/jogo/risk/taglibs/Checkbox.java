package br.jogo.risk.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;
import org.apache.taglibs.standard.tag.common.core.NullAttributeException;
 
@SuppressWarnings("serial")
public class Checkbox extends TagSupport {

	private String texto;
	private String name;
	private String checked;
	private String onClick;
	private String cssClass;

	@Override
    public int doStartTag() throws JspException {
        try {
            //Get the writer object for output.
            JspWriter out = pageContext.getOut();
 
            //Perform substr operation on string.
        	out.println("<div class='control-group'><label "+ Helpers.rawIf("for='%s'", id) +" class='checkbox'>");
        		out.println("<div class='controls'><input name='"+ name + "' "
        				+ Helpers.rawIf(isChecked(), " checked='checked' ") +" type='checkbox' " 
        				+ Helpers.rawIf(" onclick='%s'", onClick) + Helpers.rawIf("id='%s'", id)
        				+ Helpers.rawIf(" class='%s'", cssClass)
        				+" />"+ texto + "</div>");
        	out.println("</label></div>");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}

	public void setOnClick(String onClick) {
		this.onClick = onClick;
	}
	
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

	protected boolean isChecked() throws JspTagException {
		if( checked == null || checked.length() == 0 ) return false;
		try {
            Object r = ExpressionEvaluatorManager.evaluate(
                "checkbox", checked, Boolean.class, this, pageContext);
            if (r == null)
                throw new NullAttributeException("checkbox", "checked");
	    else
	        return (((Boolean) r).booleanValue());
        } catch (JspException ex) {
	    throw new JspTagException(ex.toString());
        }
	}
}