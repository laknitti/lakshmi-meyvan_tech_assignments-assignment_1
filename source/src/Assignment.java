import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.util.ArrayList;
import java.util.List;

public class Assignment {

    static List<String> addUpperCaseLetters(List<String> completePassword, String tempPassword) {
        String m = tempPassword;
        for (char d = 'A'; d <= 'Z'; ++d) {
            m = m + d;
            completePassword.add(m);
            m = tempPassword;
        }
        return completePassword;
    }

    static List<String> addLowerCaseLetters(List<String> completePassword, String tempPassword) {
        String m = tempPassword;
        for (char d = 'a'; d <= 'z'; ++d) {
            m = m + d;
            completePassword.add(m);
            m = tempPassword;
        }
        return completePassword;
    }

    static List<String> addNumbers(List<String> completePassword, String tempPassword) {
        String m = tempPassword;
        for (int i = 0; i <= 9; i++) {
            m = m + i;
            completePassword.add(m);
            m = tempPassword;
        }
        return completePassword;
    }

    static List<String> missingLetters(String password) {
        List<String> completePassword = new ArrayList<>();
        for (char c = 'A'; c <= 'Z'; ++c) {
            String k = password;
            k = k + c;
            addUpperCaseLetters(completePassword, k);
            addLowerCaseLetters(completePassword, k);
            addNumbers(completePassword, k);
        }
        for (char c = 'a'; c <= 'z'; ++c) {
            String k = password;
            k = k + c;
            addUpperCaseLetters(completePassword, k);
            addLowerCaseLetters(completePassword, k);
            addNumbers(completePassword, k);
        }
        for (int i = 0; i <= 9; i++) {
            String k = password;
            k = k + i;
            addUpperCaseLetters(completePassword, k);
            addLowerCaseLetters(completePassword, k);
            addNumbers(completePassword, k);
        }
        return completePassword;
    }

    public static void main(String[] args) {
        List<String> passwords = missingLetters("Twg48wTM");
        for (String pwd : passwords) {
            try {
                ZipFile zipFile = new ZipFile("assignment.zip");

                if (zipFile.isEncrypted()) {
                    zipFile.setPassword(pwd);
                }
                zipFile.extractAll("/home/laknitti/Documents/");
                System.out.println("\nThe password is ------" + pwd);
                break;
            } catch (ZipException ex) {
                System.out.println("error " + ex);
            }
        }
    }
}
