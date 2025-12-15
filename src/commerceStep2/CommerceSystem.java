package commerceStep2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class CommerceSystem
{
    public void start()
    {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        products.add(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 10));
        products.add(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 5));
        products.add(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 20));

        Scanner scanner = new Scanner(System.in);


        System.out.println("[ 실시간 커머스 플랫폼 - 전자제품 ]");

        for (int i = 0; i < products.size(); i++)
        {
            System.out.println((i + 1) + ". " + products.get(i));
        }

        System.out.println("0. 종료 | 프로그램 종료");

        try
        {
            int choice = scanner.nextInt();

            if (choice == 0) {
                System.out.println("커머스 플랫폼을 종료합니다.");
            } else if (choice >= 1 && choice <= products.size()) {
                System.out.println(products.get(choice - 1).getName() + "을(를) 선택했습니다.");
            }
            else
            {
                System.out.println("잘못된 입력입니다.");
            }

        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다.");
        }

        scanner.close();
    }
}
