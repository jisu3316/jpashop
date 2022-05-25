package jpabook.jpashop.service;

import jpabook.jpashop.domain.Address;
import jpabook.jpashop.domain.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;

@Component
@RequiredArgsConstructor
public class InitDb {

    @Component
    @Transactional
    @RequiredArgsConstructor
    static class InitService{

        private final InitService initService;

        @PostConstruct
        public void init(){
            initService.dbInit1();
        }
        private final EntityManager em;
        public void dbInit1(){
            Member member = new Member();
            member.setName("userA");
            member.setAddress(new Address("서울","1","1111"));
            em.persist(member);
        }
    }
}

