package spring;

import java.time.LocalDateTime;

/**
 * 회원 가입 기능 관련 서비스 클래스
 * @author devkdwDesktop
 *
 */
public class MemberRegisterService {
	private MemberDao memberDao;
	
	/**
	 * MemberRegisterService 클래스 생성자
	 * @param memberDao
	 */
	public MemberRegisterService(MemberDao memberDao) {
		this.memberDao = memberDao;
	}
	
	/**
	 * 동일한 email을 갖는 회원 데이터가 존재하는지 확인하고, 존재하면 DuplicateMemberException을 발생시킴
	 * @param req
	 * @return
	 */
	public Long regist(RegisterRequest req) {

		//email 조회
		Member member = memberDao.selectByEmail(req.getEmail());
		
		//같은 email을 갖는 회원이 존재하면 DuplicateMemberException을 발생시킴
		if(member != null) {
			throw new DuplicateMemberException("dup email " + req.getEmail());
		}
		
		
		//같은 email을 갖는 회원이 존재하지 않으면 Member 객체를 생성한 뒤 memberDao.insert() 메서드를 이용하여 저장 
		Member newMember = new Member(
								req.getEmail(), 
								req.getPassword(), 
								req.getName(), 
								LocalDateTime.now());
		
		memberDao.insert(newMember);
		
		return newMember.getId();
	}
}
