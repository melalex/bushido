function isIsomorphic(s: string, t: string): boolean {
  const dictionary = {};
  const visited = new Set<string>();

  if (s.length !== t.length) {
    return false;
  }

  for (let i = 0; i < s.length; i++) {
    const a = s[i];
    const b = t[i];

    if (a in dictionary) {
      if (dictionary[a] !== b) {
        return false;
      }
    } else if (visited.has(b)) {
      return false;
    } else {
      dictionary[a] = b;
      visited.add(b);
    }
  }

  return true;
}
