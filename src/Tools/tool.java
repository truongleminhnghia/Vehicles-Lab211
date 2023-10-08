package Tools;

import java.util.Scanner;

public class tool {
    // dùng ở mọi nơi nên dùng static.
    public static Scanner scanner = new Scanner(System.in);

    // nhap chuoi ko dk
    public static String inputStr(String msg) {
        if (msg != null) {
            System.out.print(msg);
        }
        return scanner.nextLine();
    }

    // nhập cấm rỗng.
    public static String inputPattern(String msg, String regex) {
        String s;
        do {
            s = inputStr(msg);
        } while (!s.matches(regex));
        return s;
    }

    // Get a non-blank string
    public static String inputNonBlankStr(String msg) {
        String data;
        do {
            data = inputStr(msg);
        } while (data.length() == 0);
        return data;
    }

    // Get an integer between min...max
    public static int inputInt(String msg, int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }
                int result = Integer.parseInt(scanner.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException("Input numper out of range [" + min + ", " + max + "]");
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.err.print("Enter again: ");
            }
        }
    }

    public static int checkInputIntlimit(String str, int min, int max) {
        int result = -1;
        while (true) {
            Scanner kb = new Scanner(System.in);
            result = Integer.parseInt(kb.nextLine());
            if (result < min || result > max) {
                System.err.println(str + "Please input number in rage [" + min + ", " + max + " ]");
                System.err.println("Enter again: ");
            } else {
                break;
            }
        }
        return result;
    }

    public static float checkFloatLimit(String str, float min, float max) {
        float result = -1;
        while (true) {
            Scanner kb = new Scanner(System.in);
            result = Float.parseFloat(kb.nextLine());
            if (result < min || result > max) {
                System.err.println(str + "Please input number in rage [" + min + ", " + max + " ]");
                System.err.println("Enter again: ");
            } else {
                break;
            }
        }
        return result;
    }

    public static String checkString(String num) {
        String result;
        while (true) {
            Scanner kb = new Scanner(System.in);
            result = kb.nextLine();
            if (result.trim().length() == 0) {
                System.out.println("Enter again: ");
            } else {
                return result;
            }
        }

    }

    public static boolean isPrimeNumber(int n) {
        // số nguyên <2 không phải là số nguyên tố
        if (n < 2) {
            return false;
        }
        // kiem tra số nguyên tố khi n>2
        int squareRoot = (int) Math.sqrt(n);
        for (int i = 2; i <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    // Get an float between min...max
    public static double inputFloat(String msg, int min, int max) {
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }

        while (true) {
            try {
                if (msg != null) {
                    System.out.print(msg);
                }
                double result = Double.parseDouble(scanner.nextLine());
                if (result < min || result > max) {
                    throw new NumberFormatException("Input numper out of range [" + min + ", " + max + "]");
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Please input number in range [" + min + ", " + max + "]");
                System.err.print("Enter again: ");
            }
        }
    }

    // Get a string with no condition
    public static String inputString(String msg) {
        if (msg != null) {
            System.out.println(msg);
        }
        return scanner.nextLine().trim();
    }

    public static double inputPrice(String msg) {
        double price;
        while(true) {
            try {
                System.out.print(msg + ": ");
                price = Double.parseDouble(scanner.nextLine());

                if(price <=0) {
                    throw new NumberFormatException();
                }
                break;
            }
            catch (NumberFormatException e ) {
                System.out.println("Invalid input. Please enter a positive number.");
            }
        }
        return price;
    }
}