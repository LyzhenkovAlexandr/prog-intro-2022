import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.InputMismatchException;
import java.util.LinkedHashMap;
import java.util.Map;

import static java.lang.Character.DASH_PUNCTUATION;


public class WordStatInput {
    public static void word(StringBuilder s, Map<String, Integer> map) {
        String line = s.toString();
        if (map.containsKey(line))
            map.put(line, map.get(line) + 1);
        else
            map.put(line, 1);
    }

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0]), StandardCharsets.UTF_8));
            StringBuilder s = new StringBuilder();
            Map<String, Integer> map = new LinkedHashMap<>();
            try {
                while (true) {
                    String str = reader.readLine();
                    if (str == null) {
                        break;
                    }
                    for (int i = 0; i < str.length(); i++) {
                        char ch = str.charAt(i);
                        if (Character.isLetter(ch) || Character.toString(ch).equals("'") || Character.getType(ch) == DASH_PUNCTUATION) {
                            s.append(Character.toLowerCase(ch));
                            if (i == str.length() - 1) {
                                word(s, map);
                                s = new StringBuilder();
                            }
                        } else if (s.length() != 0) {
                            word(s, map);
                            s = new StringBuilder();
                        }
                    }
                }
            } finally {
                reader.close();
            }
            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8));
            try {
                for (Map.Entry<String, Integer> item : map.entrySet()) {
                    out.write(item.getKey() + " " + item.getValue());
                    out.newLine();
                }
            } finally {
                out.close();
            }
        } catch (SecurityException e) {
            System.out.println("SecurityException" + e.getMessage());
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException" + e.getMessage());
        } catch (IOException e) {
            System.out.println("IOException" + e.getMessage());
        } catch (InputMismatchException e) {
            System.out.println("InputMismatchException" + e.getMessage());
        }
    }
}

//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.security.Security;
//import java.util.InputMismatchException;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import static java.lang.Character.DASH_PUNCTUATION;
//
//
//public class WordStatInput {
//    public static void word(StringBuilder s, Map<String, Integer> map) {
//        String line = s.toString();
//        if (map.containsKey(line))
//            map.put(line, map.get(line) + 1);
//        else
//            map.put(line, 1);
//    }
//
//    public static void main(String[] args) {
//        try {
//            FileInputStream file = new FileInputStream(args[0]);
//            Scanner reader = new Scanner(file);
//            StringBuilder s = new StringBuilder();
//            Map<String, Integer> map = new LinkedHashMap<>();
//            try {
//                while (reader.hasNextLine()) {
//                    String str = reader.nextLine();
//
//                    for (int i = 0; i < str.length(); i++) {
//                        char ch = str.charAt(i);
//                        if (Character.isLetter(ch) || Character.toString(ch).equals("'") || Character.getType(ch) == DASH_PUNCTUATION) {
//                            s.append(Character.toLowerCase(ch));
//                            if (i == str.length() - 1) {
//                                word(s, map);
//                                s = new StringBuilder();
//                            }
//                        } else if (s.length() != 0) {
//                            word(s, map);
//                            s = new StringBuilder();
//                        }
//                    }
//                }
//            } finally {
//                reader.close();
//            }
//            BufferedWriter out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(args[1]), StandardCharsets.UTF_8));
//            try {
//                for (Map.Entry<String, Integer> item : map.entrySet()) {
//                    out.write(item.getKey() + " " + item.getValue());
//                    out.newLine();
//                }
//            } finally {
//                out.close();
//            }
//        } catch (SecurityException e) {
//            System.out.println("SecurityException" + e.getMessage());
//        } catch (FileNotFoundException e) {
//            System.out.println("FileNotFoundException" + e.getMessage());
//        } catch (IOException e) {
//            System.out.println("IOException" + e.getMessage());
//        } catch (InputMismatchException e) {
//            System.out.println("InputMismatchException" + e.getMessage());
//        }
//    }
//}