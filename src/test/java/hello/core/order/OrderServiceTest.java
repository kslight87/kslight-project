package hello.core.order;

import hello.core.AppConfig;
import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class OrderServiceTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        /* given */
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);

        //when
        memberService.join(member);

        //then
        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

    @Test
    void typePromotionTest(){
        double num1= 10;
        //long num2 = 3.14d;
        double num3 = 7.0f + 3.14D;

        System.out.println(num1);
        System.out.println(num3);

        int[] type_2 = {10, 20, 30, 40, 50};
        int[] numArr = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println(numArr[9]);
    }

    @Test
    void arithmeticOperator(){
        int num1 = 10;
        int num2 = 4;

        System.out.println("+ 연산자에 의한 결과 값은 " + (num1 + num2) + " 입니다.");
        System.out.println("- 연산자에 의한 결과 값은 " + (num1 - num2) + " 입니다.");
        System.out.println("* 연산자에 의한 결과 값은 " + (num1 * num2) + " 입니다.");
        System.out.println("/ 연산자에 의한 결과 값은 " + (num1 / num2) + " 입니다.");
        System.out.println("% 연산자에 의한 결과 값은 " + (num1 % num2) + " 입니다.");

    }

    @Test
    void bitwiseOperator() {
        int num1 = 8, num2 = -8;
        System.out.println("~ 연산자에 의한 결과 값은 " + ~num1 + " 입니다.");
        System.out.println("<< 연산자에 의한 결과 값은 " + (num1 << 2) + " 입니다.");
        System.out.println(">> 연산자에 의한 결과 값은 " + (num2 >> 2) + " 입니다.");
        System.out.println(">>> 연산자에 의한 결과 값은 " + (num1 >>> 2) + " 입니다.");
        System.out.println("% 연산자에 의한 결과 값은 " + (num2 >>> 2) + " 입니다.");
    }

    @Test
    void relationalOperator() {
        int num1 = 5, num2 = 10;
        System.out.println("== 연산자에 의한 결과 값은 " + (num1 == num2) + " 입니다.");
        System.out.println("!= 연산자에 의한 결과 값은 " + (num1 != num2) + " 입니다.");
        System.out.println("> 연산자에 의한 결과 값은 " + (num1 > num2) + " 입니다.");
        System.out.println(">= 연산자에 의한 결과 값은 " + (num1 >= num2) + " 입니다.");
        System.out.println("< 연산자에 의한 결과 값은 " + (num1 < num2) + " 입니다.");
        System.out.println("<= 연산자에 의한 결과 값은 " + (num1 <= num2) + " 입니다.");
    }

    @Test
    void logicalOperator() {
        int num1 = 1, num2 = 2;
        boolean result1, result2;

        result1 = (num1 > 0) && (num2 < 3);
        result2 = (num2 < 0) && (num1 < 0);

        System.out.println("&& 연산자에 의한 결과 값은 " + result1 + " 입니다.");
        System.out.println("|| 연산자에 의한 결과 값은 " + result2 + " 입니다.");
        System.out.println("! 연산자에 의한 결과 값은 " + !result2 + " 입니다.");
    }

    class Parent{}
    class Child extends Parent{}

    @Test
    void instanceOfTest(){
        Parent parent = new Parent();
        Child child = new Child();

        System.out.println("instanceof 연산자에 의한 결과 값은 " + (parent instanceof Parent) + " 입니다.");
        System.out.println("instanceof 연산자에 의한 결과 값은 " + (child instanceof Parent) + " 입니다.");
        System.out.println("instanceof 연산자에 의한 결과 값은 " + (parent instanceof Child) + " 입니다.");
        System.out.println("instanceof 연산자에 의한 결과 값은 " + (child instanceof Child) + " 입니다.");
    }

    @Test
    void assignmentOperator() {
        int num1 = 10;
        int num2 = 20;
        int sum = 0;

        System.out.println("= 연산자에 의한 결과 값은 " + (sum = 30));
        System.out.println("+= 연산자에 의한 결과 값은 " + (sum += num1));
        System.out.println("+= 연산자에 의한 결과 값은 " + (sum -= num2));
        System.out.println("+= 연산자에 의한 결과 값은 " + (sum *= 10));
    }

    @Test
    void noNameClass(){
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.print("Run method");
            }
        };

        r.run();
    }

    @Test
    void rambdaClass(){
        Runnable r = ()-> System.out.print("Run method");

        r.run();
    }

    class Product{
        int id;
        String name;
        float price;
        public Product(int id, String name, float price) {
            this.id = id;
            this.name = name;
            this.price = price;
        }
    }

    @Test
    void rambdaClass2(){
        List<Product> list = new ArrayList<Product>();
        list.add(new Product(1,"Samsung S5",560000));
        list.add(new Product(3,"Iphone 13ProMax",1705000));
        list.add(new Product(2,"Samsung Galaxy Z-Flip3",1250000));

        // using arrow to filter data
        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 600000);
        filtered_data.forEach(
                p -> System.out.println(p.name+": "+p.price)
        );
    }

    @Test
    void ternaryOperator() {
        int num1 = 10;
        int num2 = 20;
        int result = 0;

        result = num1>num2?num1 : num2;
        System.out.println("num1과 num2 중 보다 큰 수는? " + result);
    }
}
