package Hello.HelloSpring.service;

import Hello.HelloSpring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

  MemberService memberService = new MemberService();

  @Test
  void join() {
    //given
    Member member = new Member();
    member.setName("hello");

    //when
    Long saveId = memberService.join(member);

    //then
    Optional<Member> findMember_Temp = memberService.findOne(saveId);
    //findMember_Temp.ifPresent(member1 -> {
    //  if(member1.getName()){}
    //});

    Member findMember = memberService.findOne(saveId).get();
    assertThat(member.getName()).isEqualTo(findMember.getName());

  }

  @Test
  public void 중복_회원_예외(){
    //given
    Member member1 = new Member();
    member1.setName("member1");


    Member member2 = new Member();
    member2.setName("member1");


    //when
    memberService.join(member1);
    assertThrows(IllegalStateException.class, () -> memberService.join(member2));



    /*try {
      memberService.join(member2);
    }catch (IllegalStateException e){
      assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
    }
*/

    //then
  }

  @Test
  void findMembers() {
  }

  @Test
  void findOne() {
  }
}