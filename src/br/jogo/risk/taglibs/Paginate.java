package br.jogo.risk.taglibs;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class Paginate extends TagSupport {
	
	String url;
	int page;
	int pageSize;
	int total;
	int paginationSize = 10;
	boolean audited;
	
	public int doStartTag() throws JspException{
		JspWriter out = pageContext.getOut();
		int start = 1;
		int end = paginationSize;
		
		
		int totalPages = (int) Math.ceil((double)total/pageSize);
		
		
		if (totalPages < paginationSize){ end = totalPages; }
		
		if (totalPages <= 1) return 0;
		
		if (page == 0) page = 1;

		start = page%paginationSize == 0? page - (paginationSize - 1) : ((int)page/paginationSize)*paginationSize + 1;
		
		if(start != 1) end = ((totalPages - start) < paginationSize)? totalPages: start + (paginationSize - 1);
		
		try {
			out.println("<div class='pagination'>");
				out.println("<ul>");
				if(audited) 
					montarPaginatorAdited(totalPages, start, end, out);
				else
					montarPaginator(totalPages, start, end, out);
				out.println("</ul>");
			out.println("</div>");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return SKIP_BODY;
	}
	
	public void montarPaginator (int totalPages, int start, int end, JspWriter out) throws IOException{
		if(page != 1) out.println("<li><a href='"+ url + "?page=" + (page > 1 ? page - 1: 1) +"'><</a></li>");
		if(end > paginationSize) out.println("<li><a href='"+ url + "?page=" + (start - 1) +"'>...</a></li>");
		
		String ativo;
		
		for(int i=start; i <= end; i++){
			ativo = (page == i )?"active":"";
			out.print("<li class="+ ativo + "><a ");
			out.print("href='" + url + "?page=" + i + "' ");
			
			out.println(">" + i +"</a></li>");
		}
		if(end != totalPages){
			out.println("<li><a href='"+ url + "?page=" + (end + 1) +"'>...</a></li>");
			out.println("<li><a href='"+ url + "?page=" + (page + 1) +"'>></a></li>");
		}
	}
	
	public void montarPaginatorAdited(int totalPages, int start, int end, JspWriter out) throws IOException{
		if(page!= 1) out.println("<li><a onclick=\"intranet.auditoria.loadPaginate('" + url + "?page=" + (page > 1 ? page - 1: 1) + "')\" >></a></li>");
		if(end > paginationSize) out.println("<li><a onclick=\"intranet.auditoria.loadPaginate('" + url + "?page=" + (start - 1) + "')\" >...</a></li>");
		
		String ativo;
		
		for(int i=start; i <= end; i++){
			ativo = (page == i )?"active":"";
			out.print("<li class="+ ativo + "><a ");
			out.print("onclick=\"intranet.auditoria.loadPaginate('" + url + "?page=" + i + "')\" ");
			
			out.println(">" + i +"</a></li>");
		}
		if(end != totalPages){
			
			out.println("<li><a onclick=\"intranet.auditoria.loadPaginate('" + url + "?page=" + (end + 1) + "')\" >...</a></li>");
			out.println("<li><a onclick=\"intranet.auditoria.loadPaginate('" + url + "?page=" + (page + 1) + "')\" >></a></li>");
		}
	}
	
	public int getPage() {
		return page;
	}
	public void setPage(int page) {
		this.page = page;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	public boolean getAudited() {
		return audited;
	}

	public void setAudited(boolean audited) {
		this.audited = audited;
	}	
}