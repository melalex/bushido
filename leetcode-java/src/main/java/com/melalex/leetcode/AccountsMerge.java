package com.melalex.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class AccountsMerge {

  public List<List<String>> accountsMerge(List<List<String>> accounts) {
    var emailToId = new HashMap<String, Integer>();
    var idToEmails = new HashMap<Integer, Set<String>>();
    var idToName = new HashMap<Integer, String>();
    var currId = 0;

    for (List<String> accountLine : accounts) {
      var mergeWith = new HashSet<Integer>();
      var emails = accountLine.stream()
          .skip(1)
          .collect(Collectors.toCollection(TreeSet::new));

      idToName.put(currId, accountLine.get(0));

      for (var email : emails) {
        if (emailToId.containsKey(email)) {
          mergeWith.add(emailToId.get(email));
          emailToId.put(email, currId);
        } else {
          emailToId.put(email, currId);
        }
      }

      if (mergeWith.isEmpty()) {
        idToEmails.put(currId, emails);
      } else {
        var merged = mergeWith.stream()
            .flatMap(it -> idToEmails.get(it).stream())
            .collect(Collectors.toSet());

        for (var email : merged) {
          emailToId.put(email, currId);
        }

        for (var id : mergeWith) {
          idToEmails.remove(id);
        }

        emails.addAll(merged);

        idToEmails.put(currId, emails);
      }

      currId++;
    }

    return idToEmails.entrySet()
        .stream()
        .map(it -> {
          var res = new ArrayList<String>(it.getValue().size() + 1);

          res.add(idToName.get(it.getKey()));
          res.addAll(it.getValue());

          return res;
        })
        .collect(Collectors.toList());
  }

  public static void main(String[] args) {
    var app = new AccountsMerge();

    System.out.println(
        app.accountsMerge(
            List.of(
                List.of("John","johnsmith@mail.com","john_newyork@mail.com"),
                List.of("John","johnsmith@mail.com","john00@mail.com"),
                List.of("Mary","mary@mail.com"),
                List.of("John","johnnybravo@mail.com")
            )
        )
    );
  }
}
