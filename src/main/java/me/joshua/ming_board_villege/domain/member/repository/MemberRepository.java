package me.joshua.ming_board_villege.domain.member.repository;

import me.joshua.ming_board_villege.domain.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
