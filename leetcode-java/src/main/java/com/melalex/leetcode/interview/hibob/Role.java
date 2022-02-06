package com.melalex.leetcode.interview.hibob;

import java.time.LocalDate;
import java.util.Objects;

class Role {
  private String title;
  private LocalDate effectiveFrom;

  public Role(String title, LocalDate effectiveFrom) {
    this.title = title;
    this.effectiveFrom = effectiveFrom;
  }

  public String getTitle() {
    return title;
  }

  public LocalDate getEffectiveFrom() {
    return effectiveFrom;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Role role = (Role) o;
    return Objects.equals(title, role.title) &&
        Objects.equals(effectiveFrom, role.effectiveFrom);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, effectiveFrom);
  }
}
