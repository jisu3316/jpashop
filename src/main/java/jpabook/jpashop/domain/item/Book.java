package jpabook.jpashop.domain.item;

import jpabook.jpashop.controller.BookForm;
import jpabook.jpashop.domain.*;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("B")
@Getter
@Setter
public class Book extends Item{

    private String author;
    private String isbn;

}
