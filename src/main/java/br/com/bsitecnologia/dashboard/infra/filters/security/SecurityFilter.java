package br.com.bsitecnologia.dashboard.infra.filters.security;

import java.io.IOException;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.faces.lifecycle.LifecycleFactory;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.bsitecnologia.dashboard.infra.filters.ExcludeJsfResourcesFromFilter;

@WebFilter(filterName="SecurityFilter", dispatcherTypes=DispatcherType.REQUEST, urlPatterns="*.jsf")
public class SecurityFilter implements Filter {

	public FilterConfig filterConfig;
	private FacesContext facesContext;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.filterConfig = filterConfig;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		if (ExcludeJsfResourcesFromFilter.shouldProcess(request)) {
			facesContext = getFacesContext((HttpServletRequest)request, (HttpServletResponse)response);
			facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Security filter test", "just checking..."));
			chain.doFilter(request, response);
		}else{
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		if (null != facesContext) {
			facesContext.release();
			removeFacesContext();
		}
	}
	
	protected FacesContext getFacesContext(HttpServletRequest request, HttpServletResponse response) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext == null) {

            FacesContextFactory contextFactory  = (FacesContextFactory)FactoryFinder.getFactory(FactoryFinder.FACES_CONTEXT_FACTORY);
            LifecycleFactory lifecycleFactory = (LifecycleFactory)FactoryFinder.getFactory(FactoryFinder.LIFECYCLE_FACTORY); 
            Lifecycle lifecycle = lifecycleFactory.getLifecycle(LifecycleFactory.DEFAULT_LIFECYCLE);

            facesContext = contextFactory.getFacesContext(request.getSession().getServletContext(), request, response, lifecycle);

            // Set using our inner class
            InnerFacesContext.setFacesContextAsCurrentInstance(facesContext);

            // set a new viewRoot, otherwise context.getViewRoot returns null
            UIViewRoot view = facesContext.getApplication().getViewHandler().createView(facesContext, "");
            facesContext.setViewRoot(view);                
        }
        return facesContext;
    }
    
	public void removeFacesContext() {
        InnerFacesContext.setFacesContextAsCurrentInstance(null);
    }
    
    protected Application getApplication(FacesContext facesContext) {
        return facesContext.getApplication();        
    }
    
	protected <T> T getManagedBean(FacesContext facesContext, String el, Class<? extends T> expectedType) {
    	return getApplication(facesContext).evaluateExpressionGet(facesContext, el, expectedType);
    }
    
    // You need an inner class to be able to call FacesContext.setCurrentInstance
    // since it's a protected method
    private abstract static class InnerFacesContext extends FacesContext {
        protected static void setFacesContextAsCurrentInstance(FacesContext facesContext) {
            FacesContext.setCurrentInstance(facesContext);
        }
    }     
}
