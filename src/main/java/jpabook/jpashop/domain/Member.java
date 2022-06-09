package jpabook.jpashop.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class  Member {

    @Id @GeneratedValue
    @Column(name= "member_id")
    private Long id;

    @NotEmpty
    private String name;

    @Embedded //@Embeddable 둘중에 하나만 있으면 되는데 두개다 씀.
    private Address address;

    /**
     * Member에서의 Order와의 관계 : 일대다 관계
     * 하나의 Member가 여러개의 주문을 할 수있다.
     */
    @JsonIgnore
    @OneToMany(mappedBy = "member") //나는 주인에의해 만들어진 거울이다. 읽기전용
    private List<Order> orders = new ArrayList<>();

}
