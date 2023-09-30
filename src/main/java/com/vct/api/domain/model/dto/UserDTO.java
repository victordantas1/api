package com.vct.api.domain.model.dto;

import com.vct.api.domain.model.Account;
import com.vct.api.domain.model.Card;
import com.vct.api.domain.model.User;
import jakarta.persistence.*;

public class UserDTO {

    private Long id;
    private String name;
    private Account account;
    private Card card;

    public UserDTO(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.account = user.getAccount();
        this.card = user.getCard();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
