package Hello.HelloSpring;

import Hello.HelloSpring.repository.JdbcMemeberRepository;
import Hello.HelloSpring.repository.JdbcTemplateMemberRepository;
import Hello.HelloSpring.repository.MemberRepository;
import Hello.HelloSpring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

  private DataSource dataSource;

  public SpringConfig(DataSource dataSource) {
    this.dataSource = dataSource;
  }

  @Bean
  public MemberService memberService(){
    return  new MemberService(memberRepository());
  }

  @Bean
  public MemberRepository memberRepository(){
    //return new MemoryMemberRepository();
    //return new JdbcMemeberRepository(dataSource);
    return new JdbcTemplateMemberRepository(dataSource);
  }
}
