package design.version.a.template;

import javax.naming.NamingException;

public class LdapAuthenticator extends Authenticator {

    @Override
    protected boolean doAuthenticate(String id, String pw) {
        System.out.println("LDAP.authenticate(id, pw)");
        return true;
    }

    @Override
    protected Auth createAuth(String id) throws NamingException {
        return new Auth("id", "context");
    }
}
