package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import config.AppCtx;
import spring.ChangePasswordService;
import spring.DuplicateMemberException;
import spring.MemberInfoPrinter;
import spring.MemberListPrinter;
import spring.MemberNotFoundException;
import spring.MemberRegisterService;
import spring.RegisterRequest;
import spring.VersionPrinter;
import spring.WrongIdPasswordException;

/**
 * 콘솔에서 명령어를 입력받고 각 명령어에 알맞은 기능을 수행하도록 구현
 * 
 * 사용하는 명령어
 * new: 새로운 회원 데이터를 추가함
 * change: 회원 데이터의 암호를 변경함
 *
 * @author devkdwDesktop
 *
 */

public class MainForSpring {
	
	private static ApplicationContext ctx = null;

	public static void main(String[] args) throws IOException {
		ctx = new AnnotationConfigApplicationContext(AppCtx.class);
		
		
		
		//콘솔에서 입력받음
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		
		while (true) {
			System.out.println("명령어를 입력하세요: ");
			
			//한줄 입력받음
			String command = reader.readLine();
			
			//입력받은 문자열이 "exit"이면 프로그램 종료
			if (command.equalsIgnoreCase("exit")) { 
				System.out.println("종료합니다.");
				break;
			}
			
			//입력받은 문자열이 "new "로 시작하면 processNewCommand() 메서드 실행
			if (command.startsWith("new ")) {
				processNewCommand(command.split(" ")); //"new "뒤에 공백문자가 있음
				continue;
				
			//입력받은 문자열이 "chaange "로 시작하면 processNewCommand() 메서드 실행	
			} else if (command.startsWith("change ")) {
				processChangeCommand(command.split(" ")); //"new "뒤에 공백문자가 있음
				continue;
			} else if (command.equals("list")) {
				processListCommand();
				continue;
			} else if (command.startsWith("info ")) {
				processInfoCommand(command.split(" "));
				continue;
			} else if (command.equals("version")) {
				processVersionCommand();
				continue;
			}
			
			//명령어를 잘못 입력한 경우 도움말 출력
			printHelp();
		}
	}
	

	
	/**
	 * processNewCommand(): 새로운 회원 정보 생성
	 * @param arg
	 */
	private static void processNewCommand(String[] arg) {
		
		if (arg.length != 5) {
			printHelp();
			return;
		}
		
		MemberRegisterService regSvc = ctx.getBean("memberRegSvc", MemberRegisterService.class);
		RegisterRequest req = new RegisterRequest();
		req.setEmail(arg[1]);
		req.setName(arg[2]);
		req.setPassword(arg[3]);
		req.setConfirmPassword(arg[4]);
		
		
		//입력한 암호 값이 올바르지 않은 경우
		if (!req.isPasswordEqualToConfirmPassword()) {
			System.out.println("암호와 확인이 일치하지 않습니다.\n");
			return;
		}
		
		
		try {
			
			regSvc.regist(req); //정상 실행되면 새로운 회원 데이터가 저장됨
			System.out.println("등록했습니다.");
			
		} catch(DuplicateMemberException e) { //이미 동일한 이메일을 가진 회원 데이터가 존재하면 에러 메시지 출력
			System.out.println("이미 존재하는 이메일입니다.\n");
		}
	}
	
	/**
	 * processChangeCommand(): ChangePasswordService 객체의 암호 변경 기능 실행
	 * @param arg
	 */
	private static void processChangeCommand(String[] arg) {
		if (arg.length != 4) {
			printHelp();
			return;
		}
		
		ChangePasswordService changePwdSvc = ctx.getBean("changePwdSvc", ChangePasswordService.class); //Assembler 객체 사용
		
		try {
			//변경에 성공하면 MamberDao의 map에 보관된 회원 데이터의 암호가 변경됨
			changePwdSvc.changePassword(arg[1], arg[2], arg[3]);
			System.out.println("암호를 변경했습니다.\n");
			
		} catch (MemberNotFoundException e) { //이메일에 해당하는 회원 데이터가 존재하지 않으면 에러 메시지 출력
			System.out.println("존재하지 않는 이메일입니다.\n");
			
		} catch (WrongIdPasswordException e) { //암호가 올바르지 않으면 에러 메시지 출력
			System.out.println("이메일과 암호가 일치하지 않습니다.");
		}
	}
	
	private static void processListCommand() {
		MemberListPrinter listPrinter = ctx.getBean("listPrinter", MemberListPrinter.class);
		listPrinter.printAll();
	}
	
	private static void processInfoCommand(String[] arg) {
		if(arg.length != 2) {
			printHelp();
			return;
		}
		
		MemberInfoPrinter infoPrinter = ctx.getBean("infoPrinter", MemberInfoPrinter.class);
		infoPrinter.printMemberInfo(arg[1]);
	}
	
	private static void processVersionCommand() {
		VersionPrinter versionPrinter = ctx.getBean("versionPrinter", VersionPrinter.class);
		versionPrinter.print();
	}
	
	/**
	 * 도움말 출력 메서드
	 */
	private static void printHelp() {
		System.out.println();
		System.out.println("잘못된 명령입니다. 아래 명령어 사용법을 확인하세요.");
		System.out.println("명령어 사용법: ");
		System.out.println("new 이메일 이름 암호 암호 확인");
		System.out.println("change 이메일 현재비번 변경비번");
		System.out.println();
	}	


}
