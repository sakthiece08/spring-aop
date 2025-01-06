package org.teqmonic.springaop.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Order {

  private Long id;
  private List<String> items;
}
