package com.melalex.leetcode.interview.hibob;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

class Main {

  public static final Role UNEMPLOYED = new Role("Unemployed", LocalDate.MIN);

  /**
   * Calculates what role an employee had per given set of dates
   *
   * @param history Employee role history sorted by the effectiveFrom property in descending order
   * @param dates   list of dates
   */
  private static Map<LocalDate, Role> rolesByDates(List<Role> history, List<LocalDate> dates) {
    if (history.isEmpty()) {
      return dates.stream()
          .collect(Collectors.toMap(Function.identity(), ignore -> UNEMPLOYED, (o, n) -> n));
    }

    dates.sort(Comparator.reverseOrder());

    var historyPos = 0;
    var lastRole = history.get(0);
    var mapBuilder = new HashMap<LocalDate, Role>();

    for (LocalDate date : dates) {
      while (date.isBefore(lastRole.getEffectiveFrom())) {
        historyPos++;

        if (historyPos >= history.size()) {
          lastRole = UNEMPLOYED;
        } else {
          lastRole = history.get(historyPos);
        }
      }

      mapBuilder.put(date, lastRole);
    }

    return mapBuilder;
  }


  public static void main(String[] args) {
    List<Role> history = Arrays.asList(
        new Role("Team Leader", LocalDate.of(2020, 8, 1)),
        new Role("Fullstack developer", LocalDate.of(2016, 5, 15)),
        new Role("Frontend developer", LocalDate.of(2015, 11, 17))
    );

    List<LocalDate> dates = Arrays.asList(
        LocalDate.of(2021, 1, 1),
        LocalDate.of(2014, 1, 1),
        LocalDate.of(2016, 6, 1)
    );

    Map<LocalDate, Role> rolesByDates = rolesByDates(history, dates);

    rolesByDates.forEach((key, value) -> System.out.println("date = " + key + ", role = " + value.getTitle()));
  }
}
