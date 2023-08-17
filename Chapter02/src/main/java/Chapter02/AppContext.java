package Chapter02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 사용한 어노테이션에 관한 설명
 * @Configuration: 해당 클래스를 스프링 설정 클래스로 지정
 * @Bean: 해당 메서드가 생성한 객체를 스프링이 관리하는 Bean 객체로 등록,
 * 		  메서드의 이름은 Bean 객체를 구분할 때 사용
 * 
 * @author devkdwDesktop
 *
 */

@Configuration
public class AppContext {
	@Bean
	public Greeter greeter() {
		Greeter g = new Greeter();
		g.setFormat("%s, 안녕하세요!" ); //객체 초기화
		return g;
	}

}
