import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean checkInput = false;

        while (!checkInput) {
            System.out.println("세 개의 숫자와 연산자를 입력하세요. 예) 10 + 5 * 3");
            String input = sc.nextLine().trim(); // 공백 제거를 포함하여 입력 받기

            // 입력된 문자열에서 공백을 기준으로 숫자와 연산자 분리
            String[] numbers = input.split("\\s+"); // 공백 하나 이상을 기준으로 분리

            if (numbers.length == 5) {
                try {
                    int num1 = Exception(numbers[0], "1번째 인수");
                    char math1 = numbers[1].charAt(0);
                    int num2 = Exception(numbers[2], "2번째 인수");
                    char math2 = numbers[3].charAt(0);
                    int num3 = Exception(numbers[4], "3번째 인수");

                    int result = calculate(num1, math1, num2, math2, num3);

                    System.out.println("계산 결과: " + result);
                    checkInput = true; 
                } catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                    continue; 
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                    continue;
                }
            } else if (numbers.length < 5) {
                System.out.println("인수의 갯수가 모자랍니다. 3개의 숫자를 입력하세요.");
            } else {
                System.out.println("잘못된 입력입니다. 숫자 연산자 숫자 연산자 숫자 형식으로 입력하세요.");
                continue; 
            }
        }
        sc.close();
    }
    
    public static int Exception(String str, String position) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(position + "는 숫자로 입력해주세요.");
        }
    }
    
    public static int calculate(int num1, char cal1, int num2, char cal2, int num3) {
        int result = 0;       
        switch (cal1) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                if (num2 != 0) {
                    result = num1 / num2;
                } else {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다. +, -, *, / 중 하나를 입력하세요.");
        }
        
        // 두 번째 연산 수행
        switch (cal2) {
            case '+':
                result += num3;
                break;
            case '-':
                result -= num3;
                break;
            case '*':
                result *= num3;
                break;
            case '/':
                if (num3 != 0) {
                    result /= num3;
                } else {
                    throw new IllegalArgumentException("0으로 나눌 수 없습니다.");
                }
                break;
            default:
                throw new IllegalArgumentException("잘못된 연산자입니다. +, -, *, / 중 하나를 입력하세요.");
        }

        return result;
    }
}
