package br.com.alura.gerenciador.listener;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import br.com.alura.gerenciador.modelo.User;

//https://stackoverflow.com/questions/1932091/prevent-multiple-login-using-the-same-user-name-and-password
public class UserLogged implements HttpSessionBindingListener {

    // All logins.
    private static Map<UserLogged, HttpSession> logins = new HashMap<UserLogged, HttpSession>();

    // Normal properties.
    private Long id;
    private String username;
    // Etc.. Of course with public getters+setters.

    @Override
    public boolean equals(Object other) {
	return (other instanceof User) && (id != null) ? id.equals(((UserLogged) other).id) : (other == this);
    }

    @Override
    public int hashCode() {
	return (id != null) ? (this.getClass().hashCode() + id.hashCode()) : super.hashCode();
    }

    @Override
    public void valueBound(HttpSessionBindingEvent event) {
	HttpSession session = logins.remove(this);
	if (session != null) {
	    session.invalidate();
	}
	logins.put(this, event.getSession());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent event) {
	logins.remove(this);
    }

}
