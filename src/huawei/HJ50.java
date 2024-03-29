/**
 * 版权所有: wulihua
 * 创建日期: 2020/11/10
 * 创建作者：wuqia
 * 文件名称：HJ7.java
 * 版本: 1.0
 * 修改记录:
 */
package huawei;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/** 功能：四则运算
 * 输入：strExpression：字符串格式的算术表达式，如: "3+2*{1+2*[-4/(8-6)+7]}"
 * 返回：算术表达式的计算结果
 **/
public class HJ50 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            String num = in.next();
            if(num == "0") {
                break;
            }
            try {
                num = num.replace("[","(");
                num = num.replace("]",")");
                num = num.replace("{","(");
                num = num.replace("}",")");
                System.out.println(cal(num).intValue());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static BigDecimal cal(String str) {
        // 对表达式进行预处理，并简单验证是否是正确的表达式
        // 存放处理后的表达式
        List<String> list = new ArrayList<>();
        char[] arr = str.toCharArray();
        // 存放数字临时变量
        StringBuffer tmpStr = new StringBuffer();
        for (char c : arr) {
            // 如果是数字或小数点，添加到临时变量中
            if (c >= '0' && c <= '9') {
                tmpStr.append(c);
            } else if (c == '.') {
                if (tmpStr.indexOf(".") > 0) {
                    throw new RuntimeException("非法字符");
                }
                tmpStr.append(c);
            }
            // 如果是加减乘除或者括号，将数字临时变量和运算符依次放入list中
            else if (isCalc(c)) {
                if (tmpStr.length() > 0) {
                    list.add(tmpStr.toString());
                    tmpStr.setLength(0);
                }
                list.add(c + "");
            }
            // 如果是空格，跳过
            else if (c == ' ') {
                continue;
            } else {
                throw new RuntimeException("非法字符");
            }
        }
        if (tmpStr.length() > 0) {
            list.add(tmpStr.toString());
        }
        // 如果数字前有"-",且"-"前无数字则需要将"-"合并到数字中，且数字后无运算符
        for(int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            if (s.equals("-") && (i == 0 || isCalc(list.get(i - 1)))) {
                String a = list.get(i + 1) ;
                a = s + a;
                list.set(i + 1, a);
                list.remove(s);
            }
        }
        // 初始化后缀表达式
        List<String> strList = new ArrayList<>();
        // 运算过程中，使用了两次栈结构，第一次是将中缀表达式转换为后缀表达式，第二次是计算后缀表达式的值
        Stack<String> stack = new Stack<>();
        // 声明临时变量，存放出栈元素
        String tmp;
        // 1. 将中缀表达式转换为后缀表达式
        for (String s : list) {
            // 如果是左括号直接入栈
            if (s.equals("(")) {
                stack.push(s);
            }
            // 如果是右括号，执行出栈操作，依次添加到后缀表达式中，直到出栈元素为左括号，左括号和右括号都不添加到后缀表达式中
            else if (s.equals(")")) {
                while (!(tmp = stack.pop()).equals("(")) {
                    strList.add(tmp);
                }
            }
            // 如果是加减乘除，弹出所有优先级大于或者等于该运算符的栈顶元素（栈中肯定没有右括号，认为左括号的优先级最低），然后将该运算符入栈
            else if (s.equals("*") || s.equals("/")) {
                while (!stack.isEmpty()) {
                    // 取出栈顶元素
                    tmp = stack.peek();
                    if (tmp.equals("*") || tmp.equals("/")) {
                        stack.pop();
                        strList.add(tmp);
                    } else {
                        break;
                    }
                }
                stack.push(s);
            } else if (s.equals("+") || s.equals("-")) {
                while (!stack.isEmpty()) {
                    // 取出栈顶元素
                    tmp = stack.peek();
                    if (!tmp.equals("(")) {
                        stack.pop();
                        strList.add(tmp);
                    } else {
                        break;
                    }
                }
                stack.push(s);
            }
            // 如果是数字，直接添加到后缀表达式中
            else {
                strList.add(s);
            }
        }
        // 最后依次出栈，放入后缀表达式中
        while (!stack.isEmpty()) {
            strList.add(stack.pop());
        }
        // 2.计算后缀表达式的值
        Stack<BigDecimal> newStack = new Stack<>();
        for (String s : strList) {
            // 若遇运算符，则从栈中退出两个元素，先退出的放到运算符的右边，后退出的放到运算符左边，
            // 运算后的结果再进栈，直到后缀表达式遍历完毕
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                BigDecimal b1 = newStack.pop();
                BigDecimal b2 = newStack.pop();
                switch (s) {
                    case "+":
                        newStack.push(b2.add(b1));
                        break;
                    case "-":
                        newStack.push(b2.subtract(b1));
                        break;
                    case "*":
                        newStack.push(b2.multiply(b1));
                        break;
                    case "/":
                        newStack.push(b2.divide(b1, 9, BigDecimal.ROUND_HALF_UP));
                        break;
                }
            }
            // 如果是数字，入栈
            else {
                newStack.push(new BigDecimal(s));
            }
        }
        // 最后，栈中仅有一个元素，就是计算结果
        return newStack.peek();
    }

    private static boolean isCalc(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')';
    }

    private static boolean isCalc(String c) {
        return c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/") || c.equals("(");
    }
}
