/**
 * 이 파일이 있는 패키지(com.example.myboard)와 그 하위 패키지들을 Spring Boot가 모두 스캔해서
 * @Component, @Service, @Repository, @Controller 같은 어노테이션이 붙은 클래스들을 찾아서
 * 자동으로 스프링 빈(Spring Bean)으로 등록해줍니다.
 */
package com.example.myboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication 어노테이션은 이 클래스가 Spring Boot 애플리케이션의
 * 메인 클래스임을 나타냅니다. 이 어노테이션 하나에 여러 기능이 포함되어 있습니다.
 * 1. @SpringBootConfiguration: 이 클래스가 Spring의 설정 파일임을 나타냅니다.
 * 2. @EnableAutoConfiguration: Spring Boot가 클래스패스(classpath)를 보고 필요한 설정들을 자동으로 구성해줍니다.
 *    예를 들어, 'spring-boot-starter-web'이 있으면, 내장 웹 서버(Tomcat)를 설정하고 DispatcherServlet 같은 것들을 자동으로 등록해줍니다.
 * 3. @ComponentScan: @Component 어노테이션 및 그 하위 어노테이션(@Service, @Repository, @Controller 등)이 붙은
 *    클래스들을 찾아서 스프링 컨테이너에 빈(Bean)으로 등록합니다. 이 클래스가 있는 패키지부터 하위 패지키까지 모두 스캔합니다.
 */
@SpringBootApplication
public class MyboardApplication {

	/**
	 * 자바 애플리케이션의 시작점(Entry Point)인 main 메소드입니다.
	 * SpringApplication.run() 메소드를 호출해서 Spring Boot 애플리케이션을 실행시킵니다.
	 * 이 한 줄의 코드가 내장 웹 서버(Tomcat)를 띄우고, Spring 환경을 구성하고,
	 * 우리가 만든 코드를 실행시키는 모든 준비를 해줍니다.
	 *
	 * @param args 커맨드 라인 인자(Command Line Arguments)
	 */
	public static void main(String[] args) {
		SpringApplication.run(MyboardApplication.class, args);
	}

}