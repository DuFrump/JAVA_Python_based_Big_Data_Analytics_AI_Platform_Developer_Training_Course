package com.example.newboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 안녕하세요, 두프룸프님! 이 클래스가 바로 모든 마법이 시작되는 곳, 스프링 부트 애플리케이션의 진입점(Entry Point)입니다.
 * 우리가 '애플리케이션을 실행한다'고 할 때, 실제로는 자바가 이 클래스의 main 메소드를 실행하는 것입니다.
 *
 * @SpringBootApplication 어노테이션은 스프링 부트의 가장 핵심적인 어노테이션으로,
 * 사실은 다음 세 가지 중요한 어노테이션을 합쳐놓은 것입니다.
 *
 * 1. @SpringBootConfiguration : 이 클래스가 스프링 부트의 설정 파일임을 나타냅니다.
 *    (@Configuration 어노테이션을 포함하고 있어, 이 안에서 @Bean을 등록할 수도 있습니다.)
 *
 * 2. @EnableAutoConfiguration : 스프링 부트의 '자동 설정' 기능을 활성화합니다.
 *    우리가 추가한 의존성(dependency)들을 보고, 그에 필요한 설정들을 스프링이 알아서 해주는 놀라운 기능입니다.
 *    예를 들어, 'spring-boot-starter-web'이 있으면, 내장 웹 서버(Tomcat)를 자동으로 띄워주는 식이죠.
 *
 * 3. @ComponentScan : '컴포넌트(@Component)'를 찾아서 스캔하는 역할을 합니다.
 *    스프링은 @Component 어노테이션이 붙은 클래스들을 찾아서 '스프링 빈(Bean)'으로 등록하고 관리합니다.
 *    우리가 지금까지 봤던 @Service, @Repository, @Controller, @RestController 등은 모두
 *    내부적으로 @Component 어노테이션을 포함하고 있어, @ComponentScan에 의해 자동으로 발견되는 것입니다.
 *    (기본적으로 이 클래스가 있는 패키지(com.example.newboard)와 그 하위 패키지들을 모두 스캔합니다.)
 */
@SpringBootApplication
public class MyboardApplication { // 클래스 이름을 NewboardApplication에서 MyboardApplication으로 변경했습니다.

	/**
	 * 자바 애플리케이션의 표준 시작점인 main 메소드입니다.
	 * @param args 커맨드 라인 인자(argument)
	 */
	public static void main(String[] args) {
		/**
		 * SpringApplication.run() 메소드를 호출하여 스프링 부트 애플리케이션을 실행합니다.
		 * 이 한 줄의 코드가 내장 웹 서버를 띄우고, 스프링 빈을 등록하고,
		 * 자동 설정을 수행하는 등 모든 준비 작업을 처리해줍니다.
		 *
		 * @param MyboardApplication.class : 현재 클래스를 기본 설정 클래스로 사용하겠다는 의미입니다.
		 * @param args : main 메소드가 받은 커맨드 라인 인자를 그대로 전달합니다.
		 */
        SpringApplication.run(MyboardApplication.class, args);
	}

}
