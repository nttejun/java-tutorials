package template;

import javax.naming.NamingException;

public class TemplateMain {
    public static void main(String[] args) throws NamingException {
        Authenticator authenticator = new LdapAuthenticator();
        Auth auth = authenticator.authenticate("ldap", "ldap");
    }
}
