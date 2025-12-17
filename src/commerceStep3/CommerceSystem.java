package commerceStep3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommerceSystem
{
    private Scanner scanner; //스캐너 여러개 생성시 충돌로 클래스필드로 생성

    public void start()
    {
        CategoryProduct electronics = new CategoryProduct("전자제품");
        electronics.addProduct(new Product("Galaxy S25", 1200000, "최신 안드로이드 스마트폰", 10));
        electronics.addProduct(new Product("iPhone 16", 1350000, "Apple의 최신 스마트폰", 10));
        electronics.addProduct(new Product("MacBook Pro", 2400000, "M3 칩셋이 탑재된 노트북", 5));
        electronics.addProduct(new Product("AirPods Pro", 350000, "노이즈 캔슬링 무선 이어폰", 20));
        CategoryProduct apparels = new CategoryProduct("의류");
        CategoryProduct foods = new CategoryProduct("식품");

        scanner = new Scanner(System.in);

        while (true)
        {
            System.out.println("[ 실시간 커머스 플랫폼 메인 ]");
            System.out.println("1. " + electronics.getCategoryName());
            System.out.println("2. " + apparels.getCategoryName());
            System.out.println("3. " + foods.getCategoryName());
            System.out.println("0. 종료 | 프로그램 종료");

            try
            {
                int menuChoice = scanner.nextInt();

                if (menuChoice == 0)
                {
                    System.out.println("커머스 플랫폼을 종료합니다.");
                    break;
                }
                else if (menuChoice == 1)
                {
                    System.out.println(electronics.getCategoryName() + "을(를) 선택했습니다.");
                    productChoice(electronics);
                }
                else if (menuChoice == 2)
                {
                    System.out.println(apparels.getCategoryName() + "을(를) 선택했습니다.");
                    productChoice(apparels);
                }
                else if (menuChoice == 3)
                {
                    System.out.println(foods.getCategoryName() + "을(를) 선택했습니다.");
                    productChoice(foods);
                }
                else
                {
                    System.out.println("잘못된 입력입니다.");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("잘못된 입력입니다.");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    public void productChoice(CategoryProduct category)
    {

        System.out.println();
        System.out.println("[ " + category.getCategoryName() + " 카테고리 ]");

        for (int i = 0; i < category.getProducts().size(); i++)
        {
            System.out.println((i + 1) + ". " + category.getProducts().get(i));
        }
        System.out.println("0. 뒤로가기");

        try
        {
            int choice = scanner.nextInt();

            if (choice == 0)
            {
                System.out.println("뒤로가기");
            }
            else if (choice >= 1 && choice <= category.getProductCount())
            {
                System.out.println("선택한 제품: " + category.getProducts().get(choice - 1).toDetailString());
            }
            else
            {
                System.out.println("잘못된 입력입니다.");
            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("잘못된 입력입니다.");
            scanner.nextLine();
        }
    }
}