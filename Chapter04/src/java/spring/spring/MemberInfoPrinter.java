package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * 지정한 이메일을 갖는 member를 찾아 정보를 출력하는 클래스
 * @author devkdwDesktop
 *
 */
public class MemberInfoPrinter {
	
	private MemberDao memDao;
	private MemberPrinter printer;
	
	public void printMemberInfo(String email) {
		Member member = memDao.selectByEmail(email);
		
		if(member == null) {
			System.out.println("데이터 없음\n");
			return;
		}
		
		printer.print(member);
		System.out.println();
	}
	
	@Autowired		
	public void setMemberDao(MemberDao memberDao) {
		this.memDao = memberDao;
	}
	
	@Autowired
	@Qualifier(value = "printer")
	public void setPrinter(MemberPrinter printer) {
		this.printer = printer;
	}

}
