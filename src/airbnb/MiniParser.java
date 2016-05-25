package airbnb;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by jun on 4/14/16.
 * To implement a mini parser, input string would be "324" or"[123,456,[788,799,833],[[]],10,[]]"
 * output should be 324 or [123,456,[788,799,833],[[]],10,[]].
 * <p>
 * In other words, create a customized data structure to store this information.
 */
public class MiniParser {
    public static void main(String[] args) {
        String input1 = "123";
        String input2 = "[123,456,[788,799,833],[[]],10,[]]";
        String input3 = "";
        MiniParser parser = new MiniParser();
        System.out.println(parser.parse(input1));
        System.out.println(parser.parse(input2));
        System.out.println(parser.parse(input3));
        assert parser.parse(input1).equals(input1);
        assert parser.parse(input2).equals(input2);
        assert parser.parse(input3).equals(input3);
    }

    public static class Nested {
        boolean isNumber;
        int number;
        List<Nested> list;

        public Nested() {
            this.isNumber = false;
            list = new LinkedList<>();
        }

        public Nested(int number) {
            this.isNumber = true;
            this.number = number;
            list = new LinkedList<>();
        }

        @Override
        public String toString() {
            if (isNumber)
                return String.valueOf(number);
            else
                return list.toString().replaceAll(" ", "");
        }
    }

    public String parse(String str) {
        if (str == null || str.isEmpty())
            return "";

        if (str.charAt(0) != '[')
            return new Nested(Integer.valueOf(str)).toString();

        String token = "";
        Stack<Nested> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '[') {
                stack.push(new Nested());
            } else if (ch == ']' || ch == ',') {
                if (!token.isEmpty()) {
                    int value = Integer.valueOf(token);
                    token = "";
                    stack.peek().list.add(new Nested(value));
                }

                if (ch == ']' && stack.size() > 1) {
                    Nested inner = stack.pop();
                    stack.peek().list.add(inner);
                }
            } else {
                token += ch;
            }
        }

        return stack.pop().toString();
    }

//    public static class Nested {
//        boolean isNumber;
//        int number;
//        List<Nested> list;
//
//        public Nested() {
//            isNumber = false;
//            number = -1;
//            list = new ArrayList<>();
//        }
//
//        @Override
//        public String toString() {
//            if (isNumber)
//                return String.valueOf(number);
//            else
//                return list.toString();
//        }
//    }
//
//    public String parse(String line) {
//        String result = "";
//        if (line == null || line.length() == 0)
//            return result;
//
//        line += " ";
//
//        Stack<Nested> stack = new Stack<>();
//        String token = "";
//
//        for (int i = 0; i < line.length(); i++) {
//            char ch = line.charAt(i);
//            if (ch == '[') {
//                stack.push(new Nested());
//            } else if (ch == ']' || ch == ',' || i == line.length() - 1) {
//                if (token.length() != 0) {
//                    int num = Integer.valueOf(token);
//                    token = "";
//                    Nested nestedNum = new Nested();
//                    nestedNum.isNumber = true;
//                    nestedNum.number = num;
//                    if (stack.isEmpty())
//                        stack.add(nestedNum);
//                    else
//                        stack.peek().list.add(nestedNum);
//                }
//                if (ch == ']') {
//                    if (stack.size() >= 2) {
//                        Nested nested = stack.pop();
//                        stack.peek().list.add(nested);
//                    }
//                }
//            } else {
//                token += ch;
//            }
//        }
//
//        return stack.pop().toString().replaceAll(" ", "");
//    }


//    public static class Nested {
//        boolean isNumber = false;
//        int number;
//        List<Nested> list = new ArrayList<>();
//
//        @Override
//        public String toString() {
//            if (isNumber) {
//                return String.valueOf(number);
//            } else {
//                return list.toString();
//            }
//        }
//    }
//
//    public String parse(String input) {
//        if (input.isEmpty())
//            return "";
//
//        input += " "; // important
//
//        Stack<Nested> stack = new Stack<>();
//        String buffer = "";
//
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (c == '[') {
//                stack.push(new Nested());
//            } else if (c == ']' || c == ',' || i == input.length() - 1) {
//                if (!buffer.isEmpty()) {
//                    Nested nested = new Nested();
//                    nested.isNumber = true;
//                    nested.number = Integer.valueOf(buffer);
//                    buffer = ""; // ** remember to reset buffer
//
//                    if (!stack.isEmpty())
//                        stack.peek().list.add(nested);
//                    else
//                        stack.push(nested);
//                }
//
//                if (c == ']') {
//                    Nested nested = stack.pop();
//                    if (stack.isEmpty())
//                        stack.push(nested);
//                    else
//                        stack.peek().list.add(nested);
//                }
//            } else {
//                buffer += c;
//            }
//        }
//
//        return stack.isEmpty() ? "" : stack.peek().toString().replaceAll(" ", "");
//    }


//    public String parse(String input) {
//        input += " ";
//        Stack<Nested> stack = new Stack<>();
//        String buffer = "";
//        for (int i = 0; i < input.length(); i++) {
//            char c = input.charAt(i);
//            if (c == '[') {
//                Nested nested = new Nested();
//                nested.isInteger = false;
//                stack.push(nested);
//            } else if (c == ',' || c == ']' || i == input.length() - 1) {// watch out about len-1 index, it could cut off the last digit
//                if (!buffer.isEmpty()) { // without this check, the parser can fail on empty string in the middle of the input string such as ,[[]],
//                    Nested nested = new Nested();
//
//                    nested.integer = Integer.valueOf(buffer);
//                    nested.isInteger = true;
//
//                    if (stack.isEmpty())
//                        stack.push(nested);
//                    else
//                        stack.peek().list.add(nested);
//                    buffer = "";
//                }
//
//                if (c == ']') {
//                    Nested nested = stack.pop();
//                    if (stack.isEmpty())
//                        stack.push(nested);
//                    else
//                        stack.peek().list.add(nested);
//                }
//
//            } else {
//                buffer += c;
//            }
//        }
//
//        return stack.empty() ? "" : stack.pop().toString().replaceAll(" ", "");
//    }
//
//    public static class Nested {
//        boolean isInteger;
//        int integer;
//        List<Nested> list = new LinkedList<>();
//
//        @Override
//        public String toString() {
//            if (isInteger)
//                return String.valueOf(integer);
//            else
//                return list.toString();
//        }
//    }
}
