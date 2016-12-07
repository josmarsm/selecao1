package br.com.jn.controller;

import br.com.jn.dao.HibernateUtil;
import br.com.jn.model.Users;
import static com.sun.faces.facelets.util.Path.context;
import java.io.IOException;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import static sun.security.jgss.GSSUtil.login;

@ManagedBean(name = "loginController")
@RequestScoped
@SessionScoped
public class LoginController implements PhaseListener {

    @PersistenceContext(unitName = "SLPU")
    private EntityManager em;
    private static final long serialVersionUID = 1L;
    private String login;
    SecurityContext context = SecurityContextHolder.getContext();

    protected final Log logger = LogFactory.getLog(getClass());

    public String doLogin() throws ServletException, IOException {

        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_check");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();

        return null;
    }

    public String doLogout() throws ServletException, IOException {
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest())
                .getRequestDispatcher("/j_spring_security_logout");

        dispatcher.forward((ServletRequest) context.getRequest(),
                (ServletResponse) context.getResponse());

        FacesContext.getCurrentInstance().responseComplete();

        return null;
    }

    @Override
    public void afterPhase(PhaseEvent event) {
    }

    /* (non-Javadoc)
	 * @see javax.faces.event.PhaseListener#beforePhase(javax.faces.event.PhaseEvent)
	 * 
	 * Do something before rendering phase.
     */
    @Override
    public void beforePhase(PhaseEvent event) {
        Exception e = (Exception) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get(
                WebAttributes.AUTHENTICATION_EXCEPTION);

        if (e instanceof BadCredentialsException) {
            logger.debug("Found exception in session map: " + e);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put(
                    WebAttributes.AUTHENTICATION_EXCEPTION, null);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Username or password not valid.", "Username or password not valid"));
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RENDER_RESPONSE;
    }

    private String getPrincipal() {
        String userName = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        if (principal instanceof UserDetails) {
            userName = ((UserDetails) principal).getUsername();
        } else {
            userName = principal.toString();
        }
        return userName;
    }

    public String getCurrentUsername() {
        Authentication a = SecurityContextHolder.getContext().getAuthentication();
        if (a == null) {
            return null;
        }
        Object principal = a.getPrincipal();
        String username = "";
        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();

        }
        return username;
    }

    public Users procuraUsers() {
        
        if (context instanceof SecurityContext) {
            Authentication authentication = context.getAuthentication();
            if (authentication instanceof Authentication) {
                login = (((User) authentication.getPrincipal()).getUsername());
            }
        }
        
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        
        Query query = session.createQuery("from Users user where user.username like ?");
        query.setString(0, login);
        
        
        return (Users) query.uniqueResult();
    }
}
