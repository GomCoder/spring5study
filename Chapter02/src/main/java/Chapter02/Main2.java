package Chapter02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 싱글톤 객체
 * 스프링은 기본적으로 한 개의 @Bean 어노테이션에 대해 한 개의 Bean 객체를 생성함
 * @author devkdwDesktop
 *
 */

public class Main2 {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		Greeter g1 = ctx.getBean("greeter", Greeter.class);
		Greeter g2 = ctx.getBean("greeter", Greeter.class);
		
		System.out.println("(g1 == g2) = " + (g1 == g2));
		ctx.close();

	}

}
