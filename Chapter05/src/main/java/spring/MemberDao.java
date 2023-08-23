package spring;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * 회원 정보 저장 클래스
 * @author devkdwDesktop
 *
 */

@Component
public class MemberDao {
	
	private static long nextId = 0;
	
	private Map<String, Member> map = new HashMap<>();
	
	/**
	 * 회원 email 조회
	 * @param email
	 * @return
	 */
	public Member selectByEmail(String email) {
		return map.get(email);
	}
	
	/**
	 * 회원 정보 저장
	 * @param member
	 */
	public void insert(Member member) {
		member.setId(++nextId);
		map.put(member.getEmail(), member);
	}
	
	/**
	 * 회원 정보 업데이트
	 * @param member
	 */
	public void update(Member member) {
		map.put(member.getEmail(), member);
	}
	
	public Collection<Member> selectAll() {
		return map.values();
	}
}
