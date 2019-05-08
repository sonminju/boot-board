package hello;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	//IoC Container : Inversion or Control (제어의 역전(ctx가 만들어준다.))
    	ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
    	//Greet 인터페이스 선언된 메소드는 sayHello 밖에 없음
    	//iam1,2로 나눠지면 따로따로 선언해줘야 함
    	Greet g = (Greet) ctx.getBean("korea");
    	System.out.println( "Greeting !" + g.sayHello() + ((Greeter)g).iam() );
    	g = (Greet) ctx.getBean("english");
    	System.out.println( "Greeting !" + g.sayHello() );
    	
    	Greeter korea = (Greeter) ctx.getBean("korea");
    	// Greeter 클래스로부터 생성된 객체를 참조하는 면수,
        // korea는 Greeter클래스에 정의된 메소드를 사용할 수 있다고 생각함
        System.out.println( "Greeting !" + korea.sayHello() );
        
        Greeter2 eng = (Greeter2) ctx.getBean("english");
        System.out.println( "Greeting !" + korea.sayHello() );
    }
}