package com.vct.api.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;

@Entity
@Table(name = "tb_news")
public class News extends BaseItem {
}
