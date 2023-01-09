package hello.core.member;

public interface MemberService {
    void join(Member member);

    Member findMember(Long memberId);
}

// 왜 service도 interface로 구현하지??? repository는 어는 db에 저장할지 몰라서 interface인건 알겠는데