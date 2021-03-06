package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository //comentscan으로 bean등록함
@RequiredArgsConstructor
public class MemberRepository {

    //@PersistenceContext //spring이 EntityManager를 만들어서 주입해준다.
    private final EntityManager em;

//    public MemberRepository(EntityManager em){
//        this.em = em;
//    }
    public void save(Member member){
        em.persist(member);
    }

    public Member findOne(Long id){
        return em.find(Member.class, id);//primaryKey 넣어주면된다.
    }

    public List<Member> findAll(){
       return em.createQuery("select m from Member m", Member.class)//from의 대상이 테이블이 아니라 Entity이다.
                .getResultList();
    }

    public List<Member> findByName(String name){
        return em.createQuery("select m from Member m where m.name= :name", Member.class)
                .setParameter("name", name)
                .getResultList();
    }
}
