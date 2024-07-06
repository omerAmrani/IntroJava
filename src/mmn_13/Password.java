package mmn_13;

import java.util.Random;

public class Password {
    private String _pswd;

    public Password(String pswd) {
        this._pswd = pswd;
    }

    public Password(int length) {
        this._pswd = "";
        int n = 25;
        Random r = new Random();

        for (int i = 0; i < length; ++i) {
            char ch = (char) (r.nextInt(n) + 97);
            this._pswd = this._pswd + ch;
        }
    }

    public String getPassword() {
        return this._pswd;
    }

    public boolean isPassword(String s) {
        return s.equals(this._pswd);
    }
}
