package template;

import javax.naming.NamingException;

public abstract class Authenticator {

    public Auth authenticate(String id, String pw) throws NamingException {
        if ( ! doAuthenticate(id, pw)) {
            try {
                throw createException();
            } catch (AuthException e) {
                e.printStackTrace();
            }
        }

        return createAuth(id);
    }

    protected abstract boolean doAuthenticate(String id, String pw);

    private RuntimeException createException() throws AuthException {
        throw new AuthException("message");
    }

    protected abstract Auth createAuth(String id) throws NamingException;
}
