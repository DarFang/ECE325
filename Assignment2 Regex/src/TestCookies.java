import java.util.regex.*;

/**
 * ECE 325 - Fall 2020 <br/>
 * Assignment 2: Java regular expressions <br/>
 * Test cookies using regular expressions
 * <p>
 * @author Darius Fang
 */
public class TestCookies {

    /**
     * Verify a cookie and return the verification result
     * @param cookie  The cookie string
     * @return        True for a legal cookie; false for an illegal one
     */
    public static boolean verifyCookie(String cookie) {
        boolean legal = false;
        String digit = "[0-9]";
        String letter = "[a-zA-Z]";
        String LetDig = digit +"|"+letter;
        String LetDigHyp = LetDig  + "|-";
        String LdhStr = "(" + LetDigHyp + ")*";
        String Label= letter + "((" + LdhStr + ")*" + LetDig +")*" ;
        String SubDomain = "("+ Label + "(."+ Label + ")*)";
        String Domain = "((" + SubDomain + ")|(." +SubDomain + "))*";
        
        String Http = "(HttpOnly)";
        String Secure = "(Secure)";
        String CTL = "\\p{Cntrl}";
        String PathVal = "[^;"+CTL+"]";
        String PathAv = "(Path=" + PathVal + ")";
        
        String DomainVal = Domain;
        String DomainAv = "(Domain=" + DomainVal + ")";
        
        String NonZeroDigit = "[1-9]";
        String MaxAge = "(Max-Age=" + NonZeroDigit + ")";
        
        String Month = "((Jan)|(Feb)|(Mar)|(Apr)|(May)|(Jun)|(Jul)|(Aug)|(Sep)|(Oct)|Nov|(Dec))";
        String WkDay = "((Mon)|(Tue)|(Wed)|(Thu)|(Fri)|(Sat)|(Sun))";
        String Time = "[0-9][0-9]:[0-9][0-9]:[0-9][0-9]";
        String Date = "[0-9][0-9]\u0020"+Month+"\u0020[0-9][0-9][0-9][0-9]";
        String rfc1123date = WkDay  +",\u0020" + Date + "\u0020"+ Time + "\u0020" + "GMT";
        String ExpiresAv = "(Expires=" + rfc1123date + ")";
        
        String CookieAv = "(" + ExpiresAv + "|" + MaxAge + "|" + DomainAv + "|" + PathAv + "|" + Secure + "|" + Http + ")";
        
        String CookieOctet = "[^"+CTL+"\\u0020\",;\\\\]";
        String CookieVal = "(("+CookieOctet + ")*|(\"" + "("+CookieOctet + ")*\"))*";
        String CookieName = "([^\\(\\)<>@,;:\\\\\"\\/\\[\\]?=\\{\\}\u0020\u0009"+CTL+"])+";
        String CookiePair = CookieName + "=" + CookieVal;
        String CookieStr = CookiePair+"(;\u0020"+CookieAv+")*";
        String SCHeader = "Set-Cookie: ";
        
        Pattern p = Pattern.compile(SCHeader+CookieStr);
        Matcher m = p.matcher(cookie);
        if(m.matches()) {
        	legal = true;
        }
        	

        return legal;
    }

    /**
     * Main entry
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        String [] cookies = {
            // Legal cookies:
            "Set-Cookie: ns1=\"alss/0.foobar^\"",                                           // 01 name=value
            "Set-Cookie: ns1=",                                                             // 02 empty value
            "Set-Cookie: ns1=\"alss/0.foobar^\"; Expires=Tue, 18 Nov 2008 16:35:39 GMT",    // 03 Expires=time_stamp
            "Set-Cookie: ns1=; Domain=",                                                    // 04 empty domain
            "Set-Cookie: ns1=; Domain=.srv.a.com-0",                                        // 05 Domain=host_name
            "Set-Cookie: lu=Rg3v; Expires=Tue, 18 Nov 2008 16:35:39 GMT; Path=/; Domain=.example.com; HttpOnly", // 06
            // Illegal cookies:
            "Set-Cookie:",                                              // 07 empty cookie-pair
            "Set-Cookie: sd",                                           // 08 illegal cookie-pair: no "="
            "Set-Cookie: =alss/0.foobar^",                              // 09 illegal cookie-pair: empty name
            "Set-Cookie: ns@1=alss/0.foobar^",                          // 10 illegal cookie-pair: illegal name
            "Set-Cookie: ns1=alss/0.foobar^;",                          // 11 trailing ";"
            "Set-Cookie: ns1=; Expires=Tue 18 Nov 2008 16:35:39 GMT",   // 12 illegal Expires value
            "Set-Cookie: ns1=alss/0.foobar^; Max-Age=01",               // 13 illegal Max-Age: starting 0
            "Set-Cookie: ns1=alss/0.foobar^; Domain=.0com",             // 14 illegal Domain: starting 0
            "Set-Cookie: ns1=alss/0.foobar^; Domain=.com-",             // 15 illegal Domain: trailing non-letter-digit
            "Set-Cookie: ns1=alss/0.foobar^; Path=",                    // 16 illegal Path: empty
            "Set-Cookie: ns1=alss/0.foobar^; httponly",                 // 17 lower case
        };

        for (int i = 0; i < cookies.length; i++)
            System.out.println(String.format("Cookie %2d: %s", i+1, verifyCookie(cookies[i]) ? "Legal" : "Illegal"));
    }

}
