package commerceLv1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class CommerceSystem
{
    private Scanner scanner; //스캐너 여러개 생성시 충돌로 클래스필드로 생성
    private Cart cart;

    public void start()
    {
        cart = new Cart();

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
            System.out.println("0. 종료 | 프로그램 종료\n");
            System.out.println("[ 주문 관리 ]");
            System.out.println("4. 장바구니 확인   | 장바구니를 확인 후 주문합니다.");
            System.out.println("5. 주문 취소      | 진행중인 주문을 취소합니다.\n");

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
                    System.out.println(electronics.getCategoryName() + "을(를) 선택했습니다.\n");
                    productChoice(electronics);
                }
                else if (menuChoice == 2)
                {
                    System.out.println(apparels.getCategoryName() + "을(를) 선택했습니다.\n");
                    productChoice(apparels);
                }
                else if (menuChoice == 3)
                {
                    System.out.println(foods.getCategoryName() + "을(를) 선택했습니다.\n");
                    productChoice(foods);
                }
                else if (menuChoice == 4)
                {
                    System.out.println("아래와 같이 주문 하시겠습니까?\n");
                    showCart(); //카트목록 불러오기 함수

                }
                else if (menuChoice == 5)
                {
                    removeCart();
                }
                else
                {
                    System.out.println("잘못된 입력입니다.\n");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("잘못된 입력입니다.\n");
                scanner.nextLine();
            }
        }//while (true)

        scanner.close();
    }
    public void removeCart()
    {
        System.out.println("[ 장바구니 내역 ]\n");
        if (cart.getCartCount() == 0)
        {
            System.out.println("장바구니가 비어있습니다.\n");
            return;

        }
        int total = 0;
        for (int i = 0; i < cart.getCart().size(); i++)
        {
            Product cartList = cart.getCart().get(i);
            System.out.println((i + 1) + ". " + cartList);
            total += cartList.getPrice();
        }
        System.out.println("[ 총 주문 금액 ]\n" + String.format("%,d", total) + "원\n");
        System.out.println("1. 장바구니 초기화      2. 메뉴로 돌아가기\n");
        try {
            int choice = scanner.nextInt();
            if (choice == 1) 
            {
                System.out.println("비우기 완료");
                cart.clearCart();//세터함수
            } else if (choice == 2) {
                System.out.println("돌아가기");
            } else {
                System.out.println("잘못된 입력입니다.");
            }
        }catch (InputMismatchException e)
        {
            System.out.println("잘못된 입력입니다.\n");
            scanner.nextLine();
        }
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
                System.out.println("뒤로가기\n");
                scanner.nextLine();
            }
            else if (choice >= 1 && choice <= category.getProductCount())
            {
                System.out.println("선택한 제품: " + category.getProducts().get(choice - 1).toDetailString() + "\n");
                System.out.println(category.getProducts().get(choice - 1));
                System.out.println("위 상품을 장바구니에 추가하시겠습니까?\n");
                System.out.println("1. 확인       2. 취소\n");

                int cartChoice = scanner.nextInt();
                if (cartChoice == 1)
                {
                    Product selectedProduct = category.getProducts().get(choice - 1);
                    if(selectedProduct.getStock() <= 0)
                    {
                        System.out.println("재고가 부족합니다.\n");
                    }
                    else
                    {
                        cart.addCart(selectedProduct);
                        System.out.println(category.getProducts().get(choice - 1).getName() + "가 장바구니에 추가되었습니다.\n");
                    }

                }
                else if (cartChoice == 2)
                {
                    System.out.println("취소");
                }
                else
                {
                    System.out.println("잘못된 입력입니다.\n");
                }

            }
            else
            {
                System.out.println("잘못된 입력입니다.\n");

            }
        }
        catch (InputMismatchException e)
        {
            System.out.println("잘못된 입력입니다.\n");
            scanner.nextLine();
        }
    }//public void productChoice(CategoryProduct category)

    public void showCart()
    {
        System.out.println("[ 장바구니 내역 ]\n");
        if (cart.getCartCount() == 0)
        {
            System.out.println("장바구니가 비어있습니다.\n");
            return;
        }
        int total = 0;
        for (int i = 0; i < cart.getCart().size(); i++)
        {
            Product cartList = cart.getCart().get(i);
            System.out.println((i + 1) + ". " + cartList);
            total += cartList.getPrice();
        }
        System.out.println("[ 총 주문 금액 ]\n" + String.format("%,d", total) + "원\n");
        System.out.println("1. 주문 확정      2. 메뉴로 돌아가기\n");
        try
        {
            int choice = scanner.nextInt();

            if (choice == 1)
            {

                for (int i = 0; i < cart.getCart().size(); i++)
                {
                    Product cartList = cart.getCart().get(i);
                    if (cartList.getStock() <= 0)
                    {
                        System.out.println(cartList.getName() + " 재고가 부족합니다.\n");
                        total -= cartList.getPrice();
                    }
                    else
                    {
                        System.out.println(cartList.getName() + " 재고가 " + cartList.getStock() + "개 -> " +
                                cartList.setStock(cartList.getStock() - 1) + "개로 업데이트되었습니다.\n");
                    }

                }
                System.out.println("주문이 완료되었습니다! 총 금액: " + String.format("%, d", total) + "원\n");
                cart.clearCart();


            } else if (choice == 2) {
                System.out.println("돌아갑니다.");
            } else {
                System.out.println("잘못된 입력입니다.\n");
            }
        }catch (InputMismatchException e)
        {
            System.out.println("잘못된 입력입니다.\n");
            scanner.nextLine();
        }

    }


}