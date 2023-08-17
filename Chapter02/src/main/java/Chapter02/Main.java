package Chapter02;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 스프링이 제공하는 클래스를 이용하여 AppContext를 읽어와 사용하기
 * 
 * AnnotationConfigApplicationContext: 자바 설정에서 정보를 읽어와 Bean 객체를 생성하고 관리함							
 * 
 * @author devkdwDesktop
 *
 */
public class Main {

	public static void main(String[] args) {
		/**
		 * 객체를 생성할 때 AppContext를 생성자 파라미터로 전달함
		 * AppContext에서 정의한 @Bean 설정 정보를 읽어와 Greeter 객체를 생성하고 초기화함
		 */
		//1. 설정 정보를 이용해서 빈 객체를 생성한다.
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppContext.class);
		
		/**
		 * getBean(): AnnotationConfigApplicationContext가 자바 설정을 읽어와 생성한 Bean 객체를 검색할 때 사용
		 * 
		 * 첫번째 파라미터: @Bean 어노테이션의 메서드 이름 = Bean 객체의 이름
		 * 두번째 파라미터: 검색할 Bean 객체의 타입
		 * 
		 * return: greeter() 메서드가 생성한 Greeter 객체
		 * 
		 */
		//2. 빈 객체를 제공한다.
		Greeter g = ctx.getBean("greeter", Greeter.class);
		String msg = g.greet("스프링");
		System.out.println(msg);
		
		ctx.close();	
	}
}
